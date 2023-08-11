package com.gmaroko.dao;

import com.gmaroko.config.DatabaseConfig;
import com.gmaroko.dto.SquadInfo;
import com.gmaroko.models.Hero;
import com.gmaroko.models.Squad;
import com.gmaroko.models.Strength;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

public class SquadDao {
    private static final Sql2o sql2o = DatabaseConfig.getDatabase();

    public static void create(Squad squad){
        try(Connection connection = sql2o.open()){
            String query = "INSERT INTO squads (name, max_size, cause) VALUES (:name, :max_size, :cause);";
            connection.createQuery(query)
                    .addParameter("name", squad.getName())
                    .addParameter("max_size", squad.getMax_size())
                    .addParameter("cause", squad.getCause())
                    .executeUpdate();
        } catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }

    public static SquadInfo findSquadById(int squadId) {
        try (Connection connection = sql2o.open()) {
            String querySquads = "SELECT * FROM squads WHERE NOT deleted AND id = :squadId;";
            Squad squad = connection.createQuery(querySquads)
                    .addParameter("squadId", squadId)
                    .executeAndFetchFirst(Squad.class);
            List<Hero> heroes = HeroDao.findAllHeroesBySquadId(squadId);

            SquadInfo info = new SquadInfo();
            info.setSquad(squad);
            info.setHeroes(heroes);
            info.setStrengthScore(getHeroScore(heroes, 0));
            info.setWeaknessScore(getHeroScore(heroes, 1));
            return info;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return  null;
        }
    }

    private static int getHeroScore(List<Hero> heroes, int type) {
        int score = 0;
        if (type == 0){
            for(Hero hero: heroes){
                int id = hero.getStrength_id();
                score += StrengthDao.getScoreById(id);
            }
            return score;
        } else {
            for(Hero hero: heroes){
                int id = hero.getWeakness_id();
//                score += WeaknessDao.getScoreById(id);
            }
            return score;
        }
    }
}

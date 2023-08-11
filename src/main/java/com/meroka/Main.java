package com.meroka;

import com.meroka.dao.SquadDao;
import com.meroka.dao.StrengthDao;
import com.meroka.dto.SquadInfo;
import com.meroka.models.Hero;
import com.meroka.models.Squad;
import com.meroka.models.Strength;
import com.meroka.utils.SharedUtils;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;

import static spark.Spark.*;
public class Main {


    public static void main(String[] args) {

       SquadInfo squadInfo= new SquadInfo();

        Hero hero= new Hero();
        Hero hero1= new Hero();
        Hero hero2= new Hero();
        Strength strength1=new Strength();

        Squad squad=new Squad();

        squadInfo.setSquad(squad);
        squad.setId(2);
        squad.setName("ninja turtles");
        squad.setCause("'fights'");
        squad.setMax_size(4);
        squad.setDeleted(false);

        hero.setId(3);
        hero.setName("Captain America");
        hero.setCause("null");
        hero.setAge(35);
        hero.setStrength_id(1);
        hero.setWeakness_id(0);
        hero.setSquad_id(2);
        hero.setDeleted(false);

        hero.setId(4);
        hero.setName("Wonder Woman");
        hero.setCause("null");
        hero.setAge(30);
        hero.setStrength_id(1);
        hero.setWeakness_id(0);
        hero.setSquad_id(2);
        hero.setDeleted(false);

        hero.setId(5);
        hero.setName("Thanos'");
        hero.setCause("null");
        hero.setAge(50);
        hero.setStrength_id(1);
        hero.setWeakness_id(0);
        hero.setSquad_id(2);
        hero.setDeleted(false);

        strength1.setScore(0);
        int weaknessScore=hero.getWeakness_id() + hero1.getWeakness_id() + hero2.getWeakness_id();


        get("/", (req, res)->{
            return SharedUtils.render(new HashMap<>(), "index.hbs");
        });

        get("/strength/add", (req, res)->{
            return SharedUtils.render(new HashMap<>(), "create-strength.hbs");
        });

        post("/create-strength", (req, res)->{
            String name = req.queryParams("name");
            int score = Integer.parseInt(req.queryParams("score"));

            Strength strength = new Strength();
            strength.setScore(score);
            strength.setName(name);

            StrengthDao.create(strength);

            res.redirect("/");
            return null;
        });

        System.out.println(SquadDao.findSquadById(2));
        StrengthDao.getScoreById(2);


    }
}

/*
SquadInfo{
squad=Squad{id=2, name='ninja turtles', cause='fights', max_size=4, deleted=false},
 heroes=
 [Hero
 {id=3, name='Captain America', cause='null', age=35, strength_id=1, weakness_id=0, squad_id=2, deleted=false},
  Hero{id=4, name='Wonder Woman', cause='null', age=30, strength_id=1, weakness_id=0, squad_id=2, deleted=false},
   Hero{id=5, name='Thanos', cause='null', age=50, strength_id=1, weakness_id=0, squad_id=2, deleted=false}],
  weaknessScore=0,
   strengthScore=0
   }

 */
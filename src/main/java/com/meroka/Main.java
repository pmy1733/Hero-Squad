package com.meroka;

import com.meroka.dao.SquadDao;
import com.meroka.dao.StrengthDao;
import com.meroka.models.Hero;
import com.meroka.models.Strength;
import com.meroka.utils.SharedUtils;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;

import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
        // get("/", (req, res)->{
        // return SharedUtils.render(new HashMap<>(), "index.hbs");
        // });
        //
        // get("/strength/add", (req, res)->{
        // return SharedUtils.render(new HashMap<>(), "create-strength.hbs");
        // });
        //
        // post("/create-strength", (req, res)->{
        // String name = req.queryParams("name");
        // int score = Integer.parseInt(req.queryParams("score"));
        //
        // Strength strength = new Strength();
        // strength.setScore(score);
        // strength.setName(name);
        //
        // StrengthDao.create(strength);
        //
        // res.redirect("/");
        // return null;
        // });

        // System.out.println(SquadDao.findSquadById(2));
        // StrengthDao.getScoreById(2);

    }
}

/*
 * SquadInfo{
 * squad=Squad{id=2, name='ninja turtles', cause='fights', max_size=4,
 * deleted=false},
 * heroes=
 * [Hero
 * {id=3, name='Captain America', cause='null', age=35, strength_id=1,
 * weakness_id=0, squad_id=2, deleted=false},
 * Hero{id=4, name='Wonder Woman', cause='null', age=30, strength_id=1,
 * weakness_id=0, squad_id=2, deleted=false},
 * Hero{id=5, name='Thanos', cause='null', age=50, strength_id=1, weakness_id=0,
 * squad_id=2, deleted=false}],
 * weaknessScore=0,
 * strengthScore=0
 * }
 * 
 */
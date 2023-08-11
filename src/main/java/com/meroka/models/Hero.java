package com.meroka.models;

public class Hero {
    private int id;
    private String name;
    private String cause;
    private int age;
    private int strength_id;
    private int weakness_id;
    private int squad_id;
    private boolean deleted;

    public Hero() {
        this.deleted = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getStrength_id() {
        return strength_id;
    }

    public void setStrength_id(int strength_id) {
        this.strength_id = strength_id;
    }

    public int getWeakness_id() {
        return weakness_id;
    }

    public void setWeakness_id(int weakness_id) {
        this.weakness_id = weakness_id;
    }

    public int getSquad_id() {
        return squad_id;
    }

    public void setSquad_id(int squad_id) {
        this.squad_id = squad_id;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cause='" + cause + '\'' +
                ", age=" + age +
                ", strength_id=" + strength_id +
                ", weakness_id=" + weakness_id +
                ", squad_id=" + squad_id +
                ", deleted=" + deleted +
                '}';
    }
}

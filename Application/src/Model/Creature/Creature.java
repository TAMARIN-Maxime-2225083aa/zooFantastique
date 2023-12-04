package Model.Creature;

import Controler.Controler;
import Model.Creature.Behavior.Revive;
import Model.Creature.Caracteristic.*;

/**
 * The creature abstract class. Contain anything common to all creatures.
 * Notify the controler when any change occures.
 */
public abstract class Creature implements Runnable{
    protected String name;
    protected Sex sex;
    protected Weight weight;
    protected Height height;
    protected Age age;
    protected Hunger hunger;
    protected Fatigue fatigue;
    protected Health health;
    protected Creature(String name, Sex sex, Weight weight, Height height, Age age, Hunger hunger, Fatigue fatigue, Health health)
    {
        this.name = name;
        this.sex = sex;
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.hunger = hunger;
        this.fatigue = fatigue;
        this.health = health;
    }
    protected void eat(){
        hunger = hunger.eat();
    }
    // notification pour dire je cris ?
    protected void toBeHungry() {
        if (this.hunger == Hunger.values()[0])
            loseHealth();
        this.hunger = hunger.toBeHungry();
    }
    protected void shout(){
        Controler.getInstance().notification(this.name+" émet un son ("+this.getClass().getSimpleName()+")");
    }
    protected  void loseHealth() {
        if (this.health == Health.values()[0])
            Controler.getInstance().removeCreature(this);
        this.health = health.loseHealth();
    }
    protected void heal(){
        health = health.heal();
    }
    protected void gettingFatigue() {
        if (this.fatigue == Fatigue.values()[0])
            // faire comportement pour dormir de façon prolongé
            loseHealth();
        this.fatigue = fatigue.gettingFatigue();
    }
    protected void sleep(){
        fatigue = fatigue.sleep();
    }
    protected void age() {
        if (this.age == Age.values()[Age.values().length])
            Controler.getInstance().removeCreature(this);
        age = age.gettingOder();
    }
    public String getName()
    {
        return this.name;
    }
    @Override
    public String toString()
    {
        return this.name + " le " + this.getClass().getSimpleName() + "\n" +
                "Caractéristiques : " + "\n" +
                "    Sexe : " + this.sex + "\n" +
                "    Poids : " + this.weight + "\n" +
                "    Taille : " + this.height + "\n" +
                "    Age : " + this.age + "\n" +
                "    Faim : " + this.hunger + "\n" +
                "    Fatigue : " + this.fatigue + "\n" +
                "    Santé : " + this.health;
    }
}

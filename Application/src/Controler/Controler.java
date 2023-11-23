package Controler;

import Model.Corral.*;
import Model.Creature.Creature;
import View.Interface;

/**
 * The main controler of the app.
 * Listening to anything happening in the zoo.
 */
public class Controler{
    public Zoo zoo;
    private static Controler instance;
    public static boolean game;
    private Controler()
    {
        this.zoo = Creator.createYourZoo();
    }
    public static Controler getInstance()
    {
        if(instance == null)
        {
            game = true;
            instance = new Controler();
        }
        return instance;
    }
    public void notification(String notification)
    {
        Interface.show(notification);
    }
    public void addCreature(Creature creature, Corral corral)
    {
        this.zoo.addCreature(corral, creature);
        Interface.show("Vous avez accueilli une nouvelle créature");
    }
    public void addCorral(Corral corral)
    {
        this.zoo.addCorral(corral);
        Interface.show("Vous avez inauguré un nouvel enclos");
    }
    public void removeCreature(Creature creature)
    {
        this.zoo.removeCreature(creature);
        Interface.show("Vous avez tué une créature...");
    }
    public void removeCorral(Corral corral)
    {
        this.zoo.removeCorral(corral);
        Interface.show("Vous avez explosé un enclos...");
    }
}
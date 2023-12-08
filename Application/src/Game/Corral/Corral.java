package Game.Corral;

import Game.Creature.Behavior.Revive;
import Game.Creature.Behavior.Run;
import Game.Creature.Bestiary.*;
import Game.Creature.Creature;
import Interactions.Controler;
import Interactions.Interface;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an enclosure to house creatures with the ability to run.
 */
public class Corral implements Runnable{
    private static final int MAX = 5;
    protected String name;
    protected String size;
    protected boolean isDestroyed;
    protected int max;
    private List<Run> creatures;
    protected String hygiene;
    protected String food;
    protected Corral(String name, String size)
    {
        this.name = name;
        this.size = size;
        this.max = MAX;
        this.isDestroyed = false;
        this.creatures = new ArrayList<Run>();
    }
    /**
     * Creates and returns a new instance of Corral.
     *
     * @param name The name of the corral.
     * @param size The size of the corral.
     * @return A new Corral instance.
     */
    public static Corral inaugurate(String name, String size)
    {
        return new Corral(name, size);
    }
    public String toString()
    {
        StringBuilder returnString = new StringBuilder("Enclos " + this.name + "\n");
        ArrayList<Creature> creatures = new ArrayList<>();
        for (Run creature : this.creatures) {
            creatures.add((Creature) creature);
        }
        for (Creature creature : creatures) {
            returnString.append(creature.getName()).append("\n");
        }
        return returnString.toString();
    }
    public void addCreature(Creature creature)
    {
        if (!(creature instanceof Run))
        {
            throw new IllegalArgumentException("Cette créature ne peut pas courir");
        }
        assert creature instanceof Run;
        this.creatures.add((Run) creature);
        Thread thread = new Thread(creature);
        thread.start();
    }

    public Creature removeCreature(Creature creature)
    {
        return (Creature) this.creatures.remove(this.creatures.indexOf((Run) creature));
    }

    public void kill(Creature creature)
    {
        if (creature instanceof Revive) {
            String type = creature.getClass().getSimpleName();
            removeCreature(creature);
            switch (type) {
                case "Dragon":
                    creature = Dragon.newBorn(creature.getName(),creature.getSex());
                    break;
                case "Kraken":
                    creature = Kraken.newBorn(creature.getName(),creature.getSex());
                    break;
                case "Lycantropus":
                    creature = Lycantropus.newBorn(creature.getName(),creature.getSex());
                    break;
                case "Megalodon":
                    creature = Megalodon.newBorn(creature.getName(),creature.getSex());
                    break;
                case "Mermaid":
                    creature = Mermaid.newBorn(creature.getName(),creature.getSex());
                    break;
                case "Nymph":
                    creature = Nymph.newBorn(creature.getName(),creature.getSex());
                    break;
                case "Phenix":
                    creature = Phenix.newBorn(creature.getName(),creature.getSex());
                    break;
                case "Unicorn":
                    creature = Unicorn.newBorn(creature.getName(),creature.getSex());
                    break;
            }
            addCreature(creature);
        }
        else
            removeCreature(creature);
    }

    public void clean()
    {

    }
    public int count()
    {
        return 0;
    }
    public void feed()
    {

    }
    public boolean hasFreeSpace()
    {
        //TODO : this method
        return true;
    }
    public boolean contains(Creature searched)
    {
        for(Run creature : this.creatures)
        {
            if (creature.equals(searched))
            {
                return true;
            }
        }
        return false;
    }
    public boolean empty()
    {
        return this.creatures.isEmpty();
    }
    public String getName() {
        return name;
    }
    public List<Creature> getCreatures()
    {
        List<Creature> creatures = new ArrayList<>();
        for (Run creature : this.creatures) {
            creatures.add((Creature) creature);
        }
        Interface.show(creatures.toString());
        return creatures;
    }
    public void isDestroyed()
    {
        this.isDestroyed = true;
    }
    @Override
    public void run(){
        while (!isDestroyed) {

            int randomAction = Model.DiceRoll.d8();

            if (randomAction == 1) {
                // perd un point de propreté
            }

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
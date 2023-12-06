package Game.Creature.Bestiary;
import Game.Creature.Behavior.Swim;
import Game.Creature.Caracteristic.*;
import Game.Creature.Viviparian;

public class Mermaid extends Viviparian implements Swim {
    private Mermaid(String name, Sex sex, Weight weight, Height height, Age age, Hunger hunger, Fatigue fatigue, Health health) {
        super(name, sex, weight, height, age, hunger, fatigue, health);
    }
    public static Mermaid newBorn(String name, Sex sex)
    {
        return new Mermaid(name, sex, Weight.LIGHT, Height.SMALL, Age.BABY, Hunger.GOOD, Fatigue.GOOD, Health.GOOD);
    }

}

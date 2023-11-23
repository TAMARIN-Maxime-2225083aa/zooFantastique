package Controler;

import Model.Corral.Aquarium;
import Model.Corral.Aviary;
import Model.Corral.Corral;
import Model.Creature.Bestiary.*;
import Model.Creature.Creature;
import Model.ZooMaster;
import View.Interface;

/**
 * One of the app's controler. Used when the user need to create an object
 */
public class Creator{
    private static ZooMaster createYourZooMaster()
    {
        return new ZooMaster(Interface.input("Nom de votre maître de zoo"),Asker.sex(),Asker.age());
    }
    public static Zoo createYourZoo()
    {
        return Zoo.opening(Interface.input("Nom de votre Zoo"), createYourZooMaster());
    }
    public static Creature createYourCreature()
    {
        return switch (Interface.input("Quel créature voulez vous faire naître ? Dragon, Kraken, Lycantropus, " +
                "Megalodon, Mermaid, Nymph, Phenix, Unicorn")) {
            case "Dragon" -> Dragon.newBorn(Interface.input("Nom de votre dragon"), Asker.sex());
            case "Kraken" -> Kraken.newBorn(Interface.input("Nom de votre kraken"), Asker.sex());
            case "Lycantropus" -> Lycantropus.newBorn(Interface.input("Nom de votre loup garou"), Asker.sex());
            case "Megalodon" -> Megalodon.newBorn(Interface.input("Nom de votre mégalodon"), Asker.sex());
            case "Mermaid" -> Mermaid.newBorn(Interface.input("Nom de votre sirène"), Asker.sex());
            case "Nymph" -> Nymph.newBorn(Interface.input("Nom de votre nymphe"), Asker.sex());
            case "Phenix" -> Phenix.newBorn(Interface.input("Nom de votre phénix"), Asker.sex());
            case "Unicorn" -> Unicorn.newBorn(Interface.input("Nom de votre licorne"), Asker.sex());
            default -> createYourCreature();
        };
    }
    public static Corral createYourCorral()
    {
        return switch (Interface.input("Quel type d'enclos voulez vous faire ? Corral, Aviary, Aquarium")) {
            case "Corral" -> Corral.inaugurate(Interface.input("Nom de votre enclos"), "petit");
            case "Aviary" -> Aviary.inaugurate(Interface.input("Nom de votre enclos"), "petit");
            case "Aquarium" -> Aquarium.inaugurate(Interface.input("Nom de votre enclos"), "petit");
            default -> createYourCorral();
        };
    }
}

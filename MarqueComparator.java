package Comparators;

import Classes.Voiture;
import java.util.Comparator;

public class MarqueComparator implements Comparator<Voiture> {

    @Override
    public int compare(Voiture voiture1, Voiture voiture2) {
        if (voiture1.getMarque().equalsIgnoreCase(voiture2.getMarque())) {
            return voiture1.getModele().compareTo(voiture2.getModele());
        }
        return voiture1.getMarque().compareTo(voiture2.getMarque());
    }
}

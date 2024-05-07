package Comparators;

import Classes.Voiture;
import java.util.Comparator;

public class PrixComparator implements Comparator<Voiture> {

    @Override
    public int compare(Voiture voiture1, Voiture voiture2) {
        if (voiture1.getPrix() < voiture2.getPrix()) {
            return -1;
        } else if (voiture1.getPrix() == voiture2.getPrix()) {
            return 0;
        }
        return 1;
    }
}

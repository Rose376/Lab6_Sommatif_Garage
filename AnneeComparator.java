package Comparators;

import Classes.Voiture;
import java.util.Comparator;

public class AnneeComparator implements Comparator<Voiture> {

    @Override
    public int compare(Voiture voiture1, Voiture voiture2) {
        if (voiture1.getAnnee() < voiture2.getAnnee()) {
            return -1;
        } else if (voiture1.getAnnee() == voiture2.getAnnee()) {
            return 0;
        }
        return 1;
    }
}

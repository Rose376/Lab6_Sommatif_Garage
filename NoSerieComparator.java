package Comparators;

import Classes.Voiture;
import java.util.Comparator;

public class NoSerieComparator implements Comparator<Voiture> {

    @Override
    public int compare(Voiture voiture1, Voiture voiture2) {
        return voiture1.getNoSerie().compareTo(voiture2.getNoSerie());
    }
}

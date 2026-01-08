package plateau;


import java.util.ArrayList;
import java.util.List;

public class Plateau implements Aggregate {
    private List<Case> cases;

    public Plateau() {
        cases = new ArrayList<>();
    }

    public void ajouterCase(Case c) {
        cases.add(c);  // C'est tout ! 🎉
    }

    public Case getCase(int i) {
        if (i >= 0 && i < cases.size()) {
            return cases.get(i);
        }
        return null;
    }

    public int nbCases() {
        return cases.size();  // Automatique !
    }

    public Iterator iterator() {
        return new PlateauIterator(cases);
    }
}
package joueur;

import java.util.List;

public interface JoueurDao {
    List<Joueur> getTousLesJoueurs();
    void updateJoueur(Joueur joueur);
    void deleteJoueur(Joueur joueur);
    void addJoueur(Joueur joueur);
}
package joueur;

import joueur.dto.Joueur;

import java.util.List;

public interface JoueurDao {
    List<Joueur> getTousLesJoueurs();

    void updateJoueur(Joueur joueur);

    void deleteJoueur(Joueur joueur);

    void addJoueur(Joueur joueur);
}
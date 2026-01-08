package joueur;

import java.util.ArrayList;
import java.util.List;

public class JoueurDaoImpl implements JoueurDao {
    private List<Joueur> joueurs;

    public JoueurDaoImpl() {
        joueurs = new ArrayList<>();
        // Initialisation avec 3 joueurs préenregistrés
        joueurs.add(new Joueur("Alice", 1500));
        joueurs.add(new Joueur("Bob", 1500));
        joueurs.add(new Joueur("Charlie", 1500));
    }

    @Override
    public List<Joueur> getTousLesJoueurs() {
        return new ArrayList<>(joueurs); // Retourne une copie
    }

    @Override
    public void addJoueur(Joueur joueur) {
        joueurs.add(joueur);
        System.out.println("Joueur ajouté : " + joueur);
    }

    @Override
    public void updateJoueur(Joueur joueur) {
        for (int i = 0; i < joueurs.size(); i++) {
            if (joueurs.get(i).getPrenom().equals(joueur.getPrenom())) {
                joueurs.set(i, joueur);
                System.out.println("Joueur mis à jour : " + joueur);
                return;
            }
        }
        System.out.println("Joueur non trouvé pour la mise à jour");
    }

    @Override
    public void deleteJoueur(Joueur joueur) {
        boolean removed = joueurs.removeIf(j -> j.getPrenom().equals(joueur.getPrenom()));
        if (removed) {
            System.out.println("Joueur supprimé : " + joueur.getPrenom());
        } else {
            System.out.println("Joueur non trouvé pour suppression");
        }
    }
}
package joueur;

import joueur.dto.Joueur;

import java.util.ArrayList;
import java.util.List;

public class JoueurDaoImpl implements JoueurDao {
    private List<Joueur> joueurs;

    public JoueurDaoImpl() {
        joueurs = new ArrayList<>();
        joueurs.add(new Joueur("Bertrand", 1500));
        joueurs.add(new Joueur("Gyslaine", 1500));
        joueurs.add(new Joueur("Patoche", 1500));
    }

    @Override
    public List<Joueur> getTousLesJoueurs() {
        return new ArrayList<>(joueurs);
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
        boolean existe = joueurs.contains(joueur);
        if (existe) {
            joueurs.remove(joueur);
            System.out.println("le joueur " + joueur.getPrenom() + " a été supprimé");
        } else {
            System.out.println("Aucun joueur portant le nom " + joueur.getPrenom() + " n'a été trouvé");
        }
    }
}
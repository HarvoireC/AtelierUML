import joueur.Joueur;
import joueur.JoueurDao;
import joueur.JoueurDaoImpl;
import plateau.Case;
import plateau.Iterator;
import plateau.Plateau;

import java.util.List;


/**
 *
 *
 */
public class Main {
    public static void main(String[] args) {

        System.out.println("--------------------------------------------");
        System.out.println("-------------- Atelier 1 -------------------");
        System.out.println("--------------------------------------------");

        Banque b1 = Banque.getInstance();
        System.out.println(b1.getCash());

        Banque b2 = Banque.getInstance();
        System.out.println(b2.getCash());

        b1.setCash(2000);
        System.out.println("On affiche b2 apres avoir augmenter le cash avec b1");
        System.out.println(b2.getCash());

        System.out.println("--------------------------------------------");
        System.out.println("-------------- Atelier 2 -------------------");
        System.out.println("--------------------------------------------");

        ProprieteFactory terrainFactory = new TerrainFactory();
        ProprieteFactory gareFactory = new GareFactory();
        ProprieteFactory compagnieFactory = new CompagnieEEFactory();

        Propriete terrain1 = terrainFactory.creer("Rue de la Paix", 400);
        Propriete terrain2 = terrainFactory.creer("Rue de Courcelles", 100);
        Propriete gare1 = gareFactory.creer("Montparnasse", 200);

        terrain1.afficher();
        terrain2.afficher();
        gare1.afficher();

        System.out.println("--------------------------------------------");
        System.out.println("-------------- Atelier 3 -------------------");
        System.out.println("--------------------------------------------");
        // 1- Création d'un objet plateau
        System.out.println("=== 1. Création du plateau ===");
        Plateau plateau = new Plateau();
        System.out.println("Plateau créé avec succès!\n");

        // 2- Création des 10 premières cases du jeu et ajout dans le plateau
        System.out.println("=== 2. Création et ajout des cases ===");
        plateau.ajouterCase(new Case(0, "Départ"));
        plateau.ajouterCase(new Case(1, "Avenue des Champs-Élysées"));
        plateau.ajouterCase(new Case(2, "Caisse de communauté"));
        plateau.ajouterCase(new Case(3, "Rue de la Paix"));
        plateau.ajouterCase(new Case(4, "Gare du Nord"));
        plateau.ajouterCase(new Case(5, "Boulevard Saint-Michel"));
        plateau.ajouterCase(new Case(6, "Chance"));
        plateau.ajouterCase(new Case(7, "Place Pigalle"));
        plateau.ajouterCase(new Case(8, "Prison"));
        plateau.ajouterCase(new Case(9, "Avenue Mozart"));

        System.out.println("Nombre de cases créées : " + plateau.nbCases() + "\n");

        // 3- Boucle de parcours sur le plateau et affichage de chaque case
        System.out.println("=== 3. Parcours du plateau avec l'itérateur ===");
        Iterator iterator = plateau.iterator();
        try{
            while (iterator.hasNext()) {
                Case caseActuelle = iterator.next();
                caseActuelle.afficher();
            }

        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println("--------------------------------------------");
        System.out.println("-------------- Atelier 4 -------------------");
        System.out.println("--------------------------------------------");


        JoueurDao joueurDao = new JoueurDaoImpl();

        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║   GESTION DE LA PERSISTANCE DES JOUEURS   ║");
        System.out.println("╚════════════════════════════════════════════╝\n");

        // 1- Récupération de la liste des joueurs (3 joueurs préenregistrés)
        System.out.println("=== 1. RÉCUPÉRATION DE LA LISTE DES JOUEURS ===");
        List<Joueur> joueurs = joueurDao.getTousLesJoueurs();
        afficherJoueurs(joueurs);

        // 2- Ajout de 100€ à chaque joueur
        System.out.println("\n=== 2. AJOUT DE 100€ À CHAQUE JOUEUR ===");
        for (Joueur joueur : joueurs) {
            joueur.setCash(joueur.getCash() + 100);
            joueurDao.updateJoueur(joueur);
        }

        // 3- Mise à jour des joueurs
        System.out.println("\n=== 3. MISE À JOUR DES JOUEURS ===");
        Joueur alice = joueurs.get(0);
        alice.setCash(alice.getCash() + 500); // Alice gagne 500€ de plus
        joueurDao.updateJoueur(alice);

        // 4- Suppression d'un joueur
        System.out.println("\n=== 4. SUPPRESSION D'UN JOUEUR ===");
        Joueur joueurASupprimer = joueurs.get(1); // Bob
        joueurDao.deleteJoueur(joueurASupprimer);

        // 5- Récupération de la liste des joueurs pour affichage (boucle)
        System.out.println("\n=== 5. AFFICHAGE FINAL DE LA LISTE DES JOUEURS ===");
        List<Joueur> joueursFinaux = joueurDao.getTousLesJoueurs();
        afficherJoueurs(joueursFinaux);

        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║            FIN DU PROGRAMME                ║");
        System.out.println("╚════════════════════════════════════════════╝");
    }

    // Méthode utilitaire pour afficher les joueurs
    private static void afficherJoueurs(List<Joueur> joueurs) {
        if (joueurs.isEmpty()) {
            System.out.println("Aucun joueur enregistré.");
        } else {
            for (int i = 0; i < joueurs.size(); i++) {
                System.out.println((i + 1) + ". " + joueurs.get(i));
            }
        }


        System.out.println("\n=== Fin du parcours ===");
    }
}
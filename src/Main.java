import banque.Banque;
import joueur.JoueurDao;
import joueur.JoueurDaoImpl;
import joueur.controler.JoueurControler;
import joueur.dto.Joueur;
import joueur.presentation.JoueurVue;
import plateau.Case;
import plateau.Iterator;
import plateau.Plateau;
import typeCases.GareFactory;
import typeCases.Propriete;
import typeCases.ProprieteFactory;
import typeCases.TerrainFactory;

import java.util.List;


/**
 *
 *
 */
public class Main {
    public static void main(String[] args) {

        System.out.println("--------------------------------------------");
        System.out.println("-------------- Atelier 1 -------------------");
        System.out.println("--------------------------------------------\n");

        // 1- création d’un premier objet b1 de type Banque, cash=1000
        System.out.println("création d’un premier objet b1 de type Banque, cash=1000");
        Banque b1 = Banque.getInstance(1000);
        // 2- affichage du cash de b1
        System.out.println("Cash b1 : " + b1.getCash());
        // 3- création d’un second objet b2 de type Banque, cash=500
        System.out.println("création d’un second objet b2 de type Banque, cash=500");
        Banque b2 = Banque.getInstance(500);
        // 4- affichage du cash de b2
        System.out.println("Cash de b1 et de b2 apres la création de l'objet b2 :");
        System.out.println(" - Cash b2 : " + b2.getCash());
        // 5- affichage du cash de b1
        System.out.println(" - Cash b1 : " + b1.getCash());


        System.out.println("\n--------------------------------------------");
        System.out.println("-------------- Atelier 2 (V2)---------------");
        System.out.println("--------------------------------------------\n");

        // 1- création d’une factory terrainFactory et d’une factory gareFactory
        ProprieteFactory terrainFactory = new TerrainFactory();
        ProprieteFactory gareFactory = new GareFactory();

        //2- création des terrains Rue de la Paix - 400€, Rue de Courcelles – 100€, et affichage
        Propriete terrain1 = terrainFactory.creer("Rue de la Paix", 400);
        Propriete terrain2 = terrainFactory.creer("Rue de Courcelles", 100);
        System.out.println("création des terrains Rue de la Paix - 400€, Rue de Courcelles – 100€ : ");
        System.out.print("- terrain 1 : ");
        terrain1.afficher();
        System.out.print("- terrain 2 : ");
        terrain2.afficher();

        //3- création de la gare Montparnasse – 200€, et affichage
        Propriete gare1 = gareFactory.creer("Montparnasse", 200);
        System.out.println("création de la gare Montparnasse – 200€ :");
        System.out.print("- gare : ");
        gare1.afficher();

        System.out.println("\n--------------------------------------------");
        System.out.println("-------------- Atelier 3 -------------------");
        System.out.println("--------------------------------------------\n");
        // 1- Création d'un objet plateau
        System.out.println("Création du plateau");
        Plateau plateau = new Plateau();

        // 2- Création des 10 premières cases du jeu et ajout dans le plateau
        System.out.println("Création des 10 premières cases et ajout dans le plateau");
        plateau.ajouterCase(new Case(0, "Départ"));
        plateau.ajouterCase(new Case(1, "Avenue des Champs-Élysées"));
        plateau.ajouterCase(new Case(2, "Caisse de communauté"));
        plateau.ajouterCase(new Case(3, "Rue de la Paix"));
        plateau.ajouterCase(new Case(4, "typeCases.Gare du Nord"));
        plateau.ajouterCase(new Case(5, "Boulevard Saint-Michel"));
        plateau.ajouterCase(new Case(6, "Chance"));
        plateau.ajouterCase(new Case(7, "Place Pigalle"));
        plateau.ajouterCase(new Case(8, "Prison"));
        plateau.ajouterCase(new Case(9, "Avenue Mozart"));

        System.out.println("Nombre de cases créées : " + plateau.nbCases());

        // 3- Boucle de parcours sur le plateau et affichage de chaque case
        System.out.println("Parcours du plateau :");
        Iterator iterator = plateau.iterator();
        try {
            while (iterator.hasNext()) {
                Case caseActuelle = iterator.next();
                System.out.print(" - ");
                caseActuelle.afficher();
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace(System.err);
        }

        System.out.println("\n--------------------------------------------");
        System.out.println("-------------- Atelier 4 -------------------");
        System.out.println("--------------------------------------------\n");


        // 1- Récupération de la liste des joueurs (3 joueurs préenregistrés)
        JoueurDao joueurDao = new JoueurDaoImpl();
        System.out.println("Récupération de la liste des joueurs :");
        List<Joueur> joueurs = joueurDao.getTousLesJoueurs();
        afficherJoueurs(joueurs);

        // 2- Ajout de 100€ à chaque joueur
        // et
        // 3- mise à jour des joueurs
        System.out.println("\nAjout de 100€ à chaque joueurs et mise à jour des joueurs :");
        for (Joueur joueur : joueurs) {
            joueur.setCash(joueur.getCash() + 100); // 2-
            joueurDao.updateJoueur(joueur);         // 3-
        }

        // 4- Suppression d'un joueur
        Joueur joueurASupprimer = joueurs.get(0);
        System.out.println("\nSuppression du joueur : " + joueurASupprimer.getPrenom());
        joueurDao.deleteJoueur(joueurASupprimer);

        // 5- Récupération de la liste des joueurs pour affichage (boucle)
        System.out.println("\nListe finale des joueurs :");
        List<Joueur> joueursFinaux = joueurDao.getTousLesJoueurs();
        afficherJoueurs(joueursFinaux);

        System.out.println("\n--------------------------------------------");
        System.out.println("-------------- Atelier 5 -------------------");
        System.out.println("--------------------------------------------\n");

        //1- récupération d’un joueur de la base de données (simulé)
        System.out.println("Récupération de la liste des joueurs (Simulé dans la DAO :");
        List<Joueur> joueursSimules = joueurDao.getTousLesJoueurs();
        afficherJoueurs(joueursSimules);


        // 2- création d’une vue Joueur
        JoueurVue joueurVue1 = new JoueurVue();


        // 3- création d’un contrôleur Joueur et affichage (de la vue)
        JoueurControler joueurControler1 = new JoueurControler(joueurVue1, joueursSimules.get(0));
        joueurControler1.updateVue();

        // 4- ajout de 100€ au cash du joueur
        joueurControler1.setCash(joueurControler1.getCash() + 100);

        // 5- mise à jour de la vue
        joueurControler1.updateVue();

    }

    private static void afficherJoueurs(List<Joueur> joueurs) {
        for (Joueur joueur : joueurs) {
            System.out.print(" - ");
            System.out.println(joueur.toString());
        }
    }
}
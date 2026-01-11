package joueur.controler;

import joueur.dto.Joueur;
import joueur.presentation.JoueurVue;

public class JoueurControler {
    Joueur modele;
    JoueurVue vue;

    public JoueurControler(JoueurVue joueurVue, Joueur joueur) {
        this.vue = joueurVue;
        this.modele = joueur;
    }

    public String getPrenom() {
        return modele.getPrenom();
    }

    public void setPrenom(String prenom) {
        modele.setPrenom(prenom);
    }

    public int getCash() {
        return modele.getCash();
    }

    public void setCash(int cash) {
        modele.setCash(cash);
    }

    public void updateVue() {
        vue.afficherFicheJoueur(modele.getPrenom(), modele.getCash());
    }
}

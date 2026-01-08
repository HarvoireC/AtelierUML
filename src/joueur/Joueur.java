package joueur;

import java.util.ArrayList;
import java.util.List;

// ===== CLASSE MÉTIER JOUEUR =====
public class Joueur {
    private String prenom;
    private int cash;

    public Joueur(String prenom, int cash) {
        this.prenom = prenom;
        this.cash = cash;
    }

    // Getters
    public String getPrenom() {
        return prenom;
    }

    public int getCash() {
        return cash;
    }

    // Setters
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    @Override
    public String toString() {
        return "Joueur{prenom='" + prenom + "', cash=" + cash + "€}";
    }

}
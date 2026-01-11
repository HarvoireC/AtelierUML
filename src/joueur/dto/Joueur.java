package joueur.dto;

public class Joueur {
    private String prenom;
    private int cash;


    public Joueur(String prenom, int cash) {
        this.prenom = prenom;
        this.cash = cash;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    @Override
    public String toString() {
        return (prenom + " possède " + cash + "€");
    }

}
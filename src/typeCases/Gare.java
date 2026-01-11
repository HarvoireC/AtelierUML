package typeCases;

public class Gare extends Propriete {
    private String nom;
    private int prix;

    public Gare(Integer prix, String nom) {
        this.prix = prix;
        this.nom = nom;
    }

    @Override
    public void afficher() {
        System.out.println("la gare " + nom + " coute " + prix + "€");
    }

    @Override
    public void setPrix(int prix) {
        this.prix = prix;
    }

    @Override
    public int getPrix() {
        return this.prix;
    }

    @Override
    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String getNom() {
        return this.nom;
    }
}

package typeCases;

public class CompagnieEE extends Propriete {
    private String nom;
    private int prix;

    public CompagnieEE(int prix, String nom) {
        this.prix = prix;
        this.nom = nom;
    }

    @Override
    public void afficher() {
        System.out.println("la compagnie " + nom + " coute " + prix + "€");
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

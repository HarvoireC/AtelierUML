public class Gare extends Propriete{
    private String nom;
    private Integer prix;

    public Gare(Integer prix, String nom) {
        this.prix = prix;
        this.nom = nom;
    }

    @Override
    public void afficher() {
        System.out.println("la gare "+nom+" a un prix de "+prix);
    }

    @Override
    public void setPrix(Integer prix) {
        this.prix = prix;
    }

    @Override
    public Integer getPrix() {
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

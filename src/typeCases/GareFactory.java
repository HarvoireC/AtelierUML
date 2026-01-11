package typeCases;

public class GareFactory extends ProprieteFactory {

    @Override
    public Propriete creer(String nom, int prix) {
        return new Gare(prix, nom);
    }
}

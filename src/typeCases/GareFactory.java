package typeCases;

public class GareFactory extends ProprieteFactory{

    @Override
    public Propriete creer(String nom, Integer prix) {
        return new Gare(prix,nom);
    }
}

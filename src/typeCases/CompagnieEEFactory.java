package typeCases;

public class CompagnieEEFactory extends ProprieteFactory {
    @Override
    public Propriete creer(String nom, int prix) {
        return new CompagnieEE(prix, nom);
    }
}

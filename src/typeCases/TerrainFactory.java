package typeCases;

public class TerrainFactory extends ProprieteFactory{
    @Override
    public Propriete creer(String nom, int prix) {
        return new Terrain(prix,nom);
    }
}

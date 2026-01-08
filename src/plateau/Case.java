package plateau;

public class Case {
    private int numero;
    private String nom;

    public Case(int numero, String nom) {
        this.numero = numero;
        this.nom = nom;
    }

    public void afficher() {
        System.out.println("Case " + numero + ": " + nom);
    }
}
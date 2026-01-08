public final class Banque {
    private float cash;
    private static Banque instance;

    private Banque() {
        this.cash = 1000;
    }

    public static Banque getInstance() {
        return instance == null ? instance = new Banque() : instance;
    }

    public float getCash() {
        return cash;
    }

    public void setCash(float cash) {
        this.cash = cash;
    }
}

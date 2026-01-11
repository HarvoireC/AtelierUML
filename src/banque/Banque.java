package banque;

public final class Banque {
    private int cash;
    private static Banque instance;

    private Banque(int cash) {
        this.cash = cash;
    }

    public static Banque getInstance() {
        return instance == null ? instance = new Banque() : instance;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }
}

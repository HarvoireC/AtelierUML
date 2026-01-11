package banque;

public final class Banque {
    private int cash;
    private static Banque instance;

    private Banque(int cash) {
        this.cash = cash;
    }

    public static Banque getInstance(int cash) {
        return instance == null ? instance = new Banque(cash) : instance;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }
}

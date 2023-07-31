public class App {
    static final int NB_ROWS = 5;
    static final int NB_COL = 8;

    public static void main(String[] args) {
        // TODO scanner names
        Match m = new Match(NB_ROWS, NB_COL, new HumanPlayer("Anna"), new HumanPlayer("Bob"));
        m.run();
    }
}

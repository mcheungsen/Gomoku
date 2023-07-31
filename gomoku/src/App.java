import java.util.Scanner;

public class App {
    static final int NB_ROWS = 5;
    static final int NB_COL = 8;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Nom du premier joueur : ");
        String j1 =  s.nextLine();
        System.out.println("Nom du second joueur : ");
        String j2 = s.nextLine();

        Match m = new Match(NB_ROWS, NB_COL, new HumanPlayer(j1), new HumanPlayer(j2));
        m.run();
    }
}

import Exceptions.GamePlayerLeavesException;
import Exceptions.InvalidCoordinatesException;

// Un match, quifait dérouler une partie entre deux joueurs
public class Match {
    int row, col;
    Player j1, j2, currentJ;
    Color gagnant;

    public Match(int r, int c, Player j1, Player j2) {
        this.row = r;
        this.col = c;
        this.j1 = j1;
        this.j2 = j2;
        this.currentJ = j1;
        gagnant = Color.NONE;
    }

    public void run() {
        // Initialise le match
        Board board = new Board(row, col);
        Game game = new Game(board);
        boolean enJeu = true;


        // Run
        while (enJeu) {
            try {
                System.out.println("Joueur " + currentJ.getName() + " : ");
                Position p = currentJ.choice(board);

                if (game.play(p)) {
                    board.showBoard();
                    changePlayer();

                    // Jeu terminé si Board rempli
                    if (game.coups.size() == col*row){
                        enJeu = false;
                    }
                    // Le jeu est peut-être terminé
                    gagnant = game.getResult(p);

                    switch (gagnant){
                        case NONE :
                            if(!enJeu){
                                System.out.println("Match nul.");
                            }
                            break;
                        case BLACK:
                            enJeu = false;
                            System.out.println("gagnant : " + j1.getName());
                            break;
                        case WHITE:
                            enJeu = false;
                            System.out.println("Gagnant : " + j2.getName());
                    }


                } else {
                    System.out.println("Vous ne pouvez pas jouer sur cette case. Rejouez");
                }
            } catch (InvalidCoordinatesException e) {
                System.out.println(e.getMessage());
            } catch (GamePlayerLeavesException e) {
                System.out.println(e.getMessage());
                return;
            }

        }
    }

    private void changePlayer() {
        currentJ = (currentJ == j1 ? j2 : j1);
    }
}

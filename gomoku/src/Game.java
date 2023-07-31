import java.util.ArrayList;

// La partie, qui représente l'état du jeu

public class Game {
    Color nextPlayer;
    Board board;
    ArrayList<String> coups; // Liste des coups joués

    public Game(Board b){
        coups = new ArrayList<>();
        this.board = b;
        nextPlayer = Color.BLACK;
    }

    /**
     * Joue la position p donnée, si la position est jouable (=none).
     *  Il faut aussi que la position jouée, soit à côté d'un pion. (sauf premier tour)
     * @param p
     * @return
     */
    boolean play(Position p){
        boolean playable = false;

        if(board.get(p) != Color.NONE){ // On essaie de jouer sur un pion déjà posé
            return false;
        }

        if(coups.size() == 0){ // la partie vient de commencer, on pose où l'on veut
            playable = true;
        }
        else { // on est au milieu de la partie, on doit vérifier s'il y a un voisin
            for(int i = -1; i <= 1; i++){ // lignes
                for(int j = -1; j <= 1; j++){ // colonnes
                    if(p.row+i < App.NB_ROWS && p.row+i >= 0
                    && p.col+j < App.NB_COL && p.col+j >= 0)
                    {
                        if(board.board[p.row+i][p.col+j] != Color.NONE){
                            playable = true;
                            break;
                        }
                    }
                }
            }
        }
        
        // Si c'est jouable, on met à jour le board
        if(playable)
            updateBoard(p);
        return playable;
    }

    private void updateBoard(Position p) {
        board.set(p, nextPlayer);
        coups.add(nextPlayer.toString() + " : " + p.toString());
        nextPlayer = (nextPlayer == Color.BLACK) ? Color.WHITE : Color.BLACK;
    }


    /**
     * droite : p.l + 0 ; p.c + 1
     * gauche : p.l + 0 ; p.c - 1
     *
     * haut : p.l - 1 ; p.c + 0
     * bas : p.l + 1 ; p.c + 0
     *
     * droite haut : p.l - 1 ; p.c + 1
     * gauche bas : p.l + 1 ; p.c - 1
     *
     * droite bas : p.l + 1 ; p.c + 1
     * gauche haut : p.l - 1 ; p.c - 1
     *
     * @param p
     * @return
     */
    public Color getResult(Position p) {
        int sumH = 1 + alignementSum(p, 0, 1) + alignementSum(p, 0, -1); // Horizontal
        int sumV = 1 + alignementSum(p, -1, 0) + alignementSum(p, 1,0); // vertical
        int sumDD = 1 + alignementSum(p, -1, 1) + alignementSum(p, 1,-1); // Diagonal Droite
        int sumDG = 1 + alignementSum(p, -1, -1) + alignementSum(p, 1, +1); // Diagonal Gauche
        if(sumH >= 5 || sumV >= 5 || sumDD >= 5 || sumDG >= 5)
            return board.get(p);
        return Color.NONE;
    }

    public int alignementSum(Position p, int l, int c){
        int ligne = l;
        int colonne = c;

        boolean termine = false;
        int sum = 0;

        while(!termine && sum <= 4){
            if(p.row + ligne >= 0 && p.row + ligne < board.getRow()
            && p.col + colonne >= 0 && p.col + colonne < board.getCol()){
                Position next = new Position(p.row + ligne, p.col + colonne);
                if(board.get(p) == board.get(next)){
                    ligne += l;
                    colonne += c;
                    sum++;
                } else {
                    termine = true;
                }
            } else { // On dépasse le board
                termine = true;
            }
        }

        return sum;
    }
}

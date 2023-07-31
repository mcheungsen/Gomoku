import Exceptions.GamePlayerLeavesException;
import Exceptions.InvalidCoordinatesException;

public class Position {
    final int row, col;

    public Position(int row, int col){
        this.row = row;
        this.col = col;
    }

    public Position(String pos) throws InvalidCoordinatesException, GamePlayerLeavesException {
        if(pos.equals("/quit"))
            throw new GamePlayerLeavesException("Quitter le jeu.");
        if(pos.length() != 2)
            throw new InvalidCoordinatesException("Taille invalide");

        int c = pos.charAt(0) - 65;
        int r = Character.getNumericValue(pos.charAt(1)) - 1;

        if(r < 0 || c < 0 || r >= App.NB_ROWS || c >= App.NB_COL){
            throw new InvalidCoordinatesException("Coordonnées invalides");
        }

        this.row = r;
        this.col = c;
    }
}

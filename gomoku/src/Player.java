import Exceptions.GamePlayerLeavesException;
import Exceptions.InvalidCoordinatesException;

// Joueur, qui indique le coup qu'il choisit d'effectuer à
// chaque moment de la partie
public interface Player {
    Position choice(Board b) throws InvalidCoordinatesException, GamePlayerLeavesException;
    String getName();
}

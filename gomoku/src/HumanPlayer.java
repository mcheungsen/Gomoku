import Exceptions.GamePlayerLeavesException;
import Exceptions.InvalidCoordinatesException;

import java.util.Scanner;

public class HumanPlayer implements Player{
    String name;

    public HumanPlayer(String name){
        this.name = name;
    }
    @Override
    public Position choice(Board b) throws InvalidCoordinatesException, GamePlayerLeavesException {
        Scanner s = new Scanner(System.in);
        String res =  s.nextLine().trim();
        Position p = new Position(res);
        return p;
    }

    @Override
    public String getName() {
        return name;
    }
}

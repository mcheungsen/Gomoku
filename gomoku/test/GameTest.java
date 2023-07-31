import Exceptions.GamePlayerLeavesException;
import Exceptions.InvalidCoordinatesException;
import org.junit.Assert;
import org.junit.Test;

public class GameTest {

    @Test
    public void testDiagonaleDroite() throws GamePlayerLeavesException, InvalidCoordinatesException {
        Board b = new Board(5,8);
        b.set(new Position("H1"), Color.WHITE);
        b.set(new Position("G2"), Color.WHITE);
        b.set(new Position("F3"), Color.WHITE);
        b.set(new Position("E4"), Color.WHITE);
        b.set(new Position("D5"), Color.WHITE);

        Game game = new Game(b);

        Assert.assertEquals(Color.WHITE,game.getResult(new Position("H1")));
        Assert.assertEquals(Color.WHITE,game.getResult(new Position("G2")));
        Assert.assertEquals(Color.WHITE,game.getResult(new Position("F3")));
        Assert.assertEquals(Color.WHITE,game.getResult(new Position("E4")));
        Assert.assertEquals(Color.WHITE,game.getResult(new Position("D5")));
        Assert.assertEquals(Color.NONE,game.getResult(new Position("H4")));
    }

    @Test
    public void testDiagonaleGauche() throws GamePlayerLeavesException, InvalidCoordinatesException {
        Board b = new Board(5,8);
        b.set(new Position("A1"), Color.BLACK);
        b.set(new Position("B2"), Color.BLACK);
        b.set(new Position("C3"), Color.BLACK);
        b.set(new Position("D4"), Color.BLACK);
        b.set(new Position("E5"), Color.BLACK);

        Game game = new Game(b);

        Assert.assertEquals(Color.BLACK,game.getResult(new Position("A1")));
        Assert.assertEquals(Color.BLACK,game.getResult(new Position("B2")));
        Assert.assertEquals(Color.BLACK,game.getResult(new Position("C3")));
        Assert.assertEquals(Color.BLACK,game.getResult(new Position("D4")));
        Assert.assertEquals(Color.BLACK,game.getResult(new Position("E5")));
        Assert.assertEquals(Color.NONE,game.getResult(new Position("H4")));
    }

    @Test
    public void testHorizontal() throws GamePlayerLeavesException, InvalidCoordinatesException {
        Board b = new Board(5,8);
        b.set(new Position("A1"), Color.WHITE);
        b.set(new Position("B1"), Color.WHITE);
        b.set(new Position("C1"), Color.WHITE);
        b.set(new Position("D1"), Color.WHITE);
        b.set(new Position("E1"), Color.WHITE);

        Game game = new Game(b);

        Assert.assertEquals(Color.WHITE, game.getResult(new Position("A1")));
        Assert.assertEquals(Color.WHITE, game.getResult(new Position("B1")));
        Assert.assertEquals(Color.WHITE, game.getResult(new Position("C1")));
        Assert.assertEquals(Color.WHITE, game.getResult(new Position("D1")));
        Assert.assertEquals(Color.WHITE, game.getResult(new Position("E1")));
        Assert.assertEquals(Color.NONE, game.getResult(new Position("F1")));
    }

    @Test
    public void testVertical() throws GamePlayerLeavesException, InvalidCoordinatesException {
        Board b = new Board(5, 8);
        b.set(new Position("A1"), Color.WHITE);
        b.set(new Position("A2"), Color.WHITE);
        b.set(new Position("A3"), Color.WHITE);
        b.set(new Position("A4"), Color.WHITE);
        b.set(new Position("A5"), Color.WHITE);

        Game game = new Game(b);

        Assert.assertEquals(Color.WHITE, game.getResult(new Position("A1")));
        Assert.assertEquals(Color.WHITE, game.getResult(new Position("A2")));
        Assert.assertEquals(Color.WHITE, game.getResult(new Position("A3")));
        Assert.assertEquals(Color.WHITE, game.getResult(new Position("A4")));
        Assert.assertEquals(Color.WHITE, game.getResult(new Position("A5")));
        Assert.assertEquals(Color.NONE, game.getResult(new Position("B1")));
    }
}

import Exceptions.GamePlayerLeavesException;
import Exceptions.InvalidCoordinatesException;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertThrows;


public class PositionTest {

    @Test
    public void testValidPositionString() throws InvalidCoordinatesException, GamePlayerLeavesException {
        Position p = new Position("A4");
        Assert.assertEquals(3,p.row);
        Assert.assertEquals(0, p.col);
    }

    @Test(expected = GamePlayerLeavesException.class)
    public void testQuitGame() throws GamePlayerLeavesException, InvalidCoordinatesException {
        String str = "/quit";
        Position p = new Position(str);
    }

    @Test
    public void testInvalidPosition(){
        assertThrows(InvalidCoordinatesException.class, () -> new Position("M333"));
        assertThrows(InvalidCoordinatesException.class, () -> new Position("A12B"));
        assertThrows(InvalidCoordinatesException.class, () -> new Position("XYZ"));
        assertThrows(InvalidCoordinatesException.class, () -> new Position("5"));
        assertThrows(InvalidCoordinatesException.class, () -> new Position("-1"));
    }

}

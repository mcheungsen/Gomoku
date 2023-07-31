import Exceptions.GamePlayerLeavesException;
import Exceptions.InvalidCoordinatesException;
import org.junit.Assert;
import org.junit.Test;


public class PositionTest {

    @Test
    public void checkPosition() throws InvalidCoordinatesException, GamePlayerLeavesException {
        Position p = new Position("A4");
        Assert.assertEquals(0,p.row);
        Assert.assertEquals(3, p.col);
    }

}

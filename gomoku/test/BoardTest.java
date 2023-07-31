import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BoardTest {
    Board b;


    @Before
    public void initialize(){
        b = new Board(5,4);
    }

    @Test
    public void testAttributes(){
        Assert.assertEquals(5, b.getRow());
        Assert.assertEquals(4, b.getCol());

        for(int i = 0; i < b.getRow(); i++){
            for (int j = 0; j < b.getCol(); j++){
                Assert.assertEquals(Color.NONE, b.get(new Position(i,j)));
                b.set(new Position(i,j), Color.WHITE);
                Assert.assertEquals(Color.WHITE, b.get(new Position(i,j)));
                b.set(new Position(i,j), Color.BLACK);
                Assert.assertEquals(Color.BLACK, b.get(new Position(i,j)));
            }
        }


    }
}

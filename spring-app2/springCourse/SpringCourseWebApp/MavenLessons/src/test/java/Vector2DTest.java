import org.junit.Assert;
import org.junit.Test;

public class Vector2DTest {
    @Test
    public void newVectorShouldHaveZeroLength(){
        Vector2D v1 = new Vector2D(); //action

        //assertation
        Assert.assertEquals(0, v1.getLength(), 1e-9); //such delta to use with double variables
    }
}

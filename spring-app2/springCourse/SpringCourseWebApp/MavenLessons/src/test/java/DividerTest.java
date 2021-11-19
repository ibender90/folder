import org.junit.Assert;
import org.junit.Test;


public class DividerTest {

    @Test(expected = ArithmeticException.class)
    public void zeroDelimiterShouldThrowException(){
        Divider.divide(1, 0);
    }
}

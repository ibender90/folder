import org.junit.Test;

public class SlowInitializerTest {
    @Test(timeout = 1000)
    public void methodShouldReturnFasterThanOneSecond(){
        SlowInitializer.initialize();
    }
}

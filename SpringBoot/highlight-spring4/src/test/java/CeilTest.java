import org.junit.Test;

/**
 * Created by wangqi on 16/4/12.
 */
public class CeilTest {

    @Test
    public void testCeil() {
        int i = 5;
        int j = 2;
        int h = (int) Math.ceil(i*1.0/j);
        System.out.println(h);
    }

}

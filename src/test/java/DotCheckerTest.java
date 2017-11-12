import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


/**
 * Created by 4oc3p on 11.11.2017. temp
 */
public class DotCheckerTest {

    @Test
    public void ox_parallel_is() throws Exception {
        boolean inCapsule = new DotChecker(1, 3, 10, 3, 4, 4, 3).isInCapsule();
        assertThat(inCapsule, is(true));
    }

    @Test
    public void ox_parallel_not() throws Exception {
        boolean inCapsule = new DotChecker(1, 3, 10, 3, 7, 7, 3).isInCapsule();
        assertThat(inCapsule, is(false));
    }

    @Test
    public void oy_parallel_is() throws Exception {
        boolean inCapsule = new DotChecker(3, 2, 3, 12, 7, 3, 4).isInCapsule();
        assertThat(inCapsule, is(true));
    }

    @Test
    public void oy_parallel_not() throws Exception {
        boolean inCapsule = new DotChecker(1, 2, 1, 5, 3, 6, 1).isInCapsule();
        assertThat(inCapsule, is(false));
    }

    @Test
    public void random1() throws Exception {
        boolean inCapsule = new DotChecker(5.2, 2,8.89, 3.12, 5, 7.77, 4.1).isInCapsule();
        assertThat(inCapsule, is(false));
    }

    @Test
    public void random2() throws Exception {
        boolean inCapsule = new DotChecker(1.74, 12,5.555, 0.12, 20.003, 3, 4.04).isInCapsule();
        System.out.println(inCapsule);
    }
}
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
        boolean inCapsule = new DotChecker(1.74, 12,5.555, 0.12, 4.22134, 3, 4.04).isInCapsule();
        assertThat(inCapsule, is(true));
    }

    @Test
    public void randomLoop() throws Exception {
        double x1, y1, x2, y2, x0, y0, d;
        for (int i = 0; i < 20; i++) {
            x1 = random(); y1 = random(); x2 = random(); y2 = random(); x0 = random(); y0 = random(); d = random();
            DotChecker q = new DotChecker(x1, y1, x2, y2, x0, y0, d);
            System.out.printf("A(%f, %f); B(%f, %f; O(%f, %f); D = %f; %b\n", x1,y1,x2,y2,x0,y0,d,q.isInCapsule());
        }
    }

    private double random(){
        return (Math.random() * 10);
    }
}
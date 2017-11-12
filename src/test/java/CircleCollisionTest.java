import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by 4oc3p on 09.11.2017. temp
 */
public class CircleCollisionTest {
    @Test
    public void name() throws Exception {
        CircleCollision circleCollision1 = new CircleCollision(1, 2, 1000, 1000, 1, 1);
        assertThat(circleCollision1.isIntersected(), is("Not intersected"));
        System.out.println(circleCollision1.isIntersected());

        CircleCollision circleCollision2 = new CircleCollision(0, 0, 2, 2, 1000, 5);
        System.out.println(circleCollision2.isIntersected());

        CircleCollision circleCollision3 = new CircleCollision(-1, -1, 2, 2, 2, 3 );
        System.out.println(circleCollision3.isIntersected());
    }
}
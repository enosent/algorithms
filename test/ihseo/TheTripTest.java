package ihseo;

import org.junit.Test;
import programming.TheTrip;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: enosent7
 * Date: 13. 3. 2.
 * Time: 오전 10:24
 * To change this template use File | Settings | File Templates.
 */
public class TheTripTest {

    @Test
    public void theTrip4nTest() {

        TheTrip trip = new TheTrip();

        float[] money = new float[]{15.00f, 15.01f, 3.00f, 3.01f};


        double result = trip.distribution(money);

        assertThat(result, is(11.99));
    }

    @Test
    public void theTrip3nTest() {

        TheTrip trip = new TheTrip();

        float[] money = new float[]{10.00f,20.00f,30.00f};


        double result = trip.distribution(money);

        assertThat(result, is(10.00));
    }
}

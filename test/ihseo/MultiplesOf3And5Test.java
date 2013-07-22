package ihseo;

import org.junit.*;
import programming.MultiplesOf3And5;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: enosent7
 * Date: 13. 1. 9.
 * Time: 오후 6:01
 * To change this template use File | Settings | File Templates.
 */
public class MultiplesOf3And5Test {
    @Test
    public void testSumOfMultiples() throws Exception {
        MultiplesOf3And5 multiplesOf3And5 = new MultiplesOf3And5();

        int result = multiplesOf3And5.sumOfMultiples(10);

        assertThat(result, is(23));

        result = multiplesOf3And5.sumOfMultiples(1000);

        assertThat(result, is(233168));


    }
}

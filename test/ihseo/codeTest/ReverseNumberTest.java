package ihseo.codeTest;

import org.junit.Test;
import programming.codeTest.ReverseNumber;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * User: enosent7
 * Date: 13. 8. 8.
 * Time: 오전 11:32
 */
public class ReverseNumberTest {

    @Test
    public void reverseNumberTest(){
        ReverseNumber reverse = new ReverseNumber();

        assertThat(reverse.reserveNumber(123456), is(654321));
        assertThat(reverse.reserveNumber(1), is(1));
        assertThat(reverse.reserveNumber(1234), is(4321));
        assertThat(reverse.reserveNumber(3245), is(5423));
    }


}

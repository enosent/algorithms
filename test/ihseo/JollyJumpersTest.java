package ihseo;

import org.junit.Test;
import programming.JollyJumpers;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: enosent7
 * Date: 13. 6. 22.
 * Time: 오전 10:42
 * To change this template use File | Settings | File Templates.
 */
public class JollyJumpersTest {


    @Test
    public void jollyTest() throws Exception {
        JollyJumpers jollyJumper = new JollyJumpers();

//        int[] input1 = new int[]{1,4,2,3};
//        String result1 = jollyJumper.jollyCheck(input1);

//        assertThat(result1, is("Jolly"));

        int[] input2 = new int[]{1,4,2,-1,6};
        String result2 = jollyJumper.jollyCheck(input2);

        assertThat(result2, is("Not jolly"));
    }


}

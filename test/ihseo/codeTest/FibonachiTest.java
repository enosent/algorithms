package ihseo.codeTest;

import org.junit.Test;
import programming.codeTest.Fibonacci;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * User: enosent7
 * Date: 13. 8. 8.
 * Time: 오후 12:50
 */
public class FibonachiTest {

    @Test
    public void fibonachiTest(){
        Fibonacci fibonacci = new Fibonacci();

        /*
        1 1 2 3 5 8 13 21 34 ...

        F(9) = F(8) + F(7);
        F(8) = F(7) + F(6);
         */

        assertThat(fibonacci.fibonacci(9), is(34));
        assertThat(fibonacci.fibonacci(2), is(1));
        assertThat(fibonacci.fibonacci(3), is(2));
    }

    @Test
    public void recursiveFibonacciTest(){
        Fibonacci fibonacci = new Fibonacci();

        assertThat(fibonacci.recursiveFibonacci(9), is(34));
        assertThat(fibonacci.recursiveFibonacci(2), is(1));
        assertThat(fibonacci.recursiveFibonacci(3), is(2));
    }
}

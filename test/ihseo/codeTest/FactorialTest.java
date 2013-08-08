package ihseo.codeTest;

import org.junit.Test;
import programming.codeTest.Factorial;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * User: enosent7
 * Date: 13. 8. 8.
 * Time: 오후 12:25
 */
public class FactorialTest {

    @Test
    public void factorialTest(){
        // 5! = 5*4*3*2*1 -> 120
        Factorial factorial = new Factorial();

        assertThat(factorial.factorial(5), is(120));
        assertThat(factorial.factorial(0), is(1));
        assertThat(factorial.factorial(1), is(1));
        assertThat(factorial.factorial(12), is(479001600));
    }

    // 재귀함수
    @Test
    public void recursiveFactorialTest(){
        // 5! = 5*4*3*2*1 -> 120
        Factorial factorial = new Factorial();

        assertThat(factorial.recursiveFactorial(5), is(120));
        assertThat(factorial.recursiveFactorial(0), is(1));
        assertThat(factorial.recursiveFactorial(1), is(1));
        assertThat(factorial.recursiveFactorial(12), is(479001600));
    }
}

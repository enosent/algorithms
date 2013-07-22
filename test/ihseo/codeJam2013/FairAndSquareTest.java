package ihseo.codeJam2013;

import org.junit.Test;
import programming.codeJam2013.FairAndSquare;

import java.io.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: enosent7
 * Date: 13. 4. 13.
 * Time: 오후 11:49
 * To change this template use File | Settings | File Templates.
 */
public class FairAndSquareTest {

    @Test
    public void codeJamTest() throws Exception {
        FairAndSquare test = new FairAndSquare();

//        assertThat(test.palindromes("1", "4"), is(2));
//        assertThat(test.palindromes("10", "120"), is(0));
        assertThat(test.palindromes("40704", "1211124711121"), is(2));
    }

    @Test
    public void methodTest(){
        FairAndSquare test = new FairAndSquare();

        test.isPalindrome("1234567");
    }

    @Test
    public void smallInputTest() throws IOException {
        FairAndSquare test = new FairAndSquare();
        BufferedReader in = new BufferedReader(new FileReader("/Users/enosent7/eno-java/workspace/project/algorithms/test/ihseo/codeJam2013/C-large-1.in"));
//        BufferedReader in = new BufferedReader(new FileReader("/Users/enosent7/eno-java/workspace/project/algorithms/test/ihseo/codeJam2013/A-large.in"));
        String input;
        int n = 0;
        String output = "";
        while ((input = in.readLine()) != null) {
            if(n > 0){

                String[] inputs = input.split(" ");

                output += "Case #" + n + ": " + test.palindromes(inputs[0], inputs[1]) + "\n";
            }
            n++;
        }
        in.close();

        System.out.println(output);

        BufferedWriter out = new BufferedWriter(new FileWriter("/Users/enosent7/eno-java/workspace/project/algorithms/test/ihseo/codeJam2013/C-large-1.out"));
//        BufferedWriter out = new BufferedWriter(new FileWriter("/Users/enosent7/eno-java/workspace/project/algorithms/test/ihseo/codeJam2013/A-large.out"));
        out.write(output);
        out.close();
    }
}

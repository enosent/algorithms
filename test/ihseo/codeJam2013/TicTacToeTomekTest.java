package ihseo.codeJam2013;

import org.junit.Test;
import programming.codeJam2013.TicTacToeTomek;

import java.io.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: enosent7
 * Date: 13. 4. 13.
 * Time: 오전 11:20
 * To change this template use File | Settings | File Templates.
 */
public class TicTacToeTomekTest {

    @Test
    public void codeJamTest() throws Exception {
        TicTacToeTomek test = new TicTacToeTomek();
        String result = "";

        result = test.ticTacToeTomek(new String[][]{
                {"X", "X", "X", "T"},
                {".", ".", ".", "."},
                {"O", "O", ".", "."},
                {".", ".", ".", "."}
        });

        assertThat(result, is("X won"));

        result = test.ticTacToeTomek(new String[][]{
                {"X", "O", "X", "T"},
                {"X", "X", "O", "O"},
                {"O", "X", "O", "X"},
                {"X", "X", "O", "O"}
        });

        assertThat(result, is("Draw"));


        result = test.ticTacToeTomek(new String[][]{
                {"X", "O", "X", "."},
                {"O", "X", ".", "."},
                {".", ".", ".", "."},
                {".", ".", ".", "."}
        });

        assertThat(result, is("Game has not completed"));

        result = test.ticTacToeTomek(new String[][]{
                {"O", "O", "X", "X"},
                {"O", "X", "X", "X"},
                {"O", "X", ".", "T"},
                {"O", ".", ".", "O"}
        });

        assertThat(result, is("O won"));

        result = test.ticTacToeTomek(new String[][]{
                {"X", "X", "X", "O"},
                {".", ".", "O", "."},
                {".", "O", ".", "."},
                {"T", ".", ".", "."}
        });

        assertThat(result, is("O won"));

        result = test.ticTacToeTomek(new String[][]{
                {"O", "X", "X", "X"},
                {"X", "O", ".", "."},
                {".", ".", "O", "."},
                {".", ".", ".", "O"}
        });

        assertThat(result, is("O won"));

        result = test.ticTacToeTomek(new String[][]{
                {"O", "X", "X", "X"},
                {"X", "O", "X", "."},
                {".", ".", "X", "."},
                {".", ".", "X", "O"}
        });

        assertThat(result, is("X won"));

        result = test.ticTacToeTomek(new String[][]{
                {"O", ".", "X", "X"},
                {"X", "X", "O", "O"},
                {"T", "O", "X", "X"},
                {"O", "O", "O", "X"}
        });

        assertThat(result, is("Game has not completed"));
    }

    @Test
    public void smallInputTest() throws IOException {
        TicTacToeTomek test = new TicTacToeTomek();
        BufferedReader in = new BufferedReader(new FileReader("/Users/enosent7/eno-java/workspace/project/algorithms/test/ihseo/codeJam2013/A-small-attempt1.in"));
//        BufferedReader in = new BufferedReader(new FileReader("/Users/enosent7/eno-java/workspace/project/algorithms/test/ihseo/codeJam2013/A-large.in"));
        String input;
        int n = 0;
        String output = "";
        String[][] inputs = new String[4][4];
        while ((input = in.readLine()) != null) {
            if(n > 0){

                if(input != null && !"".equals(input)){
                    for(int i = 0; i < inputs.length; i++){
                        for(int j = 0; j < inputs[i].length; j++){
                            inputs[i][j] = String.valueOf(input.charAt(j));
                        }

                        input = in.readLine();
                    }
                }

                output += "Case #" + n + ": " + test.ticTacToeTomek(inputs) + "\n";
            }
            n++;
        }
        in.close();

        System.out.println(output);

        BufferedWriter out = new BufferedWriter(new FileWriter("/Users/enosent7/eno-java/workspace/project/algorithms/test/ihseo/codeJam2013/A-small-attempt1.out"));
//        BufferedWriter out = new BufferedWriter(new FileWriter("/Users/enosent7/eno-java/workspace/project/algorithms/test/ihseo/codeJam2013/A-large.out"));
        out.write(output);
        out.close();
    }

    /*
    @Test
    public void largeInputTest() throws IOException {
        TicTacToeTomek test = new TicTacToeTomek();
        BufferedReader in = new BufferedReader(new FileReader("/Users/enosent7/eno-java/workspace/Test/telepathy/test/quize/number02/A-large-practice.in"));
        String input;
        int n = 0;
        String output = "";
        while ((input = in.readLine()) != null) {
            if(n > 0){
                String[] inputs = input.split(" ");
                output += "Case #" + n + ": " + number.codeJam(inputs[0], inputs[1], inputs[2]) + "\n";
            }
            n++;
        }
        in.close();

        System.out.println(output);

        BufferedWriter out = new BufferedWriter(new FileWriter("/Users/enosent7/eno-java/workspace/Test/telepathy/test/quize/number02/A-large-practice.out"));
        out.write(output);
        out.close();
    }
    */
}

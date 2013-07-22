package ihseo;

import programming.Interpreter;

/**
 * Created with IntelliJ IDEA.
 * User: enosent7
 * Date: 13. 3. 16.
 * Time: 오후 3:03
 * To change this template use File | Settings | File Templates.
 */
public class InterpreterTest {

    public static void main(String[] args) {
        int caseNumber = 1;
        int[] inputs = {
                 299
                ,492
                ,495
                ,399
                ,492
                ,495
                ,399
                ,283
                ,279
                ,689
                ,78
                ,100
                ,000
                ,000
                ,000
        };

        Interpreter interpreter = new Interpreter();

        interpreter.interpreter(caseNumber,inputs);
    }
}

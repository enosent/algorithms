package ihseo;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: enosent7
 * Date: 13. 3. 11.
 * Time: 오전 11:51
 * To change this template use File | Settings | File Templates.
 */
public class StackTest {

    static int i = 0;
    public static void main(String[] args) {

        Stack stack = new Stack();

        stack.push("Test");

        while(!stack.empty()){
            System.out.println(stack.pop());

            stackPush(stack, i++);

        }

        char[][] im = new char[5][6];

        for(int i = 0; i < im.length; i++){
            for(int j = 0; j < im[0].length; j++) {
                System.out.print(im[i][j]);
            }
            System.out.println();
        }
    }

    public static void stackPush(Stack stack, int j){
        if(j < 10)
            stack.push("A");
    }
}

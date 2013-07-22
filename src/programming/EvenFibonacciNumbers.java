package programming;

/**
 * Created with IntelliJ IDEA.
 * User: enosent7
 * Date: 13. 1. 9.
 * Time: 오후 6:25
 * To change this template use File | Settings | File Templates.
 */
public class EvenFibonacciNumbers {

    public static void main(String[] args) {
        int term = 0;

        int first = 1;
        int second = 2;
        int total = 0;

        while(total < 4000000) {
            if(second%2 == 0) term +=second;

            total = second + first;
            first = second;
            second = total;

        }

//        System.out.println(total);
    }

}

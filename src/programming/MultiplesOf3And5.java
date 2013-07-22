package programming;

/**
 * Created with IntelliJ IDEA.
 * User: enosent7
 * Date: 13. 1. 9.
 * Time: 오후 5:50
 * To change this template use File | Settings | File Templates.
 */
public class MultiplesOf3And5 {

    public int sumOfMultiples(int num) {
        int sum = 0;

        for(int loop = 1; loop < num; loop++) {
            if(loop%3 == 0 || loop%5 == 0){
//                System.out.println(loop);
                sum += loop;
            }
        }

        return sum;
    }
}

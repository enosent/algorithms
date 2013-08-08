package programming.codeTest;

/**
 * User: enosent7
 * Date: 13. 8. 8.
 * Time: 오후 12:50
 */
public class Fibonacci {

    public int fibonacci(int num) {
        if(num <= 2) return 1;
        int temp1;
        int temp2=1;

        int result = 1;
        for(int i = 2; i < num; i++){
            temp1 = temp2;
            temp2 = result;
            result = temp2 + temp1;
        }

        return result;
    }

    // 재귀함수
    public int recursiveFibonacci(int num){
        if(num <= 2) return 1;

        return recursiveFibonacci(num-2) + recursiveFibonacci(num-1);
    }
}

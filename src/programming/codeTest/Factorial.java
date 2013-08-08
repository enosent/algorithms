package programming.codeTest;

/**
 * User: enosent7
 * Date: 13. 8. 8.
 * Time: 오후 12:24
 */
public class Factorial {
    public int factorial(int number) {

        int result = 1;
        for(int i = number; i > 0; i--){
            result *= i;
        }

        return result;  //To change body of created methods use File | Settings | File Templates.
    }


    public int recursiveFactorial(int number){
        if(number == 0){
            return 1;
        }

        return number * recursiveFactorial(number-1);
    }
}

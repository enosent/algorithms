package programming.codeTest;

/**
 * User: enosent7
 * Date: 13. 8. 8.
 * Time: 오전 11:30
 */
public class ReverseNumber {
    /*
    123456 -> 654321
    배열 사용하지 않고 ...
     */

    public int reserveNumber(int number) {
        String testString = String.valueOf(number);
        int size = testString.length();

        if(size <= 1) return number;

        int limit = (int)Math.pow(10, size+1);

        String reverse = "";

        for(int i =10; i < limit; i*=10){
            int temp = number%i - number%(i/10);
            reverse += (temp/(i/10));
        }

        return Integer.parseInt(reverse);
    }

}

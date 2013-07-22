package programming.codeJam2013;

/**
 * Created with IntelliJ IDEA.
 * User: enosent7
 * Date: 13. 4. 13.
 * Time: 오후 11:39
 * To change this template use File | Settings | File Templates.
 */
public class FairAndSquare {

    public int palindromes(String begin, String end){

        int count = 0;

        long x = Long.parseLong(begin);
        long y = Long.parseLong(end);

        for(long i = x; i <= y; i++){

            String temp = String.valueOf(i);
            long sqrt = (long)Math.sqrt(i);

            if(isPalindrome(temp)){

                if(i%sqrt == 0){
                    String check = String.valueOf(sqrt);

//                    System.out.println(check);
                    if(isPalindrome(check)) count++;
                }
            }
        }


        System.out.println(count);

        return count;
    }

    public boolean isPalindrome(String value){

        boolean result = true;
        if(value.length() > 1){

            for(int i = 0; i < (value.length())/2; i++){

                if(value.charAt(i) == value.charAt(value.length() - 1 - i)){
                    result = true;
                }
                else{
                    result =  false;
                    break;
                }

            }
        }
        else if(value.length() == 1){
            result = true;
        }
        else {
            result = false;
        }


        return result;
    }
}

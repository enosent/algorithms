package programming;

/**
 * Created with IntelliJ IDEA.
 * User: enosent7
 * Date: 13. 6. 22.
 * Time: 오전 10:42
 * To change this template use File | Settings | File Templates.
 */
public class JollyJumpers {

    public String jollyCheck(int[] input){
        String message = "Jolly";


        for(int i = 1; i < input.length-1; i++) {

            int preDiff = Math.abs(input[i-1] - input[i]) -1;
            int postDiff = Math.abs(input[i+1] - input[i]);

            if(preDiff != postDiff) {
                message = "Not jolly";
                break;
            }

        }

        return message;
    }


}

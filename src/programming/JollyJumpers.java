package programming;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: enosent7
 * Date: 13. 6. 22.
 * Time: 오전 10:42
 * To change this template use File | Settings | File Templates.
 */
public class JollyJumpers {

    public String jollyCheck(int[] input){

        String success = "Jolly";
        String fail = "Not jolly";

        int size = input.length;

        if(size == 1) return success;

        ArrayList<Integer> diffs = new ArrayList<Integer>();

        for(int i = 0; i < size-1; i++) {
            int diff = Math.abs(input[i] - input[i+1]);

            if(diff > size) return fail;

            diffs.add(new Integer(diff));
        }

        for(int i = 1; i < size; i++){
            if(!diffs.contains(new Integer(i))){
                return fail;
            }
        }

        return success;
    }

}
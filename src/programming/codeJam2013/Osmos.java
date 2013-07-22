package programming.codeJam2013;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: enosent7
 * Date: 13. 5. 5.
 * Time: 오전 1:29
 * To change this template use File | Settings | File Templates.
 */
public class Osmos {

    public int osmos(int mote, int[] motes){
        int count = 0;

        Arrays.sort(motes);

        for(int i = 0; i < motes.length-1; i++){
            mote += motes[i];
        }


        for(int i = motes.length-1; i > 0; i--){
            System.out.println("mote : " + mote + " | motes["+i+"] : " + motes[i]);

            if(motes[i] < mote) break;
            else {
                mote -= motes[i-1];
                count++;
            }
        }

        System.out.println(count);

        return 0;
    }

}

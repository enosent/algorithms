package programming;

import java.text.*;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: enosent7
 * Date: 13. 3. 2.
 * Time: 오전 10:10
 * To change this template use File | Settings | File Templates.
 */
public class TheTrip {

    // You can insert more classes here if you want.
    public double distribution(float[] money){
        int total = 0;
        int result = 0;

        int size = money.length;

        int[] convertMoney = new int[size];
        for(int i = 0; i < size; i++){
            convertMoney[i] = (int)Math.round(money[i] * 100);
            total += Math.round(money[i] * 100);
        }

        int average = total/size;
        int diff = total%size;

        Arrays.sort(convertMoney);

        int[] avgs = new int[size];
        for(int i = 0; i < size; i++){ avgs[i] = average; }
        for(int i = size-1; i >= (size-diff); i--){
            avgs[i] = average+1;
        }

        for(int i = 0; i < size; i++){
            result += Math.abs(convertMoney[i] - avgs[i]);
        }

        result = result/2;

        return (double)result/100;
    }
}

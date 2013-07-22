package programming.p110103;

import java.io.*;
import java.math.BigDecimal;
import java.util.*;

public class Main implements Runnable{
    static String ReadLn(int maxLength){  // utility function to read from stdin,
        // Provided by Programming-challenges, edit for style only
        byte line[] = new byte [maxLength];
        int length = 0;
        int input = -1;
        try{
            while (length < maxLength){//Read untill maxlength
                input = System.in.read();
                if ((input < 0) || (input == '\n')) break; //or untill end of line ninput
                line [length++] += input;
            }

            if ((input < 0) && (length == 0)) return null;  // eof
            return new String(line, 0, length);
        }catch (IOException e){
            return null;
        }
    }

    public static void main(String args[])  // entry point from OS
    {
        Main myWork = new Main();  // Construct the bootloader
        myWork.run();            // execute
    }

    public void run() {
        new myStuff().run();
    }
}
class myStuff implements Runnable{
    public void run(){
        String input;

        while(true){
            input = Main.ReadLn(1024);

            int n = Integer.parseInt(input.trim());

            if(n == 0) break;

            float[] money = new float[n];
            for(int i = 0 ; i < n ; i++){
                String line = Main.ReadLn(1024);

                money[i] = Float.parseFloat(line);
            }

            System.out.println("$" + String.format("%.2f", distribution(money)));
        }

    }

    // You can insert more classes here if you want.
    public BigDecimal distribution(float[] money){
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

        BigDecimal x = new BigDecimal(result);
        BigDecimal y = new BigDecimal(100);

        return x.divide(y, 2, BigDecimal.ROUND_FLOOR);

    }
}
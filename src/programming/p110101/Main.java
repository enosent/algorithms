package programming.p110101;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: enosent7
 * Date: 13. 3. 3.
 * Time: 오후 2:30
 * To change this template use File | Settings | File Templates.
 */

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

        while((input = Main.ReadLn(1024)) != null){
            input = input.trim();
            if(input.isEmpty()) continue;


            int n = Integer.parseInt(input.split("\\s+")[0]);
            int m = Integer.parseInt(input.split("\\s+")[1]);

            if(m >= 1000000 || n >= 1000000) break;


            int result = this.solve(n, m);

            System.out.println(n + " " + m + " " + result);
        }
    }

    public int solve(int start, int end) {
        int max = 1;

        // start > end
        if(start > end) {
            int temp = end;
            end = start;
            start = temp;
        }

        for(int i = start; i <= end; i++) {
            int result = this.countCycle(i);
            //System.out.println(i + " is cycle. " + result + "\n");

            if(max < result) max = result;
        }

        return max;
    }

    private int countCycle(int num) {
        int cycle = 1;

        while(num != 1){
            if(num%2 == 0) {
                num = num/2;
            }
            else if(num%2 != 0) {
                num = num*3+1;
            }
            //System.out.print(num +"\t");
            cycle++;
        }

        return cycle;
    }
}

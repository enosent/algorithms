package programming.p110104;

import java.io.*;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: enosent7
 * Date: 13. 3. 8.
 * Time: 오전 11:33
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
        // Your program here
        String input;

        List<StringBuffer> output = new ArrayList<StringBuffer>();

        while((input = Main.ReadLn(1024)) != null){
            input = input.trim();
            if(input.isEmpty()) continue;


            int s = Integer.parseInt(input.split("\\s+")[0]);
            int n = Integer.parseInt(input.split("\\s+")[1]);

            if(s == 0 && n == 0) break;

            //output.add(display(s, n));
            System.out.println(display(s, n).toString());
            System.out.println();
        }

        //for(int i = 0; i < output.size(); i++){
        //    if(i > 0) System.out.println();
        //    System.out.println(output.get(i).toString());
        //}
    }

    // You can insert more classes here if you want.
    public StringBuffer display(int s, int n) {
        // 가로
        int[][] widthLCD = {
                // 0       // 1       // 2       // 3       // 4
                {1, 0, 1}, {0, 0, 0}, {1, 1, 1}, {1, 1, 1}, {0, 1, 0},
                // 5       // 6       // 7       // 8       // 9
                {1, 1, 1}, {1, 1, 1}, {1, 0, 0}, {1, 1, 1}, {1, 1, 1}
        };

        // 세로
        int[][] heightLCD = {
                // 0          // 1          // 2          // 3          // 4
                {1, 1, 1, 1}, {0, 1, 0, 1}, {0, 1, 1, 0}, {0, 1, 0, 1}, {1, 1, 0, 1},
                // 5          // 6          // 7          // 8          // 9
                {1, 0, 0, 1}, {1, 0, 1, 1}, {0, 1, 0, 1}, {1, 1, 1, 1}, {1, 1, 0, 1}

        };

        String widthWhiteSpace = "";
        String widthLine = "";
        for(int i = 0;i < s; i++){
            widthWhiteSpace += " ";
            widthLine += "-";
        }

        String[] width = {widthWhiteSpace, widthLine};
        String[] height = {" ", "|"};

        String convertNum = String.valueOf(n);
        int len = convertNum.length();

        StringBuffer output = new StringBuffer();

        StringBuffer line1 = new StringBuffer();
        StringBuffer line2 = new StringBuffer();
        StringBuffer line3 = new StringBuffer();
        StringBuffer line4 = new StringBuffer();
        StringBuffer line5 = new StringBuffer();

        for(int index = 0; index < len; index++){
            int  num = convertNum.charAt(index)-48;

            if(index > 0){
                line1.append(" ");
                line2.append(" ");
                line3.append(" ");
                line4.append(" ");
                line5.append(" ");
            }

            // line 1
            line1.append(" " + width[widthLCD[num][0]] + " ");

            // line2
            line2.append(height[heightLCD[num][0]] +""+ width[0] +"" +height[heightLCD[num][1]]);

            // line3
            line3.append( " " + width[widthLCD[num][1]] + " ");

            // line4
            line4.append(height[heightLCD[num][2]] +""+ width[0] +""+ height[heightLCD[num][3]]);

            // line5
            line5.append(" " + width[widthLCD[num][2]] + " ");
        }

        output.append(line1.toString()).append("\n");
        for(int i =0; i < s; i++){
            output.append(line2.toString()).append("\n");
        }
        output.append(line3.toString()).append("\n");
        for(int i =0; i < s; i++){
            output.append(line4.toString()).append("\n");
        }
        output.append(line5.toString());

        return output;
    }
}
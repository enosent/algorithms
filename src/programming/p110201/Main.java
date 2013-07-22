package programming.p110201;

import java.io.IOException;

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
        String input = "";
        while((input = Main.ReadLn(1024)) != null){

            input = input.trim();
            if(input.isEmpty()) continue;

            int n = Integer.parseInt(input.split("\\s+")[0]);

            int[] ins = new int[n];

            for(int i = 0; i < ins.length; i++){
                ins[i] = Integer.parseInt(input.split("\\s+")[i+1]);
            }

            String result = jollyCheck(ins);
            System.out.println(result);
        }
    }

    // You can insert more classes here if you want.
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
package programming.p110106;

import java.io.*;
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

    int[] register = new int[10];
    int[] ram = new int[1000];

    int caseNumber = 0;

    public void run(){
        // Your program here
        String input = Main.ReadLn(1024);
        input = input.trim();

        caseNumber = Integer.parseInt(input);

        Main.ReadLn(1024);
        for(int i = 0; i < caseNumber; i++){
            if(i != 0) System.out.println();
            init();
            interpreter();
        }
    }

    public void init(){
        String input;
        int index = 0;

        for(int i = 0; i < register.length; i++){
            register[i] = 0;
        }
        for(int i = 0; i < ram.length; i++){
            ram[i] = 0;
        }

        while((input = Main.ReadLn(1024)) != null){
            input = input.trim();

            if(input.isEmpty()) break;

            ram[index] = Integer.parseInt(input);
            index++;
        }
    }

    // You can insert more classes here if you want.
    public void interpreter(){
        int process;
        int address;

        process = 0;
        address = 0;
        while(true){
            int command = ram[address];
            address++;
            process++;

            if(command == 100) break;

            int question = command/100;
            int param1 = (command%100)/10;
            int param2 = (command%100)%10;

            switch (question){
                case 2:
                    register[param1] = param2;
                    break;
                case 3:
                    register[param1] = (register[param1] + param2)%1000;
                    break;
                case 4:
                    register[param1] = (register[param1] * param2)%1000;
                    break;
                case 5:
                    register[param1] = register[param2];
                    break;
                case 6:
                    register[param1] = (register[param1] + register[param2])%1000;
                    break;
                case 7:
                    register[param1] = (register[param1]*register[param2])%1000;
                    break;
                case 8:
                    register[param1] = ram[register[param2]];
                    break;
                case 9:
                    ram[register[param2]] = register[param1];
                    break;
                case 0:
                    if(register[param2] != 0){
                        address = register[param1];
                    }
                    break;
            }

        }
        System.out.println(process);
    }
}

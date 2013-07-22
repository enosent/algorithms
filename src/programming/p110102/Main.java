package programming.p110102;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

        List<String[][]> problem = new ArrayList<String[][]>();

        while((input = Main.ReadLn(1024)) != null){
            input = input.trim();
            if(input.isEmpty()) continue;


            int n = Integer.parseInt(input.split("\\s+")[0]);
            int m = Integer.parseInt(input.split("\\s+")[1]);

            if(m == 0 && n == 0) break;

            String[][] mine = new String[n][m];

            for(int i = 0 ; i < n ; i++){
                String line = Main.ReadLn(1024);

                for(int j = 0; j < m; j++){
                    mine[i][j] = String.valueOf(line.charAt(j));
                }
            }

            problem.add(mine);

        }

        for(int k = 0; k < problem.size(); k++) {
            String[][] mine = problem.get(k);

            int n = mine.length;
            int m = mine[0].length;


            String[][] minesweeper = minesweeper(n, m, mine);

            if(k > 0) System.out.println();
            System.out.println("Field #" + (k+1) + ":");
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    System.out.print(minesweeper[i][j]);
                }
                System.out.println();
            }

        }
    }
    public String[][] minesweeper(int m, int n, String[][] input){
        String[][] mine = input;

        String[][] sweeper = new String[m][n];

        // init
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){

                if("*".equals(mine[i][j])){
                    sweeper[i][j] = "*";
                }else{
                    sweeper[i][j] = "0";
                }
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if("*".equals(sweeper[i][j])){
                    if(i-1 >= 0){
                        this.increase(i-1, j, n, sweeper);
                    }
                    if((j-1) >= 0 && !"*".equals(sweeper[i][j-1])){
                        sweeper[i][j-1] = String.valueOf(Integer.parseInt(sweeper[i][j-1]) + 1);
                    }
                    if((j+1) < n && !"*".equals(sweeper[i][j+1])){
                        sweeper[i][j+1] = String.valueOf(Integer.parseInt(sweeper[i][j+1]) + 1);
                    }
                    if(i+1 < m){
                        this.increase(i+1, j, n, sweeper);
                    }
                }
            }
        }

        return sweeper;
    }

    private void increase(int i, int j, int n, String[][] sweeper){
        if((j-1) >= 0 && !"*".equals(sweeper[i][j-1])){
            sweeper[i][j-1] = String.valueOf(Integer.parseInt(sweeper[i][j-1]) + 1);
        }
        if(!"*".equals(sweeper[i][j])){
            sweeper[i][j] = String.valueOf(Integer.parseInt(sweeper[i][j]) + 1);
        }
        if((j+1) < n && !"*".equals(sweeper[i][j+1])){
            sweeper[i][j+1] = String.valueOf(Integer.parseInt(sweeper[i][j+1]) + 1);
        }
    }
}
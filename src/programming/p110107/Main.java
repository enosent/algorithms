package programming.p110107;

import java.io.IOException;
import java.util.ArrayList;
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

    private int kingX;
    private int kingY;

    public void run(){
        List<String[][]> problem = new ArrayList<String[][]>();
        while(true){
            int dotCnt = 0;
            String[][] check = new String[8][8];

            String line = Main.ReadLn(1024);
            line = line.trim();

            if(line.isEmpty()) continue;
            for(int i = 0 ; i < check.length ; i++){
                if(i != 0)  line = Main.ReadLn(1024);
                for(int j = 0; j < check[i].length; j++){
                    check[i][j] = String.valueOf(line.charAt(j));
                    if(!".".equals(check[i][j])) dotCnt++;
                }
            }

            if(dotCnt == 0) break;

            problem.add(check);

        }

        for(int k = 0; k < problem.size(); k++) {
            String[][] board = problem.get(k);

            String result = checkMate(board);

            System.out.println("Game #" + (k+1) + ": " + result);
        }
    }

    public String checkMate(String[][] board) {

        String message = "";

        this.findKingPosition(board);

        boolean result = this.isCheckMate(board);

        if(!result){
            String[][] temp = this.convertFromWhiteToBlack(board);
            this.findKingPosition(temp);

            result = this.isCheckMate(temp);

            if(result){
                message = "white king is in check.";
            }else{
                message = "no king is in check.";
            }


        }else{
            message = "black king is in check.";
        }

        return message;
    }

    private String[][] convertFromWhiteToBlack(String[][] check){
        String temp[][] = new String[8][8];
        int k = 0;
        for(int i = check.length-1; i >= 0; i--){
            int h=0;
            for(int j = check[i].length-1; j >= 0; j--){
                String str = check[i][j];
                char spell = str.charAt(0);

                if(spell >= 65 && spell <= 90){
                    str = str.toLowerCase();
                }
                else if(spell >=97 && spell <= 122){
                    str = str.toUpperCase();
                }

                temp[k][h] = str;
                h++;
            }
            k++;
        }

        return temp;
    }

    private void findKingPosition(String[][] check) {
        int row = check.length;
        int col = check[0].length;

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if("k".equals(check[i][j])){
                    kingX = i;
                    kingY = j;
                }
            }
        }
    }


    private boolean isCheckMate(String[][] check){

        if(
                (kingX <= 6 && kingY >= 1 && "P".equals(check[kingX+1][kingY-1]))
                        || (kingX <= 6 && kingY <= 6 && "P".equals(check[kingX+1][kingY+1]))
                ){

            return true;
        }

        if(
                (kingX <= 6 && kingY <= 5 && "N".equals(check[kingX+1][kingY+2]))
                        || (kingX <= 6 && kingY >= 2 && "N".equals(check[kingX+1][kingY-2]))
                        || (kingX >= 1 && kingY <= 5 && "N".equals(check[kingX-1][kingY+2]))
                        || (kingX >= 1 && kingY >= 2 && "N".equals(check[kingX-1][kingY-2]))
                        || (kingX <= 5 && kingY <= 6 && "N".equals(check[kingX+2][kingY+1]))
                        || (kingX <= 5 && kingY >= 1 && "N".equals(check[kingX+2][kingY-1]))
                        || (kingX >= 2 && kingY <= 6 && "N".equals(check[kingX-2][kingY+1]))
                        || (kingX >= 2 && kingY >= 1 && "N".equals(check[kingX-2][kingY-1]))
                ){

            return true;
        }

        if(
                loopCheck("B", 1, 1, check)
                        || loopCheck("B", 1, -1, check)
                        || loopCheck("B", -1, 1, check)
                        || loopCheck("B", -1, -1, check)
                ){

            return true;
        }

        if(
                loopCheck("R", 1, 0, check)
                        || loopCheck("R", -1, 0, check)
                        || loopCheck("R", 0, 1, check)
                        || loopCheck("R", 0, -1, check)
                ){

            return true;
        }

        if(
                loopCheck("Q", 1, 1, check)
                        || loopCheck("Q", 1, -1, check)
                        || loopCheck("Q", -1, 1, check)
                        || loopCheck("Q", -1, -1, check)
                        || loopCheck("Q", 1, 0, check)
                        || loopCheck("Q", -1, 0, check)
                        || loopCheck("Q", 0, 1, check)
                        || loopCheck("Q", 0, -1, check)
                ){

            return true;
        }

        for(int i = Math.max(kingX-1, 0); i <= Math.min(kingX+1, 7); i++){
            for(int j = Math.max(kingY-1, 0); j <= Math.min(kingY+1,7); j++){
                if("K".equals(check[i][j])){
                    return true;
                }
            }
        }

        return false;
    }

    private boolean loopCheck(String target, int x, int y, String[][] check){
        int startX = kingX + x;
        int startY = kingY + y;

        while(startX >= 0 && startX <=7 && startY >= 0 && startY <= 7 && ".".equals(check[startX][startY])){
            startX += x;
            startY += y;
        }

        return (startX >= 0 && startX <= 7 && startY >= 0 && startY <= 7 && target.equals(check[startX][startY]));
    }

}
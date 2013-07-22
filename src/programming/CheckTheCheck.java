package programming;

/**
 * Created with IntelliJ IDEA.
 * User: enosent7
 * Date: 13. 3. 15.
 * Time: 오후 5:09
 * To change this template use File | Settings | File Templates.
 */
public class CheckTheCheck {

    private int kingX;
    private int kingY;

    private String[][] check;

    public CheckTheCheck(String[][] check){
        this.check = check;
    }

    public String checkMate() {

        String message = "";

        // king 위치 확인
        this.findKingPosition();

        boolean result = this.isCheckMate();

        if(!result){
            // white 를 black 로 변환
            this.convertFromWhiteToBlack();
            this.findKingPosition();

            result = this.isCheckMate();

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

    private void convertFromWhiteToBlack(){
        // 대문자 -> 소문자 / 소문자 -> 대문자
        String temp[][] = new String[8][8];
        int k = 0;
        for(int i = check.length-1; i >= 0; i--){
            int h=0;
            for(int j = check[i].length-1; j >= 0; j--){
                String str = check[i][j];
                char spell = str.charAt(0);

                // 대문자 -> 소문자
                if(spell >= 65 && spell <= 90){
                    str = str.toLowerCase();
                }
                // 소문자 -> 대문자
                else if(spell >=97 && spell <= 122){
                    str = str.toUpperCase();
                }

                temp[k][h] = str;
                h++;
            }
            k++;
        }

        for(int i = 0; i < temp.length; i++){
            for(int j = 0; j < temp.length; j++){
                check[i][j] = temp[i][j];
            }
        }

    }

    private void findKingPosition() {
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


     private boolean isCheckMate(){

         // >> king 을 중심으로 상대방 말의 위치 확인

         // Pawn ( p or P )
         if(
                (kingX <= 6 && kingY >= 1 && "P".equals(check[kingX+1][kingY-1]))
             || (kingX <= 6 && kingY <= 6 && "P".equals(check[kingX+1][kingY+1]))
            ){

            return true;
         }

         // Knight ( n or N )
         if(
                (kingX <= 6 && kingY <= 5 && "N".equals(check[kingX+1][kingY+2]))
             || (kingX <= 6 && kingY >= 2 && "P".equals(check[kingX+1][kingY-2]))
             || (kingX >= 1 && kingY <= 5 && "P".equals(check[kingX-1][kingY+2]))
             || (kingX >= 1 && kingY >= 2 && "P".equals(check[kingX-1][kingY-2]))
             || (kingX <= 5 && kingY <= 6 && "P".equals(check[kingX+2][kingY+1]))
             || (kingX <= 5 && kingY >= 1 && "P".equals(check[kingX+2][kingY-1]))
             || (kingX >= 2 && kingY <= 6 && "P".equals(check[kingX-2][kingY+1]))
             || (kingX >= 2 && kingY >= 1 && "P".equals(check[kingX-2][kingY-1]))
            ){

             return true;
         }

         // Bishop ( b or B )
         if(
                loopCheck("B", 1, 1)
             || loopCheck("B", 1, -1)
             || loopCheck("B", -1, 1)
             || loopCheck("B", -1, -1)
            ){

             return true;
         }

         // Rook ( r or R )
         if(
                loopCheck("R", 1, 0)
             || loopCheck("R", -1, 0)
             || loopCheck("R", 0, 1)
             || loopCheck("R", 0, -1)
            ){

            return true;
         }

         // Queen ( q or Q )
         if(
                loopCheck("Q", 1, 1)
             || loopCheck("Q", 1, -1)
             || loopCheck("Q", -1, 1)
             || loopCheck("Q", -1, -1)
             || loopCheck("Q", 1, 0)
             || loopCheck("Q", -1, 0)
             || loopCheck("Q", 0, 1)
             || loopCheck("Q", 0, -1)
            ){

             return true;
         }

         // King ( k or K )
         for(int i = Math.max(kingX-1, 0); i <= Math.min(kingX+1, 7); i++){
             for(int j = Math.max(kingY-1, 0); j <= Math.min(kingY+1,7); j++){
                 if("K".equals(check[i][j])){
                     return true;
                 }
             }
         }

         return false;
     }

    private boolean loopCheck(String target, int x, int y){
        int startX = kingX + x;
        int startY = kingY + y;

        while(startX >= 0 && startX <=7 && startY >= 0 && startY <= 7 && ".".equals(check[startX][startY])){
            startX += x;
            startY += y;
        }

        return (startX >= 0 && startX <= 7 && startY >= 0 && startY <= 7 && target.equals(check[startX][startY]));
    }


    // for test
    public void printOut(){
        for(int i =0; i < check.length; i++){
            for(int j = 0; j < check[i].length; j++){
                System.out.print(check[i][j] + "\t");
            }
            System.out.println();
        }
    }
}

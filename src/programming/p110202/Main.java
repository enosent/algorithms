package programming.p110202;

import java.util.Scanner;

/**
 * User: enosent7
 * Date: 13. 8. 19.
 * Time: 오후 4:10
 */
public class Main {
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        Main main = new Main();
        while(true){

            String line = scan.nextLine().trim();

            if(line.isEmpty()) break;

            String[] temp = line.split("\\s+");

            main.poker(temp);
        }
    }
    private String[] black = new String[5];
    private String[] white = new String[5];

    private int[] blackNumber = new int[5];
    private int[] whiteNumber = new int[5];

    private String message = "Tie";

    enum CardNumber{
        N2("2", 0), N3("3", 1), N4("4", 2), N5("5", 3), N6("6", 4),  N7("7", 5),
        N8("8", 6), N9("9", 7), NT("T", 8), NJ("J", 9), NQ("Q", 10), NK("K", 11), NA("A", 12);

        final String cardNumber;
        final int num;

        private CardNumber(String cardNumber, int num){
            this.cardNumber = cardNumber;
            this.num = num;
        }

        public static int getDesc(String cardNumber){
            if("2".equals(cardNumber)) { return N2.num; }
            else if("3".equals(cardNumber)) { return N3.num; }
            else if("4".equals(cardNumber)) { return N4.num; }
            else if("5".equals(cardNumber)) { return N5.num; }
            else if("6".equals(cardNumber)) { return N6.num; }
            else if("7".equals(cardNumber)) { return N7.num; }
            else if("8".equals(cardNumber)) { return N8.num; }
            else if("9".equals(cardNumber)) { return N9.num; }
            else if("T".equals(cardNumber)) { return NT.num; }
            else if("J".equals(cardNumber)) { return NJ.num; }
            else if("Q".equals(cardNumber)) { return NQ.num; }
            else if("K".equals(cardNumber)) { return NK.num; }
            else if("A".equals(cardNumber)) { return NA.num; }
            else throw new AssertionError("Unknown value.");
        }
    }

    public void poker(String[] pokers){

        // 패분할
        for(int loop = 0; loop < 5; loop++){
            blackNumber[loop] = CardNumber.getDesc(pokers[loop].substring(0, 1));
            whiteNumber[loop] = CardNumber.getDesc(pokers[loop+5].substring(0, 1));

            black[loop] = pokers[loop].substring(1);
            white[loop] = pokers[loop+5].substring(1);

        }

        sortPoker(blackNumber);
        sortPoker(whiteNumber);


        int blackWinNo = patternCheck(blackNumber, black);
        int whiteWinNo = patternCheck(whiteNumber, white);

        if(blackWinNo < whiteWinNo){
            System.out.println("Black wins.");
        }else if(whiteWinNo < blackWinNo){
            System.out.println("White wins.");
        }else{
            //blackWinNo == whiteWinNo

            boolean isEnd = false;
            for(int i = 4; i > 0; i--){
                if(blackNumber[i] > whiteNumber[i]){
                    System.out.println("Black wins.");
                    isEnd = true;
                    break;
                }
                else if(blackNumber[i] < whiteNumber[i]){
                    System.out.println("White wins.");
                    isEnd = true;
                    break;
                }
            }

            if(!isEnd) System.out.println("Tie.");
        }

    }

    private boolean isSamePattern(String[] poker){
        String temp = poker[0];

        int size = poker.length;
        for(int loop = 1; loop < size; loop++){
            if(!temp.equals(poker[loop])) return false;
        }

        return true;
    }


    private void sortPoker(int[] poker) {
        int size = poker.length;

        for(int i = 0; i < size; i++){
            for(int j = i+1; j < size; j++){
                if(poker[i] > poker[j]){
                    int temp = poker[i];
                    poker[i] = poker[j];
                    poker[j] = temp;
                }
            }
        }
    }


    private boolean isContinuce(int[] poker){
        boolean check = true;

        for(int i = poker.length-1; i > 1; i--){
            if(poker[i] - poker[i-1] != 1) check = false;
        }

        return check;
    }

    private int patternCheck(int[] poker, String[] patterns){

        boolean isSamePattern = isSamePattern(patterns);
        boolean isContinuce = isContinuce(poker);

        int winNo = 0;
        // 1. 스트레이트 플러시 : 다섯장의 카드가 무늬가 같으면서 연속적인 값 ( 동일한 경우 가장 높은 수로 판별 )
        if(isSamePattern && isContinuce){
            winNo = 1;
        }
        // 2. 포카드 : 네장의 카드가 같은 값 ( 동일한 경우 네 장의 카드 값으로 정함 )
        else if(poker[0] == poker[3] || poker[1] == poker[4]){
            winNo = 2;
        }
        // 3. 풀하우스 : 세 장의 카드가 같은 값을 가지고 나머지 두 장의 카드가 같은 값 ( 동일한 경우 세 장의 카드로 정함 )
        else if((poker[0] == poker[2] && poker[3] == poker[4])
                || (poker[0] == poker[1] && poker[2] == poker[4])){
            winNo = 3;
        }
        // 4. 플러시 : 다섯장의 카드의 무늬가 같은 경우 ( 동일한 플러시는 하이카드 규칙으로 판별 )
        else if(isSamePattern){
            winNo = 4;
        }
        // 5. 스트레이트 : 다섯장의 카드가 연속적인 값을 ( 동일한 경우 제일 높은 수로 판별 )
        else if(isContinuce){
            winNo = 5;
        }
        // 6. 쓰리 카드 : 세장이 같은 경우 ( 동일한 경우 나머지 카드 값으로 )
        else if(poker[0] == poker[2] || poker[1] == poker[3] || poker[2] == poker[4]){
            winNo = 6;
        }
        // 7. 투 페어 : 두 쌍의 카드가 같은 값을 가지는 경우 ... ( 동일한 경우 나머지 카드 값으로 )
        else if( (poker[0] == poker[1] && poker[2] == poker[3]) || (poker[1] == poker[2] && poker[3] == poker[4])){
            winNo = 7;
        }
        // 8. 원페어 : 두 장이 같은 경우 ( 동일한 경우 나머지 카드 값으로 )
        else if( (poker[0] == poker[1]) || (poker[1] == poker[2]) || (poker[2] == poker[3]) || (poker[3] == poker[4]) ){
            winNo = 8;
        }
        // 9. 하이카드 : 가장 높은 카드의 등급에 따라 ... 가장 높은 카드의 값이 같으면 그 다음 ..
        else{
            winNo = 9;
        }

        return winNo;
    }
}

package ihseo;

import programming.PokerHands;

/**
 * User: enosent7
 * Date: 13. 8. 20.
 * Time: 오전 12:32
 */
public class PokerHandsTest {

    public static void main(String[] args) {

        // 2H 3D 5S 9C KD | 2C 3H 4S 8C AH
        // - White wins.
        // 하이카드 A > K

        // 2H 4S 4C 2D 4H | 2S 8S AS QS 3S
        // - Black wins
        // Black 4 [3] 2 [2] -  풀하우스
        // 플러시 ...

        // 2H 3D 5S 9C KD | 2C 3H 4S 8C KH
        // - Black wins
        // K 동일 다음 9 > 8 하이카드

        // 2H 3D 5S 9C KD | 2D 3H 5C 9S KH
        // - Tie

        PokerHands poker = new PokerHands();

//        String[] pokers = {"2H", "3D", "5S", "9C", "KD", "2C", "3H", "4S", "8C", "AH"};
//        String[] pokers = {"2H", "4S", "4C", "2D", "4H", "2S", "8S", "AS", "QS", "3S"};
        String[] pokers = {"2H", "4S", "4C", "2D", "5H", "2S", "4S", "4S", "5S", "5S"};
//        String[] pokers = {"2H", "3D", "5S", "9C", "KD", "AD", "3H", "5C", "9S", "KH"};
        poker.poker(pokers);

    }
}

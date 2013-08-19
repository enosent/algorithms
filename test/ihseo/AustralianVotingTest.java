package ihseo;

import programming.AustralianVoting;

/**
 * Created with IntelliJ IDEA.
 * User: enosent7
 * Date: 13. 5. 25.
 * Time: 오전 10:37
 * To change this template use File | Settings | File Templates.
 */
public class AustralianVotingTest {
    /*

    입력 케이스의 개수를 나타내는 양의 정수 한 개가 들어있는 행으로 시작되며 그 줄에는 그 숫자밖에 입력되지 않는다.
    그 뒤에는 빈줄이 하나 들어가고 서로 다른 입력 케이스 사이에는 두개의 빈줄이 입력된다.
    각 케이스의 첫번째 줄에는 후보 수를 나타내는 20 이하의 정수 n이 입력된다.
    그 밑으로 n개의 줄에 걸쳐서 후보의 이름이 순서대로 입력되며 각 후보의 이름은 80글자 이하로, 출력가능한 문자로 구성된다.
    그 뒤에는 최대 1,000줄이 입력될 수 있는데, 각 줄에는 투표 내역이 입력된다.
    각 투표 내역에는 어떤 순서로 1부터 n까지의 수가 입력된다.
    첫번째 숫자는 1순위로 찍은 후보의 번호, 두번째 숫자는 2순위로 찍은 후보의 번호, 이런식으로 숫자가 입력된다.

     */

    private static final int MAX_VOTE_COUNT = 1000;

    public static void main(String[] args) {

        int n = 3;

        String[] names = new String[n];

        names[0] = "John Doe";
        names[1] = "Jane Smith";
        names[2] = "Sirhan Sirhan";

        int[][] votes = new int[MAX_VOTE_COUNT][n];

        votes[0] = new int[]{
                1, 2, 3
        };
        votes[1] = new int[]{
                2, 1, 3
        };
        votes[2] = new int[]{
                2, 3, 1
        };
        votes[3] = new int[]{
                1, 2, 3
        };
        votes[4] = new int[]{
                3, 1, 2
        };

        int user_vote_count = 5;

//        AustralianVoting australianVoting = new AustralianVoting(names, votes, user_vote_count);

//        australianVoting.vote();

        // test case 2:

        /*
            4
            J
            L
            K
            H
            4 3 2 1
            1 2 3 4
            4 2 3 1
            2 3 4 1
            1 2 3 4
         */


        int n1 = 4;

        String[] names1 = new String[n1];

        names1[0] = "1John Doe";
        names1[1] = "2Jane Smith";
        names1[2] = "3Sirhan Sirhan";
        names1[3] = "4James";

        int[][] votes1 = new int[MAX_VOTE_COUNT][n1];

        votes1[0] = new int[]{
               4, 3, 2, 1
        };
        votes1[1] = new int[]{
               1, 2, 3, 4
        };
        votes1[2] = new int[]{
               4, 2, 3, 1
        };
        votes1[3] = new int[]{
               2, 3, 4, 1
        };
        votes1[4] = new int[]{
               1, 2, 3, 4
        };
        votes1[5] = new int[]{
               3, 2, 1, 4
        };

        int user_vote_count1 = 6;

        AustralianVoting australianVoting1 = new AustralianVoting(names1, votes1, user_vote_count1);

        australianVoting1.vote();

        /*
        4 3 2 1 5
        4 2 3 1 5
        1 2 3 4 5
        2 1 3 4 5
        5 1 2 3 4
        5 1 2 3 4

        - 최소 득표자가 2

        4 3 2 1 5
        4 2 3 1 5
        4 2 3 1 5
        5 1 3 2 4
        5 1 2 3 4
        5 1 2 3 4

        - 과반수 이상 득표자가 2 X -> 없다고 봄 -> 최다 득표자는 한명
        */
    }
}

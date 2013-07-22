package ihseo;

import programming.CheckTheCheck;

/**
 * Created with IntelliJ IDEA.
 * User: enosent7
 * Date: 13. 5. 11.
 * Time: 오전 10:41
 * To change this template use File | Settings | File Templates.
 */
public class CheckTheCheckTest {

    public static void main(String[] args) {

        // black : 소문자, white : 대문자

        String[][] check = new String[][]{
                {".", ".", "k", ".", ".", ".", ".", "."},
                {"p", "p", "p", ".", "p", "p", "p", "p"},
                {".", ".", ".", ".", ".", ".", ".", "."},
                {".", "R", ".", ".", ".", "B", ".", "."},
                {".", ".", ".", ".", ".", ".", ".", "."},
                {".", ".", ".", ".", ".", ".", ".", "."},
                {"P", "P", "P", "P", "P", "P", "P", "P"},
                {"K", ".", ".", ".", ".", ".", ".", "."}
        };

        CheckTheCheck checks = new CheckTheCheck(check);

        String s = checks.checkMate();

        System.out.println(s);

        String[][] check2 = new String[][]{
                {"r", "n", "b", "q", "k", "b", "n", "r"},
                {"p", "p", "p", "p", "p", "p", "p", "p"},
                {".", ".", ".", ".", ".", ".", ".", "."},
                {".", ".", ".", ".", ".", ".", ".", "."},
                {".", ".", ".", ".", ".", ".", ".", "."},
                {".", ".", ".", ".", ".", ".", ".", "."},
                {"P", "P", "P", "P", "P", "P", "P", "P"},
                {"R", "N", "B", "Q", "K", "B", "N", "R"}
        };

        CheckTheCheck checks2 = new CheckTheCheck(check2);

        String s2 = checks2.checkMate();

        System.out.println(s2);

        String[][] check3 = new String[][]{
                {"r", "n", "b", "q", "k", ".", "n", "r"},
                {"p", "p", "p", ".", ".", "p", "p", "p"},
                {".", ".", ".", ".", "p", ".", ".", "."},
                {".", ".", ".", "p", ".", ".", ".", "."},
                {".", "b", "P", "P", ".", ".", ".", "."},
                {".", ".", ".", ".", "N", ".", ".", "."},
                {"P", "P", ".", ".", "P", "P", "P", "P"},
                {"R", "N", "B", "Q", "K", "B", ".", "R"}
        };

        CheckTheCheck checks3 = new CheckTheCheck(check3);

        String s3 = checks3.checkMate();

        System.out.println(s3);

    }
}

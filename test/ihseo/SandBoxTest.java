package ihseo;


import java.util.Arrays;

/**
 * User: enosent7
 * Date: 13. 7. 20.
 * Time: 오전 11:17
 */
public class SandBoxTest {

    public static void main(String[] args) {

        String[][] check = new String[][]{
                {"k", ".", ".", ".", ".", ".", ".", "."},
                {"p", "p", "p", ".", "p", "p", "p", "p"},
                {".", ".", ".", ".", ".", ".", ".", "."},
                {".", "R", ".", ".", ".", "B", ".", "."},
                {".", ".", ".", ".", ".", ".", ".", "."},
                {".", ".", ".", ".", ".", ".", ".", "."},
                {"P", "P", "P", "P", "P", "P", "P", "P"},
                {"K", ".", ".", ".", ".", ".", ".", "."}
        };
        int kingY = 7, kingX = 0;


        System.out.println((kingY >= 0));
        System.out.println((kingY <= 7));

        if(
                (kingX <= 6 && kingY >= 1 && "p".equals(check[kingX+1][kingY-1]))
             || (kingX <= 6 && kingY <= 6 && "p".equals(check[kingX+1][kingY+1]))
          ){

            System.out.println("ss");
        }


        String a = "p";

        System.out.println(a.charAt(0));


        System.out.println("> " + Integer.parseInt("-1"));
        System.out.println("> " + Integer.valueOf("-1"));



        int test = 1;
        int maxTest = 10;
        for(test++; test <= maxTest; test++);

        System.out.println(test);


        String[] text = {"A", "2", "4", "5", "3", "6", "T", "8", "9", "7", "J", "K", "Q"};

        for(String temp : text) {
            System.out.print(temp + "\t");
        }

        System.out.println();
        Arrays.sort(text);
        System.out.println();

        for(String temp : text) {
            System.out.print(temp+"\t");
        }


        int[] sample = new int[] { 1, 2, 3, 4, 5 };

        for(int i = sample.length-1; i > 1; i--){

            System.out.println(sample[i]);
            System.out.println(sample[i-1]);

            System.out.println(sample[i] - sample[i-1]);

        }


    }
}

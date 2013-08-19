package ihseo;


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


    }
}

package ihseo;

/**
 * Created with IntelliJ IDEA.
 * User: enosent7
 * Date: 13. 3. 8.
 * Time: 오전 1:45
 * To change this template use File | Settings | File Templates.
 */
public class NumberSplit {
    public static void main(String[] args) {
        int n = 12345;


        String convertNum = String.valueOf(n);

        for(int i = 0; i<convertNum.length(); i++){
            int  num = convertNum.charAt(i)-48;
            System.out.println(num);
        }

        String[] a = {"a", "b", "c"};

        for(int i = 0; i < a.length; i++){
            System.out.print(a[i]);
        }

    }
}

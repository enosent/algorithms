package ihseo;

import programming.LCDDisplay;

/**
 * Created with IntelliJ IDEA.
 * User: enosent7
 * Date: 13. 3. 5.
 * Time: 오전 1:30
 * To change this template use File | Settings | File Templates.
 */
public class LCDDisplayTest {

    public static void main(String[] args) {
        LCDDisplay lcd = new LCDDisplay();

        String result1 = lcd.display(2, 888);

        System.out.print(result1);

        System.out.println();
        String result2 = lcd.display(2, 12345);

        System.out.print(result2);

        System.out.println();
        String result3 = lcd.display(3, 67890);

        System.out.print(result3);
    }
}

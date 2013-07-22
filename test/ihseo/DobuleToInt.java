package ihseo;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * Created with IntelliJ IDEA.
 * User: enosent7
 * Date: 13. 3. 3.
 * Time: 오후 3:35
 * To change this template use File | Settings | File Templates.
 */
public class DobuleToInt {

    public static void main(String[] args) {
        double d1 = 10.05;
        double d2 = 10.02;
        double d3 = 10.37;
        double d4 = 15.01;
        double d5 = 15.07;

        System.out.println("dobule");
        System.out.println(" > +0.5 ");
        System.out.println((int) (d1*100+0.5));
        System.out.println((int) (d2*100+0.5));
        System.out.println((int) (d3*100+0.5));
        System.out.println((int) (d4*100+0.5));
        System.out.println((int) (d5*100+0.5));
        System.out.println(" > Math round ");
        System.out.println((int)Math.round(d1*100));
        System.out.println((int)Math.round(d2*100));
        System.out.println((int)Math.round(d3*100));
        System.out.println((int)Math.round(d4*100));
        System.out.println((int)Math.round(d5*100));

        System.out.println("--------------------------------");

        float f1 = 10.05f;
        float f2 = 10.02f;
        float f3 = 10.37f;
        float f4 = 15.01f;
        float f5 = 15.07f;

        System.out.println("float");
        System.out.println((int) (f1*100));
        System.out.println((int) (f2*100));
        System.out.println((int) (f3*100));
        System.out.println((int) (f4*100));
        System.out.println((int) (f5*100));

        System.out.println((int)Math.round(f1*100));
        System.out.println((int)Math.round(f2*100));
        System.out.println((int)Math.round(f3*100));
        System.out.println((int)Math.round(f4*100));
        System.out.println((int)Math.round(f5*100));


        System.out.println("--------------------------------");

        int result1 = 1199;
        int result2 = 10;
        int result3 = 100;
        int result4 = 1000;
        int result5 = 3299;

        System.out.println("result division 100 convert float");
        System.out.println("$" + String.format("%.2f", (float)result1/100));
        System.out.println("$" + String.format("%.2f", (float)result2/100));
        System.out.println("$" + String.format("%.2f", (float)result3/100));
        System.out.println("$" + String.format("%.2f", (float)result4/100));
        System.out.println("$" + String.format("%.2f", (float)result5/100));

        System.out.println("result division 100 convert double");
        System.out.println("$" + String.format("%.2f", (double)result1/100));
        System.out.println("$" + String.format("%.2f", (double)result2/100));
        System.out.println("$" + String.format("%.2f", (double)result3/100));
        System.out.println("$" + String.format("%.2f", (double)result4/100));
        System.out.println("$" + String.format("%.2f", (double)result5/100));

        System.out.println("big decimal ...");
        BigDecimal div = new BigDecimal(100);
        BigDecimal math1 = new BigDecimal(result1);
        BigDecimal math2 = new BigDecimal(result2);
        BigDecimal math3 = new BigDecimal(result3);
        BigDecimal math4 = new BigDecimal(result4);
        BigDecimal math5 = new BigDecimal(result5);

        System.out.println("$" + math1.divide(div, 2, BigDecimal.ROUND_FLOOR));
        System.out.println("$" + math2.divide(div, 2, BigDecimal.ROUND_FLOOR));
        System.out.println("$" + math3.divide(div, 2, BigDecimal.ROUND_FLOOR));
        System.out.println("$" + math4.divide(div, 2, BigDecimal.ROUND_FLOOR));
        System.out.println("$" + math5.divide(div, 2, BigDecimal.ROUND_FLOOR));
    }
}

package programming;

/**
 * Created with IntelliJ IDEA.
 * User: enosent7
 * Date: 13. 3. 4.
 * Time: 오후 6:06
 * To change this template use File | Settings | File Templates.
 */
public class LCDDisplay {

    public String display(int s, int n) {
        // 가로
        int[][] widthLCD = {
            // 0       // 1       // 2       // 3       // 4
            {1, 0, 1}, {0, 0, 0}, {1, 1, 1}, {1, 1, 1}, {0, 1, 0},
            // 5       // 6       // 7       // 8       // 9
            {1, 1, 1}, {1, 1, 1}, {1, 0, 0}, {1, 1, 1}, {1, 1, 1}
        };

        // 세로
        int[][] heightLCD = {
            // 0          // 1          // 2          // 3          // 4
            {1, 1, 1, 1}, {0, 1, 0, 1}, {0, 1, 1, 0}, {0, 1, 0, 1}, {1, 1, 0, 1},
            // 5          // 6          // 7          // 8          // 9
            {1, 0, 0, 1}, {1, 0, 1, 1}, {0, 1, 0, 1}, {1, 1, 1, 1}, {1, 1, 0, 1}

        };

        String widthWhiteSpace = "";
        String widthLine = "";
        for(int i = 0;i < s; i++){
            widthWhiteSpace += " ";
            widthLine += "-";
        }

        String[] width = {widthWhiteSpace, widthLine};
        String[] height = {" ", "|"};

        String convertNum = String.valueOf(n);
        int len = convertNum.length();

        StringBuffer output = new StringBuffer();

        StringBuffer line1 = new StringBuffer();
        StringBuffer line2 = new StringBuffer();
        StringBuffer line3 = new StringBuffer();
        StringBuffer line4 = new StringBuffer();
        StringBuffer line5 = new StringBuffer();

        for(int index = 0; index < len; index++){
            int  num = convertNum.charAt(index)-48;

            if(index > 0){
                line1.append(" ");
                line2.append(" ");
                line3.append(" ");
                line4.append(" ");
                line5.append(" ");
            }

            // line 1
            line1.append(" " + width[widthLCD[num][0]] + " ");

            // line2
            line2.append(height[heightLCD[num][0]] +""+ width[0] +"" +height[heightLCD[num][1]]);

            // line3
            line3.append( " " + width[widthLCD[num][1]] + " ");

            // line4
            line4.append(height[heightLCD[num][2]] +""+ width[0] +""+ height[heightLCD[num][3]]);

            // line5
            line5.append(" " + width[widthLCD[num][2]] + " ");
        }

        output.append(line1.toString()).append("\n");
        for(int i =0; i < s; i++){
            output.append(line2.toString()).append("\n");
        }
        output.append(line3.toString()).append("\n");
        for(int i =0; i < s; i++){
            output.append(line4.toString()).append("\n");
        }
        output.append(line5.toString());

        return output.toString();
    }
}

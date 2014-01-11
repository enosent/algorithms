package ihseo;

/**
 * User: enosent7
 * Date: 13. 9. 15.
 * Time: 오후 5:20
 */
public class FromOneToTenThousand {

    public static void main(String[] args) {

        int count = 0;
        for(int i = 1; i < 10000; i++){
            if(String.valueOf(i).indexOf("8") >= 0){
                count++;
            }
        }

        System.out.println(count);
    }
}

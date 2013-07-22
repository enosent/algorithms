package programming.codeSprint2013;

import java.security.MessageDigest;

/**
 * Created with IntelliJ IDEA.
 * User: enosent7
 * Date: 13. 6. 29.
 * Time: 오전 10:27
 * To change this template use File | Settings | File Templates.
 */
public class SkeinMining {

    public static void main(String[] args) throws Exception {
        String a = "B1d";
        String b = "AI1";


        byte[] result = new byte[1024];

        Skein512.hash(a.getBytes(), result);


        for(byte r : result){
            System.out.print(r);
        }
    }

}

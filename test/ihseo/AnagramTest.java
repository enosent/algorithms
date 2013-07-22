package ihseo;

import programming.Anagram;

/**
 * Created with IntelliJ IDEA.
 * User: enosent7
 * Date: 13. 3. 11.
 * Time: 오후 3:59
 * To change this template use File | Settings | File Templates.
 */
public class AnagramTest {

    public static void main(String[] args) {
        Anagram anagram = new Anagram();

        System.out.println( anagram.anagram("TAB", "BAT") );
        System.out.println( anagram.anagram("TSAB", "BAT") );
        System.out.println( anagram.anagram("sAB", "bbs") );
        System.out.println( anagram.anagram("GOOGLE", "GELGOO") );
    }
}

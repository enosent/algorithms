package programming;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: enosent7
 * Date: 13. 3. 11.
 * Time: 오후 3:54
 * To change this template use File | Settings | File Templates.
 */
public class Anagram {

    public boolean anagram(String word1, String word2){
        boolean isAnagram = true;

        word1 = word1.toLowerCase();
        word2 = word2.toLowerCase();

        if(word1.length() == word2.length()){
            char[] wordSet1  = word1.toCharArray();
            char[] wordSet2  = word2.toCharArray();

            Arrays.sort(wordSet1);
            Arrays.sort(wordSet2);

            for(int i = 0; i < wordSet1.length; i++){
                if(wordSet1[i] != wordSet2[i]) isAnagram = false;
            }
        }
        else isAnagram = false;

        return isAnagram;
    }
}

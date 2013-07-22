package ihseo;

import org.junit.Test;
import programming.AustralianVoting;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: enosent7
 * Date: 13. 5. 25.
 * Time: 오전 10:37
 * To change this template use File | Settings | File Templates.
 */
public class AustralianVotingTest {

    @Test
    public void voteTest(){
        String[] candidates = new String[] {
                "John Doe",
                "Jane Smith",
                "Jane Austen"};

        int[][] votes = new int[][]{
                {1, 2, 3},
                {2, 1, 3},
                {2, 3, 1},
                {1, 2, 3},
                {3, 1, 2},
        };

        AustralianVoting vote = new AustralianVoting();

        assertThat(vote.vote(candidates, votes), is("John Doe"));
    }


}

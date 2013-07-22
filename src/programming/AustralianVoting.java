package programming;

/**
 * Created with IntelliJ IDEA.
 * User: enosent7
 * Date: 13. 5. 25.
 * Time: 오전 10:09
 * To change this template use File | Settings | File Templates.
 */
public class AustralianVoting {

    // candidates : 후보자
    // votes : 선호도수
    // vote  : 득표수

    public String vote(String[] candidates, int[][] votes) {

        int[] vote = new int[candidates.length];

        // 1순위 표 확인
        for(int i = 0; i < votes.length; i++){
            vote[votes[i][0]-1]++;
        }

        // 50% 이상 득표 확인
        for(int i = 0; i < vote.length; i++){

            return null;
        }

        // 최소 득표자 확인
        int max_vote = 0;
        int min_vote = 0;

        for(int i = 0; i < vote.length; i++){
            if(vote[i] >= max_vote){
                max_vote = vote[i];
            }
            else {
                min_vote = i;
            }
        }

        min_vote = vote[min_vote];
        vote[min_vote] = 0;


        // 최소 득표자 제외 - 최다 득표자 확인


        // output

        // Test - output
        for(int i = 0 ; i < vote.length; i++){
            System.out.println(candidates[i] + " : " + vote[i]);
        }



        return null;  //To change body of created methods use File | Settings | File Templates.
    }

}
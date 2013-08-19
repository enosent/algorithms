package programming;

/**
 * Created with IntelliJ IDEA.
 * User: enosent7
 * Date: 13. 5. 25.
 * Time: 오전 10:09
 * To change this template use File | Settings | File Templates.
 */
public class AustralianVoting {

    /*
    http://ikpil.com/1062 - 문제에 대한 정리 참조
    > 탈락된 후보자를 최 상위 순위로 찍은 투표용지들 중 그 다음 순위자로 표기된 자가 있다면, 그 순위자에게 표를 줍니다.

        John Doe
        Jane Smith
        Sirhan Sirhan

        1 2 3
        2 1 3
        2 3 1
        1 2 3
        3 1 2

        이 경우 3번 후보가 최하위 .. 3번을 투표한 투표자가 뽑은 2순위는 1번 후보이므로
        1번 후보자에게 1표가 추가 .. 이런식으로 투표수가 과반수가 넘는 투표자를 뽑는 방식
     */

    private String[] names;  // 후보자명
    private int[][] votes;   // 투표 정보
    private int[] voteCount; // 전체 득표 현황
    private int[] voteIndex; // 우선순위 확인을 위한 인덱스

    private int userVoteCount; // 참여인원
    private int candidate;   // 투표수

    private int maxVote = -1; // 최다 득표수
    private int maxVoteIndex = 0; // 최다 득표 후보 인덱스

    public AustralianVoting(String[] names, int[][] votes, int userVoteCount){
        this.names = names;
        this.votes = votes;
        this.userVoteCount = userVoteCount;

        candidate = names.length;
        voteCount = new int[candidate];
        voteIndex = new int[userVoteCount];
    }

    public void vote(){
        int minVote = userVoteCount; // 최소 득표수

        // 1순위 득표수 저장
        for(int n = 0; n < userVoteCount; n++){
            voteCount[votes[n][0]-1]++;
        }

        int alltied = 1;
        while(true){
            maxVote = -1;
            alltied = 1;
            for(int i = 0; i < voteCount.length; i++){
                if(voteCount[i] > 0){
                    // 최다 득표자 조회
                    if(voteCount[i] > maxVote){
                        if(maxVote > 0) alltied = 0;
                        maxVote = voteCount[i];
                        maxVoteIndex = i;
                    }

                    // 최소 득표수 조회
                    if(voteCount[i] < minVote){
                        if(minVote <= maxVote) alltied = 0;
                        minVote = voteCount[i];
                    }
                }
            }

            // 과반수 이상 or 모든 개표 완료
            if(voteCount[maxVoteIndex] * 2 > userVoteCount || alltied == 1) break;

            // 최소 득표자의 다음 우선 순위 표 증가
            for(int i = 0; i < userVoteCount; i++){
                if(voteCount[votes[i][voteIndex[i]]-1] == minVote){
                    /* ********** 중요 ... 이런식으로도 가능하군 ... */
                    for(voteIndex[i]++;voteCount[votes[i][voteIndex[i]]-1] <= minVote; voteIndex[i]++ );

                    voteCount[votes[i][voteIndex[i]]-1]++;
                }
            }

            // 최소 득표자 탈락
            for(int i = 0; i < voteCount.length; i++){
                if(voteCount[i] == minVote){
                    voteCount[i] = 0;
                }
            }
        }

        // 득표자 출력
        if(voteCount[maxVoteIndex] * 2 > userVoteCount){
            System.out.println(names[maxVoteIndex]);
        }else{
            for(int i = 0; i < voteCount.length; i++){
                if(voteCount[i] > 0){
                    if(i > 0) System.out.print(" ");
                    System.out.print(names[i]);
                }
            }
        }
    }

    // for test
    public void printOut(){
        for(int i = 0; i < voteCount.length; i++){
            System.out.println(i + " " + names[i] + " - " + voteCount[i] );
        }
    }
}
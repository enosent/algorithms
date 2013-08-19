package programming.p110108;

import java.io.IOException;

public class Main implements Runnable{
    static String ReadLn(int maxLength){  // utility function to read from stdin,
        // Provided by Programming-challenges, edit for style only
        byte line[] = new byte [maxLength];
        int length = 0;
        int input = -1;
        try{
            while (length < maxLength){//Read untill maxlength
                input = System.in.read();
                if ((input < 0) || (input == '\n')) break; //or untill end of line ninput
                line [length++] += input;
            }

            if ((input < 0) && (length == 0)) return null;  // eof
            return new String(line, 0, length);
        }catch (IOException e){
            return null;
        }
    }

    public static void main(String args[])  // entry point from OS
    {
        Main myWork = new Main();  // Construct the bootloader
        myWork.run();            // execute
    }

    public void run() {
        new myStuff().run();
    }
}

class myStuff implements Runnable{

    // You can insert more classes here if you want.
    private static final int MAX_VOTE_COUNT = 1000;

    private String[] names;
    private int[][] votes;
    private int voteCount[];
    private int[] voteIndex;

    private int userVoteCount;
    private int candidate;



    public void run(){
        // Your program here
        String input = Main.ReadLn(1024);
        input = input.trim();

        int caseNumber = Integer.parseInt(input);

        Main.ReadLn(1024);
        for(int i = 0; i < caseNumber; i++){
            userVoteCount = 0;
            if(i != 0) System.out.println();
            init();
            vote();
        }
    }

    public void init(){
        String input = Main.ReadLn(1024);
        input = input.trim();

        this.candidate = Integer.parseInt(input);

        names = new String[candidate];

        for(int i = 0 ; i < names.length ; i++){
            input = Main.ReadLn(1024);
            names[i] = input.trim();
        }

        votes = new int[MAX_VOTE_COUNT][candidate];

        for(int i = 0 ; i < votes.length ; i++){
            input = Main.ReadLn(1024);

            if(input.isEmpty()) break;
            String[] params = input.split("\\s+");

            for(int j = 0; j < votes[i].length; j++){
                votes[i][j] = Integer.parseInt(params[j]);
            }
            userVoteCount++;
        }
    }

    public void vote(){
        voteCount = new int[candidate];
        voteIndex = new int[userVoteCount];

        int minVote;
        int alltied;
        int maxVote;
        int maxVoteIndex = 0;

        for(int n = 0; n < userVoteCount; n++){
            voteCount[votes[n][0]-1]++;
        }

        while(true){
            maxVote = -1;
            minVote = userVoteCount;
            alltied = 1;

            for(int i = 0; i < voteCount.length; i++){
                if(voteCount[i] > 0){
                    if(voteCount[i] > maxVote){
                        if(maxVote > 0) alltied = 0;
                        maxVote = voteCount[i];
                        maxVoteIndex = i;
                    }

                    if(voteCount[i] < minVote){
                        if(minVote <= maxVote) alltied = 0;
                        minVote = voteCount[i];
                    }
                }
            }

            if(voteCount[maxVoteIndex] * 2 > userVoteCount || alltied == 1) break;

            for(int i = 0; i < userVoteCount; i++){
                if(voteCount[votes[i][voteIndex[i]]-1] == minVote){
                    for(voteIndex[i]++;voteCount[votes[i][voteIndex[i]]-1] <= minVote; voteIndex[i]++ );

                    voteCount[votes[i][voteIndex[i]]-1]++;
                }
            }


            for(int i = 0; i < voteCount.length; i++){
                if(voteCount[i] == minVote){
                    voteCount[i] = 0;
                }
            }
        }

        if(voteCount[maxVoteIndex] * 2 > userVoteCount){
            System.out.println(names[maxVoteIndex]);
        }else{
            for(int i = 0; i < voteCount.length; i++){
                if(voteCount[i] > 0){
                    System.out.println(names[i]);
                }
            }
        }

    }
}
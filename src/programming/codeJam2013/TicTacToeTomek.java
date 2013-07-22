package programming.codeJam2013;

import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: enosent7
 * Date: 13. 4. 13.
 * Time: 오전 10:26
 * To change this template use File | Settings | File Templates.
 */
public class TicTacToeTomek {

    public String ticTacToeTomek(String[][] board) {

        String[] winnerO = {"OOOO", "TOOO", "OTOO", "OOTO", "OOOT"};
        String[] winnerX = {"XXXX", "TXXX", "XTXX", "XXTX", "XXXT"};

        String[] rows = new String[4];
        String[] cols = new String[4];
        String[] diagonals = new String[]{
                board[0][0] + "" + board[1][1] + "" + board[2][2] + "" + board[3][3],
                board[0][3] + "" + board[1][2] + "" + board[2][1] + "" + board[3][0]
        };

        for(int i = 0; i < board.length; i++) {

            String rowStr = "";
            String colStr = "";

            for(int j = 0; j < board[i].length; j++){
                rowStr += board[i][j];
                colStr += board[j][i];
            }

            rows[i] = rowStr;
            cols[i] = colStr;

        }

        String winner = "";
        //for(int i = 0; i < 4; i++){
        //    String stateRows = rows[i];
        //    String stateCols = cols[i];
        //
        //    for(int j=0; j < 5; j++){
        //        if(stateRows.equals(winnerX[j]) || stateCols.equals(winnerX[j])) winner = "X won";
        //        if(stateRows.equals(winnerO[j]) || stateCols.equals(winnerO[j])) winner = "O won";
        //    }
        //}
        //
        //if("".equals(winner)){
        //    for(int i = 0; i < diagonals.length; i++){
        //        String stateDiagonal = diagonals[i];
        //
        //        for(int j=0; j < 5; j++){
        //            if(stateDiagonal.equals(winnerO[j])) winner = "O won";
        //            if(stateDiagonal.equals(winnerX[j])) winner = "X won";
        //        }
        //    }
        //}


        for(int i = 0; i < 5; i++){

            for(int j = 0; j < 4; j++){
                String stateRows = rows[j];
                String stateCols = cols[j];

                if(stateRows.equals(winnerX[i]) || stateCols.equals(winnerX[i])) winner = "X won";
                if(stateRows.equals(winnerO[i]) || stateCols.equals(winnerO[i])) winner = "O won";
            }

            for(int j = 0; j < diagonals.length; j++){
                String stateDiagonal = diagonals[j];

                if(stateDiagonal.equals(winnerO[i])) winner = "O won";
                if(stateDiagonal.equals(winnerX[i])) winner = "X won";
            }

            if(!"".equals(winner)) break;

        }

        if("".equals(winner)){
            for(int i = 0; i < 4; i++){
                String state = rows[i];

                if(state.indexOf('.') >= 0){ winner = "Game has not completed"; break;}
                else winner = "Draw";
            }
        }

        return winner;
    }
}

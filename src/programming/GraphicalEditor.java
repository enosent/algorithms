package programming;


import java.util.List;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: enosent7
 * Date: 13. 3. 8.
 * Time: 오후 1:47
 * To change this template use File | Settings | File Templates.
 */
public class GraphicalEditor {

    public char[][] bitmapped = new char[250][250];


    // You can insert more classes here if you want.
    public enum Commands{
        I, C, L, V, H, K, F, S, X, ERR;

        // Exception 방지를 위한 설정
        public static Commands find(String name){
            for(Commands commands : Commands.values()){
                if(commands.name().equals(name)){
                    return commands;
                }
            }
            return ERR;
        }
    }

    public void createBitMappedImages(String[] input){

        int row, col;
        int rowStart, rowEnd, colStart, colEnd;
        char color;

        String q = input[0];

        Commands commands = Commands.find(q);

        switch (commands){
            case I :

                row = Integer.parseInt(input[2]);
                col = Integer.parseInt(input[1]);
                bitmapped = new char[row][col];

                for(int i = 0; i < bitmapped.length; i++){
                    for(int j = 0; j < bitmapped[0].length; j++){
                        bitmapped[i][j] = 'O';
                    }
                }

                break;
            case C :

                for(int i = 0; i < bitmapped.length; i++){
                    for(int j = 0; j < bitmapped[0].length; j++){
                        bitmapped[i][j] = 'O';
                    }
                }

                break;
            case L :

                row = Integer.parseInt(input[2])-1;
                col = Integer.parseInt(input[1])-1;

                color = input[3].charAt(0);

                bitmapped[row][col] = color;

                break;
            case V :

                col = Integer.parseInt(input[1])-1;

                rowStart = Integer.parseInt(input[2])-1;
                rowEnd = Integer.parseInt(input[3])-1;

                color = input[4].charAt(0);

                if(rowStart > rowEnd){
                    int temp = rowStart;
                    rowStart = rowEnd;
                    rowEnd = temp;
                }

                for(int i = rowStart; i <= rowEnd; i++){
                    bitmapped[i][col] = color;
                }

                break;
            case H :

                row = Integer.parseInt(input[3])-1;

                colStart = Integer.parseInt(input[1])-1;
                colEnd = Integer.parseInt(input[2])-1;

                color = input[4].charAt(0);

                if(colStart > colEnd) {
                    int temp = colStart;
                    colStart = colEnd;
                    colEnd = temp;
                }

                for(int i = colStart; i <= colEnd; i++){
                    bitmapped[row][i] = color;
                }

                break;
            case K :

                rowStart = Integer.parseInt(input[2])-1;
                colStart = Integer.parseInt(input[1])-1;

                rowEnd = Integer.parseInt(input[4])-1;
                colEnd = Integer.parseInt(input[3])-1;

                color = input[5].charAt(0);

                for(int i = rowStart; i <= rowEnd; i++){
                    for(int j = colStart; j <= colEnd; j++){
                        bitmapped[i][j] = color;
                    }
                }

                break;
            case F :

                row = Integer.parseInt(input[2])-1;
                col = Integer.parseInt(input[1])-1;

                color = input[3].charAt(0);

                if(bitmapped[row][col] != color) {
                    this.filledColor(row, col, bitmapped[row][col], color);
                }

                break;
            case S :
                String filename = input[1];

                System.out.println(filename);

                for(int i = 0; i < bitmapped.length; i++){
                    for(int j = 0; j < bitmapped[0].length; j++){
                        System.out.print(bitmapped[i][j]);
                    }
                    System.out.println();
                }

                break;
        }
    }

    class Points{
        public int row;
        public int col;

        public Points(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    public void filledColor(int row, int col, char orgColor, char color) {
        Points points = new Points(row, col);
        Stack<Points> pointsSet = new Stack<Points>();

        pointsSet.push(points);

        while(!pointsSet.isEmpty()){
            Points currentPoint = pointsSet.pop();
            this.FloodFill(currentPoint, orgColor, color, pointsSet);
        }
    }

    public void FloodFill(Points points, char orgColor, char color, Stack<Points> pointsSet) {

        int row = points.row;
        int col = points.col;

        bitmapped[row][col] = color;

        if(row > 0 && bitmapped[row-1][col] == orgColor){
            bitmapped[row-1][col] = color;
            pointsSet.push(new Points(row-1, col));
        }
        if(row < bitmapped.length-1 && bitmapped[row+1][col] == orgColor){
            bitmapped[row+1][col] = color;
            pointsSet.push(new Points(row+1, col));
        }
        if(col > 0 && bitmapped[row][col-1] == orgColor){
            bitmapped[row][col-1] = color;
            pointsSet.push(new Points(row, col-1));
        }
        if(col < bitmapped[0].length-1 && bitmapped[row][col+1] == orgColor){
            bitmapped[row][col+1] = color;
            pointsSet.push(new Points(row, col+1));
        }

    }
}

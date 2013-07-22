package programming;

public class Minesweeper {
    public String[][] minesweeper(int m, int n, String[][] input){
        String[][] mine = input;

        String[][] sweeper = new String[m][n];

        // init
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){

                if("*".equals(mine[i][j])){
                    sweeper[i][j] = "*";
                }else{
                    sweeper[i][j] = "0";
                }
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if("*".equals(sweeper[i][j])){
                    if(i-1 >= 0){
                        this.increase(i-1, j, n, sweeper);
                    }
                    if((j-1) >= 0 && !"*".equals(sweeper[i][j-1])){
                        sweeper[i][j-1] = String.valueOf(Integer.parseInt(sweeper[i][j-1]) + 1);
                    }
                    if((j+1) < n && !"*".equals(sweeper[i][j+1])){
                        sweeper[i][j+1] = String.valueOf(Integer.parseInt(sweeper[i][j+1]) + 1);
                    }
                    if(i+1 < m){
                        this.increase(i+1, j, n, sweeper);
                    }
                }
            }
        }

        return sweeper;
    }

    private void increase(int i, int j, int n, String[][] sweeper){
        if((j-1) >= 0 && !"*".equals(sweeper[i][j-1])){
            sweeper[i][j-1] = String.valueOf(Integer.parseInt(sweeper[i][j-1]) + 1);
        }
        if(!"*".equals(sweeper[i][j])){
            sweeper[i][j] = String.valueOf(Integer.parseInt(sweeper[i][j]) + 1);
        }
        if((j+1) < n && !"*".equals(sweeper[i][j+1])){
            sweeper[i][j+1] = String.valueOf(Integer.parseInt(sweeper[i][j+1]) + 1);
        }
    }
}

















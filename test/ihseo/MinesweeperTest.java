package ihseo;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Test;
import programming.Minesweeper;


public class MinesweeperTest {

	@Test
	public void inputTest(){
		int m = 3;
		int n = 5;

		String[][] mine = {
            {"*", "*", ".", ".", "."},
            {".", ".", ".", ".", "."},
            {".", "*", ".", ".", "."}
        };


		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(mine[i][j]);
			}
			System.out.println();
		}
		
		Minesweeper mines = new Minesweeper();

		String[][] minesweeper = mines.minesweeper(m, n, mine);

		System.out.println("-------------------------------");
        System.out.println("Field #1:");
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(minesweeper[i][j]);
			}
			System.out.println();
		}
		
	}
}

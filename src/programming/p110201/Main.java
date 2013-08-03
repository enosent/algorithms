package programming.p110201;

import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        Main main = new Main();
        while(true){

            String line = scan.nextLine().trim();

            if(line.isEmpty()) break;

            String[] temp = line.split("\\s+");

            int n = Integer.parseInt(temp[0].trim());

            int[] numbers = new int[n];

            for(int i = 0; i < n; i++){
                numbers[i] = Integer.parseInt(temp[i + 1].trim());
            }

            System.out.println(main.jollyCheck(numbers));
        }
    }
    public String jollyCheck(int[] input){

        String success = "Jolly";
        String fail = "Not jolly";

        int size = input.length;

        if(size == 1) return success;

        ArrayList<Integer> diffs = new ArrayList<Integer>();

        for(int i = 0; i < size-1; i++) {
            int diff = Math.abs(input[i] - input[i+1]);

            if(diff > size) return fail;

            diffs.add(new Integer(diff));
        }

        for(int i = 1; i < size; i++){
            if(!diffs.contains(new Integer(i))){
                return fail;
            }
        }

        return success;
    }
}
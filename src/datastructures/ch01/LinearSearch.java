package datastructures.ch01;

/**
 * User: enosent7
 * Date: 2014. 1. 4.
 * Time: 오전 11:04
 */
public class LinearSearch {

    public static void main(String[] args) {
        int array[] = {3, 5, 2, 4, 9};

        int index;

        LinearSearch search = new LinearSearch();

        index = search.lSearch(array, array.length, 4);

        search.print(index);

        index = search.lSearch(array, array.length, 7);

        search.print(index);
    }

    public int lSearch(int array[], int length, int target){
        for(int i=0; i < length; i++){
            if(array[i] == target)
                return i;
        }

        return -1;
    }

    private void print(int index) {
        if(index == -1) {
            System.out.println("탐색실패");
        }
        else {
            System.out.println("타겟 저장 인덱스: " + index);
        }
    }
}

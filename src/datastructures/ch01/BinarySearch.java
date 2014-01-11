package datastructures.ch01;

/**
 * User: enosent7
 * Date: 2014. 1. 4.
 * Time: 오전 11:31
 */
public class BinarySearch {


    public static void main(String[] args) {
        int index;
        int[] array = {1, 3, 5, 7, 9};

        BinarySearch search = new BinarySearch();
        index = search.bSearch(array, 4);

        search.print(index);

        index = search.bSearch(array, 7);

        search.print(index);
    }

    public int bSearch(int[] array, int target){

        int first = 0;
        int last = array.length-1;
        int mid;

        while(first <= last){

            mid = (first + last)/2;

            if(array[mid] == target){
                return mid;
            }else{
                if(array[mid] > target){
                    last = mid -1;
                }else{
                    first = mid +1;
                }
            }
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
}                                                                R

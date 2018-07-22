package interviewbit.binarysearch;

import java.util.ArrayList;

import static java.lang.System.out;

/**
 * Created by mayan on 14/7/18.
 */
public class AssignBooks {
    public static void main(String[] args){
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(12);
        integers.add(34);
        integers.add(67);
        integers.add(90);
        AssignBooks assignBooks = new AssignBooks();
        out.println(assignBooks.books(integers,2));
    }
    public int books(ArrayList<Integer> A, int B) {
        int result = Integer.MAX_VALUE;
        if(B > A.size()) return -1;
        int start = 0;
        int end = A.stream().mapToInt(Integer::intValue).sum();
        while (start <= end){
            int mid = (start+end)/2;
            if(isPossible(A,mid,B)){
                result = Math.min(result,mid);
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return result;
    }
    private boolean isPossible(ArrayList<Integer> list,int total,int students){
        int curr_count=0;
        int currStudents = 1;
        for(Integer item : list){
            if(item > total)
                return false;

            if(curr_count + item > total){
                currStudents++;
                curr_count = item;
                if(currStudents > students)return false;

            }else{
                curr_count += item;
            }
        }
        return true;
    }
}

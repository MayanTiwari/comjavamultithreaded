package interviewbit.arrays;

import java.util.ArrayList;

import static java.lang.System.out;

/**
 * Created by mayan on 6/8/18.
 */
public class MinSteps {
    public static void main(String[] args){
        ArrayList<Integer> A = new ArrayList<>();
        ArrayList<Integer> B = new ArrayList<>();

        A.add(4);
        A.add(8);
        A.add(-7);
        A.add(-5);
        A.add(-13);
        A.add(9);
        A.add(-7);
        A.add(8);

        B.add(4);
        B.add(-15);
        B.add(-10);
        B.add(-3);
        B.add(-13);
        B.add(12);
        B.add(8);
        B.add(-8);
        MinSteps minSteps = new MinSteps();
        int res = minSteps.coverPoints(A,B);
        out.println(res);
    }
    public int coverPoints(ArrayList<Integer> A, ArrayList<Integer> B) {
        int result = 0;
        if(A.size() != B.size()) return -1;
        if(A.size() == 0 || B.size() == 0) return -1;

        for(int i = 0 ; i< A.size()-1;i++){
            int xdiff = Math.abs(A.get(A.size()-1) - A.get(0));
            int yDiff = Math.abs(B.get(B.size()-1) - B.get(0));
            result += Math.max(xdiff,yDiff);
            //result += xdiff > yDiff ? xdiff:yDiff;
        }

        return result;
    }
}

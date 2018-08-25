package interviewbit.arrays;

import java.util.ArrayList;

/**
 * Created by mayan on 12/8/18.
 */
public class SpiralMatrix {
    public static void main(String[] args){
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        spiralMatrix.generateMatrix(4);
    }
    public ArrayList<ArrayList<Integer>> generateMatrix(int A) {
        ArrayList<ArrayList<Integer>> arrayListArrayList = new ArrayList<>();
        int[][] arr = new int[A][A];
        int n  = A*A;
        int i =0;
        int right = A-1;
        int down = A-2;
        int left = A-2;
        int top = A-2;
        while (i < n){
            //Move right
            for(int j = 0; j < right; j++){
                arr[right][i] = i+1;
                i++;
            }
            right = right-1;

            //Move down.
            for(int j= down; j>=0 ; j--){
                arr[i][down] = i+1;
                i++;
            }
            down = down-1;
            //Move left
            for(int j = left;j >= 0;j--){
                arr[left][i] =  i+1;
                i++;
            }
            left = left-1;
            //Move top
            for(int j = 0 ; j < top ; j++){
                arr[i][top] = i+1;
                i++;
            }
        }
        return arrayListArrayList;
    }

}

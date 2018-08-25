package interviewbit.arrays;

import java.util.ArrayList;

import static java.lang.System.out;

/**
 * Created by mayan on 15/8/18.
 */
public class AntiDiagonal {
    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> lol = new ArrayList<>();
        ArrayList<Integer> i1 = new ArrayList<>();
        i1.add(1);
        i1.add(2);
        i1.add(3);

        ArrayList<Integer> i2 = new ArrayList<>();
        i2.add(4);
        i2.add(5);
        i2.add(6);

        ArrayList<Integer> i3 = new ArrayList<>();
        i3.add(7);
        i3.add(8);
        i3.add(9);

        lol.add(i1);
        lol.add(i2);
        lol.add(i3);

        AntiDiagonal antiDiagonal = new AntiDiagonal();
        out.print(antiDiagonal.diagonal(lol));


    }
    public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> res= new ArrayList<>();
        int r = 0;
        int c = 0;
        while (c <= A.size()-1 && r <= A.size()-1){
            int tr = r;
            int tc = c;
            ArrayList<Integer> temp = new ArrayList<>();
            while (tr <= A.size()-1 && tc >= 0){
                temp.add(A.get(tr).get(tc));
                tr++;
                tc--;
            }
            if(c < A.size()-1){
                c++;
            } else{
                r++;
            }
            res.add(temp);
        }
        return res;
    }
}

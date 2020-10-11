package interviewbit.arrays;

import java.util.ArrayList;

public class AddOneToNum {
    public static void main(String[] args) {
        ArrayList<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(9);
        integerList.add(9);
        integerList.add(9);
        AddOneToNum addOneToNum = new AddOneToNum();
        addOneToNum.plusOne(integerList).forEach(System.out::println);

    }
    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<>();
        boolean addOne = false;
        for(int i = A.size()-1 ; i >= 0 ; i--){
            if(A.get(i) + 1 >= 10){
                A.set(i,0);
                if(i == A.size()-1){
                    addOne = true;
                }
            }else{
                A.set(i, A.get(i) + 1);
                break;
            }
        }
        if(addOne) A.add(0,1);
        return A;
    }
}

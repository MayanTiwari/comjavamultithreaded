package interviewbit.heapsandmaps;

import java.util.ArrayList;
import java.util.HashMap;

import static java.lang.System.out;

/**
 * Created by mayan on 22/7/18.
 */
public class DistinctNumbers {
    public static void main(String[] args){
        DistinctNumbers distinctNumbers = new DistinctNumbers();
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(1);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(3);

        out.println(distinctNumbers.dNums(arrayList,3));
    }
    public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
        ArrayList<Integer> result = new ArrayList<>();
        if(B > A.size()) return result;
        HashMap<Integer, Integer> hM = new HashMap<Integer, Integer>();
        int dist_count = 0;
        // Traverse the first window and store count
        // of every element in hash map
        for (int i = 0; i < B; i++)
        {
            if (hM.get(A.get(i)) == null)
            {
                hM.put(A.get(i), 1);
                dist_count++;
            }
            else
            {
                int count = hM.get(A.get(i));
                hM.put(A.get(i), count+1);
            }
        }
        result.add(dist_count);
        // Traverse through the remaining array
        for (int i = B; i < A.size(); i++)
        {
            // Remove first element of previous window
            // If there was only one occurrence, then
            // reduce distinct count.
            if (hM.get(A.get(i-B)) == 1)
            {
                hM.remove(A.get(i-B));
                dist_count--;
            }
            else // reduce count of the removed element
            {
                int count = hM.get(A.get(i -B));
                hM.put(A.get(i-B), count-1);
            }
            // Add new element of current window
            // If this element appears first time,
            // increment distinct element count
            if (hM.get(A.get(i)) == null)
            {
                hM.put(A.get(i), 1);
                dist_count++;
            }
            else // Increment distinct element count
            {
                int count = hM.get(A.get(i));
                hM.put(A.get(i), count+1);
            }
            result.add(dist_count);
        }

        return result;
    }
}

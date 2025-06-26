// Divide no. of people ti K subSets:
// https://youtu.be/TvvGj1FtHIk?si=36DtM7hLXQgXm0Cj
import java.util.*;

public class kPartition {
    public static void kPartition(int i, int n, int k, Arraylist<Arraylist<Integer>> ans){
        // BC
        if(i>n){
            if(k==0){
                for(ArrayList<Integer> set: ans)
                    System.out.println(set + " ");
            }
            System.out.println();
            return;
        }

        // loop in the ans_subset array and fill: 1.all existing 2.one new place
        for(int j=0; j<ans.size(); j++){
            if(ans.get(j).size() > 0){  // existing
                ans.get(j).add(i);
                kPartition(i+1, n, k, ans);
                ans.get(j).remove(ans.get(j).size() - 1);
            }else {     // empty
                ans.get(j).add(i);
                kPartition(i+1, n, k-1, ans);
                ans.get(j).remove(ans.get(j).size() - 1);
                break;
            }
        }

    }
    
    public static void main(String[] args) {
        
    }
}

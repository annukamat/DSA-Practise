// https://leetcode.com/problems/boats-to-save-people/description/
import java.util.Arrays;

public class boatsToSavePeople {

    public int numRescueBoats(int[] people, int limit) {
        int i=0, j=people.length-1;
        int boats=0;

        Arrays.sort(people);

        while(i<=j){
            int sum = people[i] + people[j];
            if(sum <= limit){
                i++;
                j--;
            }else{
                j--;
            }
            boats++;
        }

        return boats; 
    }
    
}

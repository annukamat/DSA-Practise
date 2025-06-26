import java.util.*;

public class permutation46 {

    public List<List<Integer>> permute(int[] nums){
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

        boolean[] vis = new boolean[n];
        permute_(nums, vis, ans, res);

        return res;
    }

    public void permute_(int[] nums, boolean[] vis, List<Integer> ans, List<List<Integer>> res){
        // bc:
        if(ans.size() == nums.length){
            res.add(ans);
        }

        for(int i=0; i<nums.length; i++){
            if(!vis[i]){
                vis[i] = true;
                ans.add(i);

                permute_(nums, vis, ans, res);

                // backtrack
                vis[i] = false;
                ans.remove(ans.size() - 1);
            }
        }
    }

    // permute without vis array
        public void permute_(int[] nums, List<Integer> ans, List<List<Integer>> res){
        // bc:
        if(ans.size() == nums.length){
            res.add(new ArrayList<>(ans)); // Deep copy
            return;
        }

        for(int i=0; i<nums.length; i++){
            if(nums[i] != Integer.MAX_VALUE){
                int val = nums[i];         // Save original
                nums[i] = Integer.MAX_VALUE;
                ans.add(val);

                permute_(nums, ans, res);

                // backtrack
                nums[i] = val;
                ans.remove(ans.size() - 1);
            }
        }
    }


    public static void main(String[] args) {
        
    }
}

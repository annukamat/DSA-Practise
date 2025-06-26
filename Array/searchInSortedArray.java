// https://leetcode.com/problems/search-in-rotated-sorted-array/

public class searchInSortedArray {

    public int search(int[] nums, int tar) {
        int lo=0, hi=nums.length-1;

        while(lo <= hi){
            int mid = lo + (hi-lo)/2;

            if(nums[mid] == tar) return mid;
            else if(nums[lo] <= nums[mid]){
                if(tar>=nums[lo] && tar<nums[mid]){
                    hi = mid-1;
                }else lo = mid+1;
            }else{
                if(tar>nums[mid] && tar<=nums[hi]){
                    lo = mid+1;
                }else hi = mid-1;
            }
        }

        return -1;
    }
    
}

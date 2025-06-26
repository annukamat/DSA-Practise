public class maxSumCircularSubarray {

    public int maxSubarraySumCircular(int[] nums) {
        if(nums.length == 1) return nums[0];

        return Math.max(kadanes(nums), reverse_kadanes(nums));
    }

    public static int kadanes(int[] arr){
        int csum = 0, gsum = 0;

        for(int i=0; i<arr.length; i++){
            csum = Math.max(csum, csum+arr[i]);
            gsum = Math.max(gsum, csum);
        }

        return gsum;
    }

    public static int reverse_kadanes(int[] arr){
        int total = 0;

        for(int i=0; i<arr.length; i++){
            total += arr[i];

            arr[i] = -arr[i];
        }

        int k = kadanes(arr);
        int res = total-k;

        if(total == -k){
            return total;
        }else return res;
    }
    

    public static void main(String[] args) {
        
    }
}

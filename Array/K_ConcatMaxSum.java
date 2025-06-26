public class K_ConcatMaxSum {

    private static final int MOD = 1_000_000_007;

    public int kConcatenationMaxSum(int[] arr, int k) {
        long totalSum = 0;
        for (int e : arr) totalSum += e;

        if (k == 1) return (int)(kadanes(arr) % MOD);

        long kadaneTwo = kadanesOfTwo(arr);

        if (totalSum < 0) {
            return (int)(kadaneTwo % MOD);
        } else {
            long result = kadaneTwo + (k - 2) * totalSum;
            return (int)(result % MOD);
        }
    }

    public static long kadanes(int[] arr) {
        long csum = 0, gsum = 0;

        for (int i = 0; i < arr.length; i++) {
            csum = Math.max(arr[i], csum + arr[i]);
            gsum = Math.max(gsum, csum);
        }

        return gsum;
    }

    public static long kadanesOfTwo(int[] arr) {
        int n = arr.length;
        int[] narr = new int[n * 2];

        for (int i = 0; i < n; i++) {
            narr[i] = arr[i];
            narr[i + n] = arr[i];
        }

        return kadanes(narr);
    }

    public static void main(String[] args) {
        
    }
}
// https://www.geeksforgeeks.org/chocolate-distribution-problem/

import java.util.Arrays;

public class chocolateDistribution {

    // m: number of students
    public static int findMin(int[] arr, int m) {
        if (m == 0 || arr.length == 0 || m > arr.length) return 0;

        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;

        for (int i = 0; i <= arr.length - m; i++) {
            int cur_min = arr[i + m - 1] - arr[i];
            min = Math.min(min, cur_min);
        }

        return min;
    }

}

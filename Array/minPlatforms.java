// https://www.geeksforgeeks.org/minimum-number-platforms-required-railwaybus-station/

import java.util.Arrays;

public class minPlatforms {

    public static int findPlatform(int[] arr, int[] dep) {
        Arrays.sort(arr);
        Arrays.sort(dep);

        int n = arr.length;
        int i = 1, j = 0;
        int platforms = 1, maxPlatforms = 1;

        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
                platforms++;
                i++;
            } else {
                platforms--;
                j++;
            }

            maxPlatforms = Math.max(maxPlatforms, platforms);
        }

        return maxPlatforms;
    }

    public static void main(String[] args) {
        int[] arrival = { 900, 940, 950, 1100, 1500, 1800 };
        int[] departure = { 910, 1200, 1120, 1130, 1900, 2000 };

        System.out.println(findPlatform(arrival, departure)); // Output: 3
    }

}

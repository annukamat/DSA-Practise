import java.util.Arrays;

public class FindPairWithGivenDiff {

    public static boolean findPair(int[] arr, int x) {
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i] + x;
            if (binarySearch(arr, i + 1, arr.length - 1, num))
                return true;
        }

        return false;
    }

    public static boolean binarySearch(int[] arr, int lo, int hi, int num) {
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (arr[mid] == num) {
                return true;
            } else if (arr[mid] < num) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = { 5, 20, 3, 2, 5, 80 };
        int x = 78;

        System.out.println(findPair(arr, x)); // Output: true (2, 80)
    }
}

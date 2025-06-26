public class PairSumInRotatedArray {

public static boolean pairInRotatedSorted(int[] arr, int target) {
        int n = arr.length;

        // Step 1: Find the pivot (smallest element's index)
        int pivot = findPivot(arr);

        // Step 2: Initialize two pointers
        int l = pivot;
        int r = (pivot - 1 + n) % n;

        // Step 3: Two-pointer search
        while (l != r) {
            int sum = arr[l] + arr[r];

            if (sum == target) return true;
            else if (sum < target) {
                l = (l + 1) % n;
            } else {
                r = (r - 1 + n) % n;
            }
        }

        return false;
    }

    // Find index of the minimum element (pivot)
    private static int findPivot(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return i + 1;
            }
        }
        return 0; // array is not rotated
    }


    public static void main(String[] args) {
        int[] arr = {11, 15, 6, 8, 9, 10};
        int target = 16;
        System.out.println(pairInRotatedSorted(arr, target));  // Output: true (6 + 10)
    }
}

// https://leetcode.com/problems/find-k-pairs-with-smallest-sums/description/

import java.util.*;

public class kPair_smallestSum {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;

        List<List<Integer>> result = new ArrayList<>();
        if (m == 0 || n == 0 || k == 0) return result;

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.sum));
        Set<String> visited = new HashSet<>();

        pq.offer(new Pair(0, 0, nums1[0] + nums2[0]));
        visited.add("0#0");

        while (k-- > 0 && !pq.isEmpty()) {
            Pair curr = pq.poll();
            int i = curr.i, j = curr.j;

            result.add(Arrays.asList(nums1[i], nums2[j]));

            tryAdd(i, j + 1, nums1, nums2, pq, visited);
            tryAdd(i + 1, j, nums1, nums2, pq, visited);
        }

        return result;
    }

    private void tryAdd(int i, int j, int[] nums1, int[] nums2, PriorityQueue<Pair> pq, Set<String> visited) {
        int m = nums1.length, n = nums2.length;
        if (i < m && j < n) {
            String key = i + "#" + j;
            if (!visited.contains(key)) {
                pq.offer(new Pair(i, j, nums1[i] + nums2[j]));
                visited.add(key);
            }
        }
    }

    static class Pair {
        int i, j, sum;
        Pair(int i, int j, int sum) {
            this.i = i;
            this.j = j;
            this.sum = sum;
        }
    }
}
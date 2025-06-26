// https://leetcode.com/problems/rotate-image/description/

public class rotateImage {

    public void rotate(int[][] matrix) {
        transpose(matrix);
        reverseRow(matrix);
    }

    public void transpose(int[][] mat) {
        int n = mat.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
    }

    public void reverseRow(int[][] mat) {
        int n = mat.length;

        for (int i = 0; i < n; i++) {
            int left = 0, rt = n - 1;

            while (left < rt) {
                int temp = mat[i][left];
                mat[i][left] = mat[i][rt];
                mat[i][rt] = temp;

                left++;
                rt--;
            }
        }
    }

}

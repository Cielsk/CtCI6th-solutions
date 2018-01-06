package arrays_and_strings.java;

import java.util.Scanner;

/**
 *
 */
public class RotateMatrix {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    int[][] matrix = new int[n][n];

    int start = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        matrix[i][j] = start++;
      }
    }
    printMatrix(matrix);
    System.out.println();

    rotate(matrix);
    printMatrix(matrix);
  }

  private static void rotate(int[][] matrix) {
    if (matrix.length == 0) throw new IllegalArgumentException("Empty matrix");
    if (!isSquareMatrix(matrix)) throw new IllegalArgumentException("Not square matrix");

    int n = matrix.length;
    for (int i = 0; i < n / 2; i++) {
      // rotate by circle
      for (int j = i; j < n - i - 1; j++) {
        int temp = matrix[i][j];

        // left to top
        matrix[i][j] = matrix[n - j - 1][i];
        // bottom to left
        matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
        // right to bottom
        matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
        // top to right
        matrix[j][n - i - 1] = temp;
      }
    }
  }

  private static boolean isSquareMatrix(int[][] matrix) {
    int n = matrix.length;

    for (int[] arr : matrix) {
      if (n != arr.length) return false;
    }

    return true;
  }

  private static void printMatrix(int[][] matrix) {
    for (int[] arr : matrix) {
      for (int i : arr) {
        System.out.printf("%5d", i);
      }
      System.out.println();
    }
  }
}

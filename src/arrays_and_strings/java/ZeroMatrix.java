package arrays_and_strings.java;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/**
 *
 */
public class ZeroMatrix {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    int[][] matrix = new int[n][n];

    Random random = new Random();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        matrix[i][j] = random.nextInt(n * n);
      }
    }
    printMatrix(matrix);
    System.out.println();

    zeroMatrix(matrix);
    printMatrix(matrix);
  }

  private static void printMatrix(int[][] matrix) {
    for (int[] arr : matrix) {
      for (int i : arr) {
        System.out.printf("%5d", i);
      }
      System.out.println();
    }
  }

  private static void zeroMatrix(int[][] matrix) {
    if (!isMatrix(matrix)) throw new IllegalArgumentException("Not a matrix");

    int m = matrix.length;
    int n = matrix[0].length;

    Set<Integer> row = new HashSet<>();
    Set<Integer> col = new HashSet<>();

    for (int i = 0; i < m; i++) {
      if (row.contains(i)) continue;
      for (int j = 0; j < n; j++) {
        if (col.contains(j)) continue;

        if (matrix[i][j] == 0) {
          row.add(i);
          col.add(j);
          for (int k = 0; k < m; k++) {
            matrix[k][j] = 0;
          }
          Arrays.fill(matrix[i], 0);
          break;
        }
      }
    }
  }

  private static boolean isMatrix(int[][] matrix) {
    if (matrix.length == 0) return false;
    int len = matrix[0].length;
    for (int[] arr : matrix) {
      if (arr.length != len) return false;
    }

    return true;
  }
}

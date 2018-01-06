package arrays_and_strings.java;

import java.util.Scanner;

/**
 *
 */
public class IsUnique {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String str = in.next();

    System.out.println(isUnique(str) ? "Yes" : "No");
  }

  private static boolean isUnique(String str) {
    for (int i = 0; i < str.length(); i++) {
      int index = str.indexOf(str.charAt(i), i + 1);
      if (index < 0 || index >= str.length()) return false;
    }
    return true;
  }
}

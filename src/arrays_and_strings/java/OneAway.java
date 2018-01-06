package arrays_and_strings.java;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 */
public class OneAway {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    String a = in.next();
    String b = in.next();
    System.out.println(isOneAway(a, b) ? "Yes" : "No");
  }

  private static boolean isOneAway(String first, String second) {
    if (Math.abs(first.length() - second.length()) > 1) return false;

    String s1 = first.length() < second.length() ? first : second;
    String s2 = first.length() < second.length() ? second : first;

    boolean foundDiff = false;
    for (int i = 0, j = 0; i < s1.length() && j < s2.length(); j++) {
      if (s1.charAt(i) != s2.charAt(j)) {
        if (foundDiff) return false;
        foundDiff = true;
        if (s1.length() == s2.length()) i++;
      } else {
        i++;
      }
    }

    return true;
  }
}

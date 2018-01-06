package arrays_and_strings.java;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 */
public class CheckPermutation {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String a = in.next();
    String b = in.next();

    System.out.println(isPermutation(a, b) ? "Yes" : "No");
  }

  private static boolean isPermutation(String a, String b) {
    int length = a.length();
    if (length != b.length()) return false;
    Map<Character, Integer> buf = new HashMap<>();
    for (char c : a.toCharArray()) {
      buf.computeIfPresent(c, (k, v) -> v + 1);
      buf.putIfAbsent(c, 1);
    }
    for (char c : b.toCharArray()) {
      buf.computeIfPresent(c, (k, v) -> v - 1);
      buf.putIfAbsent(c, -1);
    }
    for (Map.Entry<Character, Integer> entry : buf.entrySet()) {
      if (entry.getValue() != 0) return false;
    }

    return true;
  }
}

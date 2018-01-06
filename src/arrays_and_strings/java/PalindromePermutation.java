package arrays_and_strings.java;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 */
public class PalindromePermutation {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String str = in.nextLine();
    String start = str.replace(" ", "");
    System.out.println(isPalindromePermutation(start) ? "Yes" : "No");
  }

  private static boolean isPalindromePermutation(String str) {
    Map<Character, Integer> buf = new HashMap<>();

    for (char c : str.toCharArray()) {
      buf.computeIfPresent(c, (k, v) -> v + 1);
      buf.putIfAbsent(c, 1);
    }

    boolean foundOdds = false;
    for (Map.Entry<Character, Integer> entry : buf.entrySet()) {
      if (entry.getValue() % 2 != 0) {
        if (foundOdds) return false;
        foundOdds = true;
      }
    }

    return true;
  }
}

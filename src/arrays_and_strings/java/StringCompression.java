package arrays_and_strings.java;

import java.util.Scanner;

/**
 *
 */
public class StringCompression {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String str = in.next();
    System.out.println(compress(str));
  }

  private static String compress(String str) {
    if (str == null || str.length() == 0) return str;

    StringBuilder builder = new StringBuilder();
    int len = 0;
    for (int i = 0; i < str.length(); i++) {
      len++;
      if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
        builder.append(str.charAt(i));
        builder.append(Integer.valueOf(len));
        len = 0;
      }
    }

    return builder.length() < str.length() ? builder.toString() : str;
  }
}

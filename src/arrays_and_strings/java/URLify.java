package arrays_and_strings.java;

import java.util.Scanner;

/**
 *
 */
public class URLify {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String str = in.nextLine();
    int len = in.nextInt();
    System.out.println(urlify(str, len));
  }

  private static String urlify(String str, int length) {
    return str.substring(0, length).replace(" ", "%20");
  }
}

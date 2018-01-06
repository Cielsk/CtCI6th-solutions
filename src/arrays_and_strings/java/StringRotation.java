package arrays_and_strings.java;

/**
 *
 */
public class StringRotation {
  public static void main(String[] args) {
    String a = "waterbottle";
    String b = "erbottlewat";

    System.out.println(isRotation(a, b) ? "Yes" : "No");
  }

  private static boolean isRotation(String first, String second) {
    return first != null
        && second != null
        && first.length() > 0
        && first.length() == second.length()
        && isSubstring(first + first, second);
  }

  private static boolean isSubstring(String string, String subString) {
    return string != null && subString != null && string.contains(subString);
  }
}

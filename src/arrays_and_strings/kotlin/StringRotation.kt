package arrays_and_strings.kotlin

/**
 *
 */
fun main(args: Array<String>) {
  val a = "waterbottle"
  val b = "erbottlewat"

  print(if (isRotation(a, b)) "Yes" else "No")
}

fun isRotation(first: String, second: String): Boolean {
  return first.isNotEmpty() && first.length == second.length && isSubString(first + first, second)
}

fun isSubString(first: String, second: String): Boolean {
  return first.isNotEmpty() && first.indexOf(second) in first.indices
}
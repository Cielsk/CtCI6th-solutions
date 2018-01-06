package arrays_and_strings.kotlin

/**
 *
 */
fun main(args: Array<String>) {
  val str = readLine().toString()

  print(if (isUnique(str)) "Yes" else "No")
}

fun isUnique(str: String): Boolean {
  for (i in str.indices) {
    val index = str.indexOf(str[i], i + 1)
    if (index in str.indices) return false
  }
  return true
}
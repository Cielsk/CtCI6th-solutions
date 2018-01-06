package arrays_and_strings.kotlin

/**
 *
 */
fun main(args: Array<String>) {
  val str = readLine().toString()
  val len = readLine().toString().toInt()

  print(urlify(str, len))
}

fun urlify(str: String, len: Int): String {
  return str.substring(0, len).replace(" ", "%20")
}
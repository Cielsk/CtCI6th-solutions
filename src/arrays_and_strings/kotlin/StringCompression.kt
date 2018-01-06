package arrays_and_strings.kotlin

/**
 *
 */
fun main(args: Array<String>) {
  val str = readLine().toString()
  print(compress(str))
}

fun compress(str: String): String {
  var count = 0
  val builder = StringBuilder()
  for (i in str.indices) {
    count++
    if (i + 1 >= str.length || str[i] != str[i + 1]) {
      builder.append(str[i])
      builder.append(count.toString())
      count = 0
    }
  }

  return if (builder.length < str.length) builder.toString() else str
}
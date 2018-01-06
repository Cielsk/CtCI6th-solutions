package arrays_and_strings.kotlin

/**
 *
 */
fun main(args: Array<String>) {
  val str = readLine().toString().replace(" ", "")

  print(if (isPalindromePermutation(str)) "Yes" else "No")
}

fun isPalindromePermutation(str: String): Boolean {
  val buf = HashMap<Char, Int>()

  str.forEach {
    buf.computeIfPresent(it, { _, v -> v + 1 })
    buf.putIfAbsent(it, 1)
  }

  var foundOdds = false
  for ((_, v) in buf) {
    if (v % 2 != 0) {
      if (foundOdds) return false else foundOdds = true
    }
  }

  return true
}
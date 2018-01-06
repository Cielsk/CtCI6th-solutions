package arrays_and_strings.kotlin

import kotlin.math.abs

/**
 *
 */
fun main(args: Array<String>) {
  val (a, b) = readLine()!!.split(" ")
  print(if (isOneAway(a, b)) "Yes" else "No")
}

fun isOneAway(first: String, second: String): Boolean {
  if (abs(first.length - second.length) > 1) return false

  val s1 = if (first.length < second.length) first else second
  val s2 = if (first.length < second.length) second else first

  var foundDiff = false
  var j = 0
  var i = 0
  while (i in s1.indices && j in s2.indices) {
    if (s1[i] != s2[j]) {
      if (foundDiff) return false
      foundDiff = true
      if (s1.length != s2.length) i--
    }
    i++
    j++
  }

  return true
}
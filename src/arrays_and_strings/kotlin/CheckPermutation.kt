package arrays_and_strings.kotlin

import java.util.Scanner

/**
 *
 */
fun main(args: Array<String>) {
  val sc = Scanner(System.`in`)
  val a = sc.next()
  val b = sc.next()
  print(if (isPermutation(a, b)) "Yes" else "No")
}

fun isPermutation(a: String, b: String): Boolean {
  val length = a.length
  if (length != b.length) return false
  val buf = HashMap<Char, Int>()
  a.forEach {
    buf.computeIfPresent(it, {_, v -> v + 1})
    buf.putIfAbsent(it, 1)
  }
  b.forEach {
    buf.computeIfPresent(it, {_, v -> v - 1})
    buf.putIfAbsent(it, -1)
  }
  for ((_, v) in buf) {
    if (v != 0) return false
  }

  return true
}
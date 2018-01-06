package arrays_and_strings.kotlin

import java.util.Arrays
import java.util.Random

/**
 *
 */
fun main(args: Array<String>) {
  val n = readLine().toString().toInt()
  val matrix = randomMatrix(n)

  printMatrix(matrix)
  print("\n")

  zeroMatrix(matrix)
  printMatrix(matrix)
}

fun randomMatrix(n: Int): Array<IntArray> {
  val re = Array(n, { IntArray(n) })
  val random = Random()
  for (i in re.indices) {
    for (j in re[i].indices) {
      re[i][j] = random.nextInt(n * n)
    }
  }
  return re
}

fun zeroMatrix(matrix: Array<IntArray>) {
  val row = HashSet<Int>()
  val col = HashSet<Int>()

  for (i in matrix.indices) {
    if (row.contains(i)) continue
    for (j in matrix[i].indices) {
      if (col.contains(j)) continue

      if (matrix[i][j] == 0) {
        row.add(i)
        col.add(j)

        for (k in matrix.indices) {
          matrix[k][j] = 0
        }
        Arrays.fill(matrix[i], 0)
        break
      }
    }
  }
}

fun isMatrix(matrix: Array<IntArray>): Boolean {
  val len = matrix[0].size
  matrix.forEach { if (len != it.size) return false }

  return true
}
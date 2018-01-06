package arrays_and_strings.kotlin

/**
 *
 */
fun main(args: Array<String>) {
  val n = readLine().toString().toInt()

  val matrix = Array(n, { IntArray(n) })

  var count = 0
  for (i in matrix.indices) {
    for (j in matrix[i].indices) {
      matrix[i][j] = count++
    }
  }

  printMatrix(matrix)
  print("\n")
  rotate(matrix)
  printMatrix(matrix)
}

fun rotate(matrix: Array<IntArray>) {
  if (matrix.isEmpty()) throw IllegalArgumentException("Empty matrix")
  if (!isSquare(matrix)) throw IllegalArgumentException("Not square matrix")

  val n = matrix.size
  for (i in 0 until n / 2) {
    for (j in i until n - i - 1) {
      val temp = matrix[i][j]

      matrix[i][j] = matrix[n - j - 1][i]
      matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1]
      matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1]
      matrix[j][n - i - 1] = temp
    }
  }
}

fun printMatrix(matrix: Array<IntArray>) {
  matrix.forEach {
    it.forEach { print(String.format("%5d", it)) }
    print("\n")
  }
}

fun isSquare(matrix: Array<IntArray>): Boolean {
  val len = matrix.size
  matrix.forEach { if (it.size != len) return false }

  return true
}
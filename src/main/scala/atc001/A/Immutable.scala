package atc001.A

import scala.io.StdIn

// TLE
object Immutable extends App {
  type V = (Int, Int)

  val Array(h, w) = StdIn.readLine().split(" ").map(_.toInt)
  val grid = Array.fill(h)(StdIn.readLine())

  def isIn(x: Int, y: Int): Boolean = x >= 0 && x < w && y >= 0 && y < h

  def dfs(stack: List[V], visited: Set[V]): Boolean = stack match {
    case Nil => false
    case (c@(x, y)) :: st =>
      if (grid(y)(x) == 'g') true
      else {
        val next = List((x + 1, y), (x - 1, y), (x, y + 1), (x, y - 1)).filter {
          case n@(nx, ny) => isIn(nx, ny) && grid(ny)(nx) != '#' && !visited(n)
        }
        dfs(next ::: st, visited + c)
      }
  }

  def run(y: Int): Boolean = grid(y).indexOf('s') match {
    case -1 => run(y + 1)
    case x => dfs((x, y) :: Nil, Set.empty)
  }

  println(if (run(0)) "Yes" else "No")
}

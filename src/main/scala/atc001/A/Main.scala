package atc001.A

import java.util
import scala.io.StdIn

object Main extends App {

  println(if (solve()) "Yes" else "No")

  def solve(): Boolean = {
    type V = (Int, Int)

    val Array(h, w) = StdIn.readLine().split(" ").map(_.toInt)
    val grid = Array.fill(h)(StdIn.readLine())

    def isIn(x: Int, y: Int): Boolean = x >= 0 && x < w && y >= 0 && y < h

    def dfs(s: V): Boolean = {
      val stack = new util.ArrayDeque[V](h * w)
      val visited = Array.ofDim[Boolean](h, w)

      def dfs0(): Boolean =
        if (stack.isEmpty) false
        else {
          val (x, y) = stack.pop()
          if (grid(y)(x) == 'g') true
          else {
            visited(y)(x) = true
            for {
              n@(nx, ny) <- Seq((x + 1, y), (x - 1, y), (x, y + 1), (x, y - 1))
              if isIn(nx, ny) && !visited(ny)(nx) && grid(ny)(nx) != '#'
            } {
              stack.push(n)
            }
            dfs0()
          }
        }

      stack.push(s)
      dfs0()
    }

    def find(c: Char, y: Int): V = grid(y).indexOf(c) match {
      case -1 => find(c, y + 1)
      case x  => (x, y)
    }

    dfs(find('s', 0))
  }

}

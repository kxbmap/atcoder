package atc001.A

import scala.io.StdIn

object Main extends App {

  println(if (solve()) "Yes" else "No")

  def solve(): Boolean = {
    val Array(h, w) = StdIn.readLine().split(" ").map(_.toInt)
    val grid = Array.fill(h)(StdIn.readLine().toCharArray)

    def isIn(x: Int, y: Int): Boolean = x >= 0 && x < w && y >= 0 && y < h

    def dfs(s: (Int, Int)): Boolean = {
      val visited = Array.ofDim[Boolean](h, w)

      def dfs0(x: Int, y: Int): Boolean = {
        if (!isIn(x, y) || visited(y)(x)) false
        else {
          grid(y)(x) match {
            case 's' | '.' =>
              visited(y)(x) = true
              val next = List((x + 1, y), (x - 1, y), (x, y + 1), (x, y - 1))
              next.exists {
                case (nx, ny) => dfs0(nx, ny)
              }

            case 'g' => true
            case _   => false
          }
        }
      }
      dfs0(s._1, s._2)
    }

    def find(c: Char, x: Int, y: Int): (Int, Int) =
      if (grid(y)(x) == c) (x, y)
      else if (x < w) find(c, x + 1, y)
      else find(c, 0, y + 1)

    dfs(find('s', 0, 0))
  }

}

package atc001.A

import java.util
import scala.io.StdIn

object Main extends App {

  println(if (solve()) "Yes" else "No")

  def solve(): Boolean = {
    type V = (Int, Int)

    val Array(h, w) = StdIn.readLine().split(" ").map(_.toInt)
    val grid = Array.fill(h)(StdIn.readLine().toCharArray)

    def get(v: V): Char = {
      val (x, y) = v
      if (x >= 0 && x < w && y >= 0 && y < h) grid(y)(x) else '#'
    }

    def dfs(s: V): Boolean = {
      val stack = new util.ArrayDeque[V]()

      def dfs0(): Boolean =
        if (stack.isEmpty) false
        else {
          val (x, y) = stack.pop()
          val next = List((x + 1, y), (x - 1, y), (x, y + 1), (x, y - 1))

          def search(ns: List[V]): Boolean = ns match {
            case Nil     => false
            case v :: vs =>
              get(v) match {
                case 'g' => true
                case '.' => stack.push(v); search(vs)
                case _   => search(vs)
              }
          }

          if (search(next)) true
          else {
            grid(y)(x) = 'V'
            dfs0()
          }
        }

      stack.push(s)
      dfs0()
    }

    def find(c: Char, x: Int, y: Int): V =
      if (grid(y)(x) == c) (x, y)
      else if (x < w) find(c, x + 1, y)
      else find(c, 0, y + 1)

    dfs(find('s', 0, 0))
  }

}

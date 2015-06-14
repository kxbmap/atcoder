package atc001.A

import java.io.StringReader
import org.scalatest.FunSpec

/**
 *
 */
class MainSpec extends FunSpec {

  def solve(input: String): Boolean =
    Console.withIn(new StringReader(input)) {
      Main.solve()
    }

  describe("solve") {
    it("solve example 1") {
      val input =
        """4 5
          |s####
          |....#
          |#####
          |#...g""".stripMargin

      assert(!solve(input))
    }

    it("solve example 2") {
      val input =
        """4 4
          |...s
          |....
          |....
          |.g..""".stripMargin

      assert(solve(input))
    }

    it("solve example 3") {
      val input =
        """10 10
          |s.........
          |#########.
          |#.......#.
          |#..####.#.
          |##....#.#.
          |#####.#.#.
          |g.#.#.#.#.
          |#.#.#.#.#.
          |###.#.#.#.
          |#.....#...""".stripMargin

      assert(!solve(input))
    }

    it("solve example 4") {
      val input =
        """10 10
          |s.........
          |#########.
          |#.......#.
          |#..####.#.
          |##....#.#.
          |#####.#.#.
          |g.#.#.#.#.
          |#.#.#.#.#.
          |#.#.#.#.#.
          |#.....#...""".stripMargin

      assert(solve(input))
    }

    it("solve example 5") {
      val input =
        """1 10
          |s..####..g""".stripMargin

      assert(!solve(input))
    }
  }

}

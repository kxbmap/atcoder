package atc001.A

import util.UnitSpec

class MainSpec extends UnitSpec {

  describe("solve") {
    it("solve example 1") {
      val input =
        """4 5
          |s####
          |....#
          |#####
          |#...g""".stripMargin

      assertStdOut(Main, input)("No\n")
    }

    it("solve example 2") {
      val input =
        """4 4
          |...s
          |....
          |....
          |.g..""".stripMargin

      assertStdOut(Main, input)("Yes\n")
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

      assertStdOut(Main, input)("No\n")
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

      assertStdOut(Main, input)("Yes\n")
    }

    it("solve example 5") {
      val input =
        """1 10
          |s..####..g""".stripMargin

      assertStdOut(Main, input)("No\n")
    }
  }

}

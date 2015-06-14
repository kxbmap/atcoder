package atc001.A

import util.UnitSpec

class ATC001ASpec extends UnitSpec {

  describe("Main (stack/mutable)") {
    it should behave like solver(Main)
  }

  describe("Immutable (stack/immutable)") {
    it should behave like solver(Immutable)
  }

  def solver(app: App): Unit = {
    it("should solve example 1") {
      val input =
        """4 5
          |s####
          |....#
          |#####
          |#...g""".stripMargin

      assertStdOut(app, input)("No\n")
    }

    it("should solve example 2") {
      val input =
        """4 4
          |...s
          |....
          |....
          |.g..""".stripMargin

      assertStdOut(app, input)("Yes\n")
    }

    it("should solve example 3") {
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

      assertStdOut(app, input)("No\n")
    }

    it("should solve example 4") {
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

      assertStdOut(app, input)("Yes\n")
    }

    it("should solve example 5") {
      val input =
        """1 10
          |s..####..g""".stripMargin

      assertStdOut(app, input)("No\n")
    }
  }

}

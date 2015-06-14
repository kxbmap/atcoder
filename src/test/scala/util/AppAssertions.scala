package util

import java.io.{ByteArrayOutputStream, StringReader}
import org.scalatest.Assertions

trait AppAssertions {
  this: Assertions =>

  def assertStdOut(app: App, input: String)(expected: String): Unit =
    assertResult(expected) {
      val out = new ByteArrayOutputStream()
      Console.withOut(out) {
        Console.withIn(new StringReader(input)) {
          app.main(Array())
        }
      }
      out.toString
    }
}

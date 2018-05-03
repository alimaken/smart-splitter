import scala.annotation.tailrec

object Splitter extends App {

  @tailrec
  final def gradualTake(xs: List[String], xss: List[String], x: Int, l: Int) : Int = {
    if (x > xs.size || xss.mkString("").length > l) x
    else gradualTake(xs, xs take (x+1), x + 1, l)
  }

  def smartSplit (input: List[String], l: Int): List[(List[String], Int, Int)] = {
    def splitLists(xs: List[String], n: Int, l: Int): List[List[String]] = {
      val x = gradualTake(xs, xs take n, n, l)
      if (xs.size <= x) xs :: Nil
      else (xs take x) :: splitLists(xs drop x, 1, l)
    }
    val result = splitLists(input, 1, l)
    val resultLength = result.length
      result.zipWithIndex.map(x => (x._1, x._2 + 1, resultLength))
  }

  println(smartSplit(List("0123456789", "ABCDEF"), 5))

}



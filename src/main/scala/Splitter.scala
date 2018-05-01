import scala.annotation.tailrec

object Splitter extends App {

  @tailrec
  final def gradualTake(xs: List[String], xss: List[String], x: Int, l: Int) : Int = {
    if (x > xs.size || xss.mkString("").length > l) x
    else gradualTake(xs, xs take (x+1), x + 1, l)
  }

  def smartSplit (input: List[String], l: Int): List[List[String]] = {
    def splitLists(xs: List[String], n: Int, l: Int): List[List[String]] = {
      val x = gradualTake(xs, xs take n, n, l)
      if (xs.size <= x) xs :: Nil
      else (xs take x) :: splitLists(xs drop x, 1, l)
    }
    splitLists(input, 1, l)
  }

}



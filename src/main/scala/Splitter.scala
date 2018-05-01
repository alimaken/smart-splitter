object Splitter extends App {
//  println("Ooh la la !!")


  private def getListElementsLength(input : List[String]) : Int = {
    /*val length = */input.mkString("").length
//    println(s"length is $length")
//    length
  }
  //private val splitLength: Int = 34 //50
//  getListElementsLength(List("hey", "there"))
//  private val inputList = List(
//    "AAAAAAAA-000b-1f2-a102-e162012",
//    "BBBBBBBB-0a00-1f2-a102-e16",
//    "CCCCCCCC-002b-1f2-a102-e16201230021",
//    "DDDDDDDD-100b-1f2-a102-e162012311",
//    "EEEEEEEE-1a00-1f2",
//    "FFFFFFFF-1020-1f2-a102-e162012311440012345")
//  getListElementsLength(inputList)

  def smartSplit (input: List[String], l: Int): List[List[String]] = {
    //@tailrec
    def split(xs: List[String], n: Int, l: Int): List[List[String]] = {
      var x = n
      var xss = xs take x
//      println(s"xs.size before is ${xs.size}")
//      println(s"xs before is ${xs.mkString("|")}")
//      println(s"xss.size before is ${xss.size}")
//      println(s"xss before is ${xss.mkString("|")}")
//      println(s"x before is $x")

      while(x <= xs.size && getListElementsLength(xss) <= l ) {
        x = x + 1
        xss = xs take x
//        println(s"x during is $x")
//        println(s"xss.size during is ${xss.size}")
//        println(s"xss during is ${xss.mkString("|")}")
      }
//      println(s"x after is $x")
//      println(s"xss.size after is ${xss.size}")
//      println(s"xss after is ${xss.mkString("|")}")
      if (xs.size <= x) xs :: Nil
      else (xs take x) :: split(xs drop x, 1, l)
    }

    split(input, 1, l)
  }

  //println(smartSplit(inputList, splitLength))
//  println(smartSplit(List("012345", "ABCDEF"), 20))



}



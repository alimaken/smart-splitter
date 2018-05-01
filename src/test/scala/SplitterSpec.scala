import org.scalatest.FunSuite

class SplitterSpec extends FunSuite {

  test("Splits an empty input") {
//    val result = Splitter.smartSplit(List.empty[String], 50)
//    println(s"result is $result")
//    assert( result == List(List.empty[String]))
    assert( Splitter.smartSplit(List.empty[String], 50) == List(List.empty[String]))
  }

  test("Splits input with single element") {
    assert( Splitter.smartSplit(List("012345"), 20) == List(List("012345")))
  }

  test("Splits input with single element with threshold less than total length") {
    assert( Splitter.smartSplit(List("0123456789"), 5) == List(List("0123456789")))
  }

  test("Splits input with single element with threshold 0") {
    assert( Splitter.smartSplit(List("0123456789"), 0) == List(List("0123456789")))
  }

  test("Splits input with multiple elements") {
    assert( Splitter.smartSplit(List("012345", "ABCDEF"), 20) == List(List("012345", "ABCDEF")))
  }

  test("Splits input with multiple elements with threshold less than total length") {
    assert( Splitter.smartSplit(List("0123456789", "ABCDEF"), 5) == List(List("0123456789"), List("ABCDEF")))
  }

  test("Splits input with multiple elements with threshold less than total length # 2") {
    assert( Splitter.smartSplit(List("0123456789", "ABCDEF"), 12) == List(List("0123456789","ABCDEF")))
  }

  test("Splits input with multiple elements with threshold 0") {
    assert( Splitter.smartSplit(List("0123456789", "ABCDEF"), 0) == List(List("0123456789"), List("ABCDEF")))
  }

  test("Split input with random sized elements") {
    assert( Splitter.smartSplit(List(
        "AAAAAAAA-000b-1f2-a102-e162012",
        "BBBBBBBB-0a00-1f2-a102-e16",
        "CCCCCCCC-002b-1f2-a102-e16201230021",
        "DDDDDDDD-100b-1f2-a102-e162012311",
        "EEEEEEEE-1a00-1f2",
        "FFFFFFFF-1020-1f2-a102-e162012311440012345"), 34) ==
      List(
        List(
          "AAAAAAAA-000b-1f2-a102-e162012",
          "BBBBBBBB-0a00-1f2-a102-e16",
          "CCCCCCCC-002b-1f2-a102-e16201230021"),
        List(
          "DDDDDDDD-100b-1f2-a102-e162012311",
          "EEEEEEEE-1a00-1f2",
          "FFFFFFFF-1020-1f2-a102-e162012311440012345"))
    )
  }


}

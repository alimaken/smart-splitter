import org.scalatest.FunSuite

class SplitterSpec extends FunSuite {

  test("Splits an empty input") {
    assert( Splitter.smartSplit(List.empty[String], 50) == List((List.empty[String],1,1)))
  }

  test("Splits input with single element") {
    assert( Splitter.smartSplit(List("012345"), 20) == List((List("012345"),1,1)))
  }

  test("Splits input with single element with threshold less than total length") {
    assert( Splitter.smartSplit(List("0123456789"), 5) == List((List("0123456789"),1,1)))
  }

  test("Splits input with single element with threshold 0") {
    assert( Splitter.smartSplit(List("0123456789"), 0) == List((List("0123456789"),1,1)))
  }

  test("Splits input with multiple elements") {
    assert( Splitter.smartSplit(List("012345", "ABCDEF"), 20) == List((List("012345", "ABCDEF"),1,1)))
  }

  test("Splits input with multiple elements with threshold less than total length") {
    assert( Splitter.smartSplit(List("0123456789", "ABCDEF"), 5) == List((List("0123456789"),1,2), (List("ABCDEF"),2,2)))
  }

  test("Splits input with multiple elements with threshold less than total length # 2") {
    assert( Splitter.smartSplit(List("0123456789", "ABCDEF"), 12) == List((List("0123456789","ABCDEF"),1,1)))
  }

  test("Splits input with multiple elements with threshold 0") {
    assert( Splitter.smartSplit(List("0123456789", "ABCDEF"), 0) == List((List("0123456789"),1,2), (List("ABCDEF"),2,2)))
  }

  test("Split input with random sized elements") {
    assert( Splitter.smartSplit(List(
      "AAAAAAAA-000b-1f2-a102-e162012",
      "BBBBBBBB-0a00-1f2-a102-e16",
      "CCCCCCCC-002b-1f2-a102-e16201230021",
      "DDDDDDDD-100b-1f2-a102-e162012311",
      "EEEEEEEE-1a00-1f2",
      "FFFFFFFF-1020-1f2-a102-e162012311440012345", "xoxo"), 30) ==
      List(
        (List(
          "AAAAAAAA-000b-1f2-a102-e162012",
          "BBBBBBBB-0a00-1f2-a102-e16"),1,5),
        (List("CCCCCCCC-002b-1f2-a102-e16201230021"),2,5),
        (List(
          "DDDDDDDD-100b-1f2-a102-e162012311"),3,5),
        (List("EEEEEEEE-1a00-1f2",
          "FFFFFFFF-1020-1f2-a102-e162012311440012345"),4,5),
        (List("xoxo"),5,5))
    )
  }


}

package com.knoldus
import org.scalatest.funsuite.AnyFunSuite
class ExtractorsSpec extends AnyFunSuite{
  test(" Test for Extract the  protocol, domain and path from a valid URL") {
    val testInput = "https://www.mywebsite.com/home"
    val expectedOutput = Some("https", "www.mywebsite.com", "home")
    assert(SeperateURL.unapply(SeperateURL(testInput))=== expectedOutput)
  }

  test ("Test for Invalid Url"){
    val testInput = "abc"
    val expectedOutput = None
    assert(SeperateURL.unapply(SeperateURL(testInput))=== expectedOutput)
  }
}

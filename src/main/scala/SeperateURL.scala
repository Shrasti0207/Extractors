package com.knoldus
import scala.util.Try
// Defining the SeperateURL class that takes a string URL as a parameter
class SeperateURL(val url: String)
//companion object
object SeperateURL {
  // apply() method for creating a new SeperateURL object
  def apply(url: String) = new SeperateURL(url)
  // unapply() method for pattern matching on SeperateURL objects
  def unapply(inputString: SeperateURL): Option[(String, String, String)] = {
    val url1=inputString.url
    Try {
      val protocolEnd = url1.indexOf(":")
      val domainEnd = url1.indexOf("/", protocolEnd + 3)
      val protocol = inputString.url.substring(0, protocolEnd)
      val domain = inputString.url.substring(protocolEnd + 3, domainEnd)
      val path = inputString.url.substring(domainEnd + 1)
      (protocol, domain, path)
    }.toOption
  }
}


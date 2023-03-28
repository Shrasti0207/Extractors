package com.knoldus
import scala.util.Try
// Defining the SeperateURL class that takes a string URL as a parameter
class SeperateURL(val url: String)
//companion object
object SeperateURL {
  // apply() method for creating a new SeperateURL object
  def apply(url: String) = new SeperateURL(url)
  // unapply() method for pattern matching on SeperateURL objects
  def unapply(inputUrl: SeperateURL): Option[(String, String, String)] = {
    val ExtractUrl = inputUrl.url
    Try {
      val protocolEnd = ExtractUrl.indexOf(":")
      val domainEnd = ExtractUrl.indexOf("/", protocolEnd + 3)
      val protocol = ExtractUrl.substring(0, protocolEnd)
      val domain = ExtractUrl.substring(protocolEnd + 3, domainEnd)
      val path = ExtractUrl.substring(domainEnd + 1)
      (protocol, domain, path)
    }.toOption
  }
}


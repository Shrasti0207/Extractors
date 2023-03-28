package com.knoldus

object Extractors extends App{
  // Creating a new SeperateURL object
  val result = new SeperateURL("https://www.mywebsite.com/home")
  result match {
    case SeperateURL(protocol, domain, path)=> s"Protocol: $protocol Domain: $domain Path: $path"
    case _ => "This is a invalid Url"
  }
}


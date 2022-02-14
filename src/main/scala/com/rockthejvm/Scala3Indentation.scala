package com.rockthejvm

object Scala3Indentation {


  //if-expressions
  val aCondition = if(2>3) "Bigger" else "smaller"

  // java-style
  val aCondition2 =
      if(2>3){
          "bigger"
      } else{
          "smaller"
      }

  val aCondition3 =
        if(2>3) "bigger"
        else "smaller"

  val aCondition4 =
    if 2 > 3 then
      "Bigger"
    else
      "Smaller"

  //Scala 3 one-liner
  val aCondition5 = if 2>3 then "Bigger" else "smaller"

  // Scala 3 compact
  val aCondition6 =
      if 2>3 then "bigger"
      else "smaller"

  for {
      n <- List(1,2,3)
      c <- List("a","b","c")
  } yield s"$c$n"

  // This feels stupid
  for
      n<- List(1,2,3)
      c<- List("a","b","c")
  yield s"$c$n"

  //methods without braces
  // Wow this also feels stupid (should use braces)
  def computeMeaningOfLive(year: Int): Int =
      println("Computing")




      42

  class Animal: // start an indentation region
    def eat(): Unit = ???

  // Same for classes, traits, objects or enums

  import scala.concurrent.ExecutionContext.Implicits.global
  import scala.concurrent.Future
  
  val aFuture = Future{ // can use : and indents instead of {}
    println("hello future")
    42
  }
      

  val aProcessedList = List(1,2,3).map{ // can use : and indents instead of {}
    x =>
    x + 1
  }
    
  def main(args: Array[String]): Unit = {
        println(computeMeaningOfLive(2022)) //Will print 42
    }
}

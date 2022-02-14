package com.rockthejvm

object Scala3GivensVSImplicits {

  // implicit conversions
  case class Person(name: String){
      def greet: String = s"Hey, my name is $name, Scala rocks!"
  }

  // Discouraged from Scala 2
  // implicit def stringToPerson(string: String): Person = Person(string)
  // "Alice".greet

  // Will be used less
  // 1 - conversions are no longer required for major FP patterns
  // 2 - conversions need to be explicitly declared
  // 3 - import the conversion package
  given stringToPerson: Conversion[String, Person] with {
      def apply(string: String): Person = Person(string)
  }

  import scala.language.implicitConversions
  "Alice".greet

  // syntax ambiguities
  //implicit val meaningOfLife: Int = 42

  //def getMap(implicit size: Int): Map[String, Int] = ???

  //getMap("Alice") //error

  given mol: Int = 42
  def getMap2(using size:Int): Map[String,Int] = ???

  getMap2(using 43)("Alice")
  getMap2("Alice")

  // track-down
  // 1 - explicitly import
  // 2 - implicitly parameters only

  // auto-importing: same problem

  // subtle: intent behind implicit
  // given/using pairs for "implicit args" and for "type existence"
  // extension methods are standalone
  // implicit conversions are now explicit

}

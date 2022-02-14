package com.rockthejvm

object ContextualAbstractions{

    //Changing to Scala 3 needs to upgrade build.sbt and project/build.properties

    // 1 - Context parameters/arguments
    val aList = List(2,1,3,4)
    val anOrderedList = aList.sorted // contextual argument: (descendingOrdering)

    //Ordering
    given descendingOrdering: Ordering[Int] = Ordering.fromLessThan(_ > _) //(a,b ==> a > b)

    // Analogous to an implicit val 

    trait Combinator[A]{ //known as a monoid
        def combine(x: A, y:A):A
    }

    def combineAll[A](list: List[A])(using combinator: Combinator[A]): A = 
        list.reduce(combinator.combine) //list.reduce((a,b)=>combinator.combine(a,b)))

    given intCombinator: Combinator[Int] = new Combinator[Int]{
        override def combine(x: Int, y:Int) = x+y
    }
    val theSum = combineAll(aList) // (intCombinator)

    /*
    Given places:
        - local scope
        - imported scope  (aka import yourPackage.given)
        - the companions of all the types involved in the cell
            - companion of List
            - the companion of Int
    */

    // Context bounds
    def combineAll_v2[A](list: List[A])(using Combinator[A]): A = ???
    def combineAll_v3[A : Combinator /* A must have an instance of combinator*/ ](list: List[A]): A = ??? 

    /*
    Where contexts are useful:
        - type classes
        - dependency injections
        - context-dependent functionality
        - type-level programming
    */

    // 2 - Extensions methods

    case class Person(name:String){
        def greet(): String = s"Hi, my name is $name"
    }

    extension (string: String)
        def greet(): String = new Person(string).greet()

    val danielsGreeting = "Daniel".greet() // "type enrichment" = old term "pimping"

    // POWER
    extension [A] (list: List[A])
        def combineAllValues(using combinator: Combinator[A]): A =
            list.reduce(combinator.combine)

    val theSum_v2 = aList.combineAllValues

    def main(args: Array[String]): Unit = {
        println(anOrderedList)
        println(theSum)
        println(theSum_v2)
    }
  
}

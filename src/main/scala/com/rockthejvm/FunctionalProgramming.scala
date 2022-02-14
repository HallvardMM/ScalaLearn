package com.rockthejvm

object FunctionalProgramming extends App{
  
    //Scala is OO 
    class Person(name:String){
        def apply(age: Int) = println(s"I have aged $age years")
    }

    val bob = new Person("Bob")
    bob.apply(43)
    bob(43) // INVOKING bob as a function === bob.apply(43)

    /*
    Scala runs on the JVM
    Functional programming: 
        - Compose functions
        - Pass functions as arguments
        - return functions as results
    
    Conclusion: FunctionX = Function1, Function2, ... Function22
    */

    val simpleIncrementor = new Function1[Int, Int]{
        override def apply(v1: Int): Int = v1 + 1
    }
    simpleIncrementor.apply(23) //24
    simpleIncrementor(23) //Same as calling apply
    // Defined a function!

    // All Scala functions are instances of these FunctionX types

    val stringConcater = new Function2[String, String, String]{
        override def apply(v1: String, v2: String): String = v1+v2
    }

    stringConcater("I Love ", "Scala")

    //Syntax sugar
    val doubler: Int => Int = (x:Int) => 2*x //Can also remove ": Int => Int"-part
    doubler(4)

    /*
     val doubler Function1[Int, int] = new Function1[Int, Int]{
         override def apply(v1: Int): Int = 2*v1
     }
    */

    //Higher-order functions: take functions as args/return functions as results
    val aMappedList = List(1,2,3).map(x=> x+1) // HOF
    val aFlatMappedList = List(1,2,3).flatMap(x => List(x,2*x))
    val alternativeFlatMappedList = List(1,2,3).flatMap{x =>
        List(x,2*x)
    } //Alternative syntax
    println(aFlatMappedList) //List(1, 2, 2, 4, 3, 6)
    val aFilteredList = List(1,2,3,4,5).filter(x=> x <= 3) //1,2,3
    val aShorterFilteredList = List(1,2,3,4,5).filter(_ <= 3) //Same as x=> x <= 3

    // All pairs between 1,2,3 and the letters "a","b","c"
    val allPairs = List(1,2,3).flatMap(number => List('a','b','c').map(letter => s"$number-$letter"))
    println(allPairs) //List(1-a, 1-b, 1-c, 2-a, 2-b, 2-c, 3-a, 3-b, 3-c)

    //For comprehensions
    val alternativePairs = for {
        number <- List(1,2,3)
        letter <- List('a','b','c')
    } yield s"$number-$letter"
    //Same as the map/flatMap chain above

    //Collections

    //Lists
    val aList = List(1,2,3,4,5)
    val head = aList.head // 1
    val rest = aList.tail // List(2, 3, 4, 5)
    val aPrependedList = 0 :: aList // List(0,1,2, 3, 4, 5)
    val anExtendedList = 0 +: aList :+ 6 //List(0,1,2, 3, 4, 5,6)

    // Sequences
    val aSequence: Seq[Int] = Seq(1,2,3) //Seq.apply(1,2,3)
    val accessedElement = aSequence(1) // same as aSequence[1] in Python gives 2

    // Vectors: fast Seq implementation
    val aVector = Vector(1,2,3,4,5)

    //sets = no duplicates
    val aSet = Set(1,2,3,4,1,2,3) // Set(1,2,3,4)
    val aSetHas5 = aSet.contains(5) //false
    val anAddedSet = aSet + 5 // Set(1,2,3,4,5)
    val aRemovedSet = aSet - 3 // Set(1,2,4)

    //Ranges
    val aRange = 1 to 100
    val twoByTwo = aRange.map(x=> 2*x).toList // List(2,4,6,8,...,2000)

    //Tuples = groups of values under the same value
    val aTuple = ("Bon Jovi", "Rock", 1982)

    //Maps
    val aPhonebook: Map[String,Int] = Map(
        ("Daniel", 17243903),
        "Jane"-> 12398123  // Same as ("Jane",12398123)
    )




}

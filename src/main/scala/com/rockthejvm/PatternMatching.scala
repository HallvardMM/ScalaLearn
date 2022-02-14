package com.rockthejvm

object PatternMatching extends App {
  
    //Switch expression
    val anInteger = 55
    val order = anInteger match {
        case 1 => "first"
        case 2 => "second"
        case 3 => "third"
        case _ => anInteger+"th"
    }
    //PM is an expression
    println(order) //55th

    case class Person(name:String, age:Int)

    val bob = Person("Bob",43) //Person.apply("Bob",43)

    val personGreeting = bob match {
        case Person(n,a) => s"Hi, my name is $n and I am $a years old"
        case _ => "Something else"
    }
    println(personGreeting) //Hi, my name is Bob and I am 43 years old

    // Deconstructing tuples
    val aTuple = ("Bon Jovi", "Rock")
    val bandDescription = aTuple match{
        case (band,genre) => s"$band belongs to $genre"
        case _ => "I do not know what you are talking about"
    }

    // decomposing list
    val aList = List(1,2,3)
    val listDescription = aList match{
        case List(_,2,_) => "List contains 2 on its second position"
        case _ => "unknown list"
    }

    // If PM doesn't match anything, it will throw an error
    // PM will try all the cases in sequence 
}

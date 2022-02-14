package com.rockthejvm

import scala.util.Try
import scala.util.Success
import scala.util.Failure
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object Advanced extends App{

    // lazy evaluation
    lazy val aLazyValue = 2
    lazy val lazyValWithSideEffect = {
        println("I am so very lazy!")
        43
    }
    
    val eagerValue = lazyValWithSideEffect + 1

    // Lazy value is useful in infinite collections 

    //"Pseudo-collections": Option, Try
    def methodWhichCanReturnNull(): String = "hello, Scala"
    val anOption = Option(methodWhichCanReturnNull()) // Some("hello","Scala")
    // option = "collections which contains at most one element": Some(Value) or None

    val stringProcessing = anOption match {
        case Some(string) => s"I have obtained a valid string: $string"
        case None => "I obtained nothing"
    }
    // map, flatmap, filter 

    def methodWhichCanThrowException(): String = throw new RuntimeException
    val aTry = Try(methodWhichCanThrowException())
    // a try = "collection" with value if the code went well, or an exception if the code threw one

    val anotherStringProcess = aTry match {
        case Success(value) => s"I have obtained a string: $value"
        case Failure(exception) => s"I have obtained an error: $exception"
    }
    // map, flatmap, filter 

    //Evaluate something on another thread (asynchronous programming)
    val aFuture = Future { // Future.apply
        println("Loading...")
        Thread.sleep(1000)
        println("I have computed a value")
        67
    }

    // Future is a "collection" that contains a value when it's evaluated
    // Future is composable with map, flatMap and filter
    
    //Implicits basics
    // #1: Implicit arguments
    def aMethodWithImplicitArgs(implicit arg: Int) = arg + 1
    //implicit val myImplicitInt: Int = 46 NOT ALLOWED IN SCALA 3
    //println(aMethodWithImplicitArgs) // aMethodWithImplicitArgs(myImplicitInt) //Returns 47

    // #2: Implicit conversions
    implicit class MyRichInteger(n: Int){
        def isEven() = n % 2 == 0
    }
    println(23.isEven()) // new MyRichInteger(23).isEven()
    // use this carefully 
}

package com.rockthejvm

class Basics extends App{
  
    //Defining a value
    val meaningOfLife: Int = 42 // Const int meaningOfLife = 42
    
    //Int, Boolean, Char, Double, Float, String
    val aBoolean = false //type is optional

    val aString = "I Love Scala"
    val aComposedString = "I" + " " + "Love" + "Scala"
    val anInterpolatedString = s"The meaning of life is $meaningOfLife"

    //Expressions = structures that can be reduced to a value
    val anExpression = 2+3

    //if-Expression
    val ifExpression = if (meaningOfLife>43) 56 else 999 // In other languages: meaningOfLife > 43 ? 56 : 999
    val chainedIfExpression =
        if (meaningOfLife>53) 56
        else if (meaningOfLife < 0) -2
        else if (meaningOfLife >999) 78
        else 0

    //code block
    val aCodeBlock = {
        //definitions
        val aLocalValue = 67

        // Value of block is the last value of block
        aLocalValue + 3
    }

    //define a function
    def myFunction(x: Int, y: String): String = {
        y + " " + x
    }

    //recursion function
    def factorial(n: Int): Int = 
        if (n<=1) 1
        else n * factorial(n-1)

    // In Scala we don't use loops or iteration we use recursion

    // the Unit type = no meaningful value === "Void" in other languages 
    // type of SIDE EFFECTS
    println("I Love Scala") // same as print() in Python

    def myUnitReturningFunction(): Unit = {
        println("I don't love returning unit")
    }

    val theUnit = ()
}

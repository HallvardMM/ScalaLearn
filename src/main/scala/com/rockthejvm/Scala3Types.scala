package com.rockthejvm

import java.io.File

object Scala3Types {
  
    // 1 - literal types
    val aNumber = 3
    val three: 3 = 3 // Subetype 3 is a subtype of Int

    def passNumber(n: Int) = println(n)
    passNumber(45)
    passNumber(three) //Ok since 3 is a subtype of int

    def passStrict(n:3) = println(n)
    passStrict(three) // Ok
    // passStrict(45) not allowed since Int type and not 3 
    
    val pi: 3.14 = 3.14
    val truth: true = true
    val myFavoriteLanguage: "Scala" = "Scala"

    def doSomethingWithYourLife(meaning: Option[42]) = meaning.foreach(println)

    // 2 - Union types
    def ambivalentMethod(arg: String | Int) = arg match{
        case _: String => println(s"the string: $arg")
        case _: Int => println(s"an int: $arg")
    }

    ambivalentMethod(42)
    ambivalentMethod("Scala")

    type ErrorOr[T] = T | "error"
    def handleResources(file: ErrorOr[File]): Unit ={
        // Your code
        ()
    }

    val stringOrInt = if(43 > 0) "a string" else 43
    val aStringOrInt: String | Int = if(43>0) "a string" else 43

    // 3 - Intersection types
    trait Camera{
        def takePhoto() = println("Snap")
    }
    trait Phone{
        def makeCall() = println("Ring ring")
    }

    def useSmartDevice(sp: Camera & Phone) = {
        sp.takePhoto()
        sp.makeCall()
    }

    class SmartPhone extends Camera with Phone
    useSmartDevice(new SmartPhone) // OK

    trait PortConfig
    trait PortController{
        def get: Option[PortConfig]
    }
    trait HostConfig 
    trait HostController{
        def get: Option[HostConfig]
    }

    def getConfigs(controller: HostController & PortController): Option[HostConfig] & Option[PortConfig] /*Same as Option[HostConfig & PortConfig]*/= controller.get

}

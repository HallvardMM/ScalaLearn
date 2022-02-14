package com.rockthejvm

object ObjectOrientation extends App {
    // extends App equvielent to: public static void main(String[] args)

    //class and instance
    class Animal{
        //define fields
        val age: Int = 0
        // define methods
        def eat() = println("I am eating!")
    }
    val anAnimal = new Animal

    //inheritance
    class Dog(val name: String) extends Animal 
    val aDog = new Dog("Lassie")

    //aDog.name is not a member of the class without val before the constructor argument

    //subtype polymorphism
    val aDeclaredAnimal: Animal = new Dog("Bob")
    aDeclaredAnimal.eat() // the most derived method will be called at runtime aka. Dog.eat()

    // abstract class
    abstract class WalkingAnimal{
        val hasLegs = true // by default public, can restrict 
        private val aPrivateVal = 42
        protected val aProtectedVal = 41 
        def walk(): Unit
    }
    
    // "interface" = ultimate abstract type
    trait Carnivore{
        def eat(animal: Animal): Unit
    }

    trait Philosopher{
        def ?!(thought: String): Unit //Valid method name!
    }

    class Crocodile extends Animal with Carnivore with Philosopher{
        //Can extend 1 class and many traits also know as "mixing"
        override def eat(anAnimal: Animal) = println(s"Crocodile is eating $anAnimal")
        override def ?!(thought: String): Unit = println(s"I was thinking about $thought!")
    }

    val aCrocodile = new Crocodile
    aCrocodile.eat(aDog)
    aCrocodile eat aDog // infix notation = object method argument, only available for methods with ONE argument
    aCrocodile ?! "What if we could fly?"

    // operators in Scala are actually methods 
    val basicMath = 1+2
    val anotherBasicMath = 1.+(2) //equivalent

    // anonymous classes
    val dinosaur = new Carnivore {
        override def eat(animal: Animal): Unit = println("I can eat anything")
    }

    /* Same as

    Class Carnivore_Anonymous_3578 extends Carnivore {
        override def eat(animal: Animal): Unit = println("I can eat anything")
    }
    val dinosaur = new Carnivore_Anonymous_3578

    */

    //singleton object
    object MySingleton{
        val myValue = 23
        def myMethod():Int = 32
        def apply(x: Int): Int = x+1
    }
    MySingleton.myMethod()
    MySingleton.apply(68)
    MySingleton(68)

    object Animal{ //class and objects are called companions
        // companions has the additional property that they can access each other's private fields/methods
        // singleton Animal and instances of Animal are different things
        val animalsCanLiveForever = false
    }

    val animalsCanLiveForever = Animal.animalsCanLiveForever //Like "static" fields/methods

    /*
    Case classes = lightweight data structures with some boilerplate
    - sensible equals and hash code
    - serialization
    - companion with apply
    */
    case class  Person(name: String, age: Int)

    //May be constructed without new
    val bob = Person("Bob", 54) //Person.apply("Bob",54)

    //Exceptions
    try{
        //Code that can throw
        val x: String = null
        x.length
    } catch{
        case e: Exception => "Some faulty error messages"
    } finally {
        // Execute some code no matter what
    }

    // Generics
    abstract class MyList[T]{
        def head: T
        def tail: MyList[T]
    }

    // Using a generic with a concrete type
    val aList: List[Int] = List(1,2,3) // List.apply(1,2,3)
    val first = aList.head //Int
    val rest = aList.tail
    val aStringList: List[String] = List("hello", "world")
    val firstString = aStringList.head // String

    // Point #1: Scala operates with immutable values/objects
    // Any modification on an object should return a new object
    // Benefit number 1) Works really good in multithreaded/distributed env
    // Benefit number 2) helps make sense of the code ("Reasoning about")
    
    val reversedList = aList.reverse // returns a NEW list

    // Point #2: Scala is closest to the Object oriented ideal 
}

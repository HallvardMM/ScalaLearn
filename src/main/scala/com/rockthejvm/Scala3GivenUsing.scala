package com.rockthejvm
//Census
case class Person(surname: String, name: String, age:Int)

object Scala3GivenUsing{
  


    // use everywhere
    val personOrdering: Ordering[Person] = new Ordering[Person]{
        override def compare(x: Person, y:Person): Int =
            x.surname.compareTo(y.surname)
    }

    def listPeople(persons: Seq[Person])(ordering: Ordering[Person]): Seq[Person] = ???
    def someOtherMethodRequiringOrdering(alice: Person, bob: Person)(ordering: Ordering[Person]): Int = ???

    // find the "standard" value
    // explicitly call methods

    // given/using
    /*given standardPersonOrdering: Ordering[Person] with {
        override def compare(x: Person, y:Person): Int =
            x.surname.compareTo(y.surname)
    }*/

    def someOtherMethodRequiringStandardOrdering(persons: List[Person])(using ordering: Ordering[Person]): List[Person] = ???

    //import givens
    // Option 1 - import explicitly
    import StandardValues.standardPersonOrdering

    // 2 - import given for a TYPE (the only one)
    // import StandardValues.{given Ordering[Person]}

    // 3 - import all the givens
    //import StandardValues.{given, *}
    //import StandardValues._ // Does NOT import the givens

    someOtherMethodRequiringStandardOrdering(List(Person("Peterson","Ron",14),Person("Peterson","Hans",14)))

    //Why? much cleaner code

    // deriving givens
    // working with options

    
}

object StandardValues {
    given standardPersonOrdering: Ordering[Person] with {
        override def compare(x: Person, y:Person): Int =
            x.surname.compareTo(y.surname)
    }
}

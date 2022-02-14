package com.rockthejvm

import scala.annotation.transparentTrait

object Scala3Traits {

    trait Talker(subject: String){ //Constructor was not allowed in Scala 2. 
        //Very much like abstract
        def talkTo(another: Talker): String = ""
    }

    class Person(name: String) extends Talker("Rock music"){
        override def talkTo(another: Talker) = ""
    }

    class RockFan extends Talker("Rock music")
    class RockFanatic extends RockFan with Talker // No constructor argument in the 2nd mixer aka Talker("Heavy Metal")

    // Derived traits will NOT pass constructor arguments to parent traits
    trait BrokenRecord extends Talker

    class AnnoyingFriend extends BrokenRecord with Talker("Politics") // Can't pass it to BrokenRecord

    // transparent traits
    transparent trait Paintable // Using "transparent" will make color just Color type
    trait Color
    case object Red extends Color with Paintable
    case object Green extends Color with Paintable
    case object Blue extends Color with Paintable

    val color = if(43>2) Red else Blue 

    /*
        All of this are transparent
        scala.Product
        java.lang.Comparable
        java.lang.Serializable
    */

}

package com.rockthejvm

object Scala3OpaqueTypes {

    object SocialNetwork{ // "domain"
        opaque type Name = String
        // Name == String
        //Bad lose all functions from String, but good start "fresh"

        // 1 - companion object
        object Name {
            def fromString(s:String): Option[Name] =
                if(s.isEmpty || s.charAt(0).isLower) None else Some(s)
        }

        // 2 - extension methods
        extension (n: Name) {
            def length: Int = n.length //.length on the String class
        }
    }

    import SocialNetwork._

    //outside scope Name != String
    // Val name: Name = "Daniel" // will not compile

    object Graphics{
        opaque type Color = Int // in hex
        opaque type ColorFilter <: Color = Int

        val Red: Color = 0xFF000000
        val Green: Color = 0x00FF0000
        val Blue: Color = 0x0000FF00
        val halfTransparency: ColorFilter = 0x88 // 50% transparency
    }

    import Graphics._
    case class OverlayFilter(c: Color)

    val fadeLayer = OverlayFilter(halfTransparency) // ColorFilter "Extends" color
  
    def main(args: Array[String]): Unit = {
        val nameOption = Name.fromString("Daniel") // Some("Daniel")
        nameOption.foreach(println)
        val danielsNameLengthOption = nameOption.map(_.length)
        danielsNameLengthOption.foreach(println)
    }
}

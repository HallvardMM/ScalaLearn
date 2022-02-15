object Scala3MatchTypes {
  
    // Ints, String, Lists
    // BigInt -> last digit, of type Int
    // String -> last char
    // List -> last element

    def lastDigitOf(number: BigInt): Int = (number % 10).toInt
    def lastCharOf(string: String):Char = 
        if string.isEmpty then throw new NoSuchElementException
        else string.charAt(string.length-1)
    def lastElementOf[T](list: List[T]): T =
        if list.isEmpty then throw new NoSuchElementException
        else list.last

    // Scala 2 can't combine this logic
    // Scala 3 can do it!

    type ConstituentPartOf[T] = T match 
        case BigInt => Int
        case String => Char
        case List[t] => t //Small t is type variable

    val aDigit: ConstituentPartOf[BigInt] = 2 // ok
    val aChar: ConstituentPartOf[String] = 'a'
    val anElement: ConstituentPartOf[List[Int]] = 42

    def lastComponentOf[T](biggerValue: T): ConstituentPartOf[T] = biggerValue match 
        case b: BigInt => (b % 10).toInt
        case s: String => 
            if s.isEmpty then throw new NoSuchElementException
            else s.charAt(s.length-1)
        case l: List[_] =>
            if l.isEmpty then throw new NoSuchElementException
            else l.last

    val lastDigit = lastComponentOf(BigInt(235678912)) //2
    val lastChar = lastComponentOf("Scala") //'a'
    val lastElement = lastComponentOf(List(1,2,3)) //3

    // Why is this different from OOP?
    // def returnLastConstituentOf(thing: Any): ConstituentPart = thing match ... 
    // In Java you would lose type safety

    // Why is this different from regular generics?
    // More subtle 

    def lastElementOfList[A](list: List[A]): A = list.last
    lastElementOf(List(1,2,3)) // 3, an Int
    lastElementOf(List("a","b","c")) // "c", a string
    // Match types would make it possible to chose the return type

    // recursion
    type LowestLevelPartOf[T] = T match
        case List[t] => LowestLevelPartOf[t]
        case _ => T

    val lastElementOfNestedList: LowestLevelPartOf[List[List[List[Int]]]] = 2

    // Not allowed
    //type AnnoyingMatchType[T] = T match 
    //    case _ => AnnoyingMatchType[T]
     
    // Will cause a stackOverflow
    // type InfiniteRecursiveType[T] = T match
    //    case Int => InfiniteRecursiveType[T]

    // def aNaiveMethod[T]: InfiniteRecursiveType[T] = ???

    // val illegal: Int = aNaiveMethod[Int]
}

package com.rockthejvm

object Scala3TypeLambdas {
  /*
  - Kinds = types of types
  - Int, String = value-level kind (level-0) => attach to values
  - List, Option = Level-1 kind ("Generics")
  - Functor, Monad = Level-2 kind ("Generics of generics")
  */
  val aNumber: Int = 42
  val aList: List[Int] = ???

  class Functor[F[_]]
  val functorOption = new Functor[Option]

  // List is similar to a function = type constructor 
  type MyList = [T] =>> List[T] // MyList ===== List

  type MapWithStringKey = [T] =>> Map[String, T]
  val addressBook: MapWithStringKey[String] = Map()
  type MapWithStringKey2[T] = Map[String, T] //Exactly the same

  type SpecialEither = [T, E] =>> Either[E, Option[T]]
  val specialEither: SpecialEither[Int, String] /*Either[String, Option[Int]]*/ = Right(Some(2))

  // Monads
  trait Monad[M[_]]{
      def pure[A](value: A):M[A]
      def flatMap[A, B](ma:M[A])(transformation: A => M[B]):M[B]
  }

  // monads for Either
  //class EitherMonad[E] extends Monad[Either[E,?]]{}
  // work for Either[String, Int], Either[String, String], Either[String, Person]

  class EitherMonad[E] extends Monad[[T] =>> Either[E,T]]{
      override def pure[A](value: A) = ???
      override def flatMap[A, B](ma:Either[E,A])(transformation: A => Either[E,B]) = ???
  }

  // Mostly used for very abstract code.

}

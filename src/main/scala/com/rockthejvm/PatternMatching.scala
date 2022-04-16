package com.rockthejvm

object PatternMatching extends App {
  // switch statement
  val anInteger: Int = 55
  val order: String = anInteger match {
    case 1 => "first"
    case 2 => "second"
    case 3 => "third"
    case _ => anInteger + "th"
  }
  // Pattern Matching is an EXPRESSION

  // Case classes decomposition
  case class Person(name: String, age: Int)
  val bob = Person("Bob", 43) // Person.apply("Bob", 43)

  val personGreating = bob match {
    case Person(name, age) => s"Hi my name is $name and I am $age years old"
    case _                 => "Something else"
  }
  println(personGreating)

  // deconstructing a tuple
  val aTuple = ("Bon Jovi", "Rock")

  val bandDescription = aTuple match {
    case (band, genre) => s"$band belongs to the $genre"
    case _             => "I don't know what you are talking about"
  }
  println(bandDescription)

  // decomposing Lists
  val aList = List(1, 2, 3)
  val aDescription = aList match {
    case List(_, 2, _) =>
      "a list containing 2 as the second element"
    case _ => "unknown list"
  }

  // If the pattern matching doesn't match anything, it will throw a MatchError
  // Pattern matching will try all cases in sequence
}

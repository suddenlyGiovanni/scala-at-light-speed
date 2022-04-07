package com.rockthejvm

object FunctionalProgramming extends App {

  // Scala is OO
  class Person(name: String) {
    def apply(age: Int): String = s"I have aged $age years"
  }

  val bob = new Person("Bob")
  bob.apply(43)
  bob(43) // invoking bob as a function === bob.apply(43)

  /*
   * Scala runs on the JVM
   * FUNCTIONAL PROGRAMMING:
   * - compose functions
   * - pass functions as arguments
   * - return functions as results
   *
   * Conclusion: FunctionX =  Function1, Function2, ..., Function22
   *
   */

  val simpleIncrementer = new Function1[Int, Int] {
    override def apply(arg: Int): Int = arg + 1
  }

  simpleIncrementer.apply(23) // 24
  simpleIncrementer(23) // equivalent to simpleIncrementer.apply(23) 24
  // defined a function

  // ALL SCALA FUNCTIONS ARE INSTANCES OF THESE FUNCTION_X TYPES

  // a function with two arguments and a String return type
  val stringConcatenation = new Function2[String, String, String] {
    override def apply(arg1: String, arg2: String): String = arg1 + arg2
  }

  stringConcatenation("I love ", "Scala") // "I love Scala"

  // syntax sugar
  val doubler: Int => Int = (x: Int) => x * 2
  /* equivalent to the much more verbose:s
   val doubler: new Function1[Int, Int] = new Function1[Int, Int] {
    override def apply(x: Int): Int = x * 2
   }
   */
  doubler(4) // 8

  // HIGH ORDER FUNCTIONS: take functions as arguments or return functions as results or both
  val aMappedList: List[Int] = List(1, 2, 3).map(x => x + 1) // HOF
  println(aMappedList) // List(2, 3, 4)

  val aFlatMappedList = List(1, 2, 3).flatMap { x =>
    List(x, 2 * x)
  } // HOF with an alternative syntax, same as .map(x => List(x, 2 * x))
  println(aFlatMappedList) // List(1, 2, 2, 4, 3, 6)

  val aFilteredList =
    List(1, 2, 3, 4, 5).filter(_ <= 3) // HOF equivalent to .filter(x => x <= 3)
  println(aFilteredList) // List(1, 2, 3)

  // all the pairs between the numbers 1,2,3 and the letters 'a', 'b', 'c'
  val allPairs =
    List(1, 2, 3).flatMap(number =>
      List('a', 'b', 'c').map(letter => s"$number-$letter")
    )
  println(allPairs)

  // for comprehensions
  val alternativePairs = for {
    number <- List(1, 2, 3)
    letter <- List('a', 'b', 'c')
  } yield s"$number-$letter" // equivalent to the `map`/`flatMap` chain above

  println(alternativePairs)

  /** Collections
    */
  // lists
  val aList = List(1, 2, 3, 4, 5)
  val firstElement = aList.head // 1
  val rest = aList.tail // List(2, 3, 4, 5)

  /** `::` is the cons operator, `::` is a method of the List class
    */
  val aPrependedList = 0 :: aList // List(0, 1, 2, 3, 4, 5)

  /** `+:` prepends an element to the list, `:+` appends an element to the list
    */
  val anExtendedList =
    0 +: aList :+ 6 // List(0, 1, 2, 3, 4, 5, 6)

  // sequences

  val aSequence: Seq[Int] = Seq(1, 2, 3, 4, 5) // Seq.apply(1, 2, 3, 4, 5)
  val accessedElement = aSequence.apply(1) // the element at index 1: 2

  // vectors: fast, fixed size, fast access, fast appends
  val aVector: Vector[Int] = Vector(1, 2, 3, 4, 5)

  // sets: collections with no duplicates
  val aSet: Set[Int] = Set(1, 2, 3, 4, 1, 2, 3) //  Set(1, 2, 3, 4)
  val setHas5 = aSet.contains(5) // false
  val anAddedSet = aSet + 5 // Set(5, 1, 2, 3, 4)
  val aRemovedSet = aSet - 3 // Set(1, 2, 4)

  // ranges
  val aRange: Range =
    1 to 1000 // a fictitious collection that contains all the integers from 1 to 1000 only if requested
  val twoByTwo = aRange.map(_ * 2).toList // List(2, 4, 6, 8, ..., 2000)

  // tuples = groups of values under the same value
  val aTuple = ("Bon Jovi", "Rock", 1982)

  // maps
  val aPhonebook: Map[String, Int] = Map(
    ("Jim", 555),
    "Pam" -> 939 // equivalent to ("Pam", 939)
  )

}

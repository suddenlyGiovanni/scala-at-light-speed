package com.rockthejvm

object Basics extends App {
  // define the first value
  val meaningOfLife: Int = 42

  // Int, Boolean, Char, Double, Float, String
  val aBoolean = false

  // strings and string operations
  val aString = "I love Scala"
  val aComposedString = "I" + " " + "love" + " " + "scala"
  val anInterpolatedString = s"the meaning of life is $meaningOfLife"

  // expressions = structures that can be reduced to a value
  val anExpressions = 2 + 3

  // if-expression
  val ifExpression =
    if (meaningOfLife > 43) 56
    else 999 // in other languages: meaningOfLife > 43 ? 56 : 999

  val chainedIfExpression = {
    if (meaningOfLife > 43) 56
    else if (meaningOfLife < 0) -2
    else if (meaningOfLife > 999) 78
    else 0
  }

  // code blocks
  val aCodeBlock = {
    // definitions
    val aLocalValue = 67

    // at the end you have to return something...
    // value of the bloc is the value of the last expression
    aLocalValue + 3
  }

  // define a function
  def myFunction(x: Int, y: String): String = {
    y + " " + x
  }

  // recursive function
  def factorial(n: Int): Int = {
    if (n <= 0) 1
    else n * factorial(n - 1)
  }
  /*
     factorial(5) = 5 * factorial(4) = 5 * 4 * factorial(3) = 5 * 4 * 3 * factorial(2) = 5 * 4 * 3 * 2 * factorial(1) = 5 * 4 * 3 * 2 * 1 = 120
     factorial(4) = 4 * factorial(3) = 4 * 3 * factorial(2) = 4 * 3 * 2 * factorial(1) = 4 * 3 * 2 * 1
     factorial(3) = 3 * factorial(2) = 3 * 2 * factorial(1) = 3 * 2 * 1
     factorial(2) = 2 * factorial(1) = 2 * 1 = 2
     factorial(1) = 1
   */

  // in Scala we don't use loops, or iteration, we use recursion

  // `Unit` return type  =  no meaningfully value === "void" in other languages
  // type of SIDE EFFECTS
  println(
    s"the meaning of life is $meaningOfLife"
  ) // System.out.println, printf, print, console.log

  def myUnitReturningFunction(x: Int): Unit = {
    // do something
    println("I don't love returning Unit!")
  }

  val theUnit = ()
}

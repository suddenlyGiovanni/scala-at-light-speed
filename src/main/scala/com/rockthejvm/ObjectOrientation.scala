package com.rockthejvm

object ObjectOrientation extends App {

  // Java equivalent: public static void main(String[] args)

  // Scala is an Object Oriented Language

  val anAnimal = new Animal
  val aDog = new Dog("Lessie")
  // subtype polymorphism
  val aDeclaredAnimal: Animal = new Dog("Hachi")

  // "interface" = ultimate abstract type
  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  // constructor arguments are not fields: need to put a `val` before the constructor argument name
  aDog.name

  // abstract class
  abstract class WalkingAnimal {
    val hasLegs =
      true // by default public, can restrict by using `protected` or `private`

    def walk(): Unit
  }
  aDeclaredAnimal.eat() // the most derived  method will be called at runtime

  // class and instance
  class Animal {
    // define fields
    val age: Int = 0

    // define methods
    def eat(): Unit = println("I'm eating")
  }

  // inheritance
  class Dog(val name: String) extends Animal // constructor definition

  trait Philosopher {
    def ?!(thought: String): Unit // a valid method name
  }

  // single class inheritance and multi-traits inheritance "mixing"
  class Crocodile extends Animal with Carnivore with Philosopher {
    override def eat(animal: Animal): Unit = println(
      "I'm eating you, " + animal
    )

    override def ?!(thought: String): Unit = println(
      s"I was thinking: $thought"
    )
  }

  val aCroc = new Crocodile
  aCroc.eat(aDog)
  aCroc eat aDog // infix notation = object method argument, only available for methods with ONE argument
  aCroc ?! "What if we could fly"

  // operator in Scala are methods
  val basicMath = 1 + 2
  val anotherBasicMath = 1.+(2) // infix notation. equivalent

  // Anonymous classes
  val dinosaur = new Carnivore {
    def eat(animal: Animal): Unit = println(
      "I'm a Dinosaur so that I can eat pretty much anything"
    )
  }

  /*
  // What you tell the compiler

  class Carnivore_Anonymous_43243 extends Carnivore {
    def eat(animal: Animal): Unit = println(
      "I'm a Carnivore so that I can eat pretty much anything"
    )
  }

  val dinosaur = new Carnivore_Anonymous_43243
   */

  // Singleton Object

  object MySingleton { // the only instance of the MySingleton type

    val mySpecialValue = 235234
    def mySpecialMethod(): Int = mySpecialValue

    def apply(x: Int): Int = x + 1
  }

  MySingleton.mySpecialMethod()
  MySingleton.apply(65)
  MySingleton(65) // equivalent to MySingleton.apply(65)

  object Animal { // the class Animal and the object Animal are companions - companion objects
    // companion objects can access each other's private fields/methods
    // the singleton Animal and the instance of an Animal are different thing

    val canLiveIndefinitely = false
  }

  val animalsCanLiveForever =
    Animal.canLiveIndefinitely // "static" field/methods

  /*
   case classes = light-weight data structures with some special boilerplate
   - sensible equals and hash code
   - sensible serialization
   - companion with apply
   - pattern matching
   */

  case class Person(name: String, age: Int)

  // case classes may be constructed with out the new keyword
  val bob = Person("Bob", 54) // Person.apply("Bob", 54) = new Person("Bob", 54)

  // exceptions
  try {
    // code that con throw an exception
    val x: String = null
    x.length
  } catch { // catch(Exception e) {...}
    case e: Exception => "some faulty error message"
  } finally {
    // execute some code no matter what
  } // very similar to what you would see in Java

  // generics
  abstract class MyList[T] {
    def head: T
    def tail: MyList[T]
  }

  // using a generic with a concrete type
  val aList: List[Int] =
    List(1, 2, 3) // List.apply(1, 2, 3) = new List(1, 2, 3)

  val first = aList.head // Int
  val rest = aList.tail // List[Int]
  val aStingList = List("hello", "world")
  val firstString = aStingList.head // String
  val tailString = aStingList.tail // List[String]

  // Point #1: in Scala we usually operate with IMMUTABLE values/objects
  // any modification to the object will return ANOTHER object
  /*
  Benefits:
  1) works miracles in multi threaded/ distributed environments
  2) helps making sense of the code
   */
  val reversedList = aList.reverse // returns a NEW list

  // Point #2: Scala is closest to OO ideal

}

package io.readian.milanatutorial.codesamples

fun main() {
  val person = Person("Milana", 25)
  val person1 = Person("Milana", 25)

  if (person == person1) {
    println("same person")
  } else {
    println("different people")
  }
}

open class Person(
  open val name: String,
  open val age: Int,
) {
  fun walk() {
    println("$name is walking")
  }
}

data class Student(
  val studentId: Int,
  override val name: String,
  override val age: Int,

  ): Person(name, age) {
  fun study() {
    println("$name is studying")
  }
}

class Teacher(
  override val name: String,
  override val age: Int,
  val experienceLeve: Int,
): Person(name, age) {
  fun teach() {
    println("$name is teaching")
  }
}

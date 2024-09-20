package io.readian.milanatutorial.codesamples

interface Animal {
  val name: String

  fun move()
}

class Dog(override val name: String): Animal {
  override fun move() {
    println("$name is running with its feet")
  }
}

class Bird(override val name: String): Animal {
  override fun move() {
    println("$name is flying with its wings")
  }
}
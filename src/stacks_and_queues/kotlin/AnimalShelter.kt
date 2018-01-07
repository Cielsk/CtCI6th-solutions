package stacks_and_queues.kotlin

import java.util.*

/**
 *
 */
fun main(args: Array<String>) {
    val shelter = Shelter()

    shelter.enqueue(Cat("a"))
    shelter.enqueue(Dog("b"))
    shelter.enqueue(Dog("c"))
    shelter.enqueue(Cat("d"))
    shelter.enqueue(Cat("e"))

    var animal = shelter.dequeueAny()
    println(animal.name)     // expect a
    println(shelter.size()) // expect 4
    println()

    val cat = shelter.dequeueCat()
    println(cat!!.name)        // expect d
    println(shelter.size()) // expect 3
    println()

    val dog = shelter.dequeueDog()
    println(dog.name)        // expect b
    println(shelter.size()) // expect 2
    println()

    animal = shelter.dequeueAny()
    println(animal.name)     // expect c
    println(shelter.size()) // expect 1
}

abstract class Animal(val name: String)

class Cat(name: String) : Animal(name)

class Dog(name: String) : Animal(name)


class Shelter {

    private val buf = LinkedList<Animal>()

    fun size(): Int {
        return buf.size
    }

    fun enqueue(animal: Animal) {
        buf.offerLast(animal)
    }

    fun dequeueAny(): Animal {
        return buf.pollFirst()
    }

    fun dequeueDog(): Dog {
        val dog = buf.first { it is Dog }
        buf.removeFirstOccurrence(dog)

        return dog as Dog
    }

    fun dequeueCat(): Cat? {
        val cat = buf.first { it is Cat }
        buf.removeFirstOccurrence(cat)

        return cat as Cat
    }
}
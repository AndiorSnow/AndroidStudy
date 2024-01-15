package com.example.yancourse2.lesson

import org.json.JSONObject

fun main(args: Array<String>) {
    //6. generic
    // generic interface
    val drinkApple = DrinkApple()
    drinkApple.drink("drink")
    // generic class
    val blueColor = BlueColor("blue")
    blueColor.printColor()
    // generic method
    fromJson<String>("{}", String::class.java)
    // Generic constraints
    fromJson2<JSONObject>("{}", JSONObject::class.java)
    // Generic Constraint - Multiple Constraints
    fromJson3<User>("{}", User::class.java)
}

// generic interface
interface Drink<T> {
    fun drink(t: T)
}

class DrinkApple: Drink<String> {
    override fun drink(t: String) {   //override
        print("drink:${t}")
    }
}

// generic class
abstract class Color <T> (val t: T /*Generic field*/) {
    abstract fun printColor()
}

class BlueColor(val color: String): Color<String> (color) {
    override fun printColor() {
        println("printColor:${color}")
    }
}

// generic method
fun <T> fromJson (json: String, tClass: Class<T>): T? {  // ? indicates that the return value can be empty
    val instance: T? = tClass.newInstance()
    return instance
}

// Generic type qualification
// The pass type T can only be a JSONObject class or a subclass of a JSONObject class
fun <T: JSONObject > fromJson2 (json: String, tClass: Class<T>): T? {
    val instance: T? = tClass.newInstance()
    return instance
}
// Passing type T must satisfy all conditions of the where clause, which implements both User type qualification and Comparable
// Comparable sorting interface, which can sort the class through Array.sort() (rewrite the compareTo function)
fun <T> fromJson3 (json: String, tClass: Class<T>): T? where T: JSONObject, T: Comparable<T> {
    val instance: T? = tClass.newInstance()
    return instance
}

class User: JSONObject(), Comparable<User> {
    override fun compareTo(other: User): Int {
        return 0
    }
}

// in/out keyword
open class Animal

open class DogAnimal : Animal()

class CatAnimal : Animal()

class WhiteDogAnimal : DogAnimal()

fun animalFuns() {
    val animal: Animal = DogAnimal()
    //val animalList : ArrayList<Animal> = ArrayList<DogAnimal>()   // Kotlin cannot perform set level type strong conversion
    // out generic parameters passed in can be Animal and its subclasses DogAnimal, CatAnimal, WhiteDogAnimal
    // Using the out keyword declaration - generic upper limit
    val animalList : ArrayList<out Animal> = ArrayList<DogAnimal>()
    val animalList2 : ArrayList2<Animal> = ArrayList2<DogAnimal>()
    // Using the in keyword to declare - generic lower bound, allowing passing in generic types such as DogAnimal and its parent class Animal
    val animalList3 : ArrayList<in DogAnimal> = ArrayList<Animal>()
    val animalList4 : ArrayList3<DogAnimal> = ArrayList3<Animal>()
}

class ArrayList2<out T> {
    // declare using the "out" keyword
}
class ArrayList3<in T> {
    // declare using the "in" keyword
}
package com.example.yancourse2.lesson

fun main(args: Array<String>) {
    //7. Extension Method
    Jump().test()
    Jump().doubleJump()
    // Generic extension methods
    val list = mutableListOf<Int>(1, 2, 3, 4)
    list.swap(0, 2)
    for (i in list) {
        println("index:${i}")
    }

    // Extension attribute
    val android  = "android"
    val lastChar = android.lastChar
    println("lastChar:${lastChar}")

    Jump2.print("Expansion of accompanying objects")

    // Apply built-in extension function
    testApply()
}

class Jump {
    fun test() {}
}

// The definition of an extension method is to add a class prefix before the method
fun Jump.doubleJump(): String {
    return "doubleJump"
}

// Generic extension methods
fun <T> MutableList<T>.swap(index: Int, index2: Int) {
    val tmp = this[index]
    this[index]  = this[index2]
    this[index2] = tmp
}

// Extended Properties
val String.lastChar: Char get() = this.get(length - 1)

// Extension functions and properties of accompanying objects
class Jump2 {
    companion object {}
}
fun Jump2.Companion.print(str: String) {
    println(str)
}

// "let" extension function, is a scope function that defines a variable within a specific scope
// Adding ? after the class indicates that the parameter may be empty. When using it, be careful to check for blanks
fun testLet(str: String?) {
//    str.let {
//        val str2 = "android"
//        println(str2 + it)
//    }
//    // println(str2) // Unable to access

    // The use of null detection, when str is empty, will not trigger the logic inside the closure (the following is the correct way of writing)
    str?.let {
        val str2 = "android"
        println(str2 + it)
    }
}

// "run" extension function, takes only one lambda function as a parameter and returns it in the form of a closure.
// The return value is either the value of the last line or the specified return.
// In "run", public properties and methods in the instance can be directly accessed
fun testRun(jump: Jump): String {
    jump.run {
        //jump.test()
        test()
        //"11111"
        return "22222"
    }
}

//apply扩展函数，调用某对象的apply函数，函数范围内直接调用该对象的任意方法，并返回该对象本身
// "apply" extension function, calling the apply function of a certain object, directly calling any method of the object within the scope of the function, and returning the object itself
// The only difference between "apply" and "run" is that they return different values
fun testApply() {
    ArrayList<String>().apply {
        add("111")
        add("222")
    }.run {
        for (s in this) {
            println("apply:${s}")
        }
    }
}
package com.example.yancourse2.lesson

fun main(args: Array<String>) {

    // Declaration and invocation of member methods for regular classes
    // Instance objects need to be built first to access member methods
    Person().test()  // The class name needs to be followed by parentheses
    // The methods in static classes are all static methods
    // No need to build instance objects, static methods can be directly accessed through class names
    val result = NumUtil.double(1)
    println("result:$result")
    Person.test2()
    read(1, 2)
    read(start = 1)// Named parameter, "offset" uses default value of 0
    read2(1, 1, action = {
        // The last line in the method body is the return value of the method
        val result: Int = 1 * 2
        "Using named parameters within parentheses, passing action parameters"
    })

    read2(start = 1) {
        // When action is the last parameter, this method can be used
        "Passing action parameters outside parentheses"
    }

    val append = append('1', '2', '3', '4')
    println("append:${append}")
    val world = charArrayOf('w', 'o', 'r', 'l', 'd')
    val append2 = append('h', 'e', 'l', 'l', 'o', ' ', *world)
    println("append2:${append2}")

    // Calling methods with method type parameters
    val numbers = arrayOf(1, 2, 3, 4)
    // Named parameter call, assign value to it using action
    transform(numbers, action = { index, element ->
        index * element  // The last line of expression is the return value of the action function
    })
    for (number in numbers) {
        println("transform:$number")
    }
    transform(numbers) {index, element ->
        index * element
    }
    for (number in numbers) {
        println("transform2:$number")
    }

    // The lambda invisible parameter "it"， can only be used when there is only one parameter
    numbers.forEach {
        println(it)
    }
    val list = arrayListOf<Int>(1, 2, 3, 4, 5, 6)
    list.forEachIndexed(action = {index: Int, element: Int ->
        println("forEachIndexed:${index}->${element}")
    })
    list.forEachIndexed {index: Int, element: Int ->
        println("forEachIndexed2:${index}->${element}")
    }
}

// named argument
fun read(offset: Int = 0, start: Int) {
    // Method parameters can have default values, and default values are used when omitting corresponding parameters
    println("read:${offset}, ${start}")
}
fun read2(offset: Int = 0, start: Int, action:() -> String) {
    // The third parameter is a method called action: (). If the type of the parameter is (), it indicates that the parameter is a method.
    // The return value of method parameters is represented by ->, where Unit indicates that no return value is required.
    val ret: String = action()
    println("read2:$ret")
}

// Variable number of parameters, at most one parameter can be vararg
// When vararg is not the last parameter, the following parameters can be assigned using the method of named parameters.
fun append(vararg str: Char): String {
    val result = StringBuffer()
    for (char in str) {
        result.append(char)
    }
    return result.toString()
}

// lambda syntax
// action takes two parameters. Request to return the transformed elements of the array and replace the old elements
fun transform(array: Array<Int>, action: (index: Int, element: Int) -> Int) {
    for (index in array.indices) {
        val newValue = action(index, array[index])
        array[index] = newValue
    }
}

// regular class
class Person {
    fun test() {  //The types of parameters and function return values are represented by:
        println("Methods")
    }
    // Companion class, used to implement static methods in regular classes.
    // No need to build instance objects, static methods can be directly accessed through class names
    companion object {
        fun test2() {
            println("Methods")
        }
    }
}

// static class
object NumUtil {
    fun double(num: Int) :Int {
        return num * 2
    }
}




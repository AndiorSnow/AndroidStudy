package com.example.yancourse2.lesson

fun main(args: Array<String>) {
    //4. conditional control
    println("maxOf:${maxOf(a = 5, b = 10)}")

    eval(100)
    eval2(200f)
}

fun maxOf (a:Int, b: Int): Int {
    // "if-else" not only a statement, but also an expression. It needs to have a return value, and the last line in the statement body should return a value
    if (a > b) {
        return a
    } else {
        return b
    }
}

fun maxOf2 (a:Int, b: Int): Int {
    // Equivalent to the ternary operator
    return if (a > b) a else b
}

fun eval(number: Number) {
    //"is" determine if it is a type
    if (number is Int) {
        println("this is int number")
    } else if (number is Double) {
        println("this is double number")
    } else if (number is Float) {
        println("this is float number")
    } else if (number is Long) {
        println("this is long number")
    } else if (number is Byte) {
        println("this is byte number")
    } else if (number is Short) {
        println("this is Short number")
    } else {
        // error
        throw IllegalArgumentException("invalid argument")
    }
}

fun eval2(number: Number): String = when (number) {
    //"when" also has a return value
    200f -> "the number is 200f"
    is Int -> "this is int number"
    is Double -> "this is double number"
    is Float -> {
        println("the number is float")
        "this is float number"
    }
    is Long -> "this is long number"
    is Byte -> "this is byte number"
    is Short -> "this is Short number"
    else -> "invalid number"
}

fun eval3 () {
    when (val value = getValue()) {// "when" condition is directly an expression, and the return value is saved with value, which is actually equivalent to writing the external line indented
        is Int -> "This is Int Type, value is $value".apply(::println)
        is String -> "This is String Type, value is $value".apply(::println)
        is Double -> "This is Double Type, value is $value".apply(::println)
        is Float -> "This is Float Type, value is $value".apply(::println)
        else -> "unknown type".apply(::println)
    }
}

fun getValue (): Any {
    return 100
}
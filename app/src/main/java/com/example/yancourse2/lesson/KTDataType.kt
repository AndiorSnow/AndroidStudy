package com.example.yancourse2.lesson

fun main(args: Array<String>) {
    //1. Declare a variable of a basic data type
    val number = 100             // Default int
    val bigNumber = 8000000000   // Exceeded the value range of int
    val longNumber = 20L
    val byteNumber:Byte = 1
    val longNumber2:Long = 20
    val doubleNumber = 3.1415928888  // Default double, 15 to 16 decimal places
    val floatNumber = 3.1415928888f  // +f or F, but float can only store 6-7 decimal places

    println("floatNumber:" + floatNumber)
    println("doubleNumber" + doubleNumber)

    val char: Char = '0'
    val inVisible: Boolean = true//true or false
    val invisible2 = false

    // string
    val str = "123456789"   // start from 0
    val str2: String = "123456"
    val strNumber2: Char = str[1]
    // Template expression for strings
    println("The result is $str")
    println("The result is ${str.length}")
    // String Concatenation
    println("I am" + 10 + "years old")
    // Character Escape
    val helloWorld = "Hello, world!\n"
    print(helloWorld + "\n" + "how are you")
    val s2 = "{\"key\":\"value\"}"
    val s3 = """
        {"key":"value"}
    """.trimIndent()
    println(s2)
    println(s3)

    // Forced conversion
    val num: Int = 100
    println("convert to string:${num.toString()}")

    // Bit operation
    val vip = true
    val admin = false
    val result1 = vip.and(admin)  // and，or，inv，xor
    val result2 = 8 ushr (2)   // Signed shift left "shl", signed shift right "shr", unsigned shift right "ushr"


}
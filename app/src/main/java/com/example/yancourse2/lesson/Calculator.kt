package com.example.yancourse2.lesson

// Expression calculator for one-time arithmetic operations
fun main() {
    while (true) {
        println("========Please enter your expression========")
        val input = readLine()
        try {
            input?.let{
                val ret = calculate(it)
                //1+1=2
                println("${input}=${ret}")
                println("Continue using it(y/n)")
                val cmd = readLine()
                cmd?.let {
                    if (it.equals("n")) {
                        System.exit(-1)
                    } else {
                        // Continue using the program
                    }
                }
            }
        }catch (ex: Exception) {
            ex.printStackTrace()
        }
    }
    // Run to this end
}

fun calculate(input: String): String {
    // input = 1+1
    // input = 1-10
    // input = 1/2
    // input = 1*11

    if (input.contains("+")) {
        val nums = input.trim().split("+")
        return operate(nums[0].toDouble(), nums[1].toDouble(), "+").toString()
    } else if (input.contains("-")) {
        val nums = input.trim().split("-")
        return operate(nums[0].toDouble(), nums[1].toDouble(), "-").toString()
    } else if (input.contains("*")) {
        val nums = input.trim().split("*")
        return operate(nums[0].toDouble(), nums[1].toDouble(), "*").toString()
    } else if (input.contains("/")) {
        val nums = input.trim().split("/")
        return operate(nums[0].toDouble(), nums[1].toDouble(), "/").toString()
    } else {
        return "error: The expression entered is incorrect"
    }
}

fun operate (num1: Double, num2: Double, operate: String): Double {
    return when (operate) {
        "+" -> num1 + num2
        "-" -> num1 - num2
        "*" -> num1 * num2
        else -> num1 / num2
    }
}
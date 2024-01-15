package com.example.yancourse2.lesson

fun main(args: Array<String>) {
    //5. loop
    //for
    val items: List<String> = listOf("java", "kotlin", "android")
    for (item in items) {
        println(item)
    }
    items.forEach {
        println(it)
    }
    items.forEachIndexed{index, item ->
        println("forEachIndexed:${index}, ${item}")
    }

    //while
    var index = 0
    while (index < items.size) {
        println("The $index element is ${items[index++]}")
    }
    index = 0
    do {
        println("The $index element is ${items[index++]}")
    } while (index < items.size)

    // loop interval
    for (i in 1..10) {//..  is a closed interval
        println("$i ")
    }
    for (i in 1 until 10) {//until   the right is a open interval
        println("$i")
    }
    for (i in 10 downTo 1 step 2) {//From large to small, with a step size of 2
        println("%i ")
    }

}
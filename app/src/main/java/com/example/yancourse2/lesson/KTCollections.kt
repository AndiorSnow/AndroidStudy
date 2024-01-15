package com.example.yancourse2.lesson

import androidx.collection.arrayMapOf
import org.json.JSONObject

fun main(args: Array<String>) {
    //2. data container
    // Array, elements cannot be added or removed after array initialization
    var array1 = arrayOf(1, 2, 3, 4)
    val array2: Array<Int> = arrayOf(1, 2, 3)
    // The elements in the collection can be of any type
    val arrayObjects: Array<Any> = arrayOf(1, true, "2")
    // An array with all empty elements of a specified size must specify the element type in the collection
    val arrayNulls = arrayOfNulls<String>(5)
    arrayNulls[0] = "element1"
    arrayNulls[1] = "element2"
    arrayNulls[2] = "element3"
    arrayNulls[3] = "element4"
    arrayNulls[4] = null

    // Using the constructor of array, dynamically create arrays 0, 1, 4, 9, 16, lambda expressions
    val asc: Array<String> = Array(5) {i: Int -> (i * i).toString()}


    // Byte Array
    val bytes = ByteArray(5)
    bytes[0] = 0

    //Int Array
    var intArray = IntArray(5)
    intArray[0] = 5

    var intArr = IntArray(5) {100}  // Length is 5, values are all 100

    val intArr2 = IntArray(5) {it * 2} //{0, 2, 4, 6, 8}, "it" is exclusive to lambda and represents the index index value

    // Array for loop traversal
    for (item in intArr2) {
        println(item)
    }
    for (i: Int in intArr2.indices) {
        println(i.toString() + "->" + intArr2[i])
    }
    for ((i, item) in intArr2.withIndex()) {
        println("$i->$item")
    }
    intArr2.forEach {
        println("forEach: $it")
    }
    intArr2.forEachIndexed { i, item ->
        println("$i: $item")
    }

    // Set, the size of the set can be dynamically changed, including List, Set, Map
    // List, mutable, can be declared uninitialized
    var list = arrayListOf<Int>(1, 2, 3)
    var list1 = mutableListOf<String>()  // Recommended use
    list1.add("11")
    list1.add("22")
    list1.add(2, "33")
    var list2 = mutableListOf<String>("1", "2", "3", "4", "5")

    // List, immutable, must be initialized during declaration
    val list3 = listOf<Int>(1, 2, 3)

    // Set and map are similar to the above
    var map1 = mutableMapOf(Pair("key", "value"))
    var map2 = arrayMapOf<String, String>()
    var map3 = arrayMapOf<String, String>(Pair("key", "value"))
    map1["1"] = "1"
    map1["2"] = "2"
    map1["2"] = "3"   //Will overwrite the key value pairs above

    // Immutable dictionary
    var map4 = mapOf<String, String>(Pair("key", "value"))

    // mutable set
    var set1 = mutableSetOf<Int>()
    set1.add(1)

    // Traverse set elements
    for (item in set1) {
        println(item)
    }

    // The following operations apply to collections and dictionaries
    println("isEmpty:${list2.isEmpty()}")
    println("contains:${list2.contains("6")}")
    println("get:${list2[0]}")
    println("indexOf:${list2.indexOf("6")}")                   // Determine the position of an element in the first occurrence of the set
    println("lastIndexOf:${list2.lastIndexOf("5")}")   // Determine the position of the last occurrence of an element in the set
    val iterator = list2.iterator()
    iterator.forEach { it ->
        println("it:${it}")
    }
    //list2.clear()
    //println("length:${list2.size}")
    list2[0] = "0"
    list.remove(0)

    //
    val numbers = mutableListOf(1, 2, 3, 4)
    numbers.reverse()
    numbers.shuffle()       //Randomly arrange elements
    numbers.sort()          //from small to large
    numbers.sortDescending()//from large to small
}
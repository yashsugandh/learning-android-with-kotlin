fun main(args: Array<String>) {

    // Conditional Operators : >, <, >=, <=, ==, !=
    // Logical Operators : &&, ||, !

    //In Kotlin if is an expression i.e. it return something

    //Traditional Approach
    val a =10
    val b = 20
    var max: Int
    if (a > b) {
        max = a
    } else {
        max = b
    }

    //As Expression
    val maximum = if (a > b) a else b

    //If branches can be blocks and the last expression is value of the block
    val max1 = if (a > b) {
        println("Choose a")
        a
    } else {
        println("Choose b")
        b
    }

    println("The maximum of a $a and b $b is $max1")

    //When Expression is similar to the Switch case in Java

    //When used as an statement using else is not mandatory
    val x = 10
    when (x) {
        //match a list
        1,2,3,4 -> println("x is present in the list")
        //match a range
        in 5..9 -> println("x is in the range of 5 to 9")
        //check for a specific value
        10 -> println("x is 10")
        //its like the default in switch case which will be called if no other condition satisfy
//        else -> {
//            println("x is neither 1 nor 2")
//        }
    }

    //When used as an expression else is mandatory
    val monthOfYear = 7
    var month = when(monthOfYear){
        1->"January"
        2->"Febuary"
        3->"March"
        4->"April"
        5->"May"
        6->"June"
        7->"July"
        8->"August"
        9->"September"
        10->"October"
        11->"November"
        12->"December"
        else -> {
            println("Not a month of year")
        }
    }
    println("This is $month month of the year")

    var listOfNumbers = arrayListOf(1,2,35,44,35,6,7,33,221,23)

    println("The list of numbers :")
    //looping through a list of numbers and printing them
    for (number in listOfNumbers) print(" $number")


    //the body can also be a block
    println("\nEven numbers in list are : ")
    for (number in listOfNumbers){
        if (number%2==0)
            println(number)
    }

    //For loop withIndex
    println("The list of numbers with indexs:")
    for ((index, value) in listOfNumbers.withIndex()) {
        println("the element at $index is $value")
    }

    //For loop with range
    println("Loop through a range")
    for (i in 10..20) print(" $i")

    //While and doWhile loops works the same
    //Break and continue are also supported
    var z = 10
    while (z != 0) {
        if (z<5)
        {
            z--
            continue
        }
        else if(z==1)
            break
        println(z)
        z--
    }
}
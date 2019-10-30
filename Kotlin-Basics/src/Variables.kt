fun main(args: Array<String>) {

    //For Immutable/Constant Variables
    val variable1 = 1
    //For Mutable(changeable) Variable
    var variable2 = 2

    //Printing the values $variableName is used to get the value of variable inside ""
    println("Immutable variable $variable1 mutable varibale = $variable2")
    variable2 = 5
    //Perform operations such as addition inside ""
    println("Addition of variable1 and variable2 = ${variable1 + variable2}")

    //Kotlin uses type inference but we can still define type
    //Different types of dataStructure for numbers

    //Integers
    var maxValueOfByte: Byte = Byte.MAX_VALUE
    var maxValueOfShort: Short = Short.MAX_VALUE
    var maxValueOfInt: Int = Int.MAX_VALUE
    var maxValueOfLong: Long = Long.MAX_VALUE

    println("max value of byte = $maxValueOfByte")
    println("max value of short = $maxValueOfShort")
    println("max value of int = $maxValueOfInt")
    println("max value of long = $maxValueOfLong")

    //By default all the numbers in the range of Int is by default considered as Int after the range it is considered as Long

    //To specify Long explicitly we use
    var explicitLongValue = 1L

    println("type of the explicitly made Long variable is ${explicitLongValue.javaClass}")

    //Decimals
    var maxValueOfFloat: Float = Float.MAX_VALUE
    var maxValueOfDouble: Double = Double.MAX_VALUE

    println("max value of float = $maxValueOfFloat")
    println("max value of double = $maxValueOfDouble")

    //By default all the decimals are initialized as double
    //To specify a decimal as float we need to use suffix 'f' or 'F'

    var valueWithoutSuffix = 3.14
    var valueWithSuffix = 3.14f

    println("type of a valueWithoutSuffix = ${valueWithoutSuffix.javaClass} and type of valueWithSuffix ${valueWithSuffix.javaClass}")

    //We can explicilty convert from one type to another type
    val characterA = 'A'
    val integerValueOfA = characterA.toInt() //similarly can be done for all the different data types

    println("The integer value of char A = $integerValueOfA")

    //We can use underscores to make number constants more readable:
    val creditCardNumber = 1234_5678_9012_3456L
    println("value of credit card number = $creditCardNumber")


    // Arrays Data Structure
    // You can store multiple types in arrays

    var arrayOfMultipleTypes = arrayOf(10, 20.23, "Yash")

    // We can access values using indexes starting at 0
    println("Accessing the element of an array at index 1 = $arrayOfMultipleTypes[1]")

    // We can change the value
    arrayOfMultipleTypes[1] = 3.14
    println("Value at index 1 after changing it is $arrayOfMultipleTypes[1]")

    // Elements in array
    println("Array Length : ${arrayOfMultipleTypes.size}")

    // Get first 2 elements in array as an array
    var partArray = arrayOfMultipleTypes.copyOfRange(0, 1)

    // Get the first element
    println("First : ${partArray.first()}")

    // Create an array of squares
    var arrayOfSquares = Array(10, { x -> x * x })
    println(arrayOfSquares[4])

    // There are type specific arrays
    var typeSpecificArray: Array<Int> = arrayOf(1, 2, 3, 4, 5)
    println(typeSpecificArray[2])


    //Ranges Data Structure
    // You define ranges by providing a starting and ending
    // value

    val oneTo10 = 1..30
    val alpha = "A".."Z"

    // Use in to search a Range
    println("R is present in alpha : ${"R" in alpha}")

    // Create ranges that goes from one value down till the specified value
    val tenTo1 = 10.downTo(1)

    // Create ranges that goes from one value up till the specified value
    val twoTo20 = 2.rangeTo(20)

    // Step through an array while adding 2
    val stepWithAdding2 = oneTo10.step(2)

    // Cycle through a range and print
    for (x in stepWithAdding2) println("step  through array adding 2 : $x")

    // Reverse a range
    for (x in tenTo1.reversed()) println("Reverse of a range: $x")

}
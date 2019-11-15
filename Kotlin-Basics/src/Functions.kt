fun main() {
    //functions are declared using fun keyword
    //Function parameters are defined using Pascal notation, i.e. name: type.
    //Parameters are separated using commas.
    //Each parameter must be explicitly typed
    fun multiplyBy2(value: Int): Int {
        return 2 * value
    }

    //calling a function
    val double = multiplyBy2(10)
    println("10 * 2 = $double")

    //Default arguments
    //A default value can be assigned to a parameter in case that only a single parameter is passed.
    fun addition(firstValue: Int, secondValue: Int = 0): Int {
        return firstValue + secondValue
    }

    //function addition is called with only a single parameter
    println("Addition of two numbers with default parameters = ${addition(1)}")

    //Kotlin does not have the concept of void as return type, so we use the return type as Unit
    fun printHello(name: String?): Unit {
        if (name != null)
            println("Hello $name")
        else
            println("Hi there!")
        // `return Unit` or `return` is optional
    }

    printHello("yash")

    //When a function returns a single expression, the curly braces can be omitted, and the body is specified after a = symbol
    fun double(x: Int): Int = x * 2

    println("The double of 2 is ${double(2)}")

    //Functions marked with the infix keyword can also be called using the infix notation (omitting the dot and the parentheses for the call).

    //They must be member functions or extension functions;
    //They must have a single parameter;
    //The parameter must not accept variable number of arguments and must have no default value.

    infix fun Int.ifx(x: Int): Int {
        return addition(x, 10)
    }

    println(1 ifx 10)


}
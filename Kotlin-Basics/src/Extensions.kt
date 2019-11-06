//Extensions are used to extend a class with new functionality without having to inherit from the class
fun main(args: Array<String>) {
    //Extension Functions

    //Adding a functionality in already present List class
    //To declare an extension function, we need to prefix its name with a receiver type,
    // i.e. the type being extended or the class name.

    fun <T> List<T>.midElement(): T {
        if (isEmpty())
            throw NoSuchElementException("List is empty.")
        return this[size / 2]
    }
    //to call this method
    var list = listOf(1, 2, 3, 4, 5)
    println("the middle element of list $list is ${list.midElement()}")
    //or
    var arrayList = arrayListOf(5, 4, 3, 2, 1)
    println("The middle element of ArrayList $arrayList is ${arrayList.midElement()}")

    //Another example
    val greet = "Hello"

    fun String.shout() = toUpperCase()

    fun String.greet(name: String) {
        //The string that called the method can be accessed using the keyword this

        println("$this $name")
    }

    println(greet.shout())
    greet.greet("Yash")

    //Extension Properties

    var listWithExtendedProp = listOf(1, 3, 5, 6, 7)

}


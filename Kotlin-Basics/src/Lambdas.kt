fun main() {

    //Structure of a lambda
    //{(parameter list ) -> body}
    val listOfNumbers = 1..4

    //external iterator
//    for (number in listOfNumbers) {
//        println(number)
//    }

    //internal iterators
    listOfNumbers.forEach { println(it * 2) }
    //using method reference
    listOfNumbers.forEach(::println)

    //storing lambda into a variable
    val printIt = { number: Int -> println(number) }

    printIt(0)

    //Lambda with Higher Order Function
    fun compute(n: Int, action: (Double) -> Unit) {
        action(n * 5.1)
    }

    //multiple syntax
    //normal cases
    compute(10, { result -> println(result) })

    //In case lambda is the last parameter
    compute(15) { result -> println(result) }

    //Filter
    println(listOfNumbers.filter { it % 2 == 0 })

    //Map and Reduce
    println(listOfNumbers.map { it * 5 }.sum())

    //Flattening
    val nestedList = listOf(listOf(1, 3, 5, 7), listOf(2, 4, 6, 8))
    val flattenedList = nestedList.flatten()
    println(flattenedList.size)
    println(flattenedList.sorted())
}
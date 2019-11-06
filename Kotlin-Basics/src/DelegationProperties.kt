fun main() {

    //In this case the temp is being calculated even though there may be a chance that temp may not be needed
    val temp = compute(7)

    //To fix the above case we use lazy
    //lazy properties: the value gets computed only upon first access;
    val tempLazy by lazy { compute(10) }

    if (Math.random() > 0.5) {
        println(temp)
        println(tempLazy)
    } else {
        println("No need to print temp")
    }
}

fun compute(n: Int): Int {
    println("compute method called")
    return n * n
}


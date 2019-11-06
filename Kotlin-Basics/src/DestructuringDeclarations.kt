import java.util.*

//A destructuring declaration creates multiple variables at once.
fun main() {

    //Created an Object of a Data Class Person
    val person = Person("yash", 75, 165)

    //Destructuring the person object into fields
    //The fields can then directly be used
    //The variable names do not need to be same as that defined inside the class
    val (name, weight, length) = person

    /*A destructuring declaration is compiled down to the following code:
        val name = person.component1()
        val weight = person.component2()
        val length = person.component3()*/
    println("$name has weight $weight and height $length")

    //Returning multiple Values from a Function
    data class Result(val result: Int, val status: String)

    fun function(result: Int, status: String): Result {
        // computations

        return Result(result, status)
    }

    // Now, to use this function:
    val (result, status) = function(90, "Passed")
    println("The result of the student $result% and student $status")

    //In cases, we need to use only 2nd value
    val (_, res) = function(10, "Failed")
    println("The student $res")

    //In case of collections
    val vehicleMap = HashMap<String, String>()
    vehicleMap["Name"] = "Suzuki"
    vehicleMap["Power"] = "220"
    vehicleMap["Type"] = "2-wheeler"
    vehicleMap["Price"] = "85000"

    vehicleMap.mapValues { (_, value): Map.Entry<String, String> -> println("value = $value") }

    vehicleMap.mapValues { entry -> println("entry = $entry") }
}
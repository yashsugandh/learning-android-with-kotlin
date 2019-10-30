fun main(args: Array<String>) {

    //creating an object of class Person
    var person = Person("pratik", 10, 20)

    //calling a function of class Person
    person.getInfo()

    //The below variable declaration will throw ava.lang.IllegalArgumentException as name field cannot contain a digit
    //    var person2 = Person("2",20,20)

    var student = Student("yash", 1)
    student.getInfo()

    //creating an object and calling a function for that object
    Student("yasham", 2).getInfo()

}
//---------Classes-------------

// There are no static methods
// Classes are final by default unless marked open
// The fields must also be marked as open

//Declaration of classes

//Two parts className and classHeader
class Data { /*...*/ }

//If body is empty classHeader can be omited
class Data2

//------Constructors------

//Two type of constructors primary and secondary

//Single primary constructor and multiple secondary constructors

//-----Primary constructor------

//using constructor keyword explicitly
class Customer constructor(customerName: String) { /*...*/ }

//If the primary constructor does not have any annotations or visibility modifiers, the constructor keyword can be omitted
class Customer1(customerName: String) {/*...*/ }

//The primary constructor cannot contain any code.
// Initialization code can be placed in initializer blocks, which are prefixed with the init keyword.

class Person(val name: String, var weight: Long, var height: Long) {
    init {

        // Regex that matches for a number any place
        // in a string
        val regex = Regex(".*\\d+.*")

        // If these requirements aren't met an
        // IllegalArgumentException is thrown
        require(!name.matches(regex)) { "Person Name can't Contain Numbers" }

        require(height > 0) { "Height must be greater then 0" }

        require(weight > 0) { "Weight must be greater then 0" }
    }

    fun getInfo(): Unit {
        println("$name has weight $weight and has height $height")
    }

}

//--------Secondary Constructor-------
//Initializing variables using a secondary constructors
class Student {

    private val name: String
    private var rollNumber: Long

    constructor(studentName: String, rollNumber: Long) {
        name = studentName
        this.rollNumber = rollNumber
    }

    fun getInfo(): Unit {
        println("$name has roll number $rollNumber")
    }

}


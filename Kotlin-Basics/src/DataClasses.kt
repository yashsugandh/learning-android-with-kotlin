fun main() {
    //Data classes provides you with the following
    // equals()/hashCode() pair;
    // toString() of the form "User(name=John, age=42)";
    //componentN() functions corresponding to the properties in their order of declaration;
    // copy() function

    data class User(val name: String, val age: Int)

    val user = User("Yash", 23)

    //The println uses the auto-generated toString function
    println(user)

    //Following conditions must be satisfied by a dataClass

    /*
    The primary constructor needs to have at least one parameter;
    All primary constructor parameters need to be marked as val or var;
    Data classes cannot be abstract, open, sealed or inner;
     */


    //Properties Declared in the Class Body

    //compiler only uses the properties defined inside the primary constructor for the automatically generated functions
    //To exclude a property from auto-generation we can define it inside the class body
    data class Person(val name: String) {
        var age: Int = 0
    }

    val person = Person("Yash")

    //The property defined inside the primary contructor will only be used in auto-generated toString() function
    println(person)
}
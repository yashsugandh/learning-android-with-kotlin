fun main(args: Array<String>) {

}

//All classes in Kotlin have a common superclass Any
//Any is the default superclass for a class with no supertypes declared
//Similar to Object class in Java


//Any has three methods: equals(), hashCode() and toString().

//To declare an explicit
//open represents that the class Base is open for extension
//By default all the classes in Kotlin are final
open class Base(p: Int)

//Place the type after the colon
//If the derived class has a primary constructor then the base class must be initialized there
class Derived(p: Int) : Base(p)

//If the derived class does not have a primary constructor then each secondary constructor must initialize the base class using the keyword super
class Derived2 : Base {
    var data: Int

    constructor(p: Int, data: Int) : super(p) {
        this.data = data
    }

    constructor(p: Int) : super(p) {
        this.data = 0
    }
}

//Kotlin requires explicit modifiers for overridable members (we call them open) :

open class Animal {
    open fun speak() { /*...*/
    }

    fun walk() { /*...*/
    }
}

class Dog() : Animal() {
    override fun speak() {/*...*/
    }
}

class Cat() : Animal() {
    //to prohibit re-overriding we use final
    final override fun speak() {/*...*/
    }
}

//------------Override Properties------------------
//similar to overriding methods
//Each declared property can be overridden by a property with an initializer or by a property with a get method.

open class Shape {
    open val vertexCount: Int = 0
}

class Rectangle : Shape() {
    override val vertexCount = 4 //Always has 4 vertices
}

//You can override val property with var but not vice-versa
//Val property declares only a get method but overriding it to var declares a set method.

class Polygon : Shape() {
    override var vertexCount: Int = 0  // Can be set to any number later
}

//Class Initialization Order
//During the derived class initialization the base class is initialized first
//the properties declared or overridden in the derived class are not yet initialized.
//So we should avoid using open members in the constructors, property initializer, and init blocks.

//-----------Calling the superclass Impl-----------
open class Alphabet {
    open fun draw() { println("Drawing an alphabet") }
    val borderColor: String get() = "black"
}

class A : Alphabet() {
    override fun draw() {
        super.draw()
        println("Drawing an A")
    }

    val fillColor: String get() = super.borderColor
}

//Super usage for inner class
class B : Alphabet(){
    override fun draw() {
        super.draw()
    }

    inner class Converter {
        fun drawAndConvert() {
            super@B.draw() // Calls Alphabet's implementation of draw()
            println("Drawn alphabet b ${super@B.borderColor}") // Uses Alphabet's implementation of borderColor's get()
        }
    }
}

//Overriding Rules
//if a class inherits multiple implementations of the same member from its immediate superclasses,
// it must override this member and provide its own implementation
open class Numbers {
    open fun draw() { /* ... */ }
}

interface Integers {
    fun draw() { /* ... */ } // interface members are 'open' by default
}

class One() : Numbers(), Integers {
    // The compiler requires draw() to be overridden:
    override fun draw() {
        super<Numbers>.draw() // call to Numbers.draw()
        super<Integers>.draw() // call to Integers.draw()
    }
}

//Abstract Classes
abstract class Decimal : Numbers() {
    abstract override fun draw()//open by default
}
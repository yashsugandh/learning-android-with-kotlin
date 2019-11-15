interface BaseClass {
    fun print()
}

class BaseImpl(val x: Int) : BaseClass {
    override fun print() {
        print(x)
    }
}

//A class Derived can implement an interface Base
//by delegating all of its public members to a specified object:
class DerivedClass(baseImpl: BaseClass) : BaseClass by baseImpl

//The by-clause in the supertype list for Derived indicates that b will be stored internally in
// objects of Derived, and the compiler will generate all the methods of Base that forward to b.
fun main() {
    //An object of class BaseImpl is created
    val baseImpl = BaseImpl(10)
    //baseImpl is used to initialize the derivedClass
    DerivedClass(baseImpl).print()
}
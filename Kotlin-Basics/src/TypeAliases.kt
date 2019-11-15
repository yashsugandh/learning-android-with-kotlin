//Type aliases provide alternative names for existing types.
//If the type name is too long you can introduce a different shorter name and use the new one instead.
typealias UserName = String

typealias Password = String
typealias PasswordHash = String
typealias HashFunction = (Password) -> PasswordHash
typealias CredentialsBuilder = (UserName, Password) -> Credentials

data class Credentials(val username: UserName, val passwordHash: PasswordHash)

fun main() {
    var credential = Credentials("yash", "abcd")


    val (userName, password) = credential
    println("The username $userName has password $password")

    //Higher-order functions with type aliases
    //The function hashingCredentialsBuilder is a higher-order function,
    //one which takes a function as its input and returns a function as its output; its purpose is to “promote” a HashFunction to a CredentialsBuilder.
    fun hashingCredentialsBuilder(hashFunction: HashFunction): CredentialsBuilder = { username, password ->
        Credentials(username, hashFunction(password))
    }

    val md5Credentials = hashingCredentialsBuilder { password ->
        // implementation goes here
        password
    }

    val credentials = md5Credentials(userName, password)

    println(credentials)
}
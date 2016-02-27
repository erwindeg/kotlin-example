fun main(args: Array<String>) : Unit {
	val total = { x: Int, y: Int -> x + y}
	println(total(1,2));
	println("Hello, World")
	
	val list = listOf(-2,-1,0,1,2)
	list.filter { it > 0 }.forEach { println(it) }
	closure()
	types()
	val sum = ::calculateTotal
	println(sum(2,2)) //prints 4
}

fun closure() {
	val list = listOf(-2,-1,0,1,2)
	var total = 0;
	list.filter { it > 0 }.forEach { 
		total += it
	}
	println(total) //prints 3
}

fun types() {
	val s = "ABC"
	var i = 1
	var i2: Int = 1
	if(i is Int){
		println("i is of type Int")
	}
	var text: String? = null
	println(text?.length)
	createPerson(lastName = "lastname", height = 1.82)
	whenExample(1);
}

fun createPerson(firstName: String = "", lastName: String = "", street: String = "", number: Int = 0, height: Double = 0.0) {
	
}

fun whenExample(x : Int){
	val result = when(x) {
		getValue(x) -> print("getValue")
		0,1 -> print("0 or 1")
		else -> print("else")
	}
	val y : Any = ""
	when(y) {
		is String -> print(y.length)
		is Int -> print(y)
		else -> print("else")
	}

}

data class Person(val firstName: String, val lastName: String)

fun getValue(x : Int) : Int {
	return 0
}

fun calculateTotal(x: Int, y: Int) = x + y //Example of an inline function, where the curly braces, return type and return statement can be ommitted.

fun String.allUpperCase() : Boolean {
		return this == this.toUpperCase()
}
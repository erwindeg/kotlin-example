import nl.edegier.RestBuilder.*

fun main(args: Array<String>) : Unit {
	createUserTestScript()
}

fun createUserTestScript() = 
testScript {
	post("/user/", params("email" to "erwin@edegier.nl","firstname" to "Erwin","lastname" to "de Gier")){
		expectedResult("OK")
	}
	get("/user/erwin"){
		expectedResult(params("email" to "erwin@edegier.nl","firstname" to "Erwin","lastname" to "de Gier"))
	}	
}
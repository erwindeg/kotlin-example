import nl.edegier.RestBuilder.*

fun main(args: Array<String>) : Unit {
	runScript()
}

fun runScript() = 
testScript {
	post("/user/"){
		params("email" to "erwin@edegier.nl","firstname" to "Erwin","lastname" to "de Gier")
	}
	get("/user/erwin"){
		params()
	}
	run()
}
package nl.edegier.RestBuilder;

enum class Method {
	GET,POST,PUT,DELETE
}

class TestScript {
	fun get(url: String, params: Map<String,String> = mapOf(), validate : RestCall.() -> Unit) : RestCall = restCall(Method.POST,url,params,validate)

	fun post(url: String, params: Map<String,String> = mapOf(), validate : RestCall.() ->  Unit ) : RestCall = restCall(Method.POST,url,params,validate)

	fun restCall(method : Method, url: String, params: Map<String,String> = mapOf(), validate : RestCall.() ->  Unit ) : RestCall {
		var call = RestCall(method,url,params)
		call.performCall()
		call.validate()
		return call
	}


	fun <K, V> params(vararg pairs: Pair<K, V>): Map<K, V> = mapOf(*pairs)

}

class RestCall(val method : Method, val url : String, val params :  Map<String,String> = mapOf<String,String>()) {
	var result : String = ""
	fun performCall() {
		//TODO: mock data from this call
		println("method: $method url: $url params: $params")
		result = "OK"
	}

	fun expectedResult(expected : String) {
		if(expected == this.result)
			println("test passed with result: $result")
			else
			println("test failed, expected: $expected, actual: $result ")
	}
}

fun testScript(init : TestScript.() -> Unit ) : TestScript {
	val testScript = TestScript()
	testScript.init();
	return testScript;
}

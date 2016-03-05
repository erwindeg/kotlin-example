package nl.edegier.RestBuilder;

enum class Method {
	GET,POST,PUT,DELETE
}

class TestScript {
	fun get(url: String, params: Map<String,String> = mapOf(), validate : RestCall.() -> Unit) : RestCall = restCall(Method.GET,url,params,validate)

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
	var result : Any = ""
	fun performCall() {
		when(method) {
			Method.GET -> this.result = MockRestClient.get(url,params)
			Method.POST -> this.result = MockRestClient.post(url,params) 
		}
		
	}

	fun expectedResult(expected : String) {
		if(expected == this.result)
			println("test passed with result: $result")
			else
			println("test failed, expected: $expected, actual: $result ")
	}
	
	fun expectedResult(expected : Map<String,String>) {
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


object MockRestClient{
	var params : Map<String,String> = mapOf()
	
	fun get(url : String ,params : Map<String,String>) : Map<String,String> {
		println("method: get url: $url params: $params")
		return params
	}
	
	fun post(url : String ,params : Map<String,String>) : String{
		println("method: post url: $url params: $params")
		this.params=params
		return "OK"
	}
}

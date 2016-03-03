package nl.edegier.RestBuilder;

class TestScript {
	var calls = arrayListOf<RestCall>()

	fun get(url: String, init : RestCall.() -> Map<String,String> ) : RestCall {
		var get = RestCall(url)
		get.params = get.init();
		calls.add(get)
		return get
	}

	fun post(url: String, init : RestCall.() ->  Map<String,String> ) : RestCall {
		var post = RestCall(url)
		post.params = post.init();
		calls.add(post)
		return post
	}
	fun run() {
		for(call in calls) {
			call.performCall()
		}
	}

	fun <K, V> params(vararg pairs: Pair<K, V>): Map<K, V> = mapOf(*pairs)
}

class RestCall(val url : String) {
	public var params :  Map<String,String> = mapOf<String,String>()
	fun performCall() : String {
		println("url: $url params: $params")
		return "result"
	}
}





fun testScript(init : TestScript.() -> Unit ) : TestScript {
	val testScript = TestScript()
	testScript.init();
	return testScript;
}

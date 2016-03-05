package nl.edegier.helloworld
import org.junit.Assert.*;

import org.junit.Test;


class KotlinTest {

	@Test
	fun testGreeting(){
		assertEquals("hello world",JavaGreeting().sayHello())
		assertEquals("hello world",KotlinGreeting().sayHello())
	}
}

package nl.edegier.helloworld;

import static org.junit.Assert.*;

import org.junit.Test;

public class JavaTest {

	@Test
	public void testHello(){
		assertEquals("hello world",new JavaGreeting().sayHello());
		assertEquals("hello world",new KotlinGreeting().sayHello());
	}
}

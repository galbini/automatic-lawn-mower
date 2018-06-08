package com.mowitnow.automaticlawnmower;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AppTest {
	
	@Test
	public void testOK() {
		
			App app = new App();
			assertEquals(Integer.valueOf(0), Integer.valueOf(app.run("src/test/data-test.txt")));
			
	}
	
	@Test
	public void testKO() {
		
			App app = new App();
			assertEquals(Integer.valueOf(1), Integer.valueOf(app.run("src/test/data-test-empty.txt")));
			
			
	}
	
}

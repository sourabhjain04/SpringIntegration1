package com.Example.JunitFirst;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class MyMathTest {

	
	MyMath myMath = new MyMath();
	
	
	@Test
	@Before
	public void before() {
		System.out.println("Before");
	}
	@Test
	@After
	public void after() {
		System.out.println("After");
		
	}
	
	@Test
	@BeforeClass
	public void beforeClass() {
		System.out.println("before Class");
	}
	
	@Test
	@AfterClass
	public void afterClass() {
		System.out.println("After Class");
	}
	
	@Test
	public void sum_with3numbers() {
		System.out.println("Test1");
		assertEquals(6, myMath.sum(new int[] {1,2,3}));
	}
	
	
	
	
}

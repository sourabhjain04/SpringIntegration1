package com.Example.JunitFirst;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalculatorTest {

	Calculator calculation = new Calculator();
	
	int sum = calculation.sum(5, 10);
	int testSum = 15;
	@Test
	public void testSum() {
		assertEquals(sum, testSum);
	}
}

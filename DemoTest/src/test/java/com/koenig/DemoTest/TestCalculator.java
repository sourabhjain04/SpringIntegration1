package com.koenig.DemoTest;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class TestCalculator  {

	Calculator c= null;
	
	CalculatorService service = Mockito.mock(CalculatorService.class);
	@Before
	public void setup()
	{
		c = new Calculator(service);
	}
	
	@Test
	public void testAdd()
	{
		when(service.add(2, 3)).thenReturn(5);// this is not the testing method so thats why giving this static values
		assertEquals(10, c.perform(2, 3));//this what we have to test
		verify(service).add(2, 3);
		
	}
}

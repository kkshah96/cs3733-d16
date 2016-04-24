package model;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

import junit.framework.TestCase;

public class TestReleaseSquare extends TestCase{
	ReleaseSquare ex;

	Color init;
	
	protected void setUp() {
		init = new Color(23);
		
		 ex = new ReleaseSquare(2,2, true, 4, init);
		
	}
	
	@Test
	public void testSetNumber() {
		
		assertTrue(ex.setNumber(6));
		assertFalse(ex.setNumber(0));
		assertFalse(ex.setNumber(7));
		
		assertEquals(6, ex.getNumber());
		
	}
	
	public void testSetColor() {
		Color color = new Color(45);
		assertTrue(ex.setNumberColor(color));
		
		
	}
}
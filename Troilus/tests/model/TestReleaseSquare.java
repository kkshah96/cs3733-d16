package model;

import java.awt.Color;

import org.junit.Test;

import junit.framework.TestCase;

public class TestReleaseSquare extends TestCase{
	ReleaseSquare rSquare;
	Color color;

	protected void setUp() {
		color = new Color(23);
		rSquare = new ReleaseSquare(2,2, true, 4, color);
	}

	@Test
	public void testSetNumber() {
		assertTrue(rSquare.setNumber(6));
		assertFalse(rSquare.setNumber(-1));
		assertFalse(rSquare.setNumber(7));

		assertEquals(6, rSquare.getNumber());
	}

	public void testSetColor() {
		assertEquals(color, rSquare.getNumberColor());
		
		Color color1 = new Color(45);
		assertTrue(rSquare.setNumberColor(color1));
		
		Color color2 = Color.RED;
		assertTrue(rSquare.setNumberColor(color2));
	}
}
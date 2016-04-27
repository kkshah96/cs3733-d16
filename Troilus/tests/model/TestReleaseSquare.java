package model;

import java.awt.Color;

import org.junit.Test;

import junit.framework.TestCase;

public class TestReleaseSquare extends TestCase {
	ReleaseSquare rSquare;
	Color color;

	protected void setUp() {
		color = new Color(23);
		rSquare = new ReleaseSquare(2, 2, true, 4, color);
	}
	
	public void testDefaults() {
		ReleaseSquare rSquare2 = new ReleaseSquare(5, 4, false);
		
		assertEquals(0, rSquare2.getNumber());
		assertEquals(null, rSquare2.getNumberColor());
		assertFalse(rSquare2.isValid());
	}

	@Test
	public void testSetNumber() {
		assertTrue(rSquare.setNumber(6));
		assertFalse(rSquare.setNumber(-1));
		assertFalse(rSquare.setNumber(7));

		assertEquals(6, rSquare.getNumber());
		
		assertTrue(rSquare.setNumber(0));
		
		assertEquals(0, rSquare.getNumber());
	}

	public void testSetColor() {
		assertEquals(color, rSquare.getNumberColor());
		
		Color color1 = new Color(45);
		assertTrue(rSquare.setNumberColor(color1));
		
		Color color2 = Color.RED;
		assertTrue(rSquare.setNumberColor(color2));
		
		assertEquals(color2, rSquare.getNumberColor());
	}
	
	public void testToggle() {
		assertTrue(rSquare.setNumber(1));
		assertTrue(rSquare.setNumberColor(Color.BLUE));
		
		rSquare.setIsValid(false);
		
		assertEquals(1, rSquare.getNumber());
		assertEquals(Color.BLUE, rSquare.getNumberColor());
	}
}
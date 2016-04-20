package model;

// TODO: Shouldn't this be an interface now that we aren't storing anything?

/**
 * Class allows for consistent manipulation of square structure.
 * 
 * Allows for implementation of squares for Kabasuji. Pieces can be
 * valid and have a type.
 * 
 * @author Maddy
 *
 */
public abstract class Square {	
	public Square() {}
	
	// TODO: Does this have to be an abstract method?
	public abstract boolean isValid();
	
	public abstract String getType();
}
package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import model.Level;

/**
 * This class offers full file-reading for level files.
 * 
 * This controller will read through the master level file and obtain the level numbers selected by the builder.
 * From here, it will call our XMLInputController to retrieve the level information from the requested level.
 * Once this has finished, an ArrayList<Level> containing all levels is returned
 * @author Dan Alfred
 *
 */
public class LevelFileInputController {
	/** The path of our file save location */
	String path;
	
	/** LevelFileInputController constructor comment
	 * This constructor takes in a path to load the file fmor
	 */
	public LevelFileInputController(String path) {
		this.path = path;
	}
	/** LevelFileInputController constructor comment
	 * This constructor assumes default path
	 */
	public LevelFileInputController() {
		this.path = "";
	}
	
	/**
	 * Gathers collection of levels based on level storage files
	 * @return ArrayList<Level> of all requested levels
	 */
	public ArrayList<Level> getLevels() {
		// Create an empty ArrayList first, in case we have an error and can't read more
		ArrayList<Level> levels = new ArrayList<Level>();
		try {
			// Initialize our XML parsing classes
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbFactory.newDocumentBuilder();
			Document doc = db.parse(new File(path + "Levels.xml"));
			
			// Obtain the root element (holds our levels)
			Element rootLevelElement = doc.getDocumentElement();
			
			// Obtain the child level elements
			NodeList xmlLevels = rootLevelElement.getChildNodes();
			
			// Loop through the child elements to get their number
			for(int i = 0; i < xmlLevels.getLength(); i++) {
				// Obtain the level number from this child element
				Node newLevel = xmlLevels.item(i);
				NamedNodeMap newLevelAttrs = newLevel.getAttributes();
				int levelNum = Integer.parseInt(newLevelAttrs.getNamedItem("Number").getNodeValue());
				
				// Create a new XMLInputController with the level number
				LevelXMLInputController xmlReader = new LevelXMLInputController(levelNum);
				
				// Attempt to read it from file, and add it to the ArrayList
				Level level = xmlReader.readLevelFromFile();
				levels.add(level);
			}
		} catch(FileNotFoundException fnfe) {
			System.out.println("LevelNumber save file is missing!");
			fnfe.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		// Return the finalized ArrayList
		return levels;
	}
}
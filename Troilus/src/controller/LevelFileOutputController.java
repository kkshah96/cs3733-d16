package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import model.Level;
import model.LevelBuilder;

/** 
 * Controller handles writing level master file and <= 15 level files.
 * 
 * This class handles writing all levels to file. It starts by selecting the first 15 level files (or all if <15)
 * and updating the master file to contain the level number. After this, it passes the Level to the XMLOutputController
 * to store the level to file properly
 * @author Dan Alfred
 *
 */

public class LevelFileOutputController {
	/** LevelBuilder object we will retrieve our levels from */
	LevelBuilder lb;
	
	/** Path for our file saves, if not default */
	String path;
	
	/**
	 * Constructor for LevelFileOutputController specifying path
	 * @param lb LevelBuilder object to pull data from
	 * @param path Path string to use when storing file
	 */
	public LevelFileOutputController(LevelBuilder lb, String path) {
		this.lb = lb;
		this.path = path;
		storeMasterFile();
	}
	
	/**
	 * Constructor for LevelFileOutputController with default path
	 * @param lb
	 */
	public LevelFileOutputController(LevelBuilder lb) {
		this.lb = lb;
		this.path = "";
		storeMasterFile();
	}
	
	/**
	 * Writes master file and calls child controller to store levels
	 */
	void storeMasterFile() {
		try {
			// Create the master file, and overwrite it if needed
			File masterFile = new File(path + "Levels.xml");
			masterFile.createNewFile();
			ArrayList<Level> levels = lb.getLevels();
			
			// Add the first 15 levels, or all levels if fewer than 15 exist
			int maxLevels = min(15, levels.size());
			
			// Create our XML Writing objects
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbFactory.newDocumentBuilder();
			Document doc = db.newDocument();
			
			// Create root Levels
			Element rootLevelElement = doc.createElement("Levels");
			
			// Loop through our levels, and create a new level child class with the attribute
			// of the level ID
			for(int i = 0; i < maxLevels; i++) {
				// Create our next level tag in XML
				Element levelElement = doc.createElement("Level");
				
				// Set the level number property from the corresponding level in LevelBuilder
				levelElement.setAttribute("Number", "" + levels.get(i).getLevelNum());
				
				// Now write that level to its file and append the new XML level tag to master file
				LevelXMLOutputController xmlWriter = new LevelXMLOutputController(levels.get(i));
				rootLevelElement.appendChild(levelElement);
			}
		} catch(IOException ioe) {
			System.err.println("File cannot be overwritten!");
			ioe.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Returns the minimum of two ints, or b if they're equal
	 * @param a First int
	 * @param b Second int
	 * @return The minimum of two ints, or b if they're equal
	 */
	int min(int a, int b) {
		if(a < b) {
			return a;
		} else {
			return b;
		}
	}
}
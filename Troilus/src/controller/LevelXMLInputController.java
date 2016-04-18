package controller;

import java.awt.Color;
import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import model.Board;
import model.Bullpen;
import model.Level;
import model.LightningLevel;
import model.LightningSquare;
import model.Piece;
import model.PieceFactory;
import model.PuzzleLevel;
import model.PuzzleSquare;
import model.ReleaseLevel;
import model.ReleaseSquare;
import model.Square;

public class LevelXMLInputController {
	String path;
	
	LevelXMLInputController(String path) {
		this.path = path;
	}
	
	LevelXMLInputController() {
		this.path = "";
	}
	
	Level readLevelFromFile() {
		Level level = null;
		Bullpen bullpen = new Bullpen();
		Board board = null;
		
		try {
			// Create a new document from the builder
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbFactory.newDocumentBuilder();
			Document doc = db.parse(new File("LevelXML.xml"));
			
			Element rootLevelElement = doc.getDocumentElement();
			String levelType = rootLevelElement.getAttribute("Type");
			int levelNumber = Integer.parseInt(rootLevelElement.getAttribute("Number"));
			boolean levelLocked = Boolean.parseBoolean(rootLevelElement.getAttribute("Locked"));
			int levelProgress = Integer.parseInt(rootLevelElement.getAttribute("Progress"));			
			
			NodeList levelNodes = rootLevelElement.getChildNodes();
			
			for(int a = 0; a < levelNodes.getLength(); a++) {
				if(levelNodes.item(a).getNodeName().equals("Bullpen")) {
					NodeList pieceList = levelNodes.item(a).getChildNodes();
					for(int i = 0; i < pieceList.getLength(); i++) {
						Node pieceNode = pieceList.item(i);
						NamedNodeMap pieceAttributes = pieceNode.getAttributes();
						
						int pieceType = 0;
						for(int j = 0; j < pieceAttributes.getLength(); j++) {
							pieceType = Integer.parseInt(pieceAttributes.item(j).getNodeValue());
						}
						
						Piece piece = PieceFactory.getPiece(0, i, pieceType);
						
						bullpen.addPiece(piece);
					}
					
				} else if(levelNodes.item(a).getNodeName().equals("Board")) {
					NodeList rowList = levelNodes.item(a).getChildNodes();
					Square[][] squares = new Square[Board.BOARD_HEIGHT][Board.BOARD_WIDTH];
					
					for(int j = 0; j < rowList.getLength(); j++) {
						Node row = rowList.item(j);
						NodeList squareList = row.getChildNodes();
						
						for(int k = 0; k < squareList.getLength(); k++) {
							String squareType = squareList.item(k).getNodeName();
							Square square = null;
							
							if(squareType.equals("ReleaseSquare")) {
								NamedNodeMap rsAttributes = squareList.item(k).getAttributes();
								int number = Integer.parseInt(rsAttributes.getNamedItem("Number").getNodeValue());
								String color = rsAttributes.getNamedItem("Color").getNodeValue();
								square = new ReleaseSquare(number, Color.getColor(color));
							} else if(squareType.equals("LightningSquare")) {
								square = new LightningSquare();
							} else if(squareType.equals("PuzzleSquare")) {
								square = new PuzzleSquare();
							}
							
							squares[j][k] = square;
						}
					}
					
					board = new Board(squares);
				}
			}
			
			if (levelType.equals("Release")) {
				level = new ReleaseLevel(levelNumber, levelLocked, bullpen, board, null);
			} else if(levelType.equals("Lightning")) {
				int levelTime = Integer.parseInt(rootLevelElement.getAttribute("Time"));
				level = new LightningLevel(levelNumber, levelLocked, bullpen, board, null, levelTime);
			} else if(levelType.equals("Puzzle")) {
				int maxMoves = Integer.parseInt(rootLevelElement.getAttribute("MaxMoves"));
				level = new PuzzleLevel(levelNumber, levelLocked, bullpen, board, null, maxMoves);
			}
			level.setNumStars(levelProgress);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return level;
	}
}
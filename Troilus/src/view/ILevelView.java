package view;

/**
 * Provides a way to abstract over LevelViews for code reuse.
 * Current implementations of this are LevelEditorView and LevelPlayerView
 * @author
 */
public interface ILevelView {
	/**
	 * Determines the BoardView boundary object
	 * @return Reference to the enclosed BoardView
	 */
	public BoardView getBoardView();
	
	/**
	 * Determines the BullpenView boundary object
	 * @return Reference to the enclosed BullpenView
	 */
	public BullpenView getBullpenView();
	
	/**
	 * Refreshes and updates the level view
	 */
	public void refresh();
}
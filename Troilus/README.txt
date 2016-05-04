Included in the Troilus project is the implementation of the Kabasuji and Level Builder applications, both of which can be found in the package "main." The applications are launched by running StartKabasuji and StartLevelBuilder, respectively.  In this project, you will also find a “CS 3733 Code Coverage Data” PDF, containing the code coverage data and graph requested.

Controls for Level Builder:
In the Level Loader
Click a level to edit it
Shift-click a level to delete it
Click the “Create New” Level buttons to create and edit a new level of that type
In the Level Editor:
Click on a piece in the palette to move one instance of that piece to the bullpen
Right click on a piece in the bullpen to remove it from the bullpen
Click on a piece in the bullpen to select that piece.
Click the rotate/flip buttons to rotate the currently selected piece if it is in the bullpen
After selecting a piece, click on the board to place it (if the placement is valid)
Click a piece on the board to select that piece and drag it
Click on the board while dragging a piece to place it in a new position on the board
Right click while dragging a piece to return it to its previous location
Click a square on the board to select/deselect it
Click the Toggle button to toggle the validity of the selected square on the board
Click the Hint button to toggle the hint status of the selected square on the board
Click the Undo button to undo the last change
Click the Redo button to redo the last undone change
NOTE: On all following text fields, the enter key must be pressed for the changes to take effect.
Clicking the Set button next to the board dimensions fields sets the board dimensions to the user specified values.  Note that this cannot be undone
In a puzzle level, hitting enter in the set max moves text field sets the maximum moves
In a lightning level, hitting enter after editing the minutes or seconds text fields will set the time limit
In a release level, selecting a square and selecting both the number and color fields will assign that number and color to the selected square
Clicking the Save button saves the current level to file.
NOTE: The Level Builder will only save the first 25 levels
Clicking the “Level Loader” button brings the user back to the level loader screen without saving the current level.
NOTE: Clicking the red X exits the level editor without saving the level


Controls for Kabasuji
In the level selector
Clicking on a level that is not greyed out take the player into the level player
Clicking on a greyed out level has no effect, as these levels are locked
In the level player
All of the same controls apply from the level builder regarding moving pieces, with the exception of moving a piece from the palette to the bullpen and removing a piece from the bullpen, as no palette exists in the player
Note that pieces may not be moved once on the board in lightning and release levels
All rotating and flipping controls are the same as the level builder.
No undo or redo controls exist in the player.
Clicking the “Exit Level” button brings the player back to the level selector screen and saves the current number of stars
Exiting out of the player through the red X does not save the level progress
Once the user gets 3 stars, the level automatically exits
NOTE: Only the first 27 levels are loaded
NOTE: Pictures containing solutions to the non-lightning levels are also submitted in case the player gets stuck

To achieve Builder Concrete Scenario:
1. Run StartLevelBuilder
2. Click on "New Puzzle Level" button
3. Enter 6 and 6 for board size, then click "Set" button
4. Enter 10 in "Max Moves" and press Enter
   (no "set" button, so it may not actually set - easy fix but low priority)
5. Click on the "6x1" piece in the palette 6 times
6. Click on one of the pieces, drag it to the board,
   and click on the board to place
7. The piece is removed from the bullpen once placed
8. Hit "Save" button
9. Click the red X (twice)
10. Run StartLevelBuilder
11. Click on the button to load the level
12. Enter 8 in Max Moves and press Enter
13. Hit "Save"
14. Click "Level Loader"
15. Click on "New Lightning Level"
16. Click on the "6x1" piece 6 times
17. Type 30 in the seconds field, then press "Set"
18. Click the red X twice

GamePlayer Concrete Scenario:
1. Run StartKabasuji
2. Click the button for the first level
3. Moves displayed should be 8/8
4-end. Click on a piece and move it to the board. Repeat.
17. Click the red X (twice)

Lightning Play Concrete Scenario:
1. Run StartKabasuji
2. Click the button for the second level
Play normally
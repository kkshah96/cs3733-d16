Included in the Troilus project is an initial implementation of the Kabasuji and Level Builder applications,
both of which can be found in the package "main." The applications are launched by running StartKabasuji
and StartLevelBuilder, respectively.

/** NOTE: For debugging purposes, we have made all levels accessible from the
Level Selector. We can easily change this, but have decided not to for now. */
/** ANOTHER NOTE: Honestly, we didn't focus at all on Lightning Level, so it
doesn't actually work correctly at the moment. However, we know what steps to
take to get it working; it's just a matter of writing the code. */

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
Simple Snake Game (LLD Example)

Files in Src:
- Main.java - starts the Swing window and the game panel
- GamePanel.java - game loop, rendering, controls
- Direction.java - enum for movement directions
- Point.java - small x/y pair with equals/hashCode

How to compile and run (macOS, zsh):

cd "5. LLD Exampes/3. Snakes_game"
javac -d bin Src/*.java
java -cp bin Main

Controls:
- Arrow keys to move
- Space to start/restart

Notes:
- Uses Swing, no external dependencies
- Tile/grid size and speed are configurable in `GamePanel.java`

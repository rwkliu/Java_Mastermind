/* 
 * The Game class contains a Game object's game state and the methods for printing the game start
 * message and play method. The play method implements the Play interface. 
 */ 
public class Game implements Play {
  private boolean gameIsRunning;

  public Game() {
    this.gameIsRunning = true;
  }
  
  public Game(boolean runningGameState) {
    this.gameIsRunning = runningGameState;
  }

  public void setGameState(boolean newGameState) {
    this.gameIsRunning = newGameState;
  }

  public boolean getGameState() {
    return gameIsRunning;
  }

  public static void startGameMessage(String startMessage) {
    System.out.println(startMessage);
  }

  public void play() {
    Game.startGameMessage("Start the game!");
  }
}

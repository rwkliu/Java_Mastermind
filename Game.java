
public class Game implements Play {
  private boolean gameIsRunning;

  public Game() {
    this.gameIsRunning = true;
  }
  
  public Game(boolean runningGameState) {
    this.gameIsRunning = runningGameState;
  }

  public static void startGameMessage(String startMessage) {
    System.out.println(startMessage);
  }

  public void play() {
    System.out.println("Default play method");
  }
}

/*
 * The main class is the driver class for the Mastermind game. The main method instantiates a
 * Mastermind object and calls the play method to run the game.
 * 
 */ 
public class Main {
  public static void main(String[] args) {
    Mastermind mastermind = new Mastermind(args);
    mastermind.play();
  }
}

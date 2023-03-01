import java.util.Random;
import java.util.Scanner;

/* 
 * The Mastermind class inherits from the Game parent class. This class contains the code for 
 * running the Mastermind game, including initializing the game parameters and running the actions
 * for each round.
 */
public class Mastermind extends Game {
  private int attempts;
  private String secretCode;
  private Guess playerInput;

  public Mastermind() {
    this.attempts = 10;
    this.secretCode = generateCode();
    this.playerInput = new Guess();
  }

  public Mastermind(String[] args) {
    this.playerInput = new Guess();
    if (args.length < 1) {
      this.attempts = 10;
      this.secretCode = generateCode();
    } 
    if (args.length == 2 && args[0].equals("-c") && args[1].length() == 4) {
      this.secretCode = args[1];
      this.attempts = 10;
    } 
    if (args.length == 2 && args[0].equals("-t")) {
      this.attempts = Integer.parseInt(args[1]);
      this.secretCode = generateCode();
    }
    if (args.length >= 4 && args[0].equals("-c") && args[1].length() == 4 && args[2].equals("-t")) {
      this.secretCode = args[1];
      this.attempts = Integer.parseInt(args[3]);
    }
  }

  public String getCode() {
    return secretCode;
  }

  public int getAttempts() {
    return attempts;
  }

  public void setAttempts(int newAttempt) {
    this.attempts = newAttempt;
  }

  //Generate the 4 digit secret code using the Fisher-Yates algorithm
  public static String generateCode() {
    int nums[] = {0, 1, 2, 3, 4, 5, 6, 7, 8};
    int last_index = 8;
    Random random = new Random();
    String code = new String();
    for (int i = 0; i < 4; i++) {
      int rand_index = random.nextInt(100) % last_index;
      int temp = nums[last_index];

      nums[last_index] = nums[rand_index];
      nums[rand_index] = temp;
      code = code + String.valueOf(nums[last_index]);
      last_index--;
    }
    return code;
  }

  public void play() {
    int round = 0;
    Game.startGameMessage("Will you find the secret code?\nPlease enter a valid guess");
    Scanner input = new Scanner(System.in);
    while (getGameState() == true) {
      input.reset();
      System.out.println("---\nRound " + round);
      System.out.print(">");
      if (input.hasNext()) {
        playerInput.setPlayerGuess(input.next());
        if (!playerInput.validInput()) {
          System.out.println("Wrong input!");
        } else if (playerInput.matchSecretCode(secretCode)) {
          setGameState(false);
        } else {
          round++;
          if (round == attempts) {
            System.out.println("Game over. The secret code was " + secretCode);
            setGameState(false);
          }
        }
      }
      else {
        setGameState(false);
      }
    }
    input.close();
  }
}

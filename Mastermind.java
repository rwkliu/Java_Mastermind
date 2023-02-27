import java.util.Random;

public class Mastermind extends Game {
  private int attempts;
  private String secretCode;

  public Mastermind() {
    this.attempts = 10;
    this.secretCode = generateCode();
  }

  public Mastermind(int attempts, String secretCode) {
    if (attempts > 0 && secretCode != null) {
      this.attempts = attempts;
      this.secretCode = secretCode;
    } 
    if (attempts <= 0) {
      this.attempts = 10;
    }
    if (secretCode == null) {
      this.secretCode = generateCode();
    }
  }

  public Mastermind(String[] args) {
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
    System.out.println("Placeholder play message");
  }
}

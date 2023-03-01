public class Guess {
  private String playerGuess;

  public Guess() {
    this.playerGuess = null;
  }
  
  public String getPlayerGuess() {
    return this.playerGuess;
  }

  public void setPlayerGuess(String input) {
    this.playerGuess = input;
  }

  public boolean validInput() {
    if (playerGuess.length() != 4) {
      return false;
    }

    for (char c : playerGuess.toCharArray()) {
      if (c < '0' || c > '8') {
        return false;
      }
    }
    return true;
  }

  public boolean inSecretCode(char piece, String secretCode) {
    for (char c : secretCode.toCharArray()) {
      if (c == piece) {
        return true;
      }
    }
    return false;
  }

  public boolean matchSecretCode(String secretCode) {
    int misplaced = 0;
    int wellPlaced = 0;

    if (playerGuess.equals(secretCode)) {
      System.out.println("Congratz! You did it!");
      return true;
    } 
    for (int i = 0; i < 4; i++) {
      if (playerGuess.charAt(i) == secretCode.charAt(i)) {
        wellPlaced++;
      } else if (inSecretCode(playerGuess.charAt(i), secretCode)) {
        misplaced++;
      }
    }
    System.out.println("Well placed pieces: " + wellPlaced);
    System.out.println("Misplaced pieces: " + misplaced);
    return false;
  }
}

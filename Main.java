public class Main {
  public static void main(String[] args) {
    Mastermind mastermind = new Mastermind(args);
    System.out.println(mastermind.getCode());
    System.out.println(mastermind.getAttempts());
  }
}

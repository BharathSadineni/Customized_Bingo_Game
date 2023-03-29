import java.util.Scanner;
public class BingoRunner {
  Scanner sc = new Scanner(System.in);
  public static void main(String[] args) {
    /* TODO
          create and execute a new BingoController that starts the game
          invoke run()
          include the Thank you for playing once the game exits (GOODBYEMESSAGE)
     */
    BingoController sc = new BingoController();
    sc.run();
    System.out.printf("Thank you for playing%n");
  }
}

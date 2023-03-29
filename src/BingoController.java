import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class BingoController {
    private final String[] mainMenuItems = {"Exit",
            "Play bingo",
            "Set number separator",
            "Create a bingo card",
            "List existing cards",
            "Set bingo card size"};

    /* TODO
          complete constants attached to mainMenuItems
     */
    private final String OPTION_EXIT = "0";
    private final String OPTION_PLAY = "1";
    private final String OPTION_SEPARATOR = "2";
    private final String OPTION_CREATE_CARD = "3";
    private final String OPTION_LIST_CARDS = "4";
    private final String OPTION_SIZE = "5";

    /* TODO
          complete default size of rows / columns as specified in the Defaults class
          create an arraylist of BingoCard cards
          include getters and setters for row / column sizes
     */
    private int currentRowSize = 4;
    private int currentColumnSize = 4;


    /* TODO
          create an ArrayList of BingoCard cards
     */
    //implement code here
    ArrayList<BingoCard> BingoCard = new ArrayList<BingoCard>();

    /* TODO
          implement getters and setters for currentRowSize / currentColumnSize
     */
    public int getCurrentRowSize() {
        /* TODO
              change the return from 0 to the appropriate return
     */
        return currentRowSize;
    }

    public void setCurrentRowSize(int currentRowSize) {
        /* TODO
             implement code here
     */
        this.currentRowSize = currentRowSize;
    }

    public int getCurrentColumnSize() {
        /* TODO
              change the return from 0 to the appropriate return
     */
        return currentColumnSize;
    }

    public void setCurrentColumnSize(int currentColumnSize) {
        /* TODO
             implement code here
     */
        this.currentColumnSize = currentColumnSize;
    }

    /* TODO
          add a new BingoCard card
     */
    public void addNewCard(BingoCard card) {
        //implement code here
        BingoCard.add(card);
    }

    /* TODO
          include an appropriate message to the the number of rows as well as the number of columns
     */
    public void setSize() {
        setCurrentRowSize(parseInt(Toolkit.getInputForMessage(
                "Enter the number of rows for the card")));
        setCurrentColumnSize(parseInt(Toolkit.getInputForMessage(
                "Enter the number of columns for the card")));
        System.out.printf("The bingo card size is set to %d rows X %d columns%n",
                getCurrentRowSize(),
                getCurrentColumnSize());
    }

    /* TODO
           ensure that the correct amount of numbers are entered
           print a message that shows the numbers entered using Toolkit.printArray(numbers)
           create, setCardNumbers and add the card as a BingoCard
     */
    public void createCard() {
        /* TODO
              calculate how many numbers are required to be entered based on the number or rows / columns
         */
        int numbersRequired = currentColumnSize * currentRowSize;

        String[] numbers;
        boolean correctAmountOfNumbersEntered;

        do {
            numbers = Toolkit.getInputForMessage(
                            String.format(
                                    "Enter %d numbers for your card (separated by " + "'%s')", numbersRequired, Defaults.getNumberSeparator()))
                    .trim().split(Defaults.getNumberSeparator());
            /* TODO
              verify if the correctAmountOfNumbersEntered is true or false dependant on the numbersRequired calculation
         */
            correctAmountOfNumbersEntered = false;
            if (numbersRequired == numbers.length) {
                correctAmountOfNumbersEntered = true; //changes according to calculation inserted here
            } else
                System.out.printf("Try again: you entered " + numbers.length + " numbers instead of " + numbersRequired + " %n");
        } while (!correctAmountOfNumbersEntered);

        /* TODO
              verify whether the numbers entered is not correct by printing an appropriate message
              verify against the expected output files
         */
        //insert code here
        System.out.printf("You entered %n ");
        Toolkit.printArray(numbers);
        // /* TODO print an appropriate message using ToolKit.printArray() to show the numbers entered*/
        // /* TODO create new BingoCard
        BingoCard card2 = new BingoCard(getCurrentRowSize(), getCurrentColumnSize());
        //  */
        //
        // insert code here
        // /* TODO setCardNumbers for the new card
        card2.setCardNumbers(numbers);
        //  */
        // insert code here
        // /* TODO add the card to the ArrayList
        //  */
        // insert code here
        addNewCard(card2);
    }

    /* TODO
         this method goes with printCardAsGrid() seen below
         when option 4 is chosen to list existing cards it prints each card accordingly
         for example, it should show the following
         Card 0 numbers:
         1  2
         3  4 (check with expected output files)
    */
    public void listCards() {
        /* TODO
              insert code here to find all cards to be printed accordingly
         */
        /* TODO
              call printCardAsGrid() method here, Hint: use getCardNumbers() when getting cards
         */
        int i = 0;
        while (i < BingoCard.size()) {
            System.out.printf("Card " + i + " numbers : %n");
            printCardAsGrid(BingoCard.get(i).getCardNumbers());
            i++;
        }
    }

    /* TODO
          this is for option 4, list existing cards where all the cards are printed as a grid
          of rows / columns, so numbers 3 4 5 6 will be printed as follows:
          3  4
          5  6
          it is a follow on method from listCards() and ensures that the grid structure is printed
     */
    public void printCardAsGrid(String numbers) {
        String[] s_numbers = numbers.split(" ");
        String a = "1";
        int b = a.length();
        for (int i = 0; i < s_numbers.length; i++) {
            if (i % this.getCurrentColumnSize() == 0 && i != 0) {
                System.out.printf("%n");
            }
            if (s_numbers[i].length() == b) {
                System.out.print(" " + s_numbers[i] + " ");
            } else
                System.out.print(s_numbers[i] + " ");
        }
        System.out.printf("%n");
    }

    /* TODO
          use Toolkit.getInputForMessage to enter a new separator
          print a message what the new separator is
     */
    public void setSeparator() {
        String sep = Toolkit.getInputForMessage("Enter the new separator");
        /* TODO
              make use of setNumberSeparator() and getNumberSeparator()
         */
        Defaults.getNumberSeparator();
        Defaults.setNumberSeparator(sep);
        System.out.printf("Separator is '" + Defaults.getNumberSeparator() + "' %n");
    }

    /* TODO
         reset all BingoCards using resetMarked (to false)
     */
    public void resetAllCards() {
        //insert code here
        boolean resetMarked;
        resetMarked = false;
    }

    /* TODO
          mark off a number that was called when it equals one of the numbers on the BingoCard
     */
    public void markNumbers(int number) {
        //insert code
        for (int i = 0; i < BingoCard.size(); i++) {
            System.out.println("Checking card " + i + " for " + number + "");
            BingoCard.get(i).markNumber(number);
        }
    }

    /* TODO
         make use of isWinner() to determine who the winner is
         the method should return the index of who the winner is
    */
    public int getWinnerId() {
        //insert code here
        int a = 0;
        for (int i = 0; i < BingoCard.size(); i++) {
            if (BingoCard.get(i).isWinner()) {
                a = i;
                return a;
            }
        }
        return Defaults.NO_WINNER;
    }

    /* TODO
          please take note that the game will not end until there is a winning sequence
     */
    public void play() {
        System.out.println("Eyes down, look in!");
        resetAllCards();

        boolean weHaveAWinner;
        do {
            markNumbers(parseInt(
                    Toolkit.getInputForMessage("Enter the next number")
                            .trim()));

            int winnerID = getWinnerId();
            weHaveAWinner = winnerID != Defaults.NO_WINNER;
            if (weHaveAWinner)
                System.out.printf("And the winner is card %d%n", winnerID);
        } while (!weHaveAWinner);
    }

    public String getMenu(String[] menuItems) {
        /* TODO
        change this method so it prints a proper numbered menu
        analyse the correct format from the ExpectedOutput files
        menuText is returned
     */

        //insert code here
        return String.valueOf(" 0: Exit\n 1: Play bingo\n 2: Set number separator\n 3: Create a bingo card\n 4: List existing cards\n 5: Set bingo card size\n");
    }
    /* TODO
          complete the menu using switch to call the appropriate method calls
     */

    public void run() {
        boolean finished = false;
        do {
            switch (Toolkit.getInputForMessage(getMenu(mainMenuItems))) {
                //insert code here
                case "0":
                    return;
                case "1":
                    play();
                    break;
                case "2":
                    setSeparator();
                    break;
                case "3":
                    createCard();
                    break;
                case "4":
                    listCards();
                    break;
                case "5":
                    setSize();
                    break;
            }
        } while (!finished);
    }
}

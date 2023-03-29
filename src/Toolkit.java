import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Toolkit {
    private static final Scanner stdIn = new Scanner(System.in);

    /* TODO
          complete the GOODBYEMESSAGE
     */
    public static final String GOODBYEMESSAGE = "Thank you for playing";

    public static String getInputForMessage(String message) {
        System.out.println(message);
        return stdIn.nextLine();
    }

    public static String printArray(String[] array) {
        StringBuilder sb = new StringBuilder();
    /* TODO
        create a loop to print the numbers out once a user has inputted the BingoCard numbers, separated by commas (trim leading / trailing spaces)
        check the expected output here to ensure that it appears as it should
        return as a sb.toString()
        */
        for (int i = 0; i < array.length; i++) {
            if (Objects.equals(array[i], String.valueOf('\'')))
                array[i] = "";
        }
        for (int i = 0; i < array.length; i++)
            array[i] = array[i].trim();
        System.out.println(Arrays.toString(array).replace("[", "").replace("]", ""));
        return sb.toString();
    }
}
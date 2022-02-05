import java.util.Scanner;
import java.util.Arrays;
import java.util.stream.Collectors;

public class binaryTranslator {
    public static void main(String[] args) {
        System.out.print("\033[H\033[2J"); System.out.flush(); System.out.println("\n>> Welcome to this binary translator. Enter the binary text that you want to translate below:");

        // Create the question
        Scanner binary = new Scanner(System.in);
        String userInput = binary.nextLine(); binary.close();

        // Check if there are characters other than 1 and 0
        for (int i = 0; i < userInput.length(); i++) {
            if (userInput.charAt(i) != '0' && userInput.charAt(i) != '1' && userInput.charAt(i) != ' ') {
                System.out.printf("A non-binary character (%s) was found in the translation. Please try again.%n", userInput.charAt(i));
                return;
            }
        }

        // Translate and then print translation
        String translation = Arrays.stream(userInput.split(" "))
            .map(binaryText -> Integer.parseInt(binaryText, 2))
            .map(Character::toString)
            .collect(Collectors.joining());

        System.out.printf("%nTranslation: \"%s\"%n%n", translation);
        binary.close();
    }
}

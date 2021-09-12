import java.util.Scanner;
import java.util.Arrays;
import java.util.stream.Collectors;

public class binaryConverter {
    public static void main(String[] args) {
        System.out.print("\033[H\033[2J"); System.out.flush(); System.out.println(">> Welcome to this binary translator! Enter the binary text that you want to translate:");

        // Create the question
        Scanner binary = new Scanner(System.in);
        String userInput = binary.nextLine(); binary.close();

        // Check if there are characters other than 1 and 0 (the array nonBinaryCharArray are characters that need to be searched)
        char[] nonBinaryCharArray = {'2', '3', '4', '5', '6', '7', '8', '9',
        'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
        '.', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '_', '+', '=', '`', '~', '\'', '"', '{', '}', '[', ']', '|', '\\', ':', ';', ',', '/', '<', '>'};

        for (int y = 0; y < userInput.length(); y++) {
            char integer = userInput.charAt(y);
            for (int z = 0; z < nonBinaryCharArray.length; z++) {
                if (nonBinaryCharArray[z] == integer) {
                    System.out.println(String.format("A non-binary character ('%s') was found in the translation. Please try again.", nonBinaryCharArray[z]));
                    return;
                }
            }
        }

        // Translate and then print translation
        String translation = Arrays.stream(userInput.split(" "))
            .map(binaryText -> Integer.parseInt(binaryText, 2))
            .map(Character::toString)
            .collect(Collectors.joining());

        System.out.println(String.format("Translation: \"%s\"", translation));
    }
}
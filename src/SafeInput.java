import java.util.Scanner;

public class SafeInput {
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        if (low > high) {
            throw new IllegalArgumentException("Minimum cannot exceed maximum.");
        }
        while (true) {
            System.out.print(prompt + " [" + low + "-" + high + "]: ");
            String entry = pipe.nextLine().trim();
            try {
                int value = Integer.parseInt(entry);
                if (value >= low && value <= high) {
                    return value;
                }
            } catch (NumberFormatException ignored) {
                // Re-prompt for invalid input.
            }
            System.out.println("Invalid input. Enter a whole number from " + low + " to " + high + ".");
        }
    }
}

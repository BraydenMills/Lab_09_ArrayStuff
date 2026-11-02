import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Task 1: Create an array containing 100 integers.
        int[] dataPoints = new int[100];
        Random rnd = new Random();

        // Task 2: Fill the array with random integers from 1 through 100.
        for (int i = 0; i < dataPoints.length; i++) {
            dataPoints[i] = rnd.nextInt(100) + 1;
        }

        // Task 3: Display the array with a separator between values.
        System.out.println("The 100 random values in dataPoints are:");
        for (int i = 0; i < dataPoints.length; i++) {
            System.out.print(dataPoints[i]);
            if (i < dataPoints.length - 1) {
                System.out.print(" | ");
            }
        }
        System.out.println();

        // Task 4: Calculate and display the sum and average.
        int sum = 0;
        for (int i = 0; i < dataPoints.length; i++) {
            sum += dataPoints[i];
        }
        double average = (double) sum / dataPoints.length;
        System.out.println("The sum of the random array dataPoints is: " + sum);
        System.out.printf("The average of the random array dataPoints is: %.2f%n", average);

        Scanner in = new Scanner(System.in);

        // Tasks 5 and 6: Ask for a number and count every match.
        int searchValue = SafeInput.getRangedInt(in,
                "Enter a number between 1 and 100 to count", 1, 100);
        int count = 0;
        for (int i = 0; i < dataPoints.length; i++) {
            if (dataPoints[i] == searchValue) {
                count++;
            }
        }
        System.out.println("The value " + searchValue + " appears " + count
                + " time(s) in dataPoints.");

        // Task 7: Find the first matching index, stopping as soon as found.
        int findValue = SafeInput.getRangedInt(in,
                "Enter a number between 1 and 100 to locate", 1, 100);
        int firstIndex = -1;
        for (int i = 0; i < dataPoints.length; i++) {
            if (dataPoints[i] == findValue) {
                firstIndex = i;
                break;
            }
        }
        if (firstIndex == -1) {
            System.out.println("The value " + findValue + " was not found in dataPoints.");
        } else {
            System.out.println("The value " + findValue
                    + " was found at array index " + firstIndex + ".");
        }

        // Task 8: Find the minimum and maximum values in one pass.
        int min = dataPoints[0];
        int max = dataPoints[0];
        for (int i = 1; i < dataPoints.length; i++) {
            if (dataPoints[i] < min) {
                min = dataPoints[i];
            }
            if (dataPoints[i] > max) {
                max = dataPoints[i];
            }
        }
        System.out.println("The minimum value in dataPoints is: " + min);
        System.out.println("The maximum value in dataPoints is: " + max);

        // Task 9: Test the reusable average method.
        System.out.println("Average of dataPoints from getAverage is: "
                + getAverage(dataPoints));
        in.close();
    }

    public static double getAverage(int[] values) {
        if (values == null || values.length == 0) {
            throw new IllegalArgumentException("The array must not be empty.");
        }
        long total = 0;
        for (int value : values) {
            total += value;
        }
        return (double) total / values.length;
    }
}

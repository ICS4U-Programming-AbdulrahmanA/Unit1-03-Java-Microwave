import java.util.Scanner;

/**
 * Calculates heating time for microwave items based on quantity.
 *
 * @author Abdul
 * @version 1.0
 * @since 2026-09-22
 */
public final class Microwave {

    /** Base heating time in seconds for a Sub. */
    private static final double SUB_TIME = 60.0;

    /** Base heating time in seconds for a Pizza. */
    private static final double PIZZA_TIME = 45.0;

    /** Base heating time in seconds for a Soup. */
    private static final double SOUP_TIME = 105.0;

    /** Time multiplier for 1 item. */
    private static final double ONE_ITEM = 1.0;

    /** Time multiplier for 2 items (+50%). */
    private static final double TWO_ITEMS = 1.5;

    /** Time multiplier for 3 items (+100%). */
    private static final double THREE_ITEMS = 2.0;

    /** Maximum allowed item quantity. */
    private static final int MAX_QUANTITY = 3;

    /** Seconds per minute conversion constant. */
    private static final double SECONDS_PER_MINUTE = 60.0;

    /**
     * Private constructor to prevent instantiation.
     */
    private Microwave() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Main method where program execution starts.
     *
     * @param args Command line arguments.
     */
    public static void main(final String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("This program calculates microwave reheat time.");
        System.out.print("Please enter the item you want to reheat "
                + "(sub, pizza, soup): ");

        String foodInput = scanner.nextLine().trim().toLowerCase();

        double baseTime = 0.0;

        if (foodInput.equals("sub")) {
            baseTime = SUB_TIME;
        } else if (foodInput.equals("pizza")) {
            baseTime = PIZZA_TIME;
        } else if (foodInput.equals("soup")) {
            baseTime = SOUP_TIME;
        } else {
            System.out.println("Error: Invalid food choice. "
                    + "Choose sub, pizza, or soup.");
            scanner.close();
            return;
        }

        try {
            System.out.print("Please enter how many items you want "
                    + "to reheat (Max " + MAX_QUANTITY + "): ");

            int quantity = Integer.parseInt(scanner.nextLine().trim());

            double multiplier = 0.0;

            if (quantity == 1) {
                multiplier = ONE_ITEM;
            } else if (quantity == 2) {
                multiplier = TWO_ITEMS;
            } else if (quantity == 3) {
                multiplier = THREE_ITEMS;
            } else {
                System.out.println("Error: Quantity must be 1, 2, or 3.");
                scanner.close();
                return;
            }

            double totalSeconds = baseTime * multiplier;
            double totalMinutes = totalSeconds / SECONDS_PER_MINUTE;

            System.out.printf("Total heating time: %.2f seconds "
                    + "(%.2f minutes)%n", totalSeconds, totalMinutes);

        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid quantity. "
                    + "Please enter a whole number (1, 2, or 3).");
        }

        scanner.close();
    }
}

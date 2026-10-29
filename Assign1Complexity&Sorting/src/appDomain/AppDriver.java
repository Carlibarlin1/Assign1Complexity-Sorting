package appDomain;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.Scanner;

import products.*;
import utilities.*;

/**
 * Main application for the Complexity and Sorting assignment.
 * Reads product files, sorts products, and displays results.
 */
public class AppDriver {

    /**
     * Main method that runs the sorting application.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {

        String fileName = "";
        String compareType = "";
        String sortType = "";

        // Read command-line arguments
        for (int i = 0; i < args.length; i++) {

            String arg = args[i];

            if (arg.length() < 3 || arg.charAt(0) != '-') {
                System.out.println("Invalid argument: " + arg);
                printUsage();
                return;
            }

            String option = arg.substring(0, 2).toLowerCase();
            String value = arg.substring(2);

            switch (option) {

                case "-f":
                    if (!fileName.equals("")) {
                        System.out.println("Duplicate file argument.");
                        return;
                    }
                    fileName = value;
                    break;

                case "-t":
                    if (!compareType.equals("")) {
                        System.out.println("Duplicate comparison argument.");
                        return;
                    }
                    compareType = value.toLowerCase();
                    break;

                case "-s":
                    if (!sortType.equals("")) {
                        System.out.println("Duplicate sorting argument.");
                        return;
                    }
                    sortType = value.toLowerCase();
                    break;

                default:
                    System.out.println("Unknown argument: " + arg);
                    printUsage();
                    return;
            }
        }

        // Check required arguments
        if (fileName.equals("") ||
            compareType.equals("") ||
            sortType.equals("")) {

            System.out.println("Missing command-line arguments.");
            printUsage();
            return;
        }

        // Check comparison type
        if (!compareType.equals("o") &&
            !compareType.equals("u") &&
            !compareType.equals("d")) {

            System.out.println("Invalid comparison type.");
            printUsage();
            return;
        }

        // Check sorting type
        if (!sortType.equals("b") &&
            !sortType.equals("s") &&
            !sortType.equals("i") &&
            !sortType.equals("m") &&
            !sortType.equals("q") &&
            !sortType.equals("z")) {

            System.out.println("Invalid sorting algorithm.");
            printUsage();
            return;
        }

        try {

            // Read products from the file
            Product[] products = readProducts(fileName);

            // Select comparator
            Comparator<Product> comparator = null;

            if (compareType.equals("o")) {
                comparator = new OriginalPriceComparator();
            }
            else if (compareType.equals("u")) {
                comparator = new UpdatedPriceComparator();
            }

            // Start measuring sorting time
            long startTime = System.nanoTime();

            // Select sorting algorithm
            switch (sortType) {

                case "b":
                    if (comparator == null) {
                        BubbleSort.sort(products);
                    }
                    else {
                        BubbleSort.sort(products, comparator);
                    }
                    break;

                case "s":
                    if (comparator == null) {
                        SelectionSort.sort(products);
                    }
                    else {
                        SelectionSort.sort(products, comparator);
                    }
                    break;

                case "i":
                    if (comparator == null) {
                        InsertionSort.sort(products);
                    }
                    else {
                        InsertionSort.sort(products, comparator);
                    }
                    break;

                case "m":
                    if (comparator == null) {
                        MergeSort.sort(products);
                    }
                    else {
                        MergeSort.sort(products, comparator);
                    }
                    break;

                case "q":
                    if (comparator == null) {
                        QuickSort.sort(products);
                    }
                    else {
                        QuickSort.sort(products, comparator);
                    }
                    break;

                case "z":
                    if (comparator == null) {
                        HeapSort.sort(products);
                    }
                    else {
                        HeapSort.sort(products, comparator);
                    }
                    break;
            }

            // Stop measuring sorting time
            long endTime = System.nanoTime();

            double sortingTime =
                (endTime - startTime) / 1000000.0;

            // Display sorted products
            displayProducts(products, compareType);

            System.out.println(
                "Sorting time: " + sortingTime + " milliseconds"
            );

        }
        catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        }
        catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        catch (java.util.InputMismatchException e) {
            System.out.println("Error: Invalid product data in file.");
        }
    }

    /**
     * Reads product information from a text file.
     *
     * @param fileName Name of the file
     * @return Array of products
     * @throws FileNotFoundException If file does not exist
     */
    public static Product[] readProducts(String fileName)
            throws FileNotFoundException {

        File file = new File(fileName);
        Scanner input = new Scanner(file);
        input.useLocale(java.util.Locale.US);

        try {

            if (!input.hasNextInt()) {
                throw new IllegalArgumentException(
                    "Invalid number of products."
                );
            }

            int size = input.nextInt();

            if (size <= 0) {
                throw new IllegalArgumentException(
                    "Product count must be greater than zero."
                );
            }

            Product[] products = new Product[size];

            for (int i = 0; i < size; i++) {

                if (!input.hasNext()) {
                    throw new IllegalArgumentException(
                        "Missing product at position " + (i + 1)
                    );
                }

                String type = input.next();

                if (!input.hasNextDouble()) {
                    throw new IllegalArgumentException(
                        "Invalid original price at product " + (i + 1)
                    );
                }

                double originalPrice = input.nextDouble();

                if (!input.hasNextDouble()) {
                    throw new IllegalArgumentException(
                        "Invalid updated price at product " + (i + 1)
                    );
                }

                double updatedPrice = input.nextDouble();

                if (originalPrice < 0 || updatedPrice < 0 ||
                    !Double.isFinite(originalPrice) ||
                    !Double.isFinite(updatedPrice)) {

                    throw new IllegalArgumentException(
                        "Invalid price at product " + (i + 1)
                    );
                }

                // Create product objects
                switch (type.toLowerCase()) {

                    case "jeans":
                        products[i] = new Jeans(
                            originalPrice, updatedPrice
                        );
                        break;

                    case "tshirts":
                        products[i] = new TShirts(
                            originalPrice, updatedPrice
                        );
                        break;

                    case "skirts":
                        products[i] = new Skirts(
                            originalPrice, updatedPrice
                        );
                        break;

                    case "dresses":
                        products[i] = new Dresses(
                            originalPrice, updatedPrice
                        );
                        break;

                    case "shorts":
                        products[i] = new Shorts(
                            originalPrice, updatedPrice
                        );
                        break;

                    case "jackets":
                        products[i] = new Jackets(
                            originalPrice, updatedPrice
                        );
                        break;

                    case "shoes":
                        products[i] = new Shoes(
                            originalPrice, updatedPrice
                        );
                        break;

                    default:
                        throw new IllegalArgumentException(
                            "Unknown product: " + type
                        );
                }
            }

            if (input.hasNext()) {
                throw new IllegalArgumentException(
                    "File contains extra product data."
                );
            }

            return products;

        }
        finally {
            input.close();
        }
    }

    /**
     * Displays products according to the assignment requirements.
     *
     * @param products Sorted product array
     * @param compareType Selected comparison type
     */
    public static void displayProducts(
            Product[] products, String compareType) {

        int size = products.length;

        if (size <= 10) {

            for (int i = 0; i < size; i++) {
                printProduct(products[i], i, compareType);
            }

        }
        else {

            printProduct(products[0], 0, compareType);

            int interval;

            if (size <= 1000) {
                interval = 100;
            }
            else {
                interval = 1000;
            }

            for (int i = interval - 1;
                 i < size - 1;
                 i += interval) {

                printProduct(products[i], i, compareType);
            }

            printProduct(products[size - 1], size - 1, compareType);
        }
    }

    /**
     * Prints one product and its comparison value.
     *
     * @param product Product to print
     * @param index Position in the array
     * @param compareType Selected comparison type
     */
    public static void printProduct(
            Product product, int index, String compareType) {

        double value = 0;
        String label = "";

        if (compareType.equals("o")) {

            value = product.getOriginalPrice();
            label = "Original Price";

        }
        else if (compareType.equals("u")) {

            value = product.getUpdatedPrice();
            label = "Updated Price";

        }
        else {

            value = product.calcRealDiff();
            label = "Real Difference";
        }

        System.out.println(
            (index + 1) + "-th element: " +
            product.getClass().getSimpleName() +
            " " + label + ": " + value
        );
    }

    /**
     * Displays instructions for command-line arguments.
     */
    public static void printUsage() {

        System.out.println(
            "Usage: java -jar Sort.jar -f<file> -t<type> -s<sort>"
        );

        System.out.println("Comparison types:");
        System.out.println("o = Original Price");
        System.out.println("u = Updated Price");
        System.out.println("d = Real Difference");

        System.out.println("Sorting algorithms:");
        System.out.println("b = Bubble");
        System.out.println("s = Selection");
        System.out.println("i = Insertion");
        System.out.println("m = Merge");
        System.out.println("q = Quick");
        System.out.println("z = Heap");
    }
}

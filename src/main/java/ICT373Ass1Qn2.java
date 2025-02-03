
import java.util.Scanner;

/**
 * Title: Magazine Subscription System - Main Application Author: PANG ZI CHENG
 * JONATHAN Date: 1 OCTOBER 20241 File Name: ICT373Ass1Qn2.java
 *
 * Purpose: The main class for the Magazine Subscription System. It initializes
 * a set of predefined customers, supplements, and magazine details. The class
 * also provides a menu-driven interface for users to manage subscriptions, add
 * or remove customers, and generate reports.
 *
 * Assumptions/Conditions: - The system assumes valid customer details are
 * provided during input. - Input is handled via the command line interface. -
 * Output is printed to the console, including customer notifications and
 * billing information.
 */
public class ICT373Ass1Qn2 {

    /**
     * Main method to run the Magazine Subscription System. It initializes
     * customers, supplements, and handles user input via a menu-driven
     * interface.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        // Display student details
        displayStudentDetails();

        // Initialize Scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Create predefined supplements
        Supplement techNews = new Supplement("Tech News", 10.00);
        Supplement fitnessTips = new Supplement("Fitness Tips", 5.00);
        Supplement foodRecipes = new Supplement("Food Recipes", 8.00);
        Supplement travelGuides = new Supplement("Travel Guides", 12.00);

        // Create magazine with a predefined weekly cost and add supplements
        Magazine mag = new Magazine(15.00);
        mag.addSupp(techNews);
        mag.addSupp(fitnessTips);
        mag.addSupp(foodRecipes);
        mag.addSupp(travelGuides);

        // Initialize hardcoded customers (Paying and Associate)
        Payment johnPayment = new Payment("Bank of America", "Credit");
        Payment janePayment = new Payment("Wells Fargo", "Debit");

        // Create paying customers
        PayCustomer john = new PayCustomer(mag.custSize() + 1, "John Doe", "john@example.com", johnPayment);
        john.addSupp(techNews);
        john.addSupp(travelGuides);
        mag.addCustomer(john);

        PayCustomer jane = new PayCustomer(mag.custSize() + 1, "Jane Smith", "jane@example.com", janePayment);
        jane.addSupp(fitnessTips);
        jane.addSupp(foodRecipes);
        jane.addSupp(techNews);
        mag.addCustomer(jane);

        // Create associate customers and link them to paying customers
        AssoCustomer alice = new AssoCustomer(mag.custSize() + 1, "Alice Doe", "alice@example.com", john);
        alice.addSupp(techNews);
        alice.addSupp(foodRecipes);
        john.addAssoCust(alice);
        mag.addCustomer(alice);

        AssoCustomer bob = new AssoCustomer(mag.custSize() + 1, "Bob Smith", "bob@example.com", jane);
        bob.addSupp(travelGuides);
        jane.addAssoCust(bob);
        mag.addCustomer(bob);

        // Handle user input via menu
        userInput(scanner, mag);

        System.out.println("\n\n\n############Exiting Program#############");
    }

    /**
     * Displays a menu to the user and handles input to manage magazine
     * subscriptions.
     *
     * @param scanner The Scanner object used for input.
     * @param mag The Magazine object containing all customer data.
     * @return boolean Returns false to exit the program.
     */
    private static boolean userInput(Scanner scanner, Magazine mag) {
        while (true) {
            System.out.println("""
                               Loaded data...
                               What do you want to do?
                               1. Display email text for all customers for four weeks of magazines
                               2. Display text for all the end of month emails for paying customers
                               3. Add new customer to magazine service
                               4. Remove customer
                               5. Exit program""");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Flush newline after nextInt()

            switch (choice) {
                case 1:
                    // Display emails for all customers for 4 weeks
                    for (int week = 1; week <= 4; week++) {
                        System.out.println("Week " + week);
                        for (Customer c : mag.getCust()) {
                            c.receiveWeeklyNoti();
                        }
                    }
                    break;
                case 2:
                    // Display monthly bills for paying customers only
                    for (Customer c : mag.getCust()) {
                        if (c instanceof PayCustomer) {
                            ((PayCustomer) c).receiveMonthlyBill(mag);
                        }
                    }
                    break;
                case 3:
                    // Add a new customer
                    addCustomer(scanner, mag);
                    break;
                case 4:
                    // Remove a customer
                    removeCustomer(scanner, mag);
                    break;
                case 5:
                    // Exit program
                    System.out.println("Are you sure you want to exit? (Y/N)");
                    char confirm = scanner.nextLine().toUpperCase().charAt(0);
                    if (confirm == 'Y') {
                        return false;
                    }
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    /**
     * Adds a new customer to the magazine service based on user input.
     *
     * @param scanner The Scanner object used for input.
     * @param mag The Magazine object to add customers to.
     */
    private static void addCustomer(Scanner scanner, Magazine mag) {
        System.out.println("""
                           Hi, welcome to your personalized Magazine service.
                           What is your name? : """);
        String name = scanner.nextLine();

        System.out.println("\nEnter your email:");
        String email = scanner.nextLine();

        System.out.println("\nWhat kind of customer are you? (B = Buyer, A = Associate)");
        char custType = scanner.next().charAt(0);
        scanner.nextLine();  // Flush newline after char input

        if (Character.toUpperCase(custType) == 'B') {
            // Create a Paying Customer
            System.out.println("\nWhat is your bank name?");
            String bankName = scanner.nextLine();

            String pType = "";
            while (true) {
                System.out.println("\nAre you paying via credit or debit? (C = Credit, D = Debit)");
                char paymentTypeChar = scanner.next().charAt(0);
                scanner.nextLine();  // Flush newline

                if (Character.toUpperCase(paymentTypeChar) == 'C') {
                    pType = "CREDIT";
                    break;
                } else if (Character.toUpperCase(paymentTypeChar) == 'D') {
                    pType = "DEBIT";
                    break;
                } else {
                    System.out.println("INVALID PAYMENT TYPE! Defaulting to CREDIT.");
                    pType = "CREDIT";
                }
            }

            Payment newPay = new Payment(bankName, pType);
            PayCustomer customer = new PayCustomer(mag.custSize() + 1, name, email, newPay);
            mag.addCustomer(customer);
            // Show available supplements and let the customer choose which to subscribe to
            System.out.println("\nThe following are the available supplements:");
            System.out.println(mag.getAllSupp());  // Display the supplements available in the magazine

            // Ask the customer which supplements they want to subscribe to
            while (true) {
                System.out.println("\nEnter the name of the supplement you want to subscribe to (or type 'done' to finish):");
                String selectedSuppName = scanner.nextLine().trim();

                // Exit the loop if the customer is done selecting supplements
                if (selectedSuppName.equalsIgnoreCase("done")) {
                    break;
                }

                // Check if the selected supplement exists in the magazine
                Supplement selectedSupplement = null;
                for (Supplement s : mag.getSupplements()) {
                    if (s.GetName().equalsIgnoreCase(selectedSuppName)) {
                        selectedSupplement = s;
                        break;
                    }
                }

                if (selectedSupplement != null) {
                    // Add the selected supplement to the customer's subscription
                    customer.addSupp(selectedSupplement);
                    System.out.println("Added " + selectedSuppName + " to your subscription.");
                } else {
                    System.out.println("The supplement '" + selectedSuppName + "' does not exist. Please try again.");
                }
            }
            System.out.println("\nSuccessfully created " + name + " as a Paying Customer!");

        } else if (Character.toUpperCase(custType) == 'A') {
            // Create an Associate Customer
            System.out.println("\nEnter the name of the Paying Customer to associate with:");
            String parentName = scanner.nextLine();

            PayCustomer parentCustomer = null;
            for (Customer c : mag.getCust()) {
                if (c instanceof PayCustomer && c.getName().equalsIgnoreCase(parentName)) {
                    parentCustomer = (PayCustomer) c;
                    break;
                }
            }

            if (parentCustomer != null) {
                AssoCustomer associateCustomer = new AssoCustomer(mag.custSize() + 1, name, email, parentCustomer);
                mag.addCustomer(associateCustomer);
                parentCustomer.addAssoCust(associateCustomer);
                System.out.println("\nSuccessfully created " + name + " as an Associate Customer!");
            } else {
                System.out.println("Parent Paying Customer not found. Associate customer not created.");
            }
        } else {
            System.out.println("Invalid customer type! Returning to main menu.");
        }
    }

    /**
     * Removes a customer from the magazine service based on user input.
     *
     * @param scanner The Scanner object used for input.
     * @param mag The Magazine object to remove customers from.
     */
    private static void removeCustomer(Scanner scanner, Magazine mag) {
        System.out.println("\nPlease enter the Customer ID to be deleted:");
        long idToDelete = scanner.nextLong();
        scanner.nextLine();  // Consume newline

        Customer customerToDelete = null;
        char confirm = 'N';

        for (Customer c : mag.getCust()) {
            if (c.getID() == idToDelete) {
                System.out.println("The Customer ID you entered is " + c.getID() + ", \n Name: " + c.getName()
                        + ".\n\nDo you wish to proceed? (Y/N)");

                confirm = scanner.nextLine().toUpperCase().charAt(0);
                if (confirm == 'Y') {
                    customerToDelete = c;
                }
                break;
            }
        }

        if (customerToDelete != null) {
            mag.getCust().remove(customerToDelete);
            System.out.println("Customer successfully removed.");
        } else if (confirm == 'N') {
            System.out.println("Deletion canceled.");
        } else {
            System.out.println("Customer ID not found or deletion canceled.");
        }
    }

    /**
     * Displays the student details for the author of the program.
     */
    private static void displayStudentDetails() {
        System.out.println("""
                           Name : Pang Zi Cheng Jonathan
                           Student Number: 35133694
                           Mode of Enrollment: FTA 373
                           Tutor: Mr Loo Poh Kok
                           Tutorial attendance day and time: Wednesday, 1415 - 1715 \n\n\n""");
    }
}

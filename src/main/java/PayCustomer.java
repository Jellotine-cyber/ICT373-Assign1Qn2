/**
 * Title: PayCustomer Class for Magazine Subscription System
 * Author: PANG ZI CHENG JONATHAN
 * Date: 1 OCTOBER 2024
 * File Name: PayCustomer.java
 * 
 * Purpose: 
 * The PayCustomer class represents a paying customer in the magazine subscription system. 
 * A paying customer is responsible for their own magazine subscriptions and the subscriptions 
 * of their associate customers. This class also handles the payment method.
 * 
 * Assumptions/Conditions:
 * - Input: Valid customer information (ID, name, email) and a valid Payment object.
 * - Output: Generates monthly bills that include the total costs of supplements for both the paying 
 * customer and their associate customers.
 */

import java.util.ArrayList;

/**
 * Represents a paying customer who is responsible for their own subscription and 
 * the subscription of associate customers.
 */
public class PayCustomer extends Customer {

    private Payment pType;                            // Payment method (e.g., credit, debit)
    private ArrayList<AssoCustomer> child;            // List of associate customers linked to this paying customer

    /**
     * Constructor for creating a PayCustomer.
     * 
     * @param ID The unique identifier for the paying customer.
     * @param name The name of the paying customer.
     * @param email The email address of the paying customer.
     * @param payMethod The payment method for the paying customer.
     */
    public PayCustomer(long ID, String name, String email, Payment payMethod) {
        super(ID, name, email);                      // Call the constructor of the Customer class to initialize common fields
        this.pType = payMethod;                      // Assign the payment method to this customer
        this.child = new ArrayList<>();              // Initialize the list of associated customers
    }

    /**
     * Adds an associate customer to this PayCustomer's list of children.
     * 
     * @param customer The associate customer to add.
     */
    public void addAssoCust(AssoCustomer customer) {
        this.child.add(customer);                    // Adds the associate customer to the child list
    }

    /**
     * Generates and prints the monthly bill for the paying customer and their associated customers.
     * Includes the magazine's base cost, the cost of supplements for both the paying customer and their associates.
     * 
     * @param mag The Magazine object that contains the weekly cost of the main magazine.
     */
    public void receiveMonthlyBill(Magazine mag) {
        double totalCost = mag.getWeekCost() * 4;  // Calculate the monthly magazine cost (4 weeks)
        
        // Begin printing the bill details for the paying customer
        System.out.println("Dear " + name + ", here is your monthly bill:");
        System.out.println("Payment Method: " + pType);  // Print the customer's payment method
        
        // Print the base magazine subscription cost
        System.out.println("Magazine Subscription (Cost: $" + mag.getWeekCost() * 4 + ")");

        // Calculate the cost of supplements for the paying customer
        System.out.println("Your supplements:");
        for (Supplement s : supplement) {
            // Multiply the supplement cost by 4 (4 weeks in a month)
            System.out.println("- " + s.GetName() + " (Cost: $" + s.GetCost() * 4 + ")");
            totalCost += s.GetCost() * 4;  // Add the cost to the total
        }

        // Calculate the cost of supplements for each associate customer
        for (AssoCustomer associate : child) {
            System.out.println("Supplements for Associate Customer: " + associate.getName());
            for (Supplement s : associate.supplement) {
                // Multiply the supplement cost by 4 for the associate customer
                System.out.println("- " + s.GetName() + " (Cost: $" + s.GetCost() * 4 + ")");
                totalCost += s.GetCost() * 4;  // Add the cost to the total
            }
        }

        // Print the total cost for the month, including magazine and supplements
        System.out.println("Total Charge for the Month: $" + totalCost);
        System.out.println();  // Add a blank line for readability
    }
}

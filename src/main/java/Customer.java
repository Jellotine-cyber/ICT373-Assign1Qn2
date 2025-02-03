/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.ArrayList;

/**
 * Title: Customer Class for Magazine Subscription System
 * Author: PANG ZI CHENG JONATHAN
 * Date: 1 OCTOBER 2024
 * File Name: Customer.java
 * 
 * Purpose: 
 * The Customer class represents a basic customer in the magazine subscription system. 
 * Each customer has a unique ID, a name, an email address, and a list of supplements they are subscribed to. 
 * Customers can receive weekly notifications about their supplements.
 * 
 * Assumptions/Conditions:
 * - Input: Valid customer information (ID, name, email) and supplement objects are provided. 
 * - Output: The customer's details and subscribed supplements can be accessed. Weekly notifications can be generated for the customer.
 */

public class Customer {

    protected String name;                    // The name of the customer
    protected long customerID;                // The unique ID of the customer
    protected String emailaddr;               // The email address of the customer
    protected ArrayList<Supplement> supplement; // List of supplements subscribed by the customer

    /**
     * Constructor for creating a Customer object.
     * 
     * @param ID The unique identifier for the customer.
     * @param name The name of the customer.
     * @param email The email address of the customer.
     */
    public Customer(long ID, String name, String email) {
        this.customerID = ID;                 // Assigns the customer ID
        this.name = name;                     // Assigns the customer name
        this.emailaddr = email;               // Assigns the customer email
        this.supplement = new ArrayList<>();  // Initializes the list of supplements
    }

    /**
     * Retrieves the name of the customer.
     * 
     * @return The name of the customer.
     */
    public String getName() {
        return this.name;                     // Returns the customer's name
    }

    /**
     * Retrieves the unique ID of the customer.
     * 
     * @return The customer's unique ID.
     */
    public long getID() {
        return this.customerID;               // Returns the customer's ID
    }

    /**
     * Adds a supplement to the customer's subscription.
     * 
     * @param supp The supplement to be added.
     */
    public void addSupp(Supplement supp) {
        this.supplement.add(supp);            // Adds the supplement to the list
    }

    /**
     * Removes a supplement from the customer's subscription.
     * 
     * @param supp The supplement to be removed.
     */
    public void removeSupp(Supplement supp) {
        this.supplement.remove(supp);         // Removes the supplement from the list
    }

    /**
     * Sends a weekly notification to the customer listing all subscribed supplements.
     */
    public void receiveWeeklyNoti() {
        System.out.println("Hi " + name + ", your weekly magazine is updated. Here are your supplements:");
        
        // Print each subscribed supplement
        for (Supplement s : supplement) {
            System.out.println(" - " + s.GetName());  // Prints the name of each subscribed supplement
        }
    }
}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 * Title: Magazine Subscription Management System
 * Author: PANG ZI CHENG JONATHAN
 * Date: 1 OCTOBER 2024
 * File Name: Magazine.java
 *
 * Purpose:
 * The purpose of this class is to manage a magazine subscription system where customers can subscribe
 * to different supplements (magazine sections) and receive weekly notifications. This class also handles
 * adding/removing customers and supplements to/from the system.
 *
 * Assumptions/Conditions:
 * - Input: This system expects to handle customers and supplements as objects. Customers are either paying customers or associated customers.
 * - Output: The system sends weekly notifications and generates monthly bills for paying customers, including supplements they and their associate customers subscribe to.
 */
import java.util.ArrayList;

/**
 * The Magazine class represents the magazine subscription system. It manages
 * customers and supplements, tracks weekly costs, and provides functionality
 * for adding and removing customers and supplements.
 */
public class Magazine {

    private double weekCost;                   // The weekly cost of the magazine subscription
    private ArrayList<Supplement> supp;        // List of supplements available in the magazine
    private ArrayList<Customer> custs;         // List of customers subscribed to the magazine

    /**
     * Constructor to initialize a new Magazine with a specified weekly cost.
     *
     * @param weekCost The weekly cost of the magazine.
     */
    public Magazine(double weekCost) {
        this.weekCost = weekCost;
        this.supp = new ArrayList<>();         // Initializes an empty list of supplements
        this.custs = new ArrayList<>();        // Initializes an empty list of customers
    }

    /**
     * Adds a supplement to the magazine.
     *
     * @param supplement The supplement to add to the magazine.
     */
    public void addSupp(Supplement supplement) {
        supp.add(supplement);                  // Adds a supplement to the list
    }

    /**
     * Retrieves the weekly cost of the magazine.
     *
     * @return The weekly cost of the magazine.
     */
    public double getWeekCost() {
        return this.weekCost;                  // Returns the weekly cost of the magazine
    }

    /**
     * Adds a customer to the magazine's subscription list.
     *
     * @param customer The customer to add to the magazine.
     */
    public void addCustomer(Customer customer) {
        this.custs.add(customer);              // Adds a customer to the subscription list
    }

    /**
     * Retrieves the list of supplements available in the magazine.
     *
     * @return An ArrayList of Supplement objects available in the magazine.
     */
    public ArrayList<Supplement> getSupplements() {
        return this.supp;  // Returns the list of supplements
    }

    /**
     * Retrieves a string containing the names of all supplements available in
     * the magazine.
     *
     * @return A string listing all the supplement names, separated by commas.
     */
    public String getAllSupp() {
        StringBuilder reply = new StringBuilder();  // Use StringBuilder for efficient string concatenation
        for (Supplement sup : this.supp) {
            // Append the supplement name to the string builder
            reply.append(sup.GetName()).append(", ");
        }

        // Remove the trailing comma and space if there are any supplements
        if (reply.length() > 0) {
            reply.setLength(reply.length() - 2);  // Trims the last ", " from the final string
        }

        return reply.toString();  // Returns the final concatenated string
    }

    /**
     * Removes a customer from the magazine's subscription list.
     *
     * @param customer The customer to remove from the magazine.
     */
    public void removeCustomer(Customer customer) {
        this.custs.remove(customer);           // Removes a customer from the subscription list
    }

    /**
     * Retrieves the list of all customers subscribed to the magazine.
     *
     * @return An ArrayList of customers.
     */
    public ArrayList<Customer> getCust() {
        return this.custs;                     // Returns the list of customers
    }

    /**
     * Retrieves the current number of customers subscribed to the magazine.
     *
     * @return The number of customers subscribed to the magazine.
     */
    public int custSize() {
        return this.custs.size();              // Returns the total number of customers
    }
}

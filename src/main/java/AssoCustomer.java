/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * Title: Associate Customer Class for Magazine Subscription System
 * Author: PANG ZI CHENG JONATHAN
 * Date: 1 OCTOBER 2024
 * File Name: AssoCustomer.java
 * 
 * Purpose: 
 * This class represents an associate customer in the magazine subscription system. 
 * Associate customers are linked to a parent paying customer, and their subscriptions 
 * are managed by the parent. They inherit basic customer details from the Customer class.
 * 
 * Assumptions/Conditions:
 * - Input: This class assumes valid customer details (ID, name, email) are provided, along with a valid parent PayCustomer object.
 * - Output: This class provides access to the associate customer's name.
 */

public class AssoCustomer extends Customer {

    private PayCustomer parent;   // Reference to the parent PayCustomer

    /**
     * Constructor for creating an Associate Customer.
     * 
     * @param id The unique identifier for the associate customer.
     * @param name The name of the associate customer.
     * @param email The email address of the associate customer.
     * @param parent The parent PayCustomer to which the associate customer is linked.
     */
    public AssoCustomer(long id, String name, String email, PayCustomer parent) {
        super(id, name, email);   // Calls the constructor of the Customer class
        this.parent = parent;     // Assigns the parent PayCustomer
    }

    /**
     * Retrieves the name of the associate customer.
     * 
     * @return The name of the associate customer.
     */
    public String GetName() {
        return name;              // Returns the associate customer's name
    }
}


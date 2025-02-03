/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * Title: Supplement Class for Magazine Subscription System
 * Author: PANG ZI CHENG JONATHAN
 * Date: 1 OCTOBER 2024
 * File Name: Supplement.java
 * 
 * Purpose: 
 * The Supplement class represents a magazine supplement in the magazine subscription system. 
 * Each supplement has a name and a cost associated with it. Supplements can be added to a customer's subscription.
 * 
 * Assumptions/Conditions:
 * - Input: This class assumes valid supplement names and costs are provided during initialization.
 * - Output: The supplement details can be accessed through getter methods, and the supplement 
 * can be represented as a formatted string.
 */

public class Supplement {

    private String suppName;    // The name of the supplement
    private double suppCost;    // The cost of the supplement

    /**
     * Constructor for creating a Supplement object.
     * 
     * @param name The name of the supplement.
     * @param cost The cost of the supplement.
     */
    public Supplement(String name, double cost) {
        this.suppName = name;   // Assigns the name of the supplement
        this.suppCost = cost;   // Assigns the cost of the supplement
    }

    /**
     * Returns a string representation of the supplement,
     * including the name and the cost formatted to two decimal places.
     * 
     * @return A formatted string representing the supplement.
     */
    @Override
    public String toString() {
        return suppName + " ($" + String.format("%.2f", suppCost) + ")"; // Formats the supplement details
    }

    /**
     * Retrieves the name of the supplement.
     * 
     * @return The name of the supplement.
     */
    public String GetName() {
        return this.suppName;   // Returns the supplement's name
    }

    /**
     * Retrieves the cost of the supplement.
     * 
     * @return The cost of the supplement.
     */
    public double GetCost() {
        return this.suppCost;   // Returns the supplement's cost
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * Title: Payment Class for Magazine Subscription System
 * Author: PANG ZI CHENG JONATHAN
 * Date: 1 OCTOBER 2024
 * File Name: Payment.java
 * 
 * Purpose: 
 * The Payment class represents a payment method in the magazine subscription system. 
 * Each paying customer has a payment method, which includes the bank name and the payment type (credit or debit).
 * 
 * Assumptions/Conditions:
 * - Input: This class assumes valid bank name and payment type (e.g., "Credit" or "Debit") are provided during initialization.
 * - Output: The payment method is represented as a formatted string and can be retrieved using accessor methods.
 */

public class Payment {

    private String bankName;    // The name of the bank associated with the payment method
    private String payType;     // The type of payment (e.g., Credit or Debit)

    /**
     * Constructor for creating a Payment object.
     * 
     * @param name The name of the bank.
     * @param type The type of payment (e.g., "Credit" or "Debit").
     */
    public Payment(String name, String type) {
        this.bankName = name;   // Assigns the bank name
        this.payType = type;    // Assigns the payment type
    }

    /**
     * Returns a string representation of the payment method, 
     * including the bank name and the payment type.
     * 
     * @return A string representation of the payment method.
     */
    @Override
    public String toString() {
        return bankName + " (" + payType + ")";  // Returns the formatted string of the payment details
    }

    /**
     * Retrieves the name of the bank associated with the payment method.
     * 
     * @return The name of the bank.
     */
    public String getBankName() {
        return bankName;   // Returns the bank name
    }

    /**
     * Retrieves the type of payment (e.g., "Credit" or "Debit").
     * 
     * @return The type of payment.
     */
    public String getPayType() {
        return payType;    // Returns the payment type
    }
}

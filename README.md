# ICT373 Assignment 1 - Magazine Subscription Management System

## 📌 Project Overview
This project is a **Java-based Magazine Subscription Management System**, developed as part of **ICT373 Assignment 1**. The system allows users to:
- **Manage Customers** (Paying and Associate Customers)
- **Manage Magazine Subscriptions**
- **Handle Payments** (Bank name, Credit/Debit payments)
- **Add & Remove Customers and Supplements**
- **Generate Weekly Notifications & Monthly Bills**

## 🚀 Features
- **Object-Oriented Design (OOP)** with **Java Classes & Inheritance**
- **Command-Line Interface (CLI)** for user interaction
- **Subscription Management** (Add/Remove Customers & Supplements)
- **Weekly & Monthly Notifications**
- **Billing System for Paying Customers**

## 🛠️ Technologies Used
- **Java (JDK 17+)**
- **Object-Oriented Programming (OOP)**
- **Command-Line Interface (CLI)**
- **Java Collections (ArrayLists)**

## 📂 Project Structure
```
ICT373Ass1Qn2/
│── src/
│   ├── AssoCustomer.java     # Represents an Associate Customer
│   ├── Customer.java         # Base Customer class
│   ├── ICT373Ass1Qn2.java    # Main Application class
│   ├── Magazine.java         # Manages subscriptions & billing
│   ├── PayCustomer.java      # Represents a Paying Customer
│   ├── Payment.java          # Handles payment methods
│   ├── Supplement.java       # Manages magazine supplements
│── README.md                 # Project documentation
```

## 🏗️ Setup & Installation
1. **Clone the Repository**:
   ```sh
   git clone https://github.com/YOUR_USERNAME/ICT373Ass1Qn2.git
   ```
2. **Navigate to the Project Directory**:
   ```sh
   cd ICT373Ass1Qn2
   ```
3. **Compile the Project**:
   ```sh
   javac src/*.java -d bin
   ```
4. **Run the Program**:
   ```sh
   java -cp bin ICT373Ass1Qn2
   ```
5.  **Run the Program**:
   ```
   Right click ICT373Ass1Qn2.java, click on 'Run File'
   ```

## 📌 Example Usage
### **Menu Options**:
```
Loaded data...
What do you want to do?
1. Display email text for all customers for four weeks of magazines
2. Display text for all the end of month emails for paying customers
3. Add new customer to magazine service
4. Remove customer
5. Exit program
```

## ✅ Future Improvements
- [ ] Implement a GUI using **JavaFX**
- [ ] Store data using **Databases** instead of memory (SQLite or MySQL)
- [ ] Implement a **REST API** for online subscription management

## 📜 License
This project is for **educational purposes only**.

## 👤 Author
**Pang Zi Cheng Jonathan**
- 📧 Email: jonapzc@gmail.com


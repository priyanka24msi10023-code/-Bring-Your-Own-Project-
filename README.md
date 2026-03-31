#  Personal Expense Tracker (Java CLI Project)

## Project Overview

The Personal Expense Tracker is a command-line based Java application designed to help users manage and monitor their daily expenses efficiently. This project allows users to record expenses, categorize them, and analyze their spending patterns over time.

The application stores data locally using file handling, ensuring persistence even after the program is closed.

## Problem Statement

Managing personal finances manually can be difficult and error-prone. Users often forget where their money is spent, leading to poor financial decisions.

This project solves that problem by providing a simple and efficient way to:

* Track daily expenses
* Categorize spending
* View monthly summaries

##  Features

*  Add new expenses (category, amount, date)
*  View all recorded expenses
*  Filter expenses by category
*  View monthly total expenditure
*  Automatic data saving using file handling
*  Data persistence between program runs

##  Technologies Used

* **Programming Language:** Java
* **Concepts Used:**

  * Object-Oriented Programming (OOP)
  * File Handling (BufferedReader, FileWriter)
  * Collections (ArrayList, HashMap)
  * Exception Handling

##  System Requirements

* Java Development Kit (JDK 8 or above)
* Any terminal / command prompt
* Basic knowledge of running Java programs

##  Project Structure

ExpenseTracker.java   → Main application file
expenses.txt          → Stores all expense records
README.md             → Project documentation


##  How to Run the Project

### Step 1: Clone the Repository

git clone https://github.com/your-username/repo-name
cd repo-name

### Step 2: Compile the Program

javac ExpenseTracker.java

### Step 3: Run the Program
java ExpenseTracker


##  How the Program Works

After running the program, the user is presented with a menu:
1. Add Expense
2. View All Expenses
3. Filter by Category
4. Monthly Total
5. Exit

### Functionalities Explained:

* **Add Expense:**
  User enters category, amount, and date → stored in memory and file

* **View Expenses:**
  Displays all saved expenses in formatted output

* **Filter by Category:**
  Shows only expenses of a specific category

* **Monthly Total:**
  Calculates and displays total spending month-wise

* **Exit:**
  Saves all data to file before closing


##  Data Storage

* All expenses are stored in a file named:


  expenses.txt

* Format:


  category,amount,date

* Example:

  Food,200,2026-03
  Travel,500,2026-03


## 📸 Sample Output

 Personal Expense Tracker 
1. Add Expense
2. View All Expenses
3. Filter by Category
4. Monthly Total
5. Exit

Choose option: 1
Enter category: Food
Enter amount: 250
Enter date (YYYY-MM): 2026-03

Expense added!

##  Testing

The program has been tested for:

* Valid user input
* File read/write operations
* Multiple expense entries
* Edge cases (empty data, invalid choice)

##  Limitations

* No graphical user interface (CLI only)
* No user authentication
* Basic input validation


##  Future Enhancements

* GUI version using Java Swing or JavaFX
* Graphical reports and charts
* Database integration (MySQL)
* Mobile application version
* Budget alerts and notifications

##  Learning Outcomes

Through this project, the following concepts were applied:

* Object-Oriented Design
* File persistence
* Data structures usage
* Real-world problem solving

##  Author

Priyanka Borah (24MSI10023)
M.sc in Biotechnplogy 




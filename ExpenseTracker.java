import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

class Transaction implements Serializable {
    String type, category;
    double amount;

    Transaction(String type, String category, double amount) {
        this.type = type;
        this.category = category;
        this.amount = amount;
    }

    public String toString() {
        return type + " | " + category + " | ₹" + amount;
    }
}
package models;

import base.Discount;
import base.Payment;
import base.Tax;

// Model.
// Применение интерфейсов.
public class Client implements Payment, Discount,Tax {

    private String name;
    private String surname;
    private int quantity;
    private double price;
    private final static int DISCOUNT_RATE = 15;
    private final static int TAX_RATE = 18;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    // Расчёт платежа, без учета скидки.
    @Override
    public double calculatePayment(int quota, double price) {
        return quota * price;
    }



    // Расчёт платежа, с учетом скидки + налога

    @Override
    public double calculatePayment(double payment, double discount, double tax) {
        return payment - discount + tax;
    }

    // Расчёт суммы скидки.
    @Override
    public double calculateDiscount(double payment) {
        return payment * DISCOUNT_RATE / 100;
    }

    @Override
    public double calculateTax(double payment) {
        return payment * TAX_RATE / 100;
    }
}

package models;

import base.Discount;
import base.Payment;

// Model.
// Применение интерфейсов.
public class Client implements Payment, Discount {

    private String name;
    private int quantity;
    private double price;
    private final static int DISCOUNT_RATE = 15;

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

    // Расчёт платежа, без учета скидки.
    @Override
    public double calculatePayment(int quota, double price) {
        return quota * price;
    }

    // Расчёт платежа, с учетом скидки.
    @Override
    public double calculatePayment(double payment, double discount) {
        return payment - discount;
    }

    // Расчёт суммы скидки.
    @Override
    public double calculateDiscount(double payment) {
        return payment * DISCOUNT_RATE / 100;
    }
}

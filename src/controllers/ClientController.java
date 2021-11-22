package controllers;

import models.Client;
import utils.Rounder;
import views.ClientView;

public class ClientController {

    Client model;
    ClientView view;

    // Конструктор
    public ClientController(Client model, ClientView view) {
        this.model = model;
        this.view = view;
    }

    public void runApp() {

        view.getInputs();

        String name = model.getName();
        String surname = model.getSurname();

        double paymentInitial = model.calculatePayment(model.getQuantity(), model.getPrice());
        String paymentInitialRounded = Rounder.roundValue(paymentInitial);

        double discount = model.calculateDiscount(paymentInitial);
        String discountRounded = Rounder.roundValue(discount);

        String paymentRounded = Rounder.roundValue(model
                .calculatePayment(paymentInitial, discount));
        double taxInitial = model.calculateTax(paymentInitial);
        String taxInitialRounded = Rounder.roundValue(taxInitial);


        String output = "------------------------------\n" +
                "Имя клиента: " + name + "\n" +
                "Фамилия клиента: " + surname + "\n" +
                "Сума покупки (грн.): " + paymentInitialRounded + "\n" +
                "Сумма скидки (грн.): " + discountRounded + "\n" +
                "Cумма налога:(грн.) " + taxInitialRounded+"\n" +
                "К оплате (грн.): " + paymentRounded;

        view.getOutput(output);
    }
}

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

        double paymentInitial = model.calculatePayment(model.getQuantity(), model.getPrice());
        String paymentInitialRounded = Rounder.roundValue(paymentInitial);

        double discount = model.calculateDiscount(paymentInitial);
        String discountRounded = Rounder.roundValue(discount);

        String paymentRounded = Rounder.roundValue(model
                .calculatePayment(paymentInitial, discount));

        String output = "------------------------------\n" +
                "Имя клиента: " + name + "\n" +
                "Сума покупки (грн.): " + paymentInitialRounded + "\n" +
                "Сумма скидки (грн.): " + discountRounded + "\n" +
                "К оплате (грн.): " + paymentRounded;

        view.getOutput(output);
    }
}

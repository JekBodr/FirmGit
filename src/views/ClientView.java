package views;

import models.Client;
import utils.Validator;

import java.util.Scanner;

// View
public class ClientView {

    Client model;
    String title;
    String name;
    int quantity;
    double price;
    Scanner scanner;

    // Конструктор
    public ClientView(Client model) {
        this.model = model;
    }

    // Ввод данных
    public void getInputs() {

        // Создаем экземпляр Scanner
        scanner = new Scanner(System.in);

        // Ввод и валидация данных

        title = "Введите имя клиента: ";
        System.out.print(title);
        name = Validator.validateName(scanner);
        model.setName(name);

        title = "Введите количество: ";
        System.out.print(title);
        quantity = Validator.validateQuantityInput(scanner);
        model.setQuantity(quantity);

        title = "Введите цену: ";
        System.out.print(title);
        price = Validator.validatePriceInput(scanner);
        model.setPrice(price);

        // Закрываем Scanner
        scanner.close();
    }

    // Вывод данных
    public void getOutput(String output) {
        System.out.println(output);
    }
}

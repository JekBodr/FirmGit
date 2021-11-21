import controllers.ClientController;
import models.Client;
import views.ClientView;

// Входная точка в программу/приложение
public class Main {

    public static void main(String[] args) {

        System.out.println("Демонстрация работы программы");

        Client model = new Client();
        ClientView view = new ClientView(model);
        ClientController controller = new ClientController(model, view);
        // Запуск программы/приложения
        controller.runApp();
    }
}

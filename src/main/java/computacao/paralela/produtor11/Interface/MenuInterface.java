package computacao.paralela.produtor11.Interface;

import java.util.Scanner;
import computacao.paralela.produtor11.controller.ProducerController;

public class MenuInterface {

    private final ProducerController producerController;

    public MenuInterface(ProducerController producerController) {
        this.producerController = producerController;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            displayMenu();
            System.out.print("Escolha uma opção: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: {
                    AgricultureDataInterface agricultureDataInterface = new AgricultureDataInterface(producerController);
                    agricultureDataInterface.start();
                    break;
                }
                case 2: {
                    ClienteOrderInterface clienteOrderInterface = new ClienteOrderInterface(producerController);
                    clienteOrderInterface.start();
                    break;
                }
                case 3: {
                    System.out.println("Saindo do sistema. Até logo!");
                    break;
                }
                default: {
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
                }
            }
        } while (choice != 3);

        scanner.close();
    }

    private void displayMenu() {
        System.out.println("Menu:");
        System.out.println("1. Acessar Sistema de Dados Agrícolas");
        System.out.println("2. Acessar Sistema de Compras de Café");
        System.out.println("3. Sair");
    }
}
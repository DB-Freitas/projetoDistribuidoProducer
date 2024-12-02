package computacao.paralela.produtor11.Interface;

import computacao.paralela.produtor11.dto.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import computacao.paralela.produtor11.controller.ProducerController;
import computacao.paralela.produtor11.dto.Dados;
import computacao.paralela.produtor11.dto.Pedido;

import java.util.Date;
import java.util.Scanner;

public class ClienteOrderInterface {

    private final ProducerController producerController;

    public ClienteOrderInterface(ProducerController producerController) {
        this.producerController = producerController;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem-vindo ao sistema de compras de Café!");

        while (true) {
            System.out.println("Por favor, insira os dados da compra ou digite 'sair' para encerrar:");

            System.out.print("ID: ");
            String idInput = scanner.nextLine();
            if (idInput.equalsIgnoreCase("sair")) break;

            System.out.print("Preço: ");
            String precoInput = scanner.nextLine();
            if (precoInput.equalsIgnoreCase("sair")) break;

            System.out.print("Tipo de Café (1-5): ");
            String tipoCafeInput = scanner.nextLine();
            if (tipoCafeInput.equalsIgnoreCase("sair")) break;

            System.out.print("Quantidade (em Kg): ");
            String quantidadeInput = scanner.nextLine();
            if (quantidadeInput.equalsIgnoreCase("sair")) break;

            try {
                int id = Integer.parseInt(idInput);
                double preco = Double.parseDouble(precoInput);
                int tipoCafe = Integer.parseInt(tipoCafeInput);
                double quantidade = Double.parseDouble(quantidadeInput);

                Date data = new Date();

                Pedido pedido = new Pedido(id,data,preco,tipoCafe,quantidade);
                producerController.sendCoffeeOrderData(pedido);
                System.out.println("Dados da venda enviados com sucesso!");
            } catch (NumberFormatException e) {
                System.out.println("Erro: Por favor, insira valores numéricos válidos para ID, Preço, Tipo de Café e Quantidade.");
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }

        scanner.close();
        System.out.println("Interface encerrada. Até logo!");
    }
}
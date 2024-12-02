package computacao.paralela.produtor11.Interface;

import com.fasterxml.jackson.core.JsonProcessingException;
import computacao.paralela.produtor11.controller.*;
import computacao.paralela.produtor11.dto.Dados;

import java.util.Scanner;
import java.util.Date;

public class AgricultureDataInterface {

    private final ProducerController producerController;

    public AgricultureDataInterface(ProducerController producerController) {
        this.producerController = producerController;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem-vindo ao sistema de envio de dados agrícolas!");

        while (true) {
            System.out.println("Por favor, insira os dados agrícolas ou digite 'sair' para encerrar:");

            System.out.print("ID: ");
            String idInput = scanner.nextLine();
            if (idInput.equalsIgnoreCase("sair")) break;

            System.out.print("tipo de Café Colhido: ");
            String tipocafecolhidoInput = scanner.nextLine();
            if (tipocafecolhidoInput.equalsIgnoreCase("sair")) break;

            System.out.print("Quantidade Colhida: ");
            String quantidadeColhidaInput = scanner.nextLine();
            if (quantidadeColhidaInput.equalsIgnoreCase("sair")) break;

            System.out.print("Produtividade: ");
            String produtividadeInput = scanner.nextLine();
            if (produtividadeInput.equalsIgnoreCase("sair")) break;

            System.out.print("ID da Cooperativa: ");
            String cooperativaIdInput = scanner.nextLine();
            if (cooperativaIdInput.equalsIgnoreCase("sair")) break;

            try {
                int id = Integer.parseInt(idInput);
                int tipocafecolhido = Integer.parseInt(tipocafecolhidoInput);
                double quantidadeColhida = Double.parseDouble(quantidadeColhidaInput);
                double produtividade = Double.parseDouble(produtividadeInput);
                int cooperativaId = Integer.parseInt(cooperativaIdInput);

                Date data = new Date();

                Dados dados = new Dados(id, data, tipocafecolhido, quantidadeColhida, produtividade, cooperativaId);
                producerController.sendAgricultureData(dados);
                System.out.println("Dados enviados com sucesso!");
            } catch (NumberFormatException e) {
                System.out.println("Erro: Por favor, insira valores numéricos válidos para ID, Quantidade Colhida e Produtividade.");
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }

        scanner.close();
        System.out.println("Interface encerrada. Até logo!");
    }
}
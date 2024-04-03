package application;

import java.util.Scanner;

import gerenciamento.Carro;
import gerenciamento.Estacionamento;

public class program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Estacionamento estacionamento = new Estacionamento(3, 5.0); // 3 vagas, taxa de R$5,00 por hora

        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Adicionar carro");
            System.out.println("2 - Remover carro");
            System.out.println("3 - Listar carros");
            System.out.println("4 - Encontrar carro");
            System.out.println("5 - Sair");

            int opcao = scanner.nextInt();
            int voltar;
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Digite a placa do carro:");
                    String placa = scanner.nextLine();
                    System.out.println("Digite o modelo do carro:");
                    String modelo = scanner.nextLine();
                    System.out.println("Digite o tempo de permanência do carro em horas:");
                    int horas = scanner.nextInt();
                    estacionamento.adicionarCarro(new Carro(placa, modelo), horas);
                    break;
                case 2:
                    System.out.println("Digite a placa do carro a ser removido:");
                    String placaRemover = scanner.nextLine();
                    estacionamento.removerCarro(placaRemover);
                    break;
                case 3:
                    System.out.println("Carros estacionados:");
                    for (Carro carro : estacionamento.listarCarros()) {
                        System.out.println("Placa: " + carro.getPlaca() + ", Modelo: " + carro.getModelo());
                        System.out.println();
                        System.out.print("Digite 1 para voltar: ");
                        voltar = scanner.nextInt();
                    }
                    break;
                case 4:
                    System.out.println("Digite a placa do carro a ser encontrado:");
                    String placaEncontrar = scanner.nextLine();
                    Carro carroEncontrado = estacionamento.encontrarCarro(placaEncontrar);
                    if (carroEncontrado != null) {
                        System.out.println("Carro encontrado:");
                        System.out.println("Placa: " + carroEncontrado.getPlaca() + ", Modelo: " + carroEncontrado.getModelo());
                        System.out.println();
                        System.out.print("Digite 1 para voltar: ");
                        voltar = scanner.nextInt();
                    } else {
                        System.out.println("Carro não encontrado no estacionamento.");
                    }
                    break;
                case 5:
                    System.out.println("Encerrando o programa...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
                    break;
            }
        }
    }
}

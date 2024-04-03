package application;

import modelos.Passageiro;
import modelos.Reserva;
import modelos.Voo;
import util.ProgramaFidelidade;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProgramaFidelidade programaFidelidade = new ProgramaFidelidade();
        List<Passageiro> passageiros = new ArrayList<>();
        List<Reserva> reservas = new ArrayList<>();
        List<Voo> voos = new ArrayList<>();

        voos.add(new Voo("1", 150, "Nova York"));
        voos.add(new Voo("2", 200, "Los Angeles"));
        voos.add(new Voo("3", 100, "Miami"));



        System.out.println("Bem-vindo ao Sistema de Reservas de Passagens Aéreas!");

        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Verificar disponibilidade de voos");
            System.out.println("2 - Fazer uma reserva");
            System.out.println("3 - Adicionar passageiro");
            System.out.println("4 - Exibir informações de passageiros");
            System.out.println("5 - Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                 System.out.println("Voos disponíveis:");
                for (Voo voo : voos) {
                 System.out.println("Número do Voo: " + voo.getNumeroVoo() +
                ", Assentos Disponíveis: " + voo.getAssentosDisponiveis() +
                ", Destino: " + voo.getDestino());
                 }
                 System.out.println();
                 System.out.print("Digite 1 para voltar: ");
                 int voltar = scanner.nextInt();
                 
                 break;

                case 2:
                    System.out.println("Digite o ID do passageiro:");
                    int idPassageiroReserva = scanner.nextInt();
                    scanner.nextLine(); 

                    Passageiro passageiroReserva = buscarPassageiroPorId(passageiros, idPassageiroReserva);

                    if (passageiroReserva != null) {
                        System.out.println("Digite o número do voo:");
                        String numeroVoo = scanner.nextLine();

                        System.out.println("Digite a quantidade de assentos desejados:");
                        int quantidadeAssentos = scanner.nextInt();

                        Voo vooSelecionado = buscarVooPorNumero(voos, numeroVoo);

                        if (vooSelecionado != null && vooSelecionado.reservarAssento(quantidadeAssentos)) {
                            Reserva reserva = new Reserva(passageiroReserva, vooSelecionado);
                            reservas.add(reserva);
                            System.out.println("Reserva realizada com sucesso para o passageiro " + passageiroReserva.getNome());
                        } else {
                            System.out.println("Não foi possível fazer a reserva. Verifique os dados e a disponibilidade do voo.");
                        }
                    } else {
                        System.out.println("Passageiro não encontrado.");
                    }
                    break;
                case 3:
                    System.out.println("Digite o nome do passageiro:");
                    String nomePassageiro = scanner.nextLine();
                    Passageiro novoPassageiro = new Passageiro(nomePassageiro);
                    passageiros.add(novoPassageiro);
                    programaFidelidade.adicionarPassageiro(novoPassageiro);
                    System.out.println("Passageiro adicionado com sucesso. ID do passageiro: " + novoPassageiro.getId());
                    System.out.println();
                    System.out.print("Digite 1 para voltar: ");
                    voltar = scanner.nextInt();
                    break;
                case 4:
                    System.out.println("Passageiros cadastrados:");
                    for (Passageiro passageiro : passageiros) {
                        System.out.println("Nome: " + passageiro.getNome() + ", ID: " + passageiro.getId());
                    }
                    System.out.println();
                    System.out.print("Digite 1 para voltar: ");
                    voltar = scanner.nextInt();
                    break;
                case 5:
                    System.out.println("Saindo do programa...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
                    break;
            }
        }
    }

    private static Passageiro buscarPassageiroPorId(List<Passageiro> passageiros, int id) {
        for (Passageiro passageiro : passageiros) {
            if (passageiro.getId() == id) {
                return passageiro;
            }
        }
        return null;
    }

    private static Voo buscarVooPorNumero(List<Voo> voos, String numeroVoo) {
        for (Voo voo : voos) {
            if (voo.getNumeroVoo().equals(numeroVoo)) {
                return voo;
            }
        }
        return null;
    }
}

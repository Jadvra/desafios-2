package application;

import java.util.Scanner;
import produtos.Estoque;
import produtos.Produto;

public class Program {
    public static void main(String[] args) {
        Estoque estoque = new Estoque();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao Sistema de Gerenciamento de Estoque!");

        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Adicionar produto ao estoque");
            System.out.println("2 - Registrar venda");
            System.out.println("3 - Listar todos os produtos no estoque");
            System.out.println("4 - Aumentar quantidade de um produto no estoque");
            System.out.println("5 - filtrar por categoria");
            System.out.println("6 - Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome do produto:");
                    String nomeProduto = scanner.nextLine();

                    System.out.println("Digite o preço do produto:");
                    double precoProduto = scanner.nextDouble();

                    System.out.println("Digite a quantidade disponível:");
                    int quantidadeDisponivel = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer do scanner

                    System.out.println("Digite a categoria do produto:");
                    String categoriaProduto = scanner.nextLine();

                    Produto novoProduto = new Produto(nomeProduto, precoProduto, quantidadeDisponivel, categoriaProduto);
                    estoque.adicionarProduto(novoProduto);
                    System.out.println("Produto adicionado ao estoque!");
                    System.out.println();
                    estoque.verificarEstoqueBaixo();
                    break;
                case 2:
                    System.out.println();
                    System.out.println("Produtos disponíveis no estoque:");
                    estoque.listarProdutos();

                    System.out.println("Digite o nome do produto a ser vendido:");
                    String nomeProdutoVenda = scanner.nextLine();

                    System.out.println("Digite a quantidade vendida:");
                    int quantidadeVendida = scanner.nextInt();

                    estoque.venderProduto(nomeProdutoVenda, quantidadeVendida);
                    System.out.println();
                    estoque.verificarEstoqueBaixo();
                    break;
                case 3:
                    System.out.println();
                    System.out.println("Produtos disponíveis no estoque:");
                    estoque.listarProdutos();
                    System.out.println("1 - voltar");
                    scanner.nextInt();
                    System.out.println();
                    estoque.verificarEstoqueBaixo();
                    break;
                case 4:
                    System.out.println();
                    System.out.println("Digite o nome do produto para aumentar a quantidade:");
                    String nomeProdutoAumentar = scanner.nextLine();

                    System.out.println("Digite a quantidade a ser adicionada:");
                    int quantidadeAumentar = scanner.nextInt();

                    estoque.aumentarQuantidadeProduto(nomeProdutoAumentar, quantidadeAumentar);
                    System.out.println();
                    estoque.verificarEstoqueBaixo();
                    break;
                    
                case 5:
                    System.out.println();
                    System.out.println("Digite a categoria dos produtos que deseja listar:");
                    String categoria = scanner.nextLine();
                    System.out.println();
                    estoque.listarProdutosPorCategoria(categoria);
                    System.out.println("1 - voltar");
                    scanner.nextInt();
                    break;
                case 6:
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
}

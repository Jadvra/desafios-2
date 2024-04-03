package produtos;

import java.util.ArrayList;
import java.util.List;

public class Estoque {
    private List<Produto> produtos;
    private int limiteMinimo = 5; // Limite mínimo de estoque

    public Estoque() {
        produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public void venderProduto(String nomeProduto, int quantidade) {
        for (Produto produto : produtos) {
            if (produto.getNome().equals(nomeProduto)) {
                int quantidadeAtual = produto.getQuantidadeDisponivel();
                if (quantidadeAtual >= quantidade) {
                    produto.setQuantidadeDisponivel(quantidadeAtual - quantidade);
                    System.out.println("Venda registrada: " + quantidade + " unidades de " + produto.getNome());
                    return;
                } else {
                    System.out.println("Quantidade insuficiente em estoque para " + produto.getNome());
                    return;
                }
            }
        }
        System.out.println("Produto não encontrado: " + nomeProduto);
    }

    public void listarProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto disponível no estoque.");
        } else {
            System.out.println("Produtos disponíveis no estoque:");
            for (Produto produto : produtos) {
                System.out.println("- " + produto.getNome() + ", Preço: $" + produto.getPreco() 
                + ", Quantidade disponível: " + produto.getQuantidadeDisponivel());
            }
        }
    }

    public void verificarEstoqueBaixo() {
        boolean estoqueBaixo = false;
        System.out.println("Mensagem de estoque");
        for (Produto produto : produtos) {
            if (produto.getQuantidadeDisponivel() < limiteMinimo) {
                estoqueBaixo = true;
                System.out.println("Produto " + produto.getNome() + " está com quantidade baixa no estoque!");
            }
        }
        if (!estoqueBaixo) {
            System.out.println("Todos os produtos estão com quantidade suficiente no estoque.");
        }
    }

    public void listarProdutosPorCategoria(String categoria) {
        System.out.println("Produtos da categoria '" + categoria + "':");
        for (Produto produto : produtos) {
            if (produto.getCategoria().equalsIgnoreCase(categoria)) {
                System.out.println("- " + produto.getNome() + ", Preço: $" + produto.getPreco() 
                + ", Quantidade disponível: " + produto.getQuantidadeDisponivel());
            }
        }
    }
    public void aumentarQuantidadeProduto(String nomeProduto, int quantidade) {
        boolean produtoEncontrado = false;
        for (Produto produto : produtos) {
            if (produto.getNome().equalsIgnoreCase(nomeProduto)) {
                produto.setQuantidadeDisponivel(produto.getQuantidadeDisponivel() + quantidade);
                System.out.println("Quantidade do produto " + produto.getNome() + " aumentada em " + quantidade);
                produtoEncontrado = true;
                break;
            }
        }
        if (!produtoEncontrado) {
            System.out.println("Produto não encontrado no estoque: " + nomeProduto);
        }
    }
}

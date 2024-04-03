package modelos;

public class Passageiro {
    private static int proximoId = 1;
    private int id;
    private String nome;
    private int pontosFidelidade;

    public Passageiro(String nome) {
        this.id = proximoId++;
        this.nome = nome;
        this.pontosFidelidade = 0;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getPontosFidelidade() {
        return pontosFidelidade;
    }

    public void adicionarPontosFidelidade(int pontos) {
        this.pontosFidelidade += pontos;
    }
}

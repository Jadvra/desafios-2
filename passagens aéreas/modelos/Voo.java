package modelos;

public class Voo {
    private String numeroVoo;
    private int capacidadeAssentos;
    private int assentosDisponiveis;
    private String destino;

    public Voo(String numeroVoo, int capacidadeAssentos, String destino) {
        this.numeroVoo = numeroVoo;
        this.capacidadeAssentos = capacidadeAssentos;
        this.assentosDisponiveis = capacidadeAssentos;
        this.destino = destino;
    }

    public String getNumeroVoo() {
        return numeroVoo;
    }

    public void setNumeroVoo(String numeroVoo) {
        this.numeroVoo = numeroVoo;
    }

    public int getCapacidadeAssentos() {
        return capacidadeAssentos;
    }

    public void setCapacidadeAssentos(int capacidadeAssentos) {
        this.capacidadeAssentos = capacidadeAssentos;
    }

    public int getAssentosDisponiveis() {
        return assentosDisponiveis;
    }

    public void setAssentosDisponiveis(int assentosDisponiveis) {
        this.assentosDisponiveis = assentosDisponiveis;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public boolean reservarAssento(int quantidade) {
        if (quantidade <= assentosDisponiveis) {
            assentosDisponiveis -= quantidade;
            return true;
        }
        return false;
    }
}

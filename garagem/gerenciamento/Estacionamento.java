package gerenciamento;

import java.util.ArrayList;
import java.util.List;

public class Estacionamento {
    private List<Carro> carrosEstacionados;
    private int limiteVagas;
    private double taxaPorHora;

    public Estacionamento(int limiteVagas, double taxaPorHora) {
        this.limiteVagas = limiteVagas;
        this.taxaPorHora = taxaPorHora;
        carrosEstacionados = new ArrayList<>();
    }

    public void adicionarCarro(Carro carro, int horas) {
        if (carrosEstacionados.size() < limiteVagas) {
            carrosEstacionados.add(carro);
            double custo = calcularCustoEstacionamento(horas);
            System.out.println("Carro adicionado ao estacionamento. Custo de estacionamento: R$" + custo);
        } else {
            System.out.println("Estacionamento lotado. Não é possível adicionar mais carros.");
        }
    }

    public void removerCarro(String placa) {
        carrosEstacionados.removeIf(carro -> carro.getPlaca().equals(placa));
    }

    public List<Carro> listarCarros() {
        return carrosEstacionados;
    }

    public Carro encontrarCarro(String placa) {
        for (Carro carro : carrosEstacionados) {
            if (carro.getPlaca().equals(placa)) {
                return carro;
            }
        }
        return null;
    }

    private double calcularCustoEstacionamento(int horas) {
        return horas * taxaPorHora;
    }
}

package util;

import modelos.Passageiro;
import java.util.ArrayList;
import java.util.List;

public class ProgramaFidelidade {
    private List<Passageiro> passageiros;

    public ProgramaFidelidade() {
        passageiros = new ArrayList<>();
    }

    public void adicionarPassageiro(Passageiro passageiro) {
        passageiros.add(passageiro);
    }

    public Passageiro buscarPassageiro(int id) {
        for (Passageiro passageiro : passageiros) {
            if (passageiro.getId() == id) {
                return passageiro;
            }
        }
        return null;
    }
}

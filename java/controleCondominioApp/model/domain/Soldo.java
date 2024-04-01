package controleCondominioApp.model.domain;

import java.time.LocalDate;
import java.time.Period;

public class Soldo {
    public static float calcularSalario(Funcionario funcionario) {
        float salarioBase = funcionario.getSalario();
        LocalDate dataAdmissao = funcionario.getDataAdmissao().toLocalDate();
        LocalDate agora = LocalDate.now();
        long anosDeCasa = Period.between(dataAdmissao, agora).getYears();

        // Aumento de 15% a cada 5 anos
        float aumentoPorTempo = (anosDeCasa / 5) * 0.15f * salarioBase;

        // Acréscimos por turno
        float aumentoPorTurno = 0;
        switch (funcionario.getTurno()) {
            case "Vespertino":
                aumentoPorTurno = 0.05f * salarioBase;
                break;
            case "Noturno":
                aumentoPorTurno = 0.30f * salarioBase; 
                break;
        }

        return salarioBase + aumentoPorTempo + aumentoPorTurno;
    }
}

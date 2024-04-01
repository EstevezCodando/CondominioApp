package controleCondominioApp.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import controleCondominioApp.model.domain.Funcionario;
import controleCondominioApp.model.domain.Morador;
import controleCondominioApp.model.domain.Veiculo;
import controleCondominioApp.model.domain.Visitante;

public class VeiculoService {
    private static Map<Integer, Veiculo> veiculos = new HashMap<>();
	private static Integer nextId = 0;

	 public static void incluir(Veiculo veiculo) {
	        if (veiculo == null) {
	            throw new IllegalArgumentException("Veículo não pode ser nulo.");
	        }
	        veiculo.setId(++nextId);
	        veiculos.put(veiculo.getId(), veiculo);

	        if (veiculo.getcpfProprietario() != null && !veiculo.getcpfProprietario().isEmpty()) {
	            associarVeiculoAoProprietarioPeloCpf(veiculo.getcpfProprietario(), veiculo.getPlaca());
	        }
	    }
    

    public static Collection<Veiculo> obterLista() {
        return veiculos.values();
    }
    
    public static Veiculo obterPorId(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("ID não pode ser nulo.");
        }
        return veiculos.get(id);
    }

    public static void excluir(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("ID não pode ser nulo.");
        }
        veiculos.remove(id);
    }
    
    
    public static void associarVeiculoAoProprietarioPeloCpf(String cpf, String placa) {
        Veiculo veiculo = veiculos.values().stream()
            .filter(v -> v.getPlaca().equals(placa))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("Veículo não encontrado com placa: " + placa));

        Funcionario funcionario = FuncionarioService.obterPorCpf(cpf);
        if (funcionario != null) {
            funcionario.getVeiculo().add(veiculo);
            return;
        }

        Morador morador = MoradorService.obterPorCpf(cpf);
        if (morador != null) {
            morador.getVeiculo().add(veiculo);
            return;
        }

        Visitante visitante = VisitanteService.obterPorCpf(cpf);
        if (visitante != null) {
            visitante.getVeiculo().add(veiculo);
            return;
        }

        throw new IllegalArgumentException("Proprietário não encontrado com CPF: " + cpf);
    }

}

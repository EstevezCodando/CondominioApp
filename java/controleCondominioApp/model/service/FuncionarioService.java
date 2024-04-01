package controleCondominioApp.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import controleCondominioApp.model.domain.Endereco;
import controleCondominioApp.model.domain.Funcionario;
import controleCondominioApp.model.domain.Soldo;

public class FuncionarioService {
	
	private static Map<Integer, Funcionario> funcionarios = new HashMap<>();
	private static Integer nextId = 0;

	EnderecoService enderecoService = new EnderecoService();

	public static void incluir(Funcionario funcionario) {
		if (funcionario.getEndereco() != null && funcionario.getEndereco().getCep() != null) {

			Endereco enderecoCompleto = EnderecoService.obterEnderecoPorCep(funcionario.getEndereco().getCep());
			funcionario.setEndereco(enderecoCompleto);
			
		}
		// Recalcula o salario do funcionario de acordo com o tempo de sv e turno
		float salarioCalculado = Soldo.calcularSalario(funcionario);
	    funcionario.setSalario(salarioCalculado);
		funcionario.setId(++nextId);
		funcionarios.put(funcionario.getId(), funcionario);
	}

	public static Collection<Funcionario> obterLista() {
		return funcionarios.values();
	}

	public static Funcionario obterPorId(Integer id) {
		return funcionarios.get(id);
	}

	public static void excluir(Integer id) {
		funcionarios.remove(id);
	}
	
	public static Funcionario obterPorCpf(String cpf) {
        return funcionarios.values().stream()
            .filter(funcionario -> funcionario.getCpf().equals(cpf))
            .findFirst()
            .orElse(null);
    }
	
//	private static FuncionarioService instance;
//	private FuncionarioService() {
//	}
//
//	public static FuncionarioService getInstance() {
//		if (instance == null) {
//			instance = new FuncionarioService();
//		}
//		return instance;
//	}

}

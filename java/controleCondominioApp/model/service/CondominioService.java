package controleCondominioApp.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import controleCondominioApp.model.domain.AreaComum;
import controleCondominioApp.model.domain.Condominio;
import controleCondominioApp.model.domain.Endereco;
import controleCondominioApp.model.domain.Funcionario;
import controleCondominioApp.model.domain.Morador;
import controleCondominioApp.model.domain.Visitante;

public class CondominioService {
	private static Map<Integer, Condominio> condominios = new HashMap<Integer, Condominio>();
	private static Integer nextId = 0;

	public static void incluir(Condominio condominio) {
		if (condominio.getEndereco() != null && condominio.getEndereco().getCep() != null) {

			Endereco enderecoCompleto = EnderecoService.obterEnderecoPorCep(condominio.getEndereco().getCep());
			condominio.setEndereco(enderecoCompleto);
			
		}
		condominio.setId(++nextId);
		condominios.put(condominio.getId(), condominio);
	}



	public static Collection<Condominio> obterLista() {
		return condominios.values();
	}
	
	public static Condominio obterPorId(Integer id) {
		return condominios.get(id);
	}

	public static void excluir(Integer id) {
		condominios.remove(id);
	}
	
	public static void adicionarAreaComum(int condominioId, AreaComum area) {
        Condominio condominio = obterPorId(condominioId);
        if (!condominio.getAreaComum().contains(area)) {
        	condominio.getAreaComum().add(area);
        	}
        	return;
    }


    public static void removerAreaComum(int condominioId, int areaId) {
        Condominio condominio = obterPorId(condominioId);
        condominio.getAreaComum().removeIf(area -> area.getId().equals(areaId));
    }

    // Associar e desassociar funcionários
    public static void adicionarFuncionario(int condominioId, Funcionario funcionario) {
        Condominio condominio = obterPorId(condominioId);
        condominio.getFuncionario().add(funcionario);
    }

    public static void removerFuncionario(int condominioId, int funcionarioId) {
        Condominio condominio = obterPorId(condominioId);
        condominio.getFuncionario().removeIf(func -> func.getId().equals(funcionarioId));
    }

    // Associar e desassociar moradores Alterando o numero de apartamentos vagos de acordo com a unidade ocupada
    public static void adicionarMorador(int condominioId, Morador morador) {
        Condominio condominio = obterPorId(condominioId);
        condominio.getMorador().add(morador); // Adiciona o morador independente da unidade
        condominio.atualizarApartamentosVagos(); // Atualiza a contagem de apartamentos vagos
    }

    public static void removerMorador(int condominioId, int moradorId) {
        Condominio condominio = obterPorId(condominioId);
        Morador moradorParaRemover = condominio.getMorador().stream()
                .filter(mor -> mor.getId().equals(moradorId))
                .findFirst()
                .orElse(null);

        if (moradorParaRemover != null) {
            condominio.getMorador().remove(moradorParaRemover);
            condominio.atualizarApartamentosVagos();
        }
    }

    // Associar e desassociar visitantes
    public static void registrarEntradaVisitante(int condominioId, Visitante visitante) {
        Condominio condominio = obterPorId(condominioId);
        condominio.getVisitante().add(visitante);
    }

    public static void registrarSaidaVisitante(int condominioId, int visitanteId) {
        Condominio condominio = obterPorId(condominioId);
        condominio.getVisitante().removeIf(vis -> vis.getId().equals(visitanteId));
    }
}

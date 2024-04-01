package controleCondominioApp.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import controleCondominioApp.model.domain.Visitante;

public class VisitanteService {
    private static Map<Integer, Visitante> visitantes = new HashMap<>();
	private static Integer nextId = 0;

    public static Visitante incluir(Visitante visitante) {
        if (visitante == null) {
            throw new IllegalArgumentException("Visitante não pode ser nulo.");
        }
 
        visitante.setId(++nextId);
        visitantes.put(nextId, visitante);
        return visitante;
    }

    public static Visitante obterPorId(Integer id) {
        return visitantes.get(id);
    }

    public static Collection<Visitante> obterLista() {
        return visitantes.values();
    }

    public static void excluir(Integer id) {
         visitantes.remove(id);
    }
    
    public static Visitante obterPorCpf(String cpf) {
        return visitantes.values().stream()
            .filter(visitante -> visitante.getCpf().equals(cpf))
            .findFirst()
            .orElse(null);
    }
}

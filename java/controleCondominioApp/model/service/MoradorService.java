package controleCondominioApp.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import controleCondominioApp.model.domain.Morador;

public class MoradorService {
	
    private static Map<Integer, Morador> moradores = new HashMap<Integer, Morador>();
    private static Integer nextId = 0;

    public static void incluir(Morador morador) {
        morador.setId(++nextId);
        moradores.put(morador.getId(), morador);
    }

    public static Collection<Morador> obterLista() {
        return moradores.values();
    }

    public static Morador obterPorId(Integer id) {
        return moradores.get(id);
    }

    public static boolean excluir(Integer id) {
        if (!moradores.containsKey(id)) {
            throw new IllegalArgumentException("Morador não encontrado para o ID: " + id);
        }
        return moradores.remove(id) != null;
    }
    
    public static Morador obterPorCpf(String cpf) {
        return moradores.values().stream()
            .filter(morador -> morador.getCpf().equals(cpf))
            .findFirst()
            .orElse(null);
    }
    
}

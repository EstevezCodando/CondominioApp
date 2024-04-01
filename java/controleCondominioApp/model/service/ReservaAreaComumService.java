package controleCondominioApp.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import controleCondominioApp.model.domain.ReservaAreaComum;

public class ReservaAreaComumService {
	private static Map<Integer, ReservaAreaComum> reservasAreaComum = new HashMap<>();
	private static Integer nextId = 0;

	public static void incluir(ReservaAreaComum reservaAreaComum) {
		reservaAreaComum.setId(++nextId);
		reservasAreaComum.put(reservaAreaComum.getId(), reservaAreaComum);
	}

	public static Collection<ReservaAreaComum> obterLista() {
		return reservasAreaComum.values(); 
	}

	public static ReservaAreaComum obterPorId(Integer id) {
		return reservasAreaComum.get(id);
	}

	public static void excluir(Integer id) {
		reservasAreaComum.remove(id);
	}
	
}

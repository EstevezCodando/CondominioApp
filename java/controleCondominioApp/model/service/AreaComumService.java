package controleCondominioApp.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import controleCondominioApp.model.domain.AreaComum;

public class AreaComumService {
	private static Map<Integer, AreaComum> areasComuns = new HashMap<Integer, AreaComum>();
	private static Integer nextId = 0;

	public static void incluir(AreaComum areaComum) {
		areaComum.setId(++nextId);
		areasComuns.put(areaComum.getId(), areaComum);
	}

	public static Optional<AreaComum> obterPorId(Integer id) {
		return Optional.ofNullable(areasComuns.get(id));
	}

	public static Collection<AreaComum> obterLista() {
		return areasComuns.values();
	}

	public static boolean excluir(Integer id) {
		return areasComuns.remove(id) != null;
	}
}

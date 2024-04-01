package controleCondominioApp.model.service;

import controleCondominioApp.model.domain.Condominio;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CondominioService {
	private final Map<Integer, Condominio> condominios = new HashMap<Integer, Condominio>();
	private Integer nextId = 0;

	public void incluir(Condominio condominio) {
		condominio.setId(++nextId);
		condominios.put(condominio.getId(), condominio);
	}

	public Optional<Condominio> obterPorId(Integer id) {
		return Optional.ofNullable(condominios.get(id));
	}

	public Collection<Condominio> obterLista() {
		return condominios.values();
	}

	public boolean excluir(Integer id) {
		return condominios.remove(id) != null;
	}
}

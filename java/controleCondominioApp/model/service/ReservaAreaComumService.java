package controleCondominioApp.model.service;

import controleCondominioApp.model.domain.ReservaAreaComum;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ReservaAreaComumService {
	private final Map<Integer, ReservaAreaComum> reservasAreaComum = new HashMap<>();
	private Integer nextId = 0;

	public ReservaAreaComum incluir(ReservaAreaComum reservaAreaComum) {
		reservaAreaComum.setId(++nextId);
		reservasAreaComum.put(reservaAreaComum.getId(), reservaAreaComum);

		// Adiciona a reserva à lista de reservas da área comum
		reservaAreaComum.getAreaComum().getReservas().add(reservaAreaComum);

		return reservaAreaComum;
	}

	public Optional<ReservaAreaComum> obterPorId(Integer id) {
		return Optional.ofNullable(reservasAreaComum.get(id));
	}

	public Collection<ReservaAreaComum> obterLista() {
		return reservasAreaComum.values();
	}

	public boolean excluir(Integer id) {
		ReservaAreaComum reserva = reservasAreaComum.remove(id);
		if (reserva != null) {
			reserva.getAreaComum().getReservas().remove(reserva);
			return true;
		}
		return false;
	}
}

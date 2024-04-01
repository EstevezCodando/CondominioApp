package controleCondominioApp.model.domain;

import java.util.ArrayList;
import java.util.List;

public class AreaComum {
	private Integer id;
	private String nome;
	private int capacidade;
	private List<ReservaAreaComum> reservas = new ArrayList<>();

	public AreaComum(String nome, int capacidade) {
		super();
		this.nome = nome;
		this.capacidade = capacidade;
	}
	public AreaComum() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	public List<ReservaAreaComum> getReservas() {
		return reservas;
	}

	public void setReservas(List<ReservaAreaComum> reservas) {
		this.reservas = reservas;
	}

	public void addReserva(ReservaAreaComum reserva) {
		reservas.add(reserva);
	}

	public void removeReserva(ReservaAreaComum reserva) {
		reservas.remove(reserva);
	}

	@Override
	public String toString() {
		return "AreaComum [nome=" + nome + ", capacidade=" + capacidade + "]";
	}

}

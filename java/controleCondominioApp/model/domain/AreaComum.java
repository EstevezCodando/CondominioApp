package controleCondominioApp.model.domain;

import java.util.ArrayList;
import java.util.List;

public class AreaComum {
	private Integer id;
	private String nome;
	private int capacidade;
	private Integer condominioId;
	private List<ReservaAreaComum> reservaAreaComum;

	public AreaComum(String nome, int capacidade, Integer condominioId, List<ReservaAreaComum> reservaAreaComum) {
		super();
		this.nome = nome;
		this.condominioId = condominioId;
		this.capacidade = capacidade;
		this.reservaAreaComum = new ArrayList<>();
	}
	public AreaComum() {}
	

	public List<ReservaAreaComum> getReservaAreaComum() {
		return reservaAreaComum;
	}
	public void setReservaAreaComum(List<ReservaAreaComum> reservaAreaComum) {
		this.reservaAreaComum = reservaAreaComum;
	}
	
	public Integer getCondominioId() {
		return condominioId;
	}
	public void setCondominio(Integer condominioId) {
		this.condominioId = condominioId;
	}
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


	@Override
	public String toString() {
		return "AreaComum [Nome:" + nome + ", Capacidade=" + capacidade + ", Reservas: "+ reservaAreaComum +  " ]";
	}

}

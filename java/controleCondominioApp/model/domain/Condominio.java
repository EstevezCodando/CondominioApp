package controleCondominioApp.model.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Condominio {
	private int id;
	private String nome;
	private Endereco endereco;
	private int totalDeApartamentos;
	private int apartamentosVagos;
	private int vagasEstacionamento;
	private List<AreaComum> areaComum;
	private List<Funcionario> funcionario;
	private List<Visitante> visitante;
	private List<Morador> morador;

	public Condominio(String nome, Endereco endereco, int totalDeApartamentos, int vagasEstacionamento,
			List<AreaComum> areaComum, List<Funcionario> funcionario, List<Visitante> visitante, List<Morador> morador) {
		this.nome = nome;
		this.endereco = endereco;
		this.totalDeApartamentos = totalDeApartamentos;
		this.vagasEstacionamento = vagasEstacionamento;
		this.apartamentosVagos = totalDeApartamentos;
		this.areaComum = new ArrayList<>();
		this.funcionario = new ArrayList<>();
		this.morador = new ArrayList<>();
		this.visitante = new ArrayList<>();
	}
	
	public void atualizarApartamentosVagos() {
	    Set<String> unidadesOcupadas = new HashSet<>();
	    for (Morador morador : this.morador) {
	        unidadesOcupadas.add(morador.getUnidade());
	    }
	    this.apartamentosVagos = this.totalDeApartamentos - unidadesOcupadas.size();
	}



	// Getters e Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}


	public int getTotalDeApartamentos() {
		return totalDeApartamentos;
	}

	public void setTotalDeApartamentos(int totalDeApartamentos) {
		this.totalDeApartamentos = totalDeApartamentos;
	}

	public int getApartamentosVagos() {
		return apartamentosVagos;
	}

	public void setApartamentosVagos(int apartamentosVagos) {
		this.apartamentosVagos = apartamentosVagos;
	}

	public int getVagasEstacionamento() {
		return vagasEstacionamento;
	}

	public void setVagasEstacionamento(int vagasEstacionamento) {
		this.vagasEstacionamento = vagasEstacionamento;
	}
	
	public List<AreaComum> getAreaComum() {
		return areaComum;
	}

	public void setAreaComum(List<AreaComum> areaComum) {
		this.areaComum = areaComum;
	}

	public List<Funcionario> getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(List<Funcionario> funcionario) {
		this.funcionario = funcionario;
	}

	public List<Visitante> getVisitante() {
		return visitante;
	}

	public void setVisitante(List<Visitante> visitante) {
		this.visitante = visitante;
	}

	public List<Morador> getMorador() {
		return morador;
	}

	public void setMorador(List<Morador> morador) {
		this.morador = morador;
	}
	

}

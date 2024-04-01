package controleCondominioApp.model.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Visitante extends Pessoa {

	private LocalDateTime entrada;
	private LocalDateTime saida;
	private Morador MoradorResponsavel;
	private String observacoes;
	private List<Veiculo> veiculo;


	public Visitante(LocalDateTime entrada, LocalDateTime saida, Morador moradorResponsavel, Veiculo veiculo,
			String observacoes) {
		super();
		this.entrada = entrada;
		this.saida = saida;
		MoradorResponsavel = moradorResponsavel;
		this.observacoes = observacoes;
		this.veiculo = new ArrayList<>();

	}

	public Visitante(String nome, String telefone, String cpf, String email, LocalDateTime entrada, LocalDateTime saida,
			Morador moradorResponsavel, String observacoes, List<Veiculo> veiculo) {
		super(nome, telefone, cpf, email);
		this.entrada = entrada;
		this.saida = saida;
		MoradorResponsavel = moradorResponsavel;
		this.observacoes = observacoes;
		this.veiculo = new ArrayList<>();

	}

	public Visitante() {
        this.veiculo = new ArrayList<>();
    }

	public List<Veiculo> getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(List<Veiculo> veiculo) {
		this.veiculo = veiculo;
	}

	public LocalDateTime getEntrada() {
		return entrada;
	}

	public void setEntrada(LocalDateTime entrada) {
		this.entrada = entrada;
	}

	public LocalDateTime getSaida() {
		return saida;
	}

	public void setSaida(LocalDateTime saida) {
		this.saida = saida;
	}

	public Morador getMoradorResponsavel() {
		return MoradorResponsavel;
	}

	public void setMoradorResponsavel(Morador moradorResponsavel) {
		MoradorResponsavel = moradorResponsavel;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	
	public String getEntradaString() {
		if (entrada == null) {
			return null;
		}
		return entrada.format(DateTimeFormatter.ISO_LOCAL_DATE);
	}
	public String getSaidaString() {
		if (saida == null) {
			return null;
		}
		return saida.format(DateTimeFormatter.ISO_LOCAL_DATE);
	}

	@Override
	public String toString() {
		return "Visitante: "+ getNome()+ "Horario de Entrada: " + entrada + ", Horario de Saida:" + saida + ", Morador Responsavel: " + MoradorResponsavel
				+ ", observacoes:" + observacoes + ", veiculo:" + veiculo + "]";
	}
	
	

}

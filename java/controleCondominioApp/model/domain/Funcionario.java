package controleCondominioApp.model.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Funcionario extends Pessoa {
	private cargo cargo;
	private String matricula;
	private String turno;
	private Float salario;
	private LocalDateTime dataAdmissao;
	private List<Veiculo> veiculo;

	public enum cargo {
		Porteiro, Zelador, Encanador, Vigilante, Limpeza,
	}
	
	public Funcionario() {
        this.veiculo = new ArrayList<>();
    }


	public Funcionario(String nome, String telefone, String cpf, String email, Endereco endereco, cargo cargo, String matricula,
			String turno, Float salario, LocalDateTime dataAdmissao, List<Veiculo> veiculo) {
		super(nome, telefone, cpf, email, endereco);
		this.cargo = cargo;
		this.matricula = matricula;
		this.turno = turno;
		this.salario = salario;
		this.dataAdmissao = dataAdmissao;
		this.veiculo = new ArrayList<>();
	}

	public cargo getCargo() {
		return cargo;
	}

	public void setCargo(cargo cargo) {
		this.cargo = cargo;
	}


	public List<Veiculo> getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(List<Veiculo> veiculo) {
		this.veiculo = veiculo;
	}

	public cargo getFuncao() {
		return cargo;
	}

	public void setFuncao(cargo cargo) {
		this.cargo = cargo;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public Float getSalario() {
		return salario;
	}

	public void setSalario(Float salario) {
		this.salario = salario;
	}

	public LocalDateTime getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(LocalDateTime dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}
	
	

	@Override
	public String toString() {
		return "Funcionarios [ ID:" + getId() + ", Nome: " + getNome() + ", Matricula:" + matricula + ", Cargo:" + cargo
				+ ", Turno:" + turno + ", Salario: R$ " + String.format("%.2f", salario) + ", Data de Admissao:"
				+ dataAdmissao + ", Veiculos: " + getVeiculo() + ", Endereco: " + getEndereco() + "]";
	}

}

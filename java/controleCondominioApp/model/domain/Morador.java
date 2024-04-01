package controleCondominioApp.model.domain;

import java.util.ArrayList;
import java.util.List;

public class Morador extends Pessoa {
    private String unidade;
    private boolean proprietario;
    private List<Veiculo> veiculo;

    public Morador(String nome, String telefone, String cpf, String email, String unidade, boolean proprietario, List<Veiculo> veiculo) {
        super(nome, telefone, cpf, email);
        this.unidade = unidade;
        this.proprietario = proprietario;
        this.veiculo = new ArrayList<>();
    }
    public Morador() {
        this.veiculo = new ArrayList<>();
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public boolean isProprietario() {
        return proprietario;
    }

    public void setProprietario(boolean proprietario) {
        this.proprietario = proprietario;
    }
    

	
	public List<Veiculo> getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(List<Veiculo> veiculo) {
		this.veiculo = veiculo;
	}
	
	@Override
    public String toString() {
        return "Morador [Nome: " + getNome() + ", Apartamento: " + unidade + ", Proprietario:" + proprietario
                + ", Id: " + getId() + ", Telefone: " + getTelefone() + ", Cpf:" + getCpf() + ", Email:" + getEmail()
                + ", Veiculo: " + veiculo + "]";
    }
}

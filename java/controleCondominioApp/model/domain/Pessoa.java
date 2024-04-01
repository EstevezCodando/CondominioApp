package controleCondominioApp.model.domain;

public class Pessoa {

	private Integer id;
	private String nome;
	private String telefone;
	private String cpf;
	private String email;
	private Endereco endereco;

	public Pessoa() {
	}

	public Pessoa(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}

	public Pessoa(String nome, String cpf, Endereco endereco) {
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
	}
	
	public Pessoa(String nome, String telefone, String cpf, String email, Endereco endereco) {
		this.nome = nome;
		this.telefone = telefone;
		this.cpf = cpf;
		this.email = email;
		this.endereco = endereco;
	}


	public Pessoa(Integer id, String nome, String telefone, String cpf, String email, Endereco endereco) {
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.cpf = cpf;
		this.email = email;
		this.endereco = endereco;
	}

	public Pessoa(String nome, String telefone, String cpf, String email) {
		this.nome = nome;
		this.telefone = telefone;
		this.cpf = cpf;
		this.email = email;
		// TODO Auto-generated constructor stub
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "Nome: " + nome;
	}

}

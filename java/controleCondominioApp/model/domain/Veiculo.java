package controleCondominioApp.model.domain;

public class Veiculo {
    
    private Integer id;
    private String tipo;
    private String marca;
    private String modelo;
    private String cor;
    private String placa;
    private String cpfProprietario;
    
    public Veiculo() {
        
    }
    
    public Veiculo(String tipo, String marca, String modelo, String cor, String placa, String cpfProprietario) {
        this.tipo = tipo;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.placa = placa;
        this.cpfProprietario = cpfProprietario;
    }
    

    public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getcpfProprietario() {
        return cpfProprietario;
    }

    public void setIdProprietario(String idProprietario) {
        this.cpfProprietario = idProprietario;
    }

    

	@Override
	public String toString() {
		return "Veiculo [Id: " + id + ", Tipo:" + tipo + ", Marca:" + marca + ", Modelo:" + modelo + ", Cor:" + cor
				+ ", Placa:" + placa + ", cpfProprietario:" + cpfProprietario + " ]";
	}
    
    
}

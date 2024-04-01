package controleCondominioApp.model.domain;

import java.util.List;

public class Condominio {
    private int id;
    private String nome;
    private Endereco endereco;
    private List<AreaComum> areasComuns;
    private int totalDeApartamentos;
    private int apartamentosVagos;
    private int vagasEstacionamento;

    
    public Condominio(String nome, Endereco endereco, int totalDeApartamentos, int vagasEstacionamento) {
        this.nome = nome;
        this.endereco = endereco;
        this.totalDeApartamentos = totalDeApartamentos;
        this.vagasEstacionamento = vagasEstacionamento;
        this.apartamentosVagos = totalDeApartamentos; 
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

 
    public List<AreaComum> getAreasComuns() {
        return areasComuns;
    }

    public void setAreasComuns(List<AreaComum> areasComuns) {
        this.areasComuns = areasComuns;
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

    
}

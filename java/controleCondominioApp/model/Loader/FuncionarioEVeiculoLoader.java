package controleCondominioApp.model.Loader;

import java.time.LocalDate;

import controleCondominioApp.model.domain.Endereco;
import controleCondominioApp.model.domain.Funcionario;
import controleCondominioApp.model.domain.Veiculo;
import controleCondominioApp.model.service.FuncionarioService;
import controleCondominioApp.model.service.VeiculoService;

public class FuncionarioEVeiculoLoader {

	public static void main(String[] args) {

		Funcionario funcionario1 = new Funcionario("João Silva", "11987654321", "11122233344", "joao@empresa.com",
				new Endereco("24900570"), // Casa Marica
				Funcionario.cargo.Zelador, "001", "Noturno", 3000.00f, LocalDate.of(2020, 1, 1),null);

		Funcionario funcionario2 = new Funcionario("Maria Oliveira", "11987654322", "22233344455", "maria@empresa.com",
				new Endereco("02040000"), // Casa SP
				Funcionario.cargo.Limpeza, "002", "Diurno", 2500.00f, LocalDate.of(2021, 5, 15),null);

		Funcionario funcionario3 = new Funcionario("Carlos Santos", "11987654323", "33344455566", "carlos@empresa.com",
				new Endereco("22070011"), // Casa Copacabana
				Funcionario.cargo.Vigilante, "003", "Noturno", 2800.00f, LocalDate.of(2019, 3, 20),null);

		Funcionario funcionario4 = new Funcionario("Ana Costa", "11987654324", "44455566677", "ana@empresa.com",
				new Endereco("70704045"), // Casa Brasilia
				Funcionario.cargo.Porteiro, "004", "Diurno", 2200.00f, LocalDate.of(2022, 7, 10),null);

		Funcionario funcionario5 = new Funcionario("Pedro Rocha", "11987654325", "55566677788", "pedro@empresa.com",
				new Endereco("59020000"), // Natal
				Funcionario.cargo.Encanador, "005", "Diurno", 2700.00f, LocalDate.of(2018, 11, 30),null);

		FuncionarioService.incluir(funcionario1);
		FuncionarioService.incluir(funcionario2);
		FuncionarioService.incluir(funcionario3);
		FuncionarioService.incluir(funcionario4);
		FuncionarioService.incluir(funcionario5);
		
		Veiculo V1 = new Veiculo("Carro", "Ford", "Focus", "Azul", "ABC1234", funcionario1.getCpf());
		Veiculo V2 = new Veiculo("Moto", "Honda", "CB500", "Preto", "DEF5678", funcionario1.getCpf());
		Veiculo V3 = new Veiculo("Carro", "Toyota", "Corolla", "Branco", "GHI9101", funcionario2.getCpf());
		Veiculo V4 = new Veiculo("Bicicleta", "Caloi", "10", "Vermelho", "JKL2345", funcionario3.getCpf());
		Veiculo V5 = new Veiculo("Carro", "Chevrolet", "Onix", "Prata", "MNO6789", null);
		
        VeiculoService.incluir(V1);
        VeiculoService.incluir(V2);
        VeiculoService.incluir(V3);
        VeiculoService.incluir(V4);
        VeiculoService.incluir(V5);
        
   
        
	}
}

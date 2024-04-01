package controleCondominioApp.model.Loader;

import java.time.LocalDateTime;

import controleCondominioApp.model.domain.AreaComum;
import controleCondominioApp.model.domain.Condominio;
import controleCondominioApp.model.domain.Endereco;
import controleCondominioApp.model.domain.Funcionario;
import controleCondominioApp.model.domain.Morador;
import controleCondominioApp.model.domain.Veiculo;
import controleCondominioApp.model.domain.Visitante;
import controleCondominioApp.model.service.AreaComumService;
import controleCondominioApp.model.service.CondominioService;
import controleCondominioApp.model.service.FuncionarioService;
import controleCondominioApp.model.service.MoradorService;
import controleCondominioApp.model.service.VeiculoService;

public class FuncionarioEVeiculoLoader {

	public static void main(String[] args) {

		Condominio condominio = new Condominio("Condominio CopaMar", new Endereco("12345678"), 100, 20, null, null,
				null, null);
		CondominioService.incluir(condominio);

		AreaComum play = new AreaComum("Playground", 50, 1, null);
		AreaComum salaDeJogos = new AreaComum("Sala de Jogos", 30, 1, null);

		AreaComumService.incluir(play);
		AreaComumService.incluir(salaDeJogos);

		CondominioService.adicionarAreaComum(condominio.getId(), play);
		CondominioService.adicionarAreaComum(condominio.getId(), salaDeJogos);

		// Criando funcionários
		Funcionario porteiro = new Funcionario("João", "11999999999", "123.456.789-00", "joao@condominio.com", null,
				Funcionario.cargo.Porteiro, "001", "Noturno", 3000f, LocalDateTime.now(), null);
		Funcionario zelador = new Funcionario("Carlos", "11888888888", "987.654.321-00", "carlos@condominio.com", null,
				Funcionario.cargo.Zelador, "002", "Diurno", 4000f, LocalDateTime.now(), null);

		CondominioService.adicionarFuncionario(condominio.getId(), porteiro);
		CondominioService.adicionarFuncionario(condominio.getId(), zelador);

		// Criando moradores
		Morador morador8 = new Morador("Maria", "1177777777", "111.222.333-44", "maria@condominio.com", "101", true,
				null);
		Morador morador9 = new Morador("Pedro", "1166666666", "444.555.666-77", "pedro@condominio.com", "102", false,
				null);
		Morador morador4 = new Morador("Suares Costa", "11987654324", "5509487023", "suares@empresa.com", "101", false,
				null);
		Morador morador5 = new Morador("Jaime Rocha", "11987654325", "8509487023", "jaime@empresa.com", "501", false,
				null);
		MoradorService.incluir(morador4);
		MoradorService.incluir(morador5);

		CondominioService.adicionarMorador(condominio.getId(), morador4);
		CondominioService.adicionarMorador(condominio.getId(), morador5);
		CondominioService.adicionarMorador(condominio.getId(), morador8);
		CondominioService.adicionarMorador(condominio.getId(), morador9);

		Veiculo V3 = new Veiculo("Carro", "Toyota", "L200", "Branco", "AA232", morador4.getCpf());
		Veiculo V4 = new Veiculo("Bicicleta", "Caloi", "10", "Vermelho", "CC234", morador4.getCpf());
		VeiculoService.incluir(V3);
		VeiculoService.incluir(V4);

		// Criando visitantes
		Visitante visitante1 = new Visitante("Joseph", "1155555555", "999.888.777-66", "visitante1@condominio.com",
				LocalDateTime.now(), null, morador8, "Amigo", null);

		CondominioService.registrarEntradaVisitante(condominio.getId(), visitante1);

		Funcionario funcionario1 = new Funcionario("João Silva", "11987654321", "11122233344", "joao@empresa.com",
				new Endereco("24900570"), // Casa Marica
				Funcionario.cargo.Zelador, "001", "Noturno", 3000.00f, LocalDateTime.of(2020, 1, 1, 12, 0), null);

		Funcionario funcionario2 = new Funcionario("Maria Oliveira", "11987654322", "22233344455", "maria@empresa.com",
				new Endereco("02040000"), // Casa SP
				Funcionario.cargo.Limpeza, "002", "Diurno", 2500.00f, LocalDateTime.of(2021, 5, 15, 12, 0), null);

		Funcionario funcionario3 = new Funcionario("Carlos Santos", "11987654323", "33344455566", "carlos@empresa.com",
				new Endereco("22070011"), // Casa Copacabana
				Funcionario.cargo.Vigilante, "003", "Noturno", 2800.00f, LocalDateTime.of(2019, 3, 20, 12, 0), null);

		Funcionario funcionario4 = new Funcionario("Ana Costa", "11987654324", "44455566677", "ana@empresa.com",
				new Endereco("70704045"), // Casa Brasilia
				Funcionario.cargo.Porteiro, "004", "Diurno", 2200.00f, LocalDateTime.of(2022, 7, 10, 12, 0), null);

		Funcionario funcionario5 = new Funcionario("Pedro Rocha", "11987654325", "55566677788", "pedro@empresa.com",
				new Endereco("59020000"), // Natal
				Funcionario.cargo.Encanador, "005", "Diurno", 2700.00f, LocalDateTime.of(2018, 11, 30, 12, 0), null);

		FuncionarioService.incluir(funcionario1);
		FuncionarioService.incluir(funcionario2);
		FuncionarioService.incluir(funcionario3);
		FuncionarioService.incluir(funcionario4);
		FuncionarioService.incluir(funcionario5);

		Veiculo V1 = new Veiculo("Carro", "Ford", "Focus", "Azul", "ABC1234", funcionario1.getCpf());
		Veiculo V2 = new Veiculo("Moto", "Honda", "CB500", "Preto", "DEF5678", funcionario1.getCpf());
		Veiculo V5 = new Veiculo("Carro", "Chevrolet", "Onix", "Prata", "MNO6789", null);

		VeiculoService.incluir(V1);
		VeiculoService.incluir(V2);
		VeiculoService.incluir(V3);
		VeiculoService.incluir(V4);
		VeiculoService.incluir(V5);

	}
}
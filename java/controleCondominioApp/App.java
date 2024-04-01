package controleCondominioApp;

import static spark.Spark.staticFiles;

import controleCondominioApp.model.controller.AreaComumController;
import controleCondominioApp.model.controller.EnderecoController;
import controleCondominioApp.model.controller.FuncionarioController;
import controleCondominioApp.model.controller.MoradorController;
import controleCondominioApp.model.controller.ReservaAreaComumController;
import controleCondominioApp.model.controller.VeiculoController;
import controleCondominioApp.model.controller.VisitanteController;
import spark.Spark;

public class App {

	public static void main(String[] args) {
		// Loader Funcionarios
		controleCondominioApp.model.Loader.FuncionarioEVeiculoLoader.main(args);
		//Loader Moradores
		controleCondominioApp.model.Loader.MoradorEVeiculoLoader.main(args);
		//Loader Visitantes
		controleCondominioApp.model.Loader.VisitanteEVeiculoLoader.main(args);

	
		staticFiles.location("/");

		Spark.port(8080);
		Spark.get("/", (req, res) -> {
			return App.class.getResourceAsStream("/index.html");

		});
		Spark.get("/sparkjava", (req, res) -> {
			return App.class.getResourceAsStream("/sparkjava.html");
		});

		Spark.get("/api", (req, res) -> {
			return App.class.getResourceAsStream("/api.html");
		});

		// VIACEP
		Spark.get("/viacep/:cep", EnderecoController.obterEnderecoPorCep);

		// Funcionarios
		Spark.get("/funcionarios/lista", FuncionarioController.obterLista);
		Spark.post("/funcionarios/incluir", FuncionarioController.incluir);
		Spark.delete("/funcionarios/:id/excluir", FuncionarioController.excluir);
		Spark.get("/funcionarios/:id", FuncionarioController.obterPorId);

		// Visitante
		Spark.get("/visitantes/lista", VisitanteController.obterLista);
		Spark.post("/visitantes/incluir", VisitanteController.incluir);
		Spark.delete("/visitantes/:id/excluir", VisitanteController.excluir);
		Spark.get("/visitantes/:id", VisitanteController.obterPorId);

		// Morador
		Spark.get("/moradores/lista", MoradorController.obterLista);
		Spark.post("/moradores/incluir", MoradorController.incluir);
		Spark.delete("/moradores/:id/excluir", MoradorController.excluir);
		Spark.get("/moradores/:id", MoradorController.obterPorId);

		// AreaComum
		Spark.get("/areascomuns/lista", AreaComumController.obterLista);
		Spark.post("/areascomuns/incluir", AreaComumController.incluir);
		Spark.delete("/areascomuns/:id/excluir", AreaComumController.excluir);
		Spark.get("/areascomuns/:id", AreaComumController.obterPorId);

		// Reserva Area Comum
		Spark.get("/reservasareascomuns/lista", ReservaAreaComumController.obterLista);
		Spark.post("/reservasareascomuns/incluir", ReservaAreaComumController.incluir);
		Spark.delete("/reservasareascomuns/:id/excluir", ReservaAreaComumController.excluir);
		Spark.get("/reservasareascomuns/:id", ReservaAreaComumController.obterPorId);

		// Veiculos
		Spark.get("/veiculos/lista", VeiculoController.obterLista);
		Spark.post("/veiculos/incluir", VeiculoController.incluir);
		Spark.delete("/veiculos/:id/excluir", VeiculoController.excluir);
		Spark.get("/veiculos/:id", VeiculoController.obterPorId);

	}

}

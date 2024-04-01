package controleCondominioApp.model.controller;

import controleCondominioApp.model.domain.Condominio;
import controleCondominioApp.model.service.CondominioService;
import spark.Route;

public class CondominioController {

	private static CondominioService condominioService = new CondominioService();

	public static Route obterLista = (req, res) -> condominioService.obterLista();

	//public static Route incluir = (req, res) -> {

//		return "Condomínio: " + novoCondominio.getNome() + " incluído com sucesso";
	//};

	public static Route excluir = (req, res) -> {
		Integer id = Integer.valueOf(req.params("id"));
		if (condominioService.excluir(id)) {
			return "Condomínio removido com sucesso.";
		} else {
			res.status(404);
			return "Condomínio não encontrado.";
		}
	};

	public static Route obterPorId = (req, res) -> {
		Integer id = Integer.valueOf(req.params("id"));
		return condominioService.obterPorId(id).map(Condominio::toString).orElse("Condomínio não encontrado.");
	};
}

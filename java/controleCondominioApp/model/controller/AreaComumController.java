package controleCondominioApp.model.controller;

import controleCondominioApp.model.domain.AreaComum;
import controleCondominioApp.model.service.AreaComumService;
import spark.Route;

public class AreaComumController {

	public static Route obterLista = (req, res) -> AreaComumService.obterLista();

	public static Route incluir = (req, res) -> {
		AreaComum novaAreaComum = new AreaComum();
		AreaComumService.incluir(novaAreaComum);
		return "Area Comum: " + novaAreaComum.getNome() + " incluída com sucesso";
	};

	public static Route excluir = (req, res) -> {
		Integer id = Integer.valueOf(req.params("id"));
		if (AreaComumService.excluir(id)) {
			return "Área Comum removida com sucesso.";
		} else {
			res.status(404);
			return "Área Comum não encontrada.";
		}
	};

	public static Route obterPorId = (req, res) -> {
		Integer id = Integer.valueOf(req.params("id"));
		return AreaComumService.obterPorId(id).map(AreaComum::toString).orElse("Área Comum não encontrada.");
	};
}

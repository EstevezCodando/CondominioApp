package controleCondominioApp.model.controller;

import java.time.LocalDateTime;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import controleCondominioApp.model.domain.AreaComum;
import controleCondominioApp.model.service.AreaComumService;
import controleCondominioApp.model.service.LocalDateTimeAdapter;
import spark.Route;

public class AreaComumController {

	  private static final Gson gson = new GsonBuilder()
	            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
	            .create();

	    public static Route obterLista = (req, res) -> {
	        res.type("application/json");
	        return gson.toJson(AreaComumService.obterLista());
	    };
	    
	    public static Route incluir = (req, res) -> {
	        AreaComum areaComum = gson.fromJson(req.body(), AreaComum.class);
	        AreaComumService.incluir(areaComum);
	        res.status(201);
	        return gson.toJson("Area Comum: " + areaComum.getNome() + " ID: " + areaComum.getId() + " incluido com sucesso.");
	    };

	    public static Route excluir = (req, res) -> {
	        Integer id = Integer.valueOf(req.params("id"));
	        AreaComum areaComum = AreaComumService.obterPorId(id);
	        if (areaComum != null) {
	        	AreaComumService.excluir(id);
	            res.status(200);
	            return gson.toJson("Area Comum, ID: " + areaComum.getId() + ", Nome: " + areaComum.getNome() + ", foi removido com sucesso.");
	        } else {
	            res.status(404);
	            return gson.toJson("Area comum não encontrada.");
	        }
	    };

	    public static Route obterPorId = (req, res) -> {
	        Integer id = Integer.valueOf(req.params("id"));
	        AreaComum areaComum = AreaComumService.obterPorId(id);
	        if (areaComum != null) {
	            res.type("application/json");
	            return gson.toJson(areaComum);
	        } else {
	            res.status(404);
	            return gson.toJson("Area Comum não encontrada.");
	        }
	    };
}

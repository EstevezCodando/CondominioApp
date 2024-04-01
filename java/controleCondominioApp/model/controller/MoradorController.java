package controleCondominioApp.model.controller;

import java.time.LocalDate;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import controleCondominioApp.model.domain.Morador;
import controleCondominioApp.model.service.LocalDateAdapter;
import controleCondominioApp.model.service.MoradorService;
import spark.Route;

public class MoradorController {

    // ObterLista
	private static final Gson gson = new GsonBuilder()
            .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
            .create();

    public static Route obterLista = (req, res) -> {
        res.type("application/json");
        return gson.toJson(MoradorService.obterLista());
    };

    // Incluir
    	public static Route incluir = (req, res) -> {
    	    Morador novoMorador = gson.fromJson(req.body(), Morador.class);
    	    MoradorService.incluir(novoMorador);
    	    return "Morador: " + novoMorador.getNome() + " ID: " + novoMorador.getId() + " Incluído com Sucesso";
    	};


    //Excluir
    public static Route excluir = (req, res) -> {
        Integer id = Integer.valueOf(req.params("id"));
        Morador morador = MoradorService.obterPorId(id);
        if (morador != null) {
            MoradorService.excluir(id);
            res.status(200);
            return gson.toJson("Morador, ID: " + morador.getId() + ", Nome: " + morador.getNome() + ", foi removido com sucesso.");
        } else {
            res.status(404);
            return gson.toJson("Morador não encontrado.");
        }
    };


    public static Route obterPorId = (req, res) -> {
        Integer id = Integer.valueOf(req.params("id"));
        Morador morador = MoradorService.obterPorId(id);
        if (morador != null) {
            res.type("application/json");
            return gson.toJson(morador);
        } else {
            res.status(404);
            return gson.toJson("Morador não encontrado.");
        }
    };
}

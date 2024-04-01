package controleCondominioApp.model.controller;

import java.time.LocalDateTime;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import controleCondominioApp.model.domain.Visitante;
import controleCondominioApp.model.service.LocalDateTimeAdapter;
import controleCondominioApp.model.service.VisitanteService;
import spark.Route;

public class VisitanteController {

    // ObterLista
    private static final Gson gson = new GsonBuilder()
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
            .create();

    public static Route obterLista = (req, res) -> {
        res.type("application/json");
        return gson.toJson(VisitanteService.obterLista());
    };

    // Incluir
    public static Route incluir = (req, res) -> {
        Visitante visitante = gson.fromJson(req.body(), Visitante.class);
        VisitanteService.incluir(visitante);
        res.status(201);
        return gson.toJson("Visitante: " + visitante.getNome() + " ID: " + visitante.getId() + " incluido com sucesso.");
    };

    // Excluir
    public static Route excluir = (req, res) -> {
        Integer id = Integer.valueOf(req.params("id"));
        Visitante visitante = VisitanteService.obterPorId(id);
        if (visitante != null) {
            VisitanteService.excluir(id);
            res.status(200);
            return gson.toJson("Visitante, ID: " + visitante.getId() + ", Nome: " + visitante.getNome() + ", foi removido com sucesso.");
        } else {
            res.status(404);
            return gson.toJson("Visitante não encontrado.");
        }
    };
    // ObterPorId

    public static Route obterPorId = (req, res) -> {
        Integer id = Integer.valueOf(req.params("id"));
        Visitante visitante = VisitanteService.obterPorId(id);
        if (visitante != null) {
            res.type("application/json");
            return gson.toJson(visitante);
        } else {
            res.status(404);
            return gson.toJson("Visitante não encontrado.");
        }
    };    
}

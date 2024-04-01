package controleCondominioApp.model.controller;

import java.time.LocalDateTime;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import controleCondominioApp.model.domain.Condominio;
import controleCondominioApp.model.service.CondominioService;
import controleCondominioApp.model.service.LocalDateTimeAdapter;
import spark.Route;

public class CondominioController {

    private static final Gson gson = new GsonBuilder()
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
            .create();

    public static Route obterLista = (req, res) -> {
        res.type("application/json");
        return gson.toJson(CondominioService.obterLista());
    };
    
    //Incluir
    public static Route incluir = (req, res) -> {
        Condominio condominio = gson.fromJson(req.body(), Condominio.class);
        CondominioService.incluir(condominio);
        res.status(201);
        return gson.toJson("Funcionario: " + condominio.getNome() + " ID: " + condominio.getId() + " incluido com sucesso.");
    };
    
    //Excluir
    public static Route excluir = (req, res) -> {
        Integer id = Integer.valueOf(req.params("id"));
        Condominio condominio = CondominioService.obterPorId(id);
        if (condominio != null) {
        	CondominioService.excluir(id);
            res.status(200);
            return gson.toJson("Condominio, ID: " + condominio.getId() + ", Nome: " + condominio.getNome() + ", foi removido com sucesso.");
        } else {
            res.status(404);
            return gson.toJson("Condominio não encontrado.");
        }
    };

    public static Route obterPorId = (req, res) -> {
        Integer id = Integer.valueOf(req.params("id"));
        Condominio condominio = CondominioService.obterPorId(id);
        if (condominio != null) {
            res.type("application/json");
            return gson.toJson(condominio);
        } else {
            res.status(404);
            return gson.toJson("Condominio não encontrado.");
        }
    };
}

package controleCondominioApp.model.controller;

import java.time.LocalDateTime;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import controleCondominioApp.model.domain.ReservaAreaComum;
import controleCondominioApp.model.service.LocalDateTimeAdapter;
import controleCondominioApp.model.service.ReservaAreaComumService;
import spark.Route;

public class ReservaAreaComumController {

    private static final Gson gson = new GsonBuilder()
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
            .create();

    public static Route obterLista = (req, res) -> {
        res.type("application/json");
        return gson.toJson(ReservaAreaComumService.obterLista());
    };
    
    //Incluir
    public static Route incluir = (req, res) -> {
    	ReservaAreaComum reservaAreaComum = gson.fromJson(req.body(), ReservaAreaComum.class);
        ReservaAreaComumService.incluir(reservaAreaComum);
        res.status(201);
        return gson.toJson( " ID: " + reservaAreaComum.getId() + " incluido com sucesso.");
    };
    
    //Excluir
    public static Route excluir = (req, res) -> {
        Integer id = Integer.valueOf(req.params("id"));
        ReservaAreaComum reservaAreaComum = ReservaAreaComumService.obterPorId(id);
        if (reservaAreaComum != null) {
        	ReservaAreaComumService.excluir(id);
            res.status(200);
            return gson.toJson("Reserva Area Comum, ID: " + reservaAreaComum.getId() +  ", foi removido com sucesso.");
        } else {
            res.status(404);
            return gson.toJson("Reserva Area comum não encontrado.");
        }
    };

    public static Route obterPorId = (req, res) -> {
        Integer id = Integer.valueOf(req.params("id"));
        ReservaAreaComum reservaAreaComum = ReservaAreaComumService.obterPorId(id);
        if (reservaAreaComum != null) {
            res.type("application/json");
            return gson.toJson(reservaAreaComum);
        } else {
            res.status(404);
            return gson.toJson("Reserva de Area Comum não encontrada.");
        }
    };
}

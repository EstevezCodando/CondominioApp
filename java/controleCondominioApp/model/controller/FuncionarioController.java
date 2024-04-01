package controleCondominioApp.model.controller;

import java.time.LocalDate;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import controleCondominioApp.model.domain.Funcionario;
import controleCondominioApp.model.service.FuncionarioService;
import controleCondominioApp.model.service.LocalDateAdapter;
import spark.Route;

public class FuncionarioController {
   // private static FuncionarioService funcionarioService = FuncionarioService.getInstance();
    
    private static final Gson gson = new GsonBuilder()
            .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
            .create();

    public static Route obterLista = (req, res) -> {
        res.type("application/json");
        return gson.toJson(FuncionarioService.obterLista());
    };
    
    //Incluir
    public static Route incluir = (req, res) -> {
        Funcionario funcionario = gson.fromJson(req.body(), Funcionario.class);
        FuncionarioService.incluir(funcionario);
        res.status(201);
        return gson.toJson("Funcionario: " + funcionario.getNome() + " ID: " + funcionario.getId() + " incluido com sucesso.");
    };
    
    //Excluir
    public static Route excluir = (req, res) -> {
        Integer id = Integer.valueOf(req.params("id"));
        Funcionario funcionario = FuncionarioService.obterPorId(id);
        if (funcionario != null) {
            FuncionarioService.excluir(id);
            res.status(200);
            return gson.toJson("Funcionario, ID: " + funcionario.getId() + ", Nome: " + funcionario.getNome() + ", foi removido com sucesso.");
        } else {
            res.status(404);
            return gson.toJson("Funcionario não encontrado.");
        }
    };

    public static Route obterPorId = (req, res) -> {
        Integer id = Integer.valueOf(req.params("id"));
        Funcionario funcionario = FuncionarioService.obterPorId(id);
        if (funcionario != null) {
            res.type("application/json");
            return gson.toJson(funcionario);
        } else {
            res.status(404);
            return gson.toJson("Funcionario não encontrado.");
        }
    };
}

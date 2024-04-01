package controleCondominioApp.model.controller;

import com.google.gson.Gson;

import controleCondominioApp.model.domain.Veiculo;
import controleCondominioApp.model.service.FuncionarioService;
import controleCondominioApp.model.service.VeiculoService;
import spark.Route;

public class VeiculoController {

    private static final Gson gson = new Gson();

    public static Route obterLista = (req, res) -> {
        res.type("application/json");
        return gson.toJson(VeiculoService.obterLista());
    };

    public static Route incluir = (req, res) -> {
        Veiculo veiculo = gson.fromJson(req.body(), Veiculo.class);
        VeiculoService.incluir(veiculo);
        res.status(201);
        return gson.toJson("Veiculo: " + veiculo.getMarca() + ", " + veiculo.getModelo() + " ID: " + veiculo.getId() + " incluido com sucesso.");
    };

    public static Route excluir = (req, res) -> {
        Integer id = Integer.valueOf(req.params("id"));
        Veiculo veiculo = VeiculoService.obterPorId(id);
        if (veiculo != null) {
            FuncionarioService.excluir(id);
            res.status(200);
            return gson.toJson("Funcionario, ID: " + veiculo.getId() + ", Nome: " + veiculo.getMarca() + ", foi removido com sucesso.");
        } else {
            res.status(404);
            return gson.toJson("Funcionario não encontrado.");
        }
    };

    public static Route obterPorId = (req, res) -> {
        Integer id = Integer.valueOf(req.params("id"));
        Veiculo veiculo = VeiculoService.obterPorId(id);
        if (veiculo != null) {
            res.type("application/json");
            return gson.toJson(veiculo);
        } else {
            res.status(404);
            return gson.toJson("Funcionario não encontrado.");
        }
    };
}

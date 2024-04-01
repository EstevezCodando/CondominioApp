package controleCondominioApp.model.controller;

import spark.Route;

public class EnderecoController {

    public static Route obterEnderecoPorCep = (req, res) -> {
        String cep = req.params(":cep");
        return ViaCepController.obterEnderecoPorCep(cep);
    };
}

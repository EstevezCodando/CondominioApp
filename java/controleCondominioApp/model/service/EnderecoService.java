package controleCondominioApp.model.service;

import com.google.gson.Gson;

import controleCondominioApp.model.controller.ViaCepController;
import controleCondominioApp.model.domain.Endereco;

public class EnderecoService {

    public static Endereco obterEnderecoPorCep(String cep) {
        String enderecoJson = ViaCepController.obterEnderecoPorCep(cep);
        Gson gson = new Gson();
        Endereco endereco = gson.fromJson(enderecoJson, Endereco.class);
        return endereco;
	}
}

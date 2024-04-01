package controleCondominioApp.model.Loader;

import java.time.LocalDateTime;
import java.util.Collections;

import controleCondominioApp.model.domain.Veiculo;
import controleCondominioApp.model.domain.Visitante;
import controleCondominioApp.model.service.VeiculoService;
import controleCondominioApp.model.service.VisitanteService;

public class VisitanteEVeiculoLoader {

	public static void main(String[] args) {
		
		LocalDateTime h1 = LocalDateTime.of(2024, 1, 5, 18, 0);
	
		Visitante visitante1 = new Visitante("Julinho da Van Silva", "219692223", "15094822023", "Julin@empresa.com",
                LocalDateTime.of(2024, 1, 1, 10, 0), LocalDateTime.of(2024, 1, 1, 12, 0), null, "AP 101", Collections.emptyList());

        Visitante visitante2 = new Visitante("Ernestinho menino Oliveira", "11987654322", "25093287024", "Ernesto@empresa.com",
                LocalDateTime.of(2024, 1, 5, 14, 0), LocalDateTime.of(2024, 1, 5, 18, 0), null, "AP 202", Collections.emptyList());

        VisitanteService.incluir(visitante1);
        VisitanteService.incluir(visitante2);

        Veiculo V1 = new Veiculo("Carro", "Volkswagen", "Golf", "Cinza", "FX123AB", visitante1.getCpf());
        Veiculo V2 = new Veiculo("Moto", "Yamaha", "MT-07", "Azul", "GY456CD", visitante1.getCpf());
        Veiculo V3 = new Veiculo("Carro", "Chevrolet", "Onix", "Vermelho", "HZ789EF", visitante2.getCpf());
        Veiculo V4 = new Veiculo("Bicicleta", "Trek", "Marlin 5", "Preta", "JK123GH", visitante2.getCpf());

        VeiculoService.incluir(V1);
        VeiculoService.incluir(V2);
        VeiculoService.incluir(V3);
        VeiculoService.incluir(V4);
    }
}
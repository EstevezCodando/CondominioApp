package controleCondominioApp.model.Loader;

import controleCondominioApp.model.domain.Morador;
import controleCondominioApp.model.domain.Veiculo;
import controleCondominioApp.model.service.MoradorService;
import controleCondominioApp.model.service.VeiculoService;

public class MoradorEVeiculoLoader {

	public static void main(String[] args) {
	
		Morador morador1 = new Morador("Mauro Silva", "219692223", "1509487023", "Mauro@empresa.com","AP 101",true,null);

		Morador morador2 = new Morador("Muticia Oliveira", "11987654322", "2509487024", "maria@empresa.com","AP 202",true,null);

		Morador morador3 = new Morador("Carlico Santos", "11987654323", "3509487025", "carlos@empresa.com","APT 301",false,null);

		Morador morador4 = new Morador("Suares Costa", "11987654324", "5509487023", "suares@empresa.com","APT 402",false,null);

		Morador morador5 = new Morador("Jaime Rocha", "11987654325", "8509487023", "jaime@empresa.com","APT 501",false,null);

		MoradorService.incluir(morador1);
		MoradorService.incluir(morador2);
		MoradorService.incluir(morador3);
		MoradorService.incluir(morador4);
		MoradorService.incluir(morador5);
		
		Veiculo V1 = new Veiculo("Carro", "Fiat", "Uno Mille", "Azul", "BB232", morador1.getCpf());
		Veiculo V2 = new Veiculo("Moto", "Honda", "BIS", "Preto", "MM232", morador1.getCpf());
		Veiculo V3 = new Veiculo("Carro", "Toyota", "L200", "Branco", "AA232", morador2.getCpf());
		Veiculo V4 = new Veiculo("Bicicleta", "Caloi", "10", "Vermelho", "CC234", morador3.getCpf());
		Veiculo V5 = new Veiculo("Carro", "Honda", "HB20", "Prata", "DD234", null);
		
        VeiculoService.incluir(V1);
        VeiculoService.incluir(V2);
        VeiculoService.incluir(V3);
        VeiculoService.incluir(V4);
        VeiculoService.incluir(V5);
        
   
        
	}
}

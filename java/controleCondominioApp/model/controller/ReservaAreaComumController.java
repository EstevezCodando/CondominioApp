package controleCondominioApp.model.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import controleCondominioApp.model.domain.AreaComum;
import controleCondominioApp.model.domain.Morador;
import controleCondominioApp.model.domain.ReservaAreaComum;
import controleCondominioApp.model.service.AreaComumService;
import controleCondominioApp.model.service.MoradorService;
import controleCondominioApp.model.service.ReservaAreaComumService;
import spark.Route;

public class ReservaAreaComumController {

    private static ReservaAreaComumService reservaAreaComumService = new ReservaAreaComumService();
   
    public static Route obterLista = (req, res) -> reservaAreaComumService.obterLista();

    public static Route incluir = (req, res) -> {
        Integer areaComumId = Integer.valueOf(req.queryParams("areaComumId"));
        Integer moradorId = Integer.valueOf(req.queryParams("moradorId"));
        LocalDateTime dataHoraInicio = LocalDateTime.parse(req.queryParams("dataHoraInicio"), DateTimeFormatter.ISO_DATE_TIME);
        LocalDateTime dataHoraFim = LocalDateTime.parse(req.queryParams("dataHoraFim"), DateTimeFormatter.ISO_DATE_TIME);
        AreaComum areaComum = AreaComumService.obterPorId(areaComumId).orElse(null);
        Morador morador = MoradorService.obterPorId(moradorId);

        if (areaComum == null) {
            res.status(404);
            return "Área comum não encontrada.";
        }

        if (morador == null) {
            res.status(404);
            return "Morador não encontrado.";
        }

        ReservaAreaComum novaReserva = new ReservaAreaComum();
        novaReserva.setAreaComum(areaComum);
        novaReserva.setMorador(morador);
        novaReserva.setDataHoraInicio(dataHoraInicio);
        novaReserva.setDataHoraFim(dataHoraFim);

        reservaAreaComumService.incluir(novaReserva);

        return "Reserva incluída com sucesso para a área: " + areaComum.getNome();
    };

    public static Route excluir = (req, res) -> {
        Integer id = Integer.valueOf(req.params("id"));
        if (reservaAreaComumService.excluir(id)) {
            return "Reserva removida com sucesso.";
        } else {
            res.status(404);
            return "Reserva não encontrada.";
        }
    };

    public static Route obterPorId = (req, res) -> {
        Integer id = Integer.valueOf(req.params("id"));
        return reservaAreaComumService.obterPorId(id)
                .map(ReservaAreaComum::toString)
                .orElse("Reserva não encontrada.");
    };
}

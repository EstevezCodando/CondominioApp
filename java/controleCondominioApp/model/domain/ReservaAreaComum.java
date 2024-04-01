package controleCondominioApp.model.domain;

import java.time.LocalDateTime;

public class ReservaAreaComum {
	
	private Integer id;
    private AreaComum areaComum;
    private Morador morador;
    private LocalDateTime dataHoraInicio;
    private LocalDateTime dataHoraFim;
    
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public AreaComum getAreaComum() {
		return areaComum;
	}
	public void setAreaComum(AreaComum areaComum) {
		this.areaComum = areaComum;
	}
	public Morador getMorador() {
		return morador;
	}
	public void setMorador(Morador morador) {
		this.morador = morador;
	}
	public LocalDateTime getDataHoraInicio() {
		return dataHoraInicio;
	}
	public void setDataHoraInicio(LocalDateTime dataHoraInicio) {
		this.dataHoraInicio = dataHoraInicio;
	}
	public LocalDateTime getDataHoraFim() {
		return dataHoraFim;
	}
	public void setDataHoraFim(LocalDateTime dataHoraFim) {
		this.dataHoraFim = dataHoraFim;
	}
    
    

}

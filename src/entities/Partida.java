package entities;

public class Partida {
	
	private Integer idPartida;
	private Integer idClubeCasa;
	private Integer idClubeVisitante;
	private Integer golsCasa;
	private Integer golsVisitante;
	private Integer vencedor;
	
	public Partida(/*Integer idPartida, Integer idClubeCasa, Integer idClubeVisitante, Integer golsCasa,
			Integer golsVisitante, Integer vencedor*/) {
		/*super();
		this.idPartida = idPartida;
		this.idClubeCasa = idClubeCasa;
		this.idClubeVisitante = idClubeVisitante;
		this.golsCasa = golsCasa;
		this.golsVisitante = golsVisitante;
		this.vencedor = vencedor;*/
	}

	public Integer getIdPartida() {
		return idPartida;
	}

	public void setIdPartida(Integer idPartida) {
		this.idPartida = idPartida;
	}

	public Integer getIdClubeCasa() {
		return idClubeCasa;
	}

	public void setIdClubeCasa(Integer idClubeCasa) {
		this.idClubeCasa = idClubeCasa;
	}

	public Integer getIdClubeVisitante() {
		return idClubeVisitante;
	}

	public void setIdClubeVisitante(Integer idClubeVisitante) {
		this.idClubeVisitante = idClubeVisitante;
	}

	public Integer getGolsCasa() {
		return golsCasa;
	}

	public void setGolsCasa(Integer golsCasa) {
		this.golsCasa = golsCasa;
	}

	public Integer getGolsVisitante() {
		return golsVisitante;
	}

	public void setGolsVisitante(Integer golsVisitante) {
		this.golsVisitante = golsVisitante;
	}

	public Integer getVencedor() {
		return vencedor;
	}

	public void setVencedor(Integer vencedor) {
		this.vencedor = vencedor;
	}

	@Override
	public String toString() {
		return "Partida [idPartida=" + idPartida + ", idClubeCasa=" + idClubeCasa + ", idClubeVisitante="
				+ idClubeVisitante + ", golsCasa=" + golsCasa + ", golsVisitante=" + golsVisitante + ", vencedor="
				+ vencedor + "]";
	}
	
	

}

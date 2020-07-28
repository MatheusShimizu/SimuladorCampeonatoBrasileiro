package entities;

public class Clubes {
	
	private Integer idClube;
	private String nome;
	private Integer golsPro;
	private Integer golsCon;
	private Integer golsSaldo;
	
	public Clubes() {}

	public Clubes(Integer idClube, String nome, Integer golsPro, Integer golsCon, Integer golsSaldo) {
		
		this.idClube = idClube;
		this.nome = nome;
		this.golsPro = golsPro;
		this.golsCon = golsCon;
		this.golsSaldo = golsSaldo;
	}



	public Integer getIdClube() {
		return idClube;
	}

	public void setIdClube(Integer idClube) {
		this.idClube = idClube;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getGolsPro() {
		return golsPro;
	}

	public void setGolsPro(Integer golsPro) {
		this.golsPro = golsPro;
	}

	public Integer getGolsCon() {
		return golsCon;
	}

	public void setGolsCon(Integer golsCon) {
		this.golsCon = golsCon;
	}

	public Integer getGolsSaldo() {
		return golsSaldo;
	}

	public void setGolsSaldo(Integer golsSaldo) {
		this.golsSaldo = golsSaldo;
	}

	@Override
	public String toString() {
		return nome;
	}
	
	
}

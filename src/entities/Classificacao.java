package entities;

public class Classificacao {
	
	private int idClassificacao;
	private int idClube;
	private int golsPro;
	private int golsCon;
	private int saldoGols;
	private int jogos;
	private int vitorias;
	private int empates;
	private int derrotas;
	private int pontos;
	private int cartoesAmarelos;
	private int cartoesVermelhos;
	private double aproveitamento;
	
	private Clubes clubes;
	

	public Classificacao() {}


	public Classificacao(int idClassificacao, int idClube, int golsPro, int golsCon, int saldoGols, int jogos,
			int vitorias, int empates, int derrotas, int pontos, int cartoesAmarelos, int cartoesVermelhos,
			double aproveitamento) {
		
		this.idClassificacao = idClassificacao;
		this.idClube = idClube;
		this.golsPro = golsPro;
		this.golsCon = golsCon;
		this.saldoGols = saldoGols;
		this.jogos = jogos;
		this.vitorias = vitorias;
		this.empates = empates;
		this.derrotas = derrotas;
		this.pontos = pontos;
		this.cartoesAmarelos = cartoesAmarelos;
		this.cartoesVermelhos = cartoesVermelhos;
		this.aproveitamento = aproveitamento;
	}

	public int getIdClassificacao() {
		return idClassificacao;
	}

	public void setIdClassificacao(int idClassificacao) {
		this.idClassificacao = idClassificacao;
	}

	public int getIdClube() {
		return idClube;
	}

	public void setIdClube(int idClube) {
		this.idClube = idClube;
	}

	public int getGolsPro() {
		return golsPro;
	}

	public void setGolsPro(int golsPro) {
		this.golsPro = golsPro;
	}

	public int getGolsCon() {
		return golsCon;
	}

	public void setGolsCon(int golsCon) {
		this.golsCon = golsCon;
	}

	public int getSaldoGols() {
		return saldoGols;
	}

	public void setSaldoGols(int saldoGols) {
		this.saldoGols = saldoGols;
	}

	public int getJogos() {
		return jogos;
	}

	public void setJogos(int jogos) {
		this.jogos = jogos;
	}

	public int getVitorias() {
		return vitorias;
	}

	public void setVitorias(int vitorias) {
		this.vitorias = vitorias;
	}

	public int getEmpates() {
		return empates;
	}

	public void setEmpates(int empates) {
		this.empates = empates;
	}

	public int getDerrotas() {
		return derrotas;
	}

	public void setDerrotas(int derrotas) {
		this.derrotas = derrotas;
	}

	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}

	public int getCartoesAmarelos() {
		return cartoesAmarelos;
	}

	public void setCartoesAmarelos(int cartoesAmarelos) {
		this.cartoesAmarelos = cartoesAmarelos;
	}

	public int getCartoesVermelhos() {
		return cartoesVermelhos;
	}

	public void setCartoesVermelhos(int cartoesVermelhos) {
		this.cartoesVermelhos = cartoesVermelhos;
	}

	public double getAproveitamento() {
		return aproveitamento;
	}

	public void setAproveitamento(double aproveitamento) {
		this.aproveitamento = aproveitamento;
	}

	public Clubes getClubes() {
		return clubes;
	}


	public void setClubes(Clubes clubes) {
		this.clubes = clubes;
	}


	@Override
	public String toString() {
		return "Classificacao [idClassificacao=" + idClassificacao + ", idClube=" + idClube + ", golsPro=" + golsPro
				+ ", golsCon=" + golsCon + ", saldoGols=" + saldoGols + ", jogos=" + jogos + ", vitorias=" + vitorias
				+ ", empates=" + empates + ", derrotas=" + derrotas + ", pontos=" + pontos + ", cartoesAmarelos="
				+ cartoesAmarelos + ", cartoesVermelhos=" + cartoesVermelhos + ", aproveitamento=" + aproveitamento
				+ "]";
	}

	
	
	

}

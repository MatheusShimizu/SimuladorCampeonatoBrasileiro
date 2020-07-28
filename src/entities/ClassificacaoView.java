package entities;

public class ClassificacaoView {
	
	private String Clube;
	private int Pontos;
	private int Jogos;
	private int Vitorias;
	private int Empates;
	private int Derrotas;
	private int GolsPro;
	private int GolsCon;
	private int SaldoGols;
	private int CA;
	private int CV;
	//private double Aproveitamento;
	
	
	
	public ClassificacaoView() {}

	public ClassificacaoView(String clube, int pontos, int jogos, int vitorias, int empates, int derrotas, int golsPro,
			int golsCon, int saldoGols, int cA, int cV) {
		super();
		Clube = clube;
		Pontos = pontos;
		Jogos = jogos;
		Vitorias = vitorias;
		Empates = empates;
		Derrotas = derrotas;
		GolsPro = golsPro;
		GolsCon = golsCon;
		SaldoGols = saldoGols;
		CA = cA;
		CV = cV;
		//Aproveitamento = aproveitamento;
	}

	public String getClube() {
		return Clube;
	}

	public void setClube(String clube) {
		Clube = clube;
	}

	public int getPontos() {
		return Pontos;
	}

	public void setPontos(int pontos) {
		Pontos = pontos;
	}

	public int getJogos() {
		return Jogos;
	}

	public void setJogos(int jogos) {
		Jogos = jogos;
	}

	public int getVitorias() {
		return Vitorias;
	}

	public void setVitorias(int vitorias) {
		Vitorias = vitorias;
	}

	public int getEmpates() {
		return Empates;
	}

	public void setEmpates(int empates) {
		Empates = empates;
	}

	public int getDerrotas() {
		return Derrotas;
	}

	public void setDerrotas(int derrotas) {
		Derrotas = derrotas;
	}

	public int getGolsPro() {
		return GolsPro;
	}

	public void setGolsPro(int golsPro) {
		GolsPro = golsPro;
	}

	public int getGolsCon() {
		return GolsCon;
	}

	public void setGolsCon(int golsCon) {
		GolsCon = golsCon;
	}

	public int getSaldoGols() {
		return SaldoGols;
	}

	public void setSaldoGols(int saldoGols) {
		SaldoGols = saldoGols;
	}

	public int getCA() {
		return CA;
	}

	public void setCA(int cA) {
		CA = cA;
	}

	public int getCV() {
		return CV;
	}

	public void setCV(int cV) {
		CV = cV;
	}

	public Clubes vencedor(ClassificacaoView Classificacao) {
		
		Clubes clube = new Clubes();
		
		clube.setNome(Classificacao.getClube());
		
		return clube;
	}

	
	
	public ClassificacaoView convertToView(Classificacao cl, Clubes c) {
		ClassificacaoView vw = new ClassificacaoView();
		
		vw.setClube(c.getNome());
		vw.setPontos(cl.getPontos());
		vw.setJogos(cl.getJogos());
		vw.setVitorias(cl.getVitorias());
		vw.setEmpates(cl.getEmpates());
		vw.setDerrotas(cl.getDerrotas());
		vw.setGolsPro(cl.getGolsPro());
		vw.setGolsCon(cl.getGolsCon());
		vw.setSaldoGols(cl.getSaldoGols());
		vw.setCA(cl.getCartoesAmarelos());
		vw.setCV(cl.getCartoesVermelhos());
		//vw.setAproveitamento(cl.getAproveitamento());
		
		
		return vw;
	}

	@Override
	public String toString() {
		return Clube + ", Pontos=" + Pontos + ", Jogos=" + Jogos + ", Vitorias="
				+ Vitorias + ", Empates=" + Empates + ", Derrotas=" + Derrotas + ", GolsPro=" + GolsPro + ", GolsCon="
				+ GolsCon + ", SaldoGols=" + SaldoGols + ", CA=" + CA + ", CV=" + CV
				;
	}
	
	
	

}

package dao;

import java.util.List;

import entities.Clubes;

public interface PartidaDao {

	List<Integer>returnAllIds();
	String returnNameCCasa(int idPartida);
	String returnNameCFora(int idPartida);
	Integer returnIdCasa(int idPartida);
	Integer returnIdFora(int idPartida);
	void insertGolsClassificacao(int idClubeCasa, int idClubeFora, int golsCasa, int golsFora);
	void insertGolsPartida(int golsCasa, int golsFora, int idPartida);
	void vencedorCasa(int idClubeCasa, int idClubeFora);
	void vencedorFora(int idClubeCasa, int idClubeFora);
	void empate(int idClubeCasa, int idClubeFora);
	void attQntJogos(int idClubeCasa, int idClubeFora);
	void insertCards(int idClube, int cartoesAmarelos, int cartoesVermelhos);
	void limparPartidas(int idPartida);
}

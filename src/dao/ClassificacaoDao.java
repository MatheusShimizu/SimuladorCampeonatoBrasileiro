package dao;

import java.util.List;

import entities.ClassificacaoView;

public interface ClassificacaoDao {
	
	List<ClassificacaoView>organizarClassificacao();
	List<Integer>allIdsClassificacao();
	void limparClassificacao(int idClassificacao);
	Integer getPontos(int idClube);
	void insertAproveitamento(int idClube, int pontos);
	
}

package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

import dao.ClassificacaoDao;
import dao.ClubesDao;
import dao.DaoFactory;
import dao.PartidaDao;
import entities.Classificacao;
import entities.ClassificacaoView;

public class Program {
	
	
	
	public static void auto38rodadas() {
		
		ClassificacaoDao classificacaodao = DaoFactory.createClassificacaoDao();
		PartidaDao partidadao = DaoFactory.createPartidaDao();
		ClubesDao clubesdao = DaoFactory.createClubesDao();
		Random random = new Random();
		
		for(int la : partidadao.returnAllIds()) {
			int golsCasa = random.nextInt(5);
			int golsFora = random.nextInt(5);
			if(golsCasa > golsFora) {
				partidadao.vencedorCasa(partidadao.returnIdCasa(la), partidadao.returnIdFora(la));
			}
			if(golsFora > golsCasa){
				partidadao.vencedorFora(partidadao.returnIdCasa(la), partidadao.returnIdFora(la));
			}
			if( golsCasa == golsFora) {
				partidadao.empate(partidadao.returnIdCasa(la), partidadao.returnIdFora(la));
			}
			partidadao.insertGolsPartida(golsCasa, golsFora, la);
			partidadao.insertGolsClassificacao(partidadao.returnIdCasa(la), partidadao.returnIdFora(la), golsCasa, golsFora);
			partidadao.attQntJogos(partidadao.returnIdCasa(la), partidadao.returnIdFora(la));
		}
		
		for(int c : clubesdao.findAllIds()){
			
			int CA = random.nextInt(110);
			int CV = random.nextInt(13);
			
			partidadao.insertCards(c, CA, CV);
		}
		
		List<ClassificacaoView>vencedor = new ArrayList<>();
		
		for(ClassificacaoView v : classificacaodao.organizarClassificacao()) {
			vencedor.add(v);
			System.out.println(v);
			}
		
	
		ClassificacaoView cv = new ClassificacaoView();
		
		JOptionPane.showMessageDialog(null," O vencedor é o " + cv.vencedor(vencedor.get(0)));
		
	}
	
	public static void manual38rodadas() {
		ClassificacaoDao classificacaodao = DaoFactory.createClassificacaoDao();
		PartidaDao partidadao = DaoFactory.createPartidaDao();
		ClubesDao clubesdao = DaoFactory.createClubesDao();
		Random random = new Random();
		
		for(int la : partidadao.returnAllIds()) {
			JOptionPane.showMessageDialog(null, partidadao.returnNameCCasa(la) + " vs "+ partidadao.returnNameCFora(la) + "\n Entre com os resultado: ");
			int golsCasa = Integer.parseInt(JOptionPane.showInputDialog(null, partidadao.returnNameCCasa(la) + ": "));
			int golsFora = Integer.parseInt(JOptionPane.showInputDialog(null, partidadao.returnNameCFora(la) + ": "));
			if(golsCasa > golsFora) {
				JOptionPane.showMessageDialog(null, partidadao.returnNameCCasa(la) + " Venceu!");
				partidadao.vencedorCasa(partidadao.returnIdCasa(la), partidadao.returnIdFora(la));
			}
			if(golsFora > golsCasa){
				JOptionPane.showMessageDialog(null, partidadao.returnNameCFora(la) + " Venceu!");
				partidadao.vencedorFora(partidadao.returnIdCasa(la), partidadao.returnIdFora(la));
			}
			if( golsCasa == golsFora) {
				JOptionPane.showMessageDialog(null, partidadao.returnNameCCasa(la) + " vs "+ partidadao.returnNameCFora(la)  + " Empatou!");
				partidadao.empate(partidadao.returnIdCasa(la), partidadao.returnIdFora(la));
			}
			partidadao.insertGolsPartida(golsCasa, golsFora, la);
			partidadao.insertGolsClassificacao(partidadao.returnIdCasa(la), partidadao.returnIdFora(la), golsCasa, golsFora);
			partidadao.attQntJogos(partidadao.returnIdCasa(la), partidadao.returnIdFora(la));
		}
		
		for(int c : clubesdao.findAllIds()){
			
			int CA = random.nextInt(110);
			int CV = random.nextInt(13);
			
			partidadao.insertCards(c, CA, CV);
		}
		
		for(ClassificacaoView v : classificacaodao.organizarClassificacao()) {
			System.out.println(v);
		}
		
	}
	

	public static void main (String[] args) {

		ClubesDao clubesdao = DaoFactory.createClubesDao();
		
		ClassificacaoDao classificacaodao = DaoFactory.createClassificacaoDao();

		PartidaDao partidadao = DaoFactory.createPartidaDao();
		
		Random random = new Random();
		
		int opcao;
		JOptionPane.showMessageDialog(null,"Bem vindo ao Sistema de Acompanhamento e Gestão do Campeonato Brasileiro de Futebol");
		do {
			for(int i : partidadao.returnAllIds()) {
				partidadao.limparPartidas(i);
			}
			for( int i : classificacaodao.allIdsClassificacao()) {
				classificacaodao.limparClassificacao(i);
				}
			
		opcao = Integer.parseInt(JOptionPane.showInputDialog(null, "Escolha uma das Opções abaixo! \n 1 - Gerar resultados automaticamente. \n 2 - Inserir resultados manualmente. \n 0 - Para sair."));
		
		switch (opcao) {
		case 1:
			auto38rodadas();
			break;
		case 2:
			manual38rodadas();
			break;
		case 0:
			break;
		default:
			JOptionPane.showMessageDialog(null,"Opção invalida!");
		}
		}while(opcao != 0);
		}
	}
	



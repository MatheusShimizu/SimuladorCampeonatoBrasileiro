package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ClassificacaoDao;
import db.DB;
import db.DbException;
import entities.Classificacao;
import entities.ClassificacaoView;
import entities.Clubes;


public class ClassificacaoDaoJDBC implements ClassificacaoDao{

	private Connection conn;
	
	public ClassificacaoDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public List<ClassificacaoView>organizarClassificacao() {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement("select c.nome as Clube, cl.pontos as Pontos, cl.jogos as Jogos, cl.vitorias as Vitórias, cl.empates as Empates, " 
				+"cl.derrotas as Derrotas, cl.golsPro, cl.golsCon, cl.saldoGols, cl.cartoesAmarelos as CA, cl.cartoesVermelhos as CV " 
				+"from classificacao cl join clube c on c.idClube = cl.idClube " 
				+"where jogos != 0 order by cl.pontos desc, cl.vitorias desc, cl.saldoGols desc, cl.golsPro desc, " 
				+"cl.cartoesVermelhos asc, cl.cartoesAmarelos asc ");
			rs = st.executeQuery();
			
			List<ClassificacaoView>list = new ArrayList<>();
			
			Clubes clube = new Clubes();
			Classificacao cl = new Classificacao();
			ClassificacaoView view = new ClassificacaoView();
			while(rs.next()) {
				clube = instantiateClubes(rs);
				cl = instantiateClassificacao(rs, clube);
				view = convertToView(cl, clube);
				list.add(view);
			}
			
			
			
			
			//seria tipo
			// View vw = intantiateView(cl,clube);
			//é isso ne?
			//sim, mas voce vai retornar um List<View>
			
			//vc tem essa lista, vai ter que criar um metodo instantiateView(list)
			//e nesse metodo voce popula a classe view
			
			return list;
			
		}catch (SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}
	
	private Classificacao instantiateClassificacao(ResultSet rs, Clubes cb) throws SQLException {
		Classificacao cl = new Classificacao();
		
		//cl.setIdClube(rs.getInt("idClube"));
		cl.setGolsPro(rs.getInt("golsPro"));
		cl.setGolsCon(rs.getInt("golsCon"));
		cl.setSaldoGols(rs.getInt("saldoGols"));
		cl.setJogos(rs.getInt("Jogos"));
		cl.setVitorias(rs.getInt("Vitórias"));
		cl.setEmpates(rs.getInt("Empates"));
		cl.setDerrotas(rs.getInt("Derrotas"));
		cl.setPontos(rs.getInt("Pontos"));
		cl.setCartoesAmarelos(rs.getInt("CA"));
		cl.setCartoesVermelhos(rs.getInt("CV"));
		//cl.setAproveitamento(rs.getDouble("%"));
		cl.setClubes(cb);
		
		return cl;
	}
	
	private Clubes instantiateClubes(ResultSet rs) throws SQLException{
		Clubes clube = new Clubes();
		clube.setNome(rs.getString("Clube"));
		
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
	public List<Integer> allIdsClassificacao() {
		PreparedStatement st = null;
		ResultSet rs = null;
		List<Integer>idClassificacao = new ArrayList<>();
		try {
			st = conn.prepareStatement("select idClassificacao from classificacao");
			rs = st.executeQuery();
			while(rs.next()) {
				idClassificacao.add(rs.getInt("idClassificacao"));
			}
			
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		return idClassificacao;	
	}
	

	@Override
	public void limparClassificacao(int idClassificacao) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("update classificacao set golsPro = 0, golsCon = 0, saldoGols = 0, "
					+ "jogos = 0, vitorias = 0, empates = 0, derrotas = 0, pontos = 0, "
					+ "cartoesAmarelos = 0, cartoesVermelhos = 0 where idClassificacao = " + idClassificacao);
			st.executeUpdate();
			
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);
		}
		
	}

	
	@Override
	public void insertAproveitamento(int idClube, int pontos) {
		PreparedStatement st = null;
		double aproveitamento = pontos/114;
		double aux = aproveitamento * 100;
		try{
			st = conn.prepareStatement("update classificacao set aproveitamento = " + aux
					+ " where idClube = " + idClube);
			st.executeUpdate();
			
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public Integer getPontos(int idClube) {
		PreparedStatement st = null;
		ResultSet rs = null;
		int pontos = 0;
		try {
			st = conn.prepareStatement("select pontos from classificacao where idClube = " + idClube);
			rs = st.executeQuery();
			if(rs.next()) {
				pontos = rs.getInt("pontos");
			}
			
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		return pontos;
		
	}
	
	}



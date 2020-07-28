package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.PartidaDao;
import db.DB;
import db.DbException;

public class PartidaDaoJDBC implements PartidaDao{
	
	private Connection conn;
	
	public PartidaDaoJDBC (Connection conn) {
		this.conn = conn;
	}

	@Override
	public List<Integer> returnAllIds() {
		
		List<Integer>idPartida = new ArrayList<Integer>();
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("Select idpartida from partida order by rodada asc;");
			rs = st.executeQuery();
			
			while(rs.next()) {
			
			idPartida.add(rs.getInt("idPartida"));
			}
			
		}catch (SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		return idPartida;
		
	}

	@Override
	public String returnNameCCasa(int idPartida) {
		PreparedStatement st = null;
		ResultSet rs = null;
		String NomeClube = "";
		try {
			st = conn.prepareStatement("Select c.nome  from partida p  join "
					+"clube c on p.idClubeCasa = c.idClube where p.idPartida = " + idPartida);
			rs = st.executeQuery();
			if(rs.next()) {
			NomeClube = rs.getString("nome");
			}
			
		}catch (SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		return NomeClube;
		
	}

	@Override
	public String returnNameCFora(int idPartida) {
		PreparedStatement st = null;
		ResultSet rs = null;
		String NomeClube = "";
		try {
			st = conn.prepareStatement("Select c.nome  from partida p  join "
					+"clube c on p.idClubeFora = c.idClube where p.idPartida = " + idPartida);
			rs = st.executeQuery();
			if(rs.next()) {
			NomeClube = rs.getString("nome");
			}
			
		}catch (SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		return NomeClube;
	}

	@Override
	public Integer returnIdCasa(int idPartida) {
		PreparedStatement st = null;
		ResultSet rs = null;
		int idCasa = 0;
		try {
			st = conn.prepareStatement("Select idClubeCasa from partida where idPartida = " + idPartida);
			rs = st.executeQuery();
			if(rs.next()) {
			idCasa = rs.getInt("idClubeCasa");
			}
			
		}catch (SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		return idCasa;
	}

	@Override
	public Integer returnIdFora(int idPartida) {
		PreparedStatement st = null;
		ResultSet rs = null;
		int idFora = 0;
		try {
			st = conn.prepareStatement("Select idClubeFora from partida where idPartida = " + idPartida);
			rs = st.executeQuery();
			if(rs.next()) {
			idFora = rs.getInt("idClubeFora");
			}
			
		}catch (SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		return idFora;
	}

	@Override
	public void insertGolsClassificacao(int idClubeCasa, int idClubeFora, int golsCasa, int golsFora) {

		
		int sdcasa = golsCasa - golsFora;
		int sdfora = golsFora - golsCasa;
		
		// insere golsPro do ClubeCasa
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("UPDATE classificacao SET golsPro = golsPro + "+ golsCasa
					+" WHERE idClube = " + idClubeCasa);
			st.executeUpdate();
			
		}catch(SQLException e) {
			throw new DbException( e.getMessage());
		}finally {
			DB.closeStatement(st);
		}
		
		// insere golsPro do ClubeFora
		PreparedStatement st1 = null;
		try {
			st1 = conn.prepareStatement("UPDATE classificacao SET golsPro = golsPro + "+ golsFora
					+" WHERE idClube = " + idClubeFora);
			st1.executeUpdate();
			
		}catch(SQLException e) {
			throw new DbException( e.getMessage());
		}finally {
			DB.closeStatement(st1);
			
		}
		
		//insere golsCon no ClubeCasa
		PreparedStatement st2 = null;
		try {
			st2 = conn.prepareStatement("UPDATE classificacao SET golsCon = golsCon + " + golsFora
					+ " where idClube = " + idClubeCasa);
			st2.executeUpdate();
			
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st2);
		}
		
		//insere golsCon no ClubeFora
		PreparedStatement st3 = null;
		try {
			st3 = conn.prepareStatement("UPDATE classificacao SET golsCon = golsCon + " + golsCasa
					+ " where idClube = " + idClubeFora);
			st3.executeUpdate();
			
		}catch (SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st3);
		}
		
		//atualiza saldo de gols do ClubeCasa
		PreparedStatement st4 = null;
		try {
			st = conn.prepareStatement("UPDATE classificacao SET saldoGols = saldoGols + "
		            + sdcasa +" where idClube = " + idClubeCasa);
			st.executeUpdate();
		}catch (SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st4);
		}
		
		
		//atualiza saldo de gols do Clubefora
		PreparedStatement st5 = null;
		try {
			st = conn.prepareStatement("UPDATE classificacao SET saldoGols = saldoGols +"
					+ sdfora + " where idClube = " + idClubeFora);
			st.executeUpdate();
				
			}catch (SQLException e) {
				throw new DbException(e.getMessage());
			}finally {
				DB.closeStatement(st5);
			}
		}

	@Override
	public void insertGolsPartida(int golsCasa, int golsFora, int idPartida) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("update partida set golsCasa = " + golsCasa
					+", golsFora = " + golsFora + " where idPartida = " + idPartida);
			st.executeUpdate();
		}catch (SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);
		}
		
	}

	@Override
	public void vencedorCasa(int idClubeCasa, int idClubeFora) {
			PreparedStatement st = null;
			
		try {
			st = conn.prepareStatement("update classificacao set vitorias = vitorias + 1, "
					+"pontos = pontos + 3 where idClube =  " + idClubeCasa);
			st.executeUpdate();
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);
		}
		
		   PreparedStatement st1 = null;
		
		   try {
			   st1 = conn.prepareStatement("update classificacao set derrotas = derrotas + 1 "
			   		+ "where idClube = " + idClubeFora);
			   st1.executeUpdate();
			   
		   }catch(SQLException e) {
				throw new DbException(e.getMessage());
			}finally {
				DB.closeStatement(st1);		
}
	}

	@Override
	public void vencedorFora(int idClubeCasa, int idClubeFora) {
		PreparedStatement st = null;
		
	try {
		st = conn.prepareStatement("update classificacao set vitorias = vitorias + 1, "
				+"pontos = pontos + 3 where idClube =  " + idClubeFora);
		st.executeUpdate();
	}catch(SQLException e) {
		throw new DbException(e.getMessage());
	}finally {
		DB.closeStatement(st);
	}
	
	   PreparedStatement st1 = null;
	
	   try {
		   st1 = conn.prepareStatement("update classificacao set derrotas = derrotas + 1 "
		   		+ "where idClube = " + idClubeCasa);
		   st1.executeUpdate();
		   
	   }catch(SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st1);
		
}
		
	}

	@Override
	public void empate(int idClubeCasa, int idClubeFora) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("update classificacao set empates = empates + 1, "
					+ "pontos = pontos + 1 where idClube = " + idClubeCasa);
			st.executeUpdate();
			
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);
		}
		
		PreparedStatement st1 = null;
		try {
			st1 = conn.prepareStatement("update classificacao set empates = empates + 1, "
					+ "pontos = pontos + 1 where idClube = " + idClubeFora);
			st1.executeUpdate();
			
		}catch (SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st1);
		}
		
	}

	@Override
	public void attQntJogos(int idClubeCasa, int idClubeFora) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("update classificacao set jogos = jogos + 1 where idClube = " + idClubeCasa);
			st.executeUpdate();
		}catch (SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);
		}
		
		PreparedStatement st1 = null;
		try {
			st1 = conn.prepareStatement("update classificacao set jogos = jogos + 1 where idClube = " + idClubeFora);
			st1.executeUpdate();
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st1);
		}
		
	}

	
	@Override
	public void insertCards(int idClube, int cartoesAmarelos, int cartoesVermelhos) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("update classificacao set cartoesAmarelos = " + cartoesAmarelos + " where idClube = " + idClube);
			st.executeUpdate();
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);
		}
		PreparedStatement st1 =  null;
		try {
			st1 = conn.prepareStatement("update classificacao set cartoesVermelhos = " + cartoesVermelhos + " where idClube = " + idClube);
			st1.executeUpdate();
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st1);
		}
	}

	@Override
	public void limparPartidas(int idPartida) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("update partida set golsCasa = 0, golsFora = 0 where idPartida = " + idPartida);
			st.executeUpdate();
			
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);
		}
		
	}
}
	
	

		
	

	



	
	
		



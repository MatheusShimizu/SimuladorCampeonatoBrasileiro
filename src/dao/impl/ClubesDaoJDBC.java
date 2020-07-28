package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ClubesDao;
import db.DB;
import db.DbException;
import entities.Clubes;

public class ClubesDaoJDBC implements ClubesDao{

	private Connection conn;
	
	public ClubesDaoJDBC (Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public List<Integer> findAllIds() {
		PreparedStatement st = null;
		ResultSet rs = null;
		List<Integer> list = new ArrayList<>();
		try {
			st = conn.prepareStatement("SELECT idClube from clube");
			rs = st.executeQuery();
			
			while(rs.next()) {
				Clubes clube = new Clubes();
				clube.setIdClube(rs.getInt("idClube"));
				Integer id = rs.getInt("idClube");
				list.add(id);
			}
			//System.out.println(list);
			
		}catch (SQLException e) {
			throw new DbException( e.getMessage());
		}finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		
		
		
		return list;
	}

}

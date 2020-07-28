package dao;

import dao.impl.ClassificacaoDaoJDBC;
import dao.impl.ClubesDaoJDBC;
import dao.impl.PartidaDaoJDBC;
import db.DB;

public class DaoFactory {
	
	
	public static PartidaDao createPartidaDao() {
		return new PartidaDaoJDBC(DB.getConnection());
	}
	
	
	
	public static ClubesDao createClubesDao() {
		return new ClubesDaoJDBC(DB.getConnection());
	}
	
	
	public static ClassificacaoDao createClassificacaoDao() {
		return new ClassificacaoDaoJDBC(DB.getConnection());
	}

}

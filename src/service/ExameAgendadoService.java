package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import dao.BancoDados;
import dao.ExameAgendadoDAO;
import entities.ExameAgendado;

public class ExameAgendadoService {
	
	public ExameAgendadoService() {
		
	}
	
	public void agendar(ExameAgendado exameAg) throws SQLException, IOException {
		
		Connection conn = BancoDados.conectar();
		new ExameAgendadoDAO(conn).agendar(exameAg);
	}

}

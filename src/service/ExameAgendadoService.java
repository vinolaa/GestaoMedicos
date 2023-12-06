package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

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

	public List<ExameAgendado> buscarTodas(int crm) throws SQLException, IOException {

		System.out.println("Exame Service");
		Connection conn = BancoDados.conectar();
		return new ExameAgendadoDAO(conn).buscarTodas(crm);
	}
	
	public List<ExameAgendado> buscarPorTipo(int tipo) throws SQLException, IOException {
		
		Connection conn = BancoDados.conectar();
		return new ExameAgendadoDAO(conn).buscarPorTipo(tipo);
	}

}

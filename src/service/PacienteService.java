package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import dao.BancoDados;
import dao.PacienteDAO;
import entities.Paciente;


public class PacienteService {
	
	public PacienteService() {

	}

	public void cadastrar(Paciente paciente) throws SQLException, IOException {

		Connection conn = BancoDados.conectar();
		new PacienteDAO(conn).cadastrar(paciente);
	}

}

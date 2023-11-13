package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import dao.BancoDados;
import dao.MedicoDAO;
import entities.Medico;

public class MedicoService {

	public MedicoService() {

	}

	public void cadastrar(Medico medico) throws SQLException, IOException {

		Connection conn = BancoDados.conectar();
		new MedicoDAO(conn).cadastrar(medico);
	}
}

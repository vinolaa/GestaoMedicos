package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.BancoDados;
import dao.EspecialidadeDAO;
import entities.Especialidade;

public class EspecialidadeService {

	public EspecialidadeService() {

	}

	public void cadastrar(Especialidade especialidade) throws SQLException, IOException {

		Connection conn = BancoDados.conectar();
		new EspecialidadeDAO(conn).cadastrar(especialidade);
	}
	
	public List<Especialidade> buscarTodas() throws SQLException, IOException {

		Connection conn = BancoDados.conectar();
		return new EspecialidadeDAO(conn).buscarTodas();
	}
}

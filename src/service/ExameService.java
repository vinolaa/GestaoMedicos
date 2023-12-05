package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.BancoDados;
import dao.ExameAgendadoDAO;
import dao.ExameDAO;
import entities.Exame;

public class ExameService {

	public ExameService() {
	}

	public List<Exame> buscarExames() throws SQLException, IOException {

		Connection conn = BancoDados.conectar();
		return new ExameDAO(conn).buscarTodos();
	}

	public Exame buscarPorCodigo(int codigoExame) throws SQLException, IOException {

		Connection conn = BancoDados.conectar();
		return new ExameDAO(conn).buscarPorCodigo(codigoExame);
	}

}

package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.BancoDados;
import dao.PagamentoDAO;
import entities.Pagamento;

public class PagamentoService {

	public PagamentoService() {

	}

	public void cadastrar(Pagamento pagamento) throws SQLException, IOException {

		Connection conn = BancoDados.conectar();
		new PagamentoDAO(conn).cadastrar(pagamento);
	}
	
	public List<Pagamento> buscarTodos() throws SQLException, IOException {

		Connection conn = BancoDados.conectar();
		return new PagamentoDAO(conn).buscarTodos();
	}
}

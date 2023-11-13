package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import entities.Pagamento;

public class PagamentoDAOTeste {

	public static void buscarTodosPagamentosTeste() throws SQLException, IOException {

		Connection conn = BancoDados.conectar();
		List<Pagamento> listaPagamentos = new PagamentoDAO(conn).buscarTodos();

		for (Pagamento pagamento : listaPagamentos) {

			System.out.println(pagamento.getCodigo() + " - " + pagamento.getFormaPagamento());
		}
	}

	public static void main(String[] args) {

		try {
			PagamentoDAOTeste.buscarTodosPagamentosTeste();
		} catch (SQLException | IOException e) {
			System.out.println(e.getMessage());
		}

	}
}

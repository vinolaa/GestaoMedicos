package test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.BancoDados;
import dao.ExameDAO;
import entities.Exame;

public class ExameDAOTeste {

	public static void buscarTodasEspecialidadesTeste() throws SQLException, IOException {

		Connection conn = BancoDados.conectar();
		List<Exame> listaExames = new ExameDAO(conn).buscarTodos();

		for (Exame exame : listaExames) {

			System.out.println(exame.getCodigo() + " - " + exame.getNome());
		}
	}

	public static void main(String[] args) {

		try {
			ExameDAOTeste.buscarTodasEspecialidadesTeste();
		} catch (SQLException | IOException e) {
			System.out.println(e.getMessage());
		}

	}
}

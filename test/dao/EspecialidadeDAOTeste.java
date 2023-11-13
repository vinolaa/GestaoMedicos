package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import entities.Especialidade;

public class EspecialidadeDAOTeste {

	public static void buscarTodasEspecialidadesTeste() throws SQLException, IOException {

		Connection conn = BancoDados.conectar();
		List<Especialidade> listaEspecialidades = new EspecialidadeDAO(conn).buscarTodas();

		for (Especialidade especialidade : listaEspecialidades) {

			System.out.println(especialidade.getCodigo() + " - " + especialidade.getNome());
		}
	}

	public static void main(String[] args) {

		try {
			EspecialidadeDAOTeste.buscarTodasEspecialidadesTeste();
		} catch (SQLException | IOException e) {
			System.out.println(e.getMessage());
		}

	}
}

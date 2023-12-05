package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entities.Exame;

public class ExameDAO {

	private Connection conn;

	public ExameDAO(Connection conn) {

		this.conn = conn;
	}

	public List<Exame> buscarTodos() throws SQLException {

		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = conn.prepareStatement("select * from exame");

			rs = st.executeQuery();

			List<Exame> listaExames = new ArrayList<>();

			while (rs.next()) {

				Exame exame = new Exame();
				exame.setCodigo(rs.getInt("codigo"));
				exame.setNome(rs.getString("nome"));
				exame.setValor(rs.getDouble("valor"));
				exame.setOrientacoes(rs.getString("orientacoes"));

				listaExames.add(exame);
			}

			return listaExames;

		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
			BancoDados.desconectar();
		}
	}

	public Exame buscarPorCodigo(int codigoExame) throws SQLException {

		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = conn.prepareStatement("select * from exame where codigo = ?");

			st.setInt(1, codigoExame);

			rs = st.executeQuery();

			if (rs.next()) {

				Exame exame = new Exame();

				exame.setCodigo(rs.getInt("codigo"));
				exame.setNome(rs.getString("nome"));
				exame.setValor(rs.getDouble("valor"));
				exame.setOrientacoes(rs.getString("orientacoes"));

				return exame;
			}

			return null;

		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
			BancoDados.desconectar();
		}
	}

}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Especialidade;

public class EspecialidadeDAO {

	private Connection conn;
	
	public EspecialidadeDAO (Connection conn) {

		this.conn = conn;
	}
	
	public void cadastrar(Especialidade especialidade) throws SQLException {

		PreparedStatement st = null;

		try {

			st = conn.prepareStatement(
					"insert into especialidade_medico (cod_especialidade, nome) values (?, ?)");

			st.setInt(1, especialidade.getCodigo());
			st.setString(2, especialidade.getNome());
			st.executeUpdate();

		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
	}
	
	public List<Especialidade> buscarTodas() throws SQLException {

		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = conn.prepareStatement("select * from especialidade_medico");

			rs = st.executeQuery();

			List<Especialidade> listaEspecialidades = new ArrayList<>();

			while (rs.next()) {

				Especialidade especialidade = new Especialidade();
				especialidade.setCodigo(rs.getInt("cod_especialidade"));
				especialidade.setNome(rs.getNString("nome"));

				listaEspecialidades.add(especialidade);
			}

			return listaEspecialidades;

		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
			BancoDados.desconectar();
		}
	}

}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entities.Medico;

public class MedicoDAO {

	private Connection conn;

	public MedicoDAO(Connection conn) {

		this.conn = conn;
	}

	public void cadastrar(Medico medico) throws SQLException {

		PreparedStatement st = null;

		try {

			st = conn.prepareStatement(
					"insert into medico (crm, nome, endereco, telefone, cod_especialidade ) values (?, ?, ?, ?, ?)");

			st.setInt(1, medico.getCrm());
			st.setString(2, medico.getNome());
			st.setString(3, medico.getEndereco());
			st.setString(4, medico.getTelefone());
			st.setInt(5, medico.getEspecialidade().getCodigo());
			st.executeUpdate();

		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
	}

	public int buscarCrmPorNome(String nome) throws SQLException {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement("SELECT * FROM medico WHERE nome = ?");
			st.setString(1, nome);
			rs = st.executeQuery();

			if (rs.next()) {
				return rs.getInt("crm");
			} else {

				return -1;
			}

		} finally {
			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
			BancoDados.desconectar();
		}
	}

}

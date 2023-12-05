package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Especialidade;
import entities.ExameAgendado;

public class ExameAgendadoDAO {

	private Connection conn;

	public ExameAgendadoDAO(Connection conn) {

		this.conn = conn;
	}

	public void agendar(ExameAgendado exameAg) throws SQLException {

		PreparedStatement st = null;

		try {

			st = conn.prepareStatement(
					"insert into exame_agendado (nome_paciente, crm, data, hora, valor_pago, cod_exame) values (?, ?, ?, ?, ?, ?)");

			st.setString(1, exameAg.getNomePaciente());
			st.setInt(2, exameAg.getCrm());
			st.setDate(3, exameAg.getData());
			st.setTime(4, exameAg.getHora());
			st.setDouble(5, exameAg.getValorPago());
			st.setInt(6, exameAg.getCodigoExame());

			st.executeUpdate();

		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
	}

	public List<ExameAgendado> buscarTodas(int crm) throws SQLException {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = conn.prepareStatement("SELECT * FROM exame_agendado WHERE crm = ? ORDER BY data DESC, hora DESC");

			st.setInt(1, crm);
			rs = st.executeQuery();

			List<ExameAgendado> listaExames = new ArrayList<>();

			while (rs.next()) {
				ExameAgendado exame = new ExameAgendado();
				exame.setNomePaciente(rs.getString("nome_paciente"));
				exame.setData(rs.getDate("data"));
				exame.setHora(rs.getTime("hora"));
				exame.setValorPago(rs.getDouble("valor_pago"));
				exame.setCodigoExame(rs.getInt("cod_exame"));
				listaExames.add(exame);
			}

			return listaExames;

		} finally {
			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
			BancoDados.desconectar();
		}
	}

}

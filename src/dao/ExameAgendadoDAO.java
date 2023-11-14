package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import entities.ExameAgendado;

public class ExameAgendadoDAO {
	
	private Connection conn;
	
	public ExameAgendadoDAO (Connection conn) {
		
		this.conn = conn;
	}
	
	public void agendar(ExameAgendado exameAg) throws SQLException {
		
		PreparedStatement st = null;

		try {

			st = conn.prepareStatement(
					"insert into exame_agendado (nome_paciente, crm, data, valor_pago, cod_exame) values (?, ?, ?, ?, ?)");

			st.setString(1, exameAg.getNomePaciente());
			st.setInt(2, exameAg.getCrm());
			st.setDate(3, exameAg.getData());
			st.setDouble(4, exameAg.getValorPago());
			st.setInt(5, exameAg.getCodigoExame());
			
			
			st.executeUpdate();

		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
	}

}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import entities.Consulta;

public class ConsultaDAO {

	private Connection conn;

	public ConsultaDAO(Connection conn) {

		this.conn = conn;
	}

	public void agendar(Consulta consulta, int codigo, int crm) throws SQLException {

		PreparedStatement st = null;

		try {
		    st = conn.prepareStatement("insert into consulta (cod_paciente, crm, dia, hora) values (?, ?, ?, ?)");

		    st.setInt(1, codigo);
		    st.setInt(2, crm);
		    st.setDate(3, consulta.getDataConsulta());
		    st.setTime(4, consulta.getHoraCosulta());
		    
		    st.executeUpdate();
		    
		    System.out.println("Data:" + consulta.getDataConsulta());
		    System.out.println("Hora: " + consulta.getHoraCosulta());
		    // Adicione outras operações no banco de dados, se necessário

		} finally {
		    BancoDados.finalizarStatement(st);
		    BancoDados.desconectar();
		}
	}
}

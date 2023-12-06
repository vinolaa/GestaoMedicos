package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Consulta;
import service.MedicoService;
import service.PacienteService;

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

		} finally {
			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
	}

	public List<Consulta> buscarPorNomePaciente(String nome_paciente) throws SQLException, IOException {

		PreparedStatement st = null, st1 = null;
		ResultSet rs = null, rs1 = null;

		try {

			st = conn.prepareStatement("SELECT cod_paciente FROM paciente WHERE nome = ?");
			st.setString(1, nome_paciente);
			rs = st.executeQuery();

			List<Consulta> listaConsultas = new ArrayList<>();

			if (rs.next()) {

				int codigoPaciente = rs.getInt("cod_paciente");

				st1 = conn.prepareStatement("SELECT * FROM consulta WHERE cod_paciente = ?");
				st1.setInt(1, codigoPaciente);
				rs1 = st1.executeQuery();

				while (rs1.next()) {
					Consulta consulta = new Consulta();
					consulta.setPaciente(nome_paciente);
					consulta.setCrm(rs1.getInt("crm"));
					consulta.setCodigoConsulta(rs1.getInt("cod_consulta"));
					consulta.setDataConsulta(rs1.getDate("dia"));
					consulta.setHoraCosulta(rs1.getTime("hora"));
					listaConsultas.add(consulta);
				}

			}

			return listaConsultas;

		} finally {
			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
			BancoDados.finalizarStatement(st1);
			BancoDados.finalizarResultSet(rs1);
			BancoDados.desconectar();
		}
	}

	public List<Consulta> buscarTodas(int crm) throws SQLException, IOException {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = conn.prepareStatement("SELECT * FROM consulta WHERE crm = ? ORDER BY dia ASC, hora ASC");

			st.setInt(1, crm);
			rs = st.executeQuery();

			List<Consulta> listaConsultas = new ArrayList<>();
			int codigo;
			PacienteService pacienteService = new PacienteService();
			String paciente, medico;
			MedicoService medicoService = new MedicoService();

			while (rs.next()) {
				Consulta consulta = new Consulta();
				codigo = rs.getInt("cod_paciente");
				paciente = pacienteService.buscarNomePorCodigo(codigo);
				consulta.setPaciente(paciente);
				medico = medicoService.buscarNomePorCrm(crm);
				consulta.setMedico(medico);
				consulta.setDataConsulta(rs.getDate("dia"));
				consulta.setHoraCosulta(rs.getTime("hora"));

				listaConsultas.add(consulta);
			}

			return listaConsultas;

		} catch (SQLException e) {

			e.printStackTrace();
			throw e;
		}

		finally {
			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
			BancoDados.desconectar();
		}
	}


}

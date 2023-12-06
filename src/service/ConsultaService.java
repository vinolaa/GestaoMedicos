package service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.BancoDados;
import dao.ConsultaDAO;
import entities.Consulta;

public class ConsultaService {

	public ConsultaService() {

	}

	public void agendar(Consulta consulta) throws SQLException, IOException {

		Connection conn = BancoDados.conectar();
		MedicoService medicoService = new MedicoService();
		int crm = medicoService.buscarCrmPorNome(consulta.getMedico());
		PacienteService pacienteService = new PacienteService();
		conn = BancoDados.conectar();
		int cod_paciente = pacienteService.buscarCrmPorNome(consulta.getPaciente());
		System.out.println("CRM: " + crm + "\n");
		System.out.println("Codigo: " + cod_paciente);
		conn = BancoDados.conectar();
		new ConsultaDAO(conn).agendar(consulta, cod_paciente, crm);
	}

	public List<Consulta> buscarTodas(int crm) throws SQLException, IOException {

		Connection conn = BancoDados.conectar();
		return new ConsultaDAO(conn).buscarTodas(crm);
	}
}

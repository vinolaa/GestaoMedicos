package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import entities.Paciente;

public class PacienteDAO {

	private Connection conn;

	public PacienteDAO(Connection conn) {

		this.conn = conn;
	}
	
	public void cadastrar(Paciente paciente) throws SQLException {

		PreparedStatement st = null;

		try {

			st = conn.prepareStatement(
					"insert into paciente (nome, endereco, telefone, foto, data_nascimento, sexo, cod_forma_pagamento ) values (?, ?, ?, ?, ?, ?, ?)");

			st.setString(1, paciente.getNome());
			st.setString(2, paciente.getEndereco());
			st.setString(3, paciente.getTelefone());
			st.setString(4, paciente.getFoto());
			st.setDate(5, paciente.getDataNascimento());
			st.setString(6, paciente.getSexo());
			st.setInt(7, paciente.getFormaPagamento());

			st.executeUpdate();

		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
	}
}

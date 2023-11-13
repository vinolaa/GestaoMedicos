package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Pagamento;

public class PagamentoDAO {

	private Connection conn;

	public PagamentoDAO(Connection conn) {

		this.conn = conn;
	}

	public void cadastrar(Pagamento pagamento) throws SQLException {

		PreparedStatement st = null;

		try {

			st = conn.prepareStatement("insert into forma_pagamento (forma_pagamento) values (?)");

			st.setString(1, pagamento.getFormaPagamento());
			st.executeUpdate();

		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.desconectar();
		}
	}
	
	public List<Pagamento> buscarTodos() throws SQLException {

		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			st = conn.prepareStatement("select * from forma_pagamento");

			rs = st.executeQuery();

			List<Pagamento> listaPagamentos = new ArrayList<>();

			while (rs.next()) {

				Pagamento pagamento = new Pagamento();
				pagamento.setCodigo(rs.getInt("cod_forma_pagamento"));
				pagamento.setFormaPagamento(rs.getString("forma_pagamento"));

				listaPagamentos.add(pagamento);
			}

			return listaPagamentos;

		} finally {

			BancoDados.finalizarStatement(st);
			BancoDados.finalizarResultSet(rs);
			BancoDados.desconectar();
		}
	}

}

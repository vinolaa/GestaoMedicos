package entities;

import java.sql.Date;

public class ExameAgendado {
	
	private String nomePaciente;
	private int crm;
	private Date data;
	private double valorPago;
	private int codigoExame;
	
	public ExameAgendado() {}

	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}

	public void setCrm(int crm) {
		this.crm = crm;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public void setValorPago(double valorPago) {
		this.valorPago = valorPago;
	}

	public void setCodigoExame(int codigoExame) {
		this.codigoExame = codigoExame;
	}

	public String getNomePaciente() {
		return nomePaciente;
	}

	public int getCrm() {
		return crm;
	}

	public Date getData() {
		return data;
	}

	public double getValorPago() {
		return valorPago;
	}

	public int getCodigoExame() {
		return codigoExame;
	}

	@Override
	public String toString() {
		return "ExameAgendado [nomePaciente=" + nomePaciente + ", crm=" + crm + ", data=" + data + ", valorPago="
				+ valorPago + ", codigoExame=" + codigoExame + "]";
	}
	

}

package entities;

import java.sql.Date;
import java.sql.Time;

public class ExameAgendado {

	private String nomePaciente;
	private int crm;
	private Date data;
	private Time hora;
	private double valorPago;
	private int codigoExame;
	private String exame;

	public ExameAgendado() {

	}

	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}

	public void setCrm(int crm) {
		this.crm = crm;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}

	public void setValorPago(double valorPago) {
		this.valorPago = valorPago;
	}

	public void setCodigoExame(int codigoExame) {
		this.codigoExame = codigoExame;
	}

	public void setExame(String exame) {
		this.exame = exame;
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

	public Time getHora() {
		return hora;
	}

	public double getValorPago() {
		return valorPago;
	}

	public int getCodigoExame() {
		return codigoExame;
	}

	public String getExame() {
		return exame;
	}

	@Override
	public String toString() {
		return "ExameAgendado [nomePaciente=" + nomePaciente + ", crm=" + crm + ", data=" + data + ", valorPago="
				+ valorPago + ", codigoExame=" + codigoExame + "]";
	}

}

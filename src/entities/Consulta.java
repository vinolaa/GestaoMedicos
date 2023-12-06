package entities;

import java.sql.Date;
import java.sql.Time;

public class Consulta {
	private String paciente;
	private String medico;
	private Date dataConsulta;
	private Time horaCosulta;
	private int codigoConsulta;
	private int crm;

	public Consulta() {

	}

	public Consulta(String paciente, String medico, Date horarioConsulta) {
	
		this.paciente = paciente;
		this.medico = medico;
		this.dataConsulta = horarioConsulta;
	}

	public String getPaciente() {
		return paciente;
	}

	public void setPaciente(String paciente) {
		this.paciente = paciente;
	}

	public String getMedico() {
		return medico;
	}

	public void setMedico(String medico) {
		this.medico = medico;
	}

	public Date getDataConsulta() {
		return dataConsulta;
	}

	public void setDataConsulta(Date dataConsulta) {
		this.dataConsulta = dataConsulta;
	}

	public Time getHoraCosulta() {
		return horaCosulta;
	}

	public void setHoraCosulta(Time horaCosulta) {
		this.horaCosulta = horaCosulta;
	}

	public int getCodigoConsulta() {
		return codigoConsulta;
	}

	public void setCodigoConsulta(int codigoConsulta) {
		this.codigoConsulta = codigoConsulta;
	}

	public int getCrm() {
		return crm;
	}

	public void setCrm(int crm) {
		this.crm = crm;
	}

	@Override
	public String toString() {
		return "Consulta [paciente=" + paciente + ", medico=" + medico + ", dataConsulta=" + dataConsulta
				+ ", horaCosulta=" + horaCosulta + ", codigoConsulta=" + codigoConsulta + ", crm=" + crm + "]";
	}

}
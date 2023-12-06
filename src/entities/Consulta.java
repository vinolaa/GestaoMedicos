package entities;

import java.sql.Date;
import java.sql.Time;

public class Consulta {
	private String paciente;
	private String medico;
	private Date dataConsulta;
	private Time horaCosulta;

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

}

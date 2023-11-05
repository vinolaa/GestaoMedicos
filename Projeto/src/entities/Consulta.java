package entities;

import java.util.Date;

public class Consulta {
	private Paciente paciente;
	private Medico medico;
	private Date horarioConsulta;

	public Consulta(Paciente paciente, Medico medico, Date horarioConsulta) {
		super();
		this.paciente = paciente;
		this.medico = medico;
		this.horarioConsulta = horarioConsulta;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Date getHorarioConsulta() {
		return horarioConsulta;
	}

	public void setHorarioConsulta(Date horarioConsulta) {
		this.horarioConsulta = horarioConsulta;
	}

}

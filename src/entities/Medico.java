package entities;

public class Medico extends Pessoa {
	private int crm;
	private Especialidade especialidade;

	public Medico(String nome, String endereco, String telefone, int crm, Especialidade especialidade) {
		super(nome, endereco, telefone);
		this.crm = crm;
		this.especialidade = especialidade;
	}

	public int getCrm() {
		return crm;
	}

	public void setCrm(int crm) {
		this.crm = crm;
	}

	public Especialidade getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}

}

package entities;

import java.sql.Date;

public class Paciente extends Pessoa {

	private String foto;
	private Date dataNascimento;
	private String sexo;
	private int formaPagamento;

	public Paciente() {

	}

	public Paciente(String nome, String endereco, String telefone, String foto, Date dataNascimento, String sexo,
			int formaPagamento) {
		super(nome, endereco, telefone);
		this.foto = foto;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.formaPagamento = formaPagamento;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(int formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	@Override
	public String toString() {
		return super.toString() + "Paciente [foto=" + foto + ", dataNascimento=" + dataNascimento + ", sexo=" + sexo
				+ ", formaPagamento=" + formaPagamento + "]";
	}

}

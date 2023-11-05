package entities;

public class Paciente extends Pessoa {

	private String foto;
	private String dataNascimento;
	private String sexo;
	private String formaPagamento;

	public Paciente(String nome, String endereco, String telefone, String foto, String dataNascimento, String sexo,
			String formaPagamento) {
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

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

}

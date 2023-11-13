package entities;

public class Pagamento {

	private int codigo;
	private String formaPagamento;

	public Pagamento() {

	}

	public Pagamento(String formaPagamento) {

		this.formaPagamento = formaPagamento;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	  @Override
	    public String toString() {
	        return formaPagamento;
	    }
}

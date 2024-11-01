package entities;

public class Planejamento extends Mes{

	private String mes;
	private String categoria;
	private Double valor;
	
	public Planejamento() {
		
	}

	
	public Planejamento(String mes, String categoria, Double valor) {
		super();
		this.mes = mes;
		this.categoria = categoria;
		this.valor = valor;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	
	
	
	
}

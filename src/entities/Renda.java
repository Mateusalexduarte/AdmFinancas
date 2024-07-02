package entities;

import enums.Status;

public class Renda extends Mes {
	
	public String origem;
	public Double valor;
	public Status status;
	
	
	public Renda(String mes, String origem, Double valor, Status status) {
		super(mes);
		this.origem = origem;
		this.valor = valor;
		this.status = status;
	}


	public String getOrigem() {
		return origem;
	}


	public void setOrigem(String origem) {
		this.origem = origem;
	}


	public Double getValor() {
		return valor;
	}


	public void setValor(Double valor) {
		this.valor = valor;
	}


	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		
		return getMes()+ " " + getOrigem() + " " + getValor() + " " + getStatus();
	}

	
}

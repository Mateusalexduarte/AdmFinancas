package entities;

import java.util.Date;

import enums.Status;

public class Gastos extends Mes {
	
	public String categoria;
	public String descricao;
	public Double valor;
	public String data;
	public Status status;
	
	
	
	
	
	public Gastos() {
		
	}


	public Gastos(String mes, String categoria, String descricao, Double valor, String data, Status status) {
		super(mes);
		this.categoria = categoria;
		this.descricao = descricao;
		this.valor = valor;
		this.data = data;
		this.status = status;
	}


	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public Double getValor() {
		return valor;
	}


	public void setValor(Double valor) {
		this.valor = valor;
	}


	public String getData() {
		return data;
	}


	public void setData(String data) {
		this.data = data;
	}


	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	}
	
	
	
	@Override
	public String toString() {
		return getMes() 
				+ " " + getCategoria()
				+" "+ getDescricao()
				+" "+ getValor()
				+" "+ getData()
				+" "+ getStatus();
	} 

}

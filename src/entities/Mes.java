package entities;

import java.util.ArrayList;
import java.util.List;

public class Mes {
	
	public String mes;
	private List<Renda> renda = new ArrayList<>();
	private List<Gastos> gastos = new ArrayList<>();
	
	public Mes() {
		
	}

	public Mes(String mes) {
		this.mes = mes;
		
	}



	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}
	
	public void addRenda(Renda renda) {
		this.addRenda(renda);
	}
	
	public void addGastos(Gastos gastos) {
		this.addGastos(gastos);
	}
	
	@Override
	public String toString() {
		return getMes();
	}
	

}

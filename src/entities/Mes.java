package entities;

import java.util.ArrayList;
import java.util.List;

import entities.Gastos;
import entities.Renda;
import enums.Status;

public class Mes {
	
	public String mes;
	private List<Renda> renda = new ArrayList<Renda>();
	private List<Gastos> gastos = new ArrayList<Gastos>();
	public Double total;
	
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
	
	
	
	public List<Renda> getRenda() {
		return renda;
	}

	public void setRenda(List<Renda> renda) {
		this.renda = renda;
	}

	public List<Gastos> getGastos() {
		return gastos;
	}

	public void setGastos(List<Gastos> gastos) {
		this.gastos = gastos;
	}

	public void addRenda(Renda renda) {
		this.renda.add(renda);
	}
	
	public void addGastos(Gastos gastos) {
		this.gastos.add(gastos);
	}
	
	public void printRenda() {
		for(Renda r : renda) {
			System.out.println(
					r.getMes()
					+" "+ r.getOrigem()
					+" "+ r.getValor()
					+" "+ r.getStatus()
					);
		}
	}
	
	public void printGastos() {
		for(Gastos g : gastos) {
			System.out.println(
					g.getMes()
					+" "+ g.getCategoria()
					+" "+ g.getDescricao()
					+" "+ g.getValor()
					+" "+ g.getData()
					+" "+ g.getStatus()
					);
		}
	}
	
	public Double somaGastos() {
		double total = 0;
		for(Gastos g : gastos) {
			total += g.getValor();
		}
		return total;
	}
	
	public Double somaRenda() {
		double total = 0;
		for(Renda r : renda) {
			total += r.getValor();
		}
		return total;
	}
	
	public Double saldo() {
		Double saldo;
		saldo = somaRenda() - somaGastos();
		return saldo;
		
	}
	
	public String rendasPendentes() {
		int pendente = 0;
		int recebido = 0;
		
		for(Renda r : renda) {
			if (r.getStatus() == Status.PENDENTE) {
			pendente += 1;
		 }
			if (r.getStatus() == Status.RECEBIDO) {
				recebido += 1;
			 }
		}
		return  "Rendas pendentes :" + pendente + "   " + "Rendas recebidas : " + recebido;
	}
	
	public String gastosPendentes() {
		int pendente = 0;
		int pago = 0;
		
		for(Gastos g : gastos) {
			if (g.getStatus() == Status.PENDENTE) {
			pendente += 1;
		 }
			if (g.getStatus() == Status.PAGO) {
				pago += 1;
			 }
		}
		return "Debitos pendentes :" + pendente + "   " + "Debitos pagos :" + pago;
	}
	
	
	
	@Override
	public String toString() {
		return getMes();
	}
	

}

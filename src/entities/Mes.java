package entities;

import java.util.ArrayList;
import java.util.List;

import enums.Status;

public class Mes {
	
	public String mes;
	private List<Renda> renda = new ArrayList<Renda>();
	private List<Gastos> gastos = new ArrayList<Gastos>();
	private List<String> formPag = new ArrayList<>();
	public List<Planejamento> planejamento = new ArrayList<Planejamento>();
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
	
	public void setPlanejamento(String mes, String nome) {
		for(Planejamento p : planejamento) {
			if(p.getMes().equals(mes) && p.getCategoria().equals(nome)) {
			
			}
		}
	}

	public void addRenda(Renda renda) {
		this.renda.add(renda);
	}
	
	public void addGastos(Gastos gastos) {
		this.gastos.add(gastos);
	}
	
	
	public void addFormPag(String formPag) {
		this.formPag.add(formPag);
	}
	
	public void addPlanejamento(Planejamento planejamneto) {
		this.planejamento.add(planejamneto);
	}
	
	public void listarFormPag(String mes) {
		for(String f : formPag) {
			System.out.println(f + "\n");
		}
	}
	
	
	public void printRenda(String mes) {
		System.out.println(mes);
		System.out.print("_______________________________________________________________");
		for(Renda r : renda) {
			if(r.getMes().equals(mes)) {
				System.out.println(
						
						"\n Origem :  "+ r.getOrigem()
						+" \n Valor : "+ r.getValor()
						+"\n Status :  "+ r.getStatus());
			
			}
			else { System.out.println("Não tem renda para esse mês ");}
		}
		System.out.print("_______________________________________________________________");
	}
	
	public void printGastos(String mes) {
		System.out.println(mes);
		System.out.print("_______________________________________________________________");
		for(Gastos g : gastos) {
			if(g.getMes().equals(mes)) {
			System.out.println(
					 
					"\n Categoria : "+ g.getCategoria()
					+"\n Descrição : "+ g.getDescricao()
					+"\n Valor : "+ g.getValor()
					+"\n Data : "+ g.getData()
					+"\n Forma de pagamento : "+ g.getFormPag()
					+"\n Status : "+ g.getStatus()+ "\n\n\n"
					);
			}else {System.out.println("Não foi encontrado gastos para esse mês ");}
		}
		System.out.print("_______________________________________________________________");
	}
	
	public void printPlanejamento(String mes) {
		System.out.println(" Mês : " +mes);
		for(Planejamento p : planejamento) {
			if(p.getMes().equals(mes)) {
			System.out.println(
					"Categoria : "+ p.getCategoria() + "  " + "Valor : "+ p.getValor());
			}
			else System.out.println("Nenhum planejamento encontrado ");
		}
	}
	
	public boolean confirmarCategoriaRepetida(String mes, String ctg) {
		boolean x = false;
		for(Planejamento p : planejamento) {
			if(p.getMes().equals(mes) && p.getCategoria().equals(ctg)) {
				x = true;
			 }
			
		}
		return x;
	}
	
	
	public void statusPlanejamento(String mes) {
		
		double gasto = 0;
		double saldo = 0;
		String ctg = null;
		for(Planejamento p : planejamento) {
			if(p.getMes().equals(mes)) {
				ctg = p.getCategoria();
				saldo += p.getValor();
				
				for(Gastos g : gastos) {
					if(ctg.equals(g.getCategoria())) {
					saldo -= g.getValor();
					gasto += g.getValor();
					}
				}
				System.out.println( ctg + "  "+ p.getValor() + "  " + gasto + "  " + saldo);
				gasto = 0;
				saldo = 0;
			}
		}
		
	}
	
	
	
	public Double somaGastos(String mes) {
		double total = 0;
		for(Gastos g : gastos) {
			if(g.getMes().equals(mes)) {
			total += g.getValor();
			}
		}
		return total;
	}
	
	public Double somaRenda(String mes) {
		double total = 0;
		for(Renda r : renda) {
			if(r.getMes().equals(mes)) {
			total += r.getValor();
			}
		}
		return total;
	}
	
	public Double saldo(String mes) {
		Double saldo;
		saldo = somaRenda(mes) - somaGastos(mes);
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

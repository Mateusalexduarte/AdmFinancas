package application;

import java.text.SimpleDateFormat;
import java.util.Date;

import entities.Gastos;
import entities.Mes;
import entities.Renda;
import enums.Status;

public class Program {
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_BLUE = "\u001B[34m";
	
	public static void main(String[] args) {
		
		
		
		 Date dataAtual = new Date();
		 
		 SimpleDateFormat data =  new SimpleDateFormat("dd/MM/yyyy");
		String dt = data.format(dataAtual);
	
		
		Mes mes = new Mes();
		
		mes.addRenda(new Renda("jan","salario", 5000.0, Status.PENDENTE));
		mes.addRenda(new Renda("fev","salario", 6000.0, Status.RECEBIDO));
		mes.addRenda(new Renda("mar","salario", 7000.0, Status.RECEBIDO));
		mes.addRenda(new Renda("abr","salario", 5000.0, Status.RECEBIDO));
		
		mes.printRenda();
		
		System.out.println("    ");
		System.out.println("    ");
		System.out.println("    ");
		
		mes.addGastos(new Gastos("jan"," fixo", " conta de luz", 120.0,dt, Status.PENDENTE ));
		mes.addGastos(new Gastos("jan"," fixo", " conta de agua", 100.0,dt, Status.PAGO ));
		mes.addGastos(new Gastos("jan"," fixo", " compras", 1000.0,dt, Status.PAGO ));
		mes.addGastos(new Gastos("jan"," fixo", " transporte",200.0,dt, Status.PAGO ));
		
		mes.printGastos();
		
		System.out.println("    ");
		System.out.println("    ");
		System.out.println("    ");
		
		
		System.out.println("Renda : " + ANSI_BLUE + mes.somaRenda() + ANSI_RESET);
		System.out.println("Gastos : "+ ANSI_RED + mes.somaGastos() + ANSI_RESET);
		System.out.println("Saldo : "+ ANSI_GREEN + mes.saldo() + ANSI_RESET);
		
		System.out.println("    ");
		System.out.println("    ");
		System.out.println("    ");
		
		System.out.println( mes.rendasPendentes());
		System.out.println( mes.gastosPendentes());
		
		
	}

}
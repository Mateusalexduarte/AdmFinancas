package application;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Gastos;
import entities.Mes;
import entities.Planejamento;
import entities.Renda;
import enums.Status;

public class Program {
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_BLUE = "\u001B[34m";
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		 Date dataAtual = new Date();
		 
		 SimpleDateFormat data =  new SimpleDateFormat("dd/MM/yyyy");
		String dt = data.format(dataAtual);
	
		
		Mes mes = new Mes();
		
		System.out.println("\n Digite um mês : ");
		System.out.print("Mês : ");
		String mesM = sc.next();
		
	while(true){
			
				
		System.out.println("    ");
		System.out.println("    ");
		System.out.println("    ");
		
		System.out.print("Renda : " + ANSI_BLUE + mes.somaRenda(mesM ) + ANSI_RESET);
		System.out.print("  Gastos : "+ ANSI_RED + mes.somaGastos(mesM ) + ANSI_RESET);
		System.out.print("  Saldo : "+ ANSI_GREEN + mes.saldo(mesM ) + ANSI_RESET);
		
		System.out.println("    ");
		System.out.println("    ");
		System.out.println("    ");
		
		System.out.println( mes.rendasPendentes());
		System.out.println( mes.gastosPendentes());
		
		System.out.println("    ");
		mes.statusPlanejamento(mesM);
		System.out.println("    ");
		System.out.println("    ");
		
		
				System.out.println("SELECIONE UMA OPÇÃO");
				System.out.println("[1] add renda");
				System.out.println("[2] add gastos");
				System.out.println("[3] add planejamento");
				System.out.println("[4] ver renda");
				System.out.println("[5] ver gastos");
				System.out.println("[6] ver planejamento");
				System.out.println("[7] Status do planejamento ");
				System.out.println("[8] Trocar de mês ");
				
				System.out.println("");
				
				int op = sc.nextInt();
				switch(op) {
				
				case 1 : 
					System.out.println("Add renda ");
					System.out.print("Origem : ");
					String descricao = sc.next();
					sc.nextLine();
					System.out.print("Valor :");
					double valor = sc.nextDouble();
					
					
					mes.addRenda(new Renda(mesM, descricao,valor,Status.RECEBIDO));
					break;
					
				case 2: 
					System.out.println("Add gastos ");
					 System.out.print("Categoria :");
					 String ctg = sc.next();
					 if(!mes.confirmarCategoriaRepetida(mesM, ctg)) {
						 System.out.println("Essa categoria de gastos não existe");
						 System.out.println("A categoria "+ ctg + " foi criada com sucesso!!!");
						 mes.addPlanejamento(new Planejamento(mesM,ctg,0.0));
						
					 }else 
						 sc.nextLine();
					System.out.print("Descrição : ");
					descricao = sc.nextLine();
					 sc.nextLine();
					System.out.println("Valor :");
					 valor = sc.nextDouble();
					 System.out.print("Forma de pagamento : ");
					 String formPag = null;
					 System.out.print("\n [1] Dinheiro \n [2] Pix \n [3] Debito \n [4] Cartão de credito \n ");
					 op = sc.nextInt();
					 if(op == 1) {
						 formPag = "Dinheiro";
					 }
					 if(op == 2) {
						 formPag = "Pix";
					 }
					 if(op == 3) {
						 formPag = "Debito";
					 }
					 if(op == 4) { 
						 System.out.print("De um nome para o cartão que será usado como forma de pagamento : ");
						 formPag = sc.next();
						 mes.addFormPag(formPag);
					 }
					 
						 mes.addGastos(new Gastos(mesM, ctg, descricao, valor,dt,formPag, Status.PENDENTE ));
					break;
					
				case 3 :
					
					System.out.print("Crie uma categoria de gastos : ");
					ctg = sc.next();
					if(mes.confirmarCategoriaRepetida(mesM, ctg)) {
						System.out.println(ANSI_RED + "Essa categoria ja existe" + ANSI_RESET);
						
					}
					else {
					System.out.print("Teto de gastos : ");
					valor = sc.nextDouble();
					mes.addPlanejamento(new Planejamento(mesM, ctg, valor));
					}
					break;
					
				case 4:
				mes.printRenda(mesM);
				
					break;
					
				case 5	:
					mes.printGastos(mesM);
					System.out.println("");
					break;
					
				case 6 : 
					mes.printPlanejamento(mesM);
					break;
					
				case 7 : 
					mes.statusPlanejamento(mesM);
					break;
					
				case 8 : 
					System.out.print("Digite o mês : ");
					mesM = sc.next();
					
				}
				
				
			}
		
		
	}

}
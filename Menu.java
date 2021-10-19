package Avaliacao;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Menu {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Conta> Contas = new ArrayList<Conta>();
		int opt = 0, controle;
		
		String nomeAgencia, nomeCliente, CPFCliente;
		int numeroAgencia; 
		double valorDeposito;
		
		Random geradorConta = new Random();
		
		do {		
			System.out.println("1. Cadastro");
			System.out.println("2. Depósito");
			System.out.println("3. Render Juros");
			System.out.println("4. Consulta de número de agência");
			System.out.println("5. Alteração de número e nome de agência");
			System.out.println("0. Sair");
			opt = sc.nextInt();
			
		switch(opt) {
		
		case 1:				
				System.out.println();
				System.out.println("Nome da Agência: ");
				nomeAgencia = sc.next();
				System.out.println("Numero da Agência: ");
				numeroAgencia = sc.nextInt();
				System.out.println("Seu nome: ");
				nomeCliente = sc.next();
				System.out.println("CPF: ");
				CPFCliente = sc.next();
				int numConta = geradorConta.nextInt(100);
				System.out.println("O número da sua conta é: "+numConta);	
							
				System.out.println("1. Poupança");
				System.out.println("2. Outra");
				controle = sc.nextInt(); 
				
				if(controle == 1) 
				{
					Contas.add(new Poupanca(numConta, new Banco(numeroAgencia, nomeAgencia), new Cliente(nomeCliente, CPFCliente), 0.0));
				}else 
				{
					Contas.add(new Conta(numConta, new Banco(numeroAgencia, nomeAgencia), new Cliente(nomeCliente, CPFCliente), 0.0));
				}	
				System.out.println("Cadastro realizado com sucesso!");
				System.out.println("Saldo Inicial : 0.0");		
			break;
			
		case 2: 
			System.out.println("Informe seu CPF: ");
			CPFCliente = sc.next();
			
			for (int i = 0; i < Contas.size(); i++){	
				if(Contas.get(i).getCliente().getCPF().equals(CPFCliente))
				{
					System.out.println("Valor a ser depositado: ");
					valorDeposito = sc.nextDouble();
					Contas.get(i).setSaldo(valorDeposito);
				} 
			}
		break;
		
		case 3:
			System.out.println("Informe seu CPF: ");
			CPFCliente = sc.next();
		
			for (int i = 0; i < Contas.size(); i++) 
			{	
				if(Contas.get(i) instanceof Poupanca)
				{
				 if(((Poupanca) Contas.get(i)).getCliente().getCPF().equals(CPFCliente))
				{
					System.out.println("Rendimento: "+ ((Poupanca) Contas.get(i)).RenderJuros());
				} 
				}
		    }
			break;
		
		case 4: 
			System.out.println("Numero da Agência: ");
			numeroAgencia = sc.nextInt();
			System.out.println("Nome da Agência: ");
			nomeAgencia = sc.next();
			
			for (int i = 0; i < Contas.size(); i++) {
				if(Contas.get(i).getBanco().getNomeAgencia().equals(nomeAgencia) && Contas.get(i).getBanco().getNumeroAgencia() == numeroAgencia) 
				{
					System.out.println("Nome do Cliente: "+Contas.get(i).getCliente().getNome());
					System.out.println("CPF do Cliente: "+Contas.get(i).getCliente().getCPF());
				}
			}
			System.out.println("Agência não cadastrada!");
			break;
			
		case 5: 
			System.out.println("Informe seu nome: ");
			nomeCliente = sc.next();
			
			for (int i = 0; i < Contas.size(); i++) {
				if(Contas.get(i).getCliente().getNome().equals(nomeCliente)) 
				{
					System.out.println("Novo número da Agência: ");
					numeroAgencia = sc.nextInt();
					System.out.println("Nova Agência: ");
					nomeAgencia = sc.next();			
					Contas.get(i).getBanco().setNumeroAgencia(numeroAgencia);
					Contas.get(i).getBanco().setNomeAgencia(nomeAgencia);
					System.out.println("Dados alterados com sucesso.");
				}
			}	
			break;
		}						
		}while(opt!=0);
	}

}

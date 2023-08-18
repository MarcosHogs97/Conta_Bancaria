package util;

import java.util.Scanner;

public class ContaBancaria {
	private String nomeTitular;
	private int idConta;
	private double depositoInicial;
	private static final double taxa = 5;
	
	//construto personalizado para 2 parametros.
	public ContaBancaria(String nomeTitular,int idConta){
		this.nomeTitular = nomeTitular;
		this.idConta = idConta;
		this.depositoInicial = 0;
	}
	
	//get e set
	public String getNomeTitular() {
		return nomeTitular;
	}

	public void setNomeTitular(String nomeTitular) {
		this.nomeTitular = nomeTitular;
	}

	public int getIdConta() {
		return idConta;
	}

	public void setIdConta(int idConta) {
		this.idConta = idConta;
	}

	public double getDepositoInicial() {
		return depositoInicial;
	}

	//deposito e saques
	public void deposito(double depositoInicial) {
		this.depositoInicial += depositoInicial;
	}
	public void saques(double depositoInicial) {
		this.depositoInicial -= (depositoInicial + taxa);
	}
	
	//Metodo para iniciar a aplicação.
	public void startAplication(Scanner sc) {	
		System.out.print("Informe o nome do titular: ");
		String nome = sc.nextLine();
		setNomeTitular(nome);
		
		System.out.print("Informe o id da conta: ");
		int id = sc.nextInt();
		setIdConta(id);
		
		escolhaDepositoInicial(sc);
		
		depositar(sc);
		informacaoConta();
		
		retirada(sc);
		 informacaoConta();
	}
	//metodo para escolher se quer ou nao depositar um valor inicial.
	public void escolhaDepositoInicial(Scanner sc) {
		System.out.println("Gostaria de efetuar o deposito inicial? (s/n)");
		char resposta = sc.next().charAt(0);
		
		switch (resposta) {
		case 's':
			System.out.print("Informe o valor que deseja depositar: ");
			double deposito = sc.nextDouble();
			deposito(deposito);
			informacaoConta();
			break;
		case 'n':
			System.out.println("Obrigado pela preferencia!!");
			System.out.println("Aqui esta os dados da sua conta!");
			informacaoConta();
			break;
		default:
			System.out.println("Informe uma opção valida!!\n");
			escolhaDepositoInicial(sc);
			break;
		}
	}
	
	//metodo para depositar. 
	public void depositar(Scanner sc) {
		System.out.print("Insira um valor para depósito: ");
		double deposito = sc.nextDouble();
		deposito(deposito);
	}
	
	//metodo para retirar. 
	public void retirada(Scanner sc) {
		System.out.print("Insira um valor para retirada: ");
		double retirada = sc.nextDouble();
		saques(retirada);
	}
	
	//metodo para exibir as informaçoes da conta.
	public void informacaoConta() {
		System.out.println("=============================================");
		System.out.println(toString());
		System.out.println("=============================================");
	}
	
	public String toString(){
		return "Conta: " + String.format("%.2f", getIdConta())  + "\nNome do titular: " + String.format("%.2f",getNomeTitular())  + "\nSaldo: R$ " + String.format("%.2f",getDepositoInicial());
	}
}
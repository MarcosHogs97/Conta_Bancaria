package aplication;

import java.util.Scanner;

import util.ContaBancaria;

public class Start_Conta_Bancaria {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ContaBancaria conta = new ContaBancaria();
		
		conta.startAplication(sc);
		
		sc.close();
	}

}

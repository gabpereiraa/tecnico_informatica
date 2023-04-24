package locadora;

import java.util.Random;

public class Carro {
	//atributos
	int ano;
	String cor;
	
	//construtor
	public Carro() {
		System.out.println("______________________________________");
		// Dica: <ctrl><shift><o> importa automaticamente a classe
		// a linha abaixo cria um objeto de nome chassi
		String chassi = new String("123456789ABCDEFGHIJKLMNOPQRSTUVXYZ");
		// apoio ao entendimento da logica
		// System.out.println(chassi.charAt(6));
		// System.out.println(chassi.length());
		Random gerador = new Random();
		System.out.print("Chassi: * ");
		for (int i = 1; i < 16; i++) {
			char numeracao = (char) gerador.nextInt(chassi.length());
			System.out.print(chassi.charAt(numeracao));
		}
		System.out.println(" *");
	}// fim do construtor
	
	//métodos
	public void ligar() {
		System.out.println("Engine on.....");
	}
	
	public void desligar() {
		System.out.println("Engine off.");
	}
	
	public void acelerar() {
		System.out.println("Vrummmmmmmmmmmm");
	}
}

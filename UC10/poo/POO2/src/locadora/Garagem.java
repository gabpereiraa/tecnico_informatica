package locadora;

public class Garagem {

	public static void main(String[] args) {
		Carro fusca = new Carro();
		fusca.ano = 1967;
		fusca.cor = "Azul";
		System.out.println("Fusca");
		System.out.println("Ano: " + fusca.ano);
		System.out.println("Cor: " + fusca.cor);
		fusca.ligar();
		fusca.desligar();
		
		Carro ferrari = new Carro();
		ferrari.ano = 2012;
		ferrari.cor = "Vermelho";
		System.out.println("Ferrari");
		System.out.println("Ano: " + ferrari.ano);
		System.out.println("Cor: " + ferrari.cor);
		ferrari.ligar();
		ferrari.acelerar();;		
	}

}

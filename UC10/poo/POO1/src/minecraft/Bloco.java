package minecraft;

public class Bloco {
	//atributos
	int resistencia;
	String textura;
	
	//construtor
	public Bloco() {
		System.out.println("_________________________________");		
	}
	
	//métodos
	public void construir() {		
		System.out.println(" ___");
		System.out.println("|   |");
		System.out.println("|___|");
		System.out.println("");
	}
	
	public void minerar() {
		System.out.println(" _   _   _   _");
		System.out.println("|_| |_| |_| |_|");
	}
	
	public void craftar() {
		System.out.println("Item criado!");
	}
}

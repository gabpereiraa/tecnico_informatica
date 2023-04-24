package minecraft;

//extends no Java significa herança
public class Enxada extends Bloco {
	// atributos	
	boolean conquista;
	
	//construtor
	public Enxada() {
		System.out.println(" -__");
		System.out.println(" /");
		System.out.println("/");
	}
	
	// métodos
	public void arar() {
		System.out.println("Terra arada ._._._.");
		conquista = true;
	}
	
	// Uso de polimorfismo (sobrescrita de método para 
	// mudar o compartamento de um método exixtente na
	// classe pai (OBRIGATÓRIO criar o método com o 
	// mesmo nome)
	public void minerar() {
		System.out.println(" &#@! Dano causado !!!");
	}
	
}

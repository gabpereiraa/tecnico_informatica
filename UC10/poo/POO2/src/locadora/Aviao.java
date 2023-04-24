package locadora;

public class Aviao extends Carro{
	// atributos
	double envergadura;

	// métodos
	void aterrizar() {
		System.out.println("Avião pousou.");
	}
	
	//polimorfismo
	public void acelerar() {
		System.out.println("Avião decolou...");
	}
}

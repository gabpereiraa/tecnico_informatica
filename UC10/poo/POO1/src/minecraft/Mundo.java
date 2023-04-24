package minecraft;

public class Mundo {

	public static void main(String[] args) {
		// instanciar um bloco de terra
		Bloco blocoTerra = new Bloco();
		blocoTerra.resistencia = 1;
		blocoTerra.textura = "Terra";
		System.out.println("Bloco: " + blocoTerra.textura);
		System.out.println("Resistência: " + blocoTerra.resistencia);
		blocoTerra.construir();
		// instanciar um bloco de madeira
		Bloco blocoMadeira = new Bloco();
		blocoMadeira.resistencia = 2;
		blocoMadeira.textura = "Madeira";
		System.out.println("Bloco: " + blocoMadeira.textura);
		System.out.println("Resistência: " + blocoMadeira.resistencia);
		blocoMadeira.construir();
		blocoMadeira.minerar();
		blocoMadeira.craftar();
		// instaciar uma enxada de madeira
		Enxada enxadaMadeira = new Enxada();
		enxadaMadeira.textura = "Madeira";
		enxadaMadeira.resistencia = 2;
		enxadaMadeira.conquista = false;
		System.out.println("Enxada de : " + enxadaMadeira.textura);
		System.out.println("Resistência: " + enxadaMadeira.resistencia);
		enxadaMadeira.minerar();
		if (enxadaMadeira.conquista == true) {
			System.out.println("---------------------------------");
			System.out.println("Conquista obtida!");
			System.out.println("Dedicação séria. Hora do plantio.");
			System.out.println("---------------------------------");
		}
		
		// instaciar uma enxada de ferro
		Enxada enxadaFerro = new Enxada();
		enxadaFerro.textura = "Ferro";
		enxadaFerro.resistencia = 5;
		enxadaFerro.conquista = false;
		System.out.println("Enxada de: " + enxadaFerro.textura);
		System.out.println("Resistência: " + enxadaFerro.resistencia);
		enxadaFerro.arar();
		if (enxadaFerro.conquista == true) {
			System.out.println("---------------------------------");
			System.out.println("Conquista obtida!");
			System.out.println("Dedicação séria. Hora do plantio.");
			System.out.println("---------------------------------");
		}
	}

}

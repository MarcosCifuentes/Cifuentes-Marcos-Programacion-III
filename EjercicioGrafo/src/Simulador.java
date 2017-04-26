
public class Simulador {

	public static void main(String[] args) {

				grafoDirigido g = new grafoDirigido(5000);
				
				for (int i = 0; i < 5000; i++) {
					g.addVertice(i);
				}
				//grafo sin ciclo
				g.addAristas();
				System.out.println("----------------------------------------------");
				System.out.println("DFS Recursivo");
				System.out.println("El Grafo es ciclico: "+g.tieneCicloRecursivo());
				System.out.println("DFS Iterativo");
				System.out.println("El Grafo es ciclico: "+g.tieneCicloIterativo());
				System.out.println("----------------------------------------------");
				//agrego una arista para generar un ciclo
				g.addArista(1000, 357);
				System.out.println("----------------------------------------------");
				System.out.println("DFS Recursivo");
				System.out.println("El Grafo es ciclico: "+g.tieneCicloRecursivo());
				System.out.println("DFS Iterativo");
				System.out.println("El Grafo es ciclico: "+g.tieneCicloIterativo());
				System.out.println("----------------------------------------------");
	}
		//al generar recorridos muy grandes, el DFS recursivo consume mucha memoria
		//y genera el error stack_overflow, lo que no sucede en el DFS iterativo, aunque la 
		//velocidad de respuesta en valores anteriores al error, es mejor en el DFS recursivo. 
		//En sintesis, el DFS recursivo es mas rapido que el DFS iterativo, pero el mismo no 
		//generara Stack_Overflow, a diferencia del DFS recursivo, al consumir la memoria.
		
}

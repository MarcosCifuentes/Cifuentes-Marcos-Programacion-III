
public class Simulador {

	public static void main(String[] args) {

				grafoDirigido g = new grafoDirigido(5000);
				
				for (int i = 0; i < 5000; i++) {
					g.addVertice(i);
				}
				
				g.addAristas();
				g.addArista(555, 200);
				
//				for (int i = 0; i < g.getCantVertices(); i++) {
//					for (int j = 0; j < g.getCantAristasPorVertice(i); j++) {
//						System.out.println("Vertice: "+i+" Arista: " +g.getValorArista(i, j));
//					}
//				}

		System.out.println(g.tieneCicloRecursivo());		
		System.out.println(g.tieneCicloIterativo());

		
	}


}

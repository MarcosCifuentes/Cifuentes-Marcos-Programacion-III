
public class Simulador {

	public static void main(String[] args) {

				grafoDirigido g = new grafoDirigido(10000);// el contructor recibe la cantidad de vertices inicial
				
				for (int i = 0; i < 10000; i++) {
					g.addVertice(i);
				}
				
				g.addAristas();
				//g.addArista(555, 200);

		
				for (int i = 0; i < g.getCantVertices(); i++) {
					for (int j = 0; j < g.getCantAristasByVert(i); j++) {
						System.out.println("Vertice: "+i+" Arista: " +g.getValorArista(i, j));
					}
				}

		System.out.println(g.tieneCicloIterativo());
	}


}

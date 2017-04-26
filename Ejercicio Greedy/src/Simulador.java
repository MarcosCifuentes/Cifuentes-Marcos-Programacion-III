
public class Simulador {

	public static void main(String[] args) {
		Elemento[] e = new Elemento[4];

		//elementos a utilizar
		e[0] = new Elemento("Primero",50,2,10);
		e[1] = new Elemento("Segundo",20,20,10);	
		e[2] = new Elemento("Tercero",7,14,10);
		e[3] = new Elemento("Cuarto",1,1,10);

		Greedy g = new Greedy();
		//genera la mochila dentro del greedy
		Elemento[] mochila = g.greedy(e,128);
		//muestra los elementos cargados a la mochila
		System.out.println("Elementos en la mochila");
		for (int i = 0; i < mochila.length; i++) {
			System.out.println(mochila[i].toString());
		}
	}
}

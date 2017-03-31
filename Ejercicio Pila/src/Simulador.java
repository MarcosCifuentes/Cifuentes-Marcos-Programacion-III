
public class Simulador {

	public static void main(String[] args) {

		Pila pila =new Pila();
		
		System.out.println("Esta vacia la pila: " + pila.estaVacia());
		
		pila.apilar(1);
		
		System.out.println("El tope de la pila es: "+ pila.darTope());
	
		pila.apilar(2);
		
		System.out.println("El tope de la pila es: "+ pila.darTope());
		
		pila.apilar(3);
		
		System.out.println("El tope de la pila es: "+ pila.darTope());
		
		pila.apilar(4);
		
		System.out.println("El tope de la pila es: "+ pila.darTope());
		
		System.out.println("Esta vacia la pila: " + pila.estaVacia());
		
		pila.desapilar();
		
		System.out.println("El tope de la pila es: "+ pila.darTope());
		
		pila.desapilar();
		
		System.out.println("El tope de la pila es: "+ pila.darTope());
		
		pila.desapilar();
		
		System.out.println("El tope de la pila es: "+ pila.darTope());
		
		pila.desapilar();
		
		System.out.println("Esta vacia la pila: " + pila.estaVacia());

	}

}

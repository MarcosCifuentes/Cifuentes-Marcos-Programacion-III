
public class Pila {

	private Lista listaPila = new Lista();

	public int darTope(){
		return listaPila.getFirst();
	}

	public boolean estaVacia(){

		return listaPila.isEmpty();
	}

	public void apilar(int elem){

		listaPila.add(elem);
	}

	public void desapilar(){
		
		listaPila.delete();
	}
}

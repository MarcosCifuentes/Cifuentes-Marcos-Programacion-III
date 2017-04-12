
public class Nodo {

	int elem;
	Nodo siguenteNodo;

	public Nodo(){
		siguenteNodo = null;
	}

	public Nodo(int s){
		siguenteNodo = null;
		elem = s;
	}

	public Nodo(Nodo n, int _elem) {
		siguenteNodo = n;
		elem = _elem;
	}

	public void setElem(int _elem){
		elem=_elem;
	}

	public int getElem(){
		return elem;
	}

	public Nodo getSiguenteNodo(){
		return siguenteNodo;
	}

	public void setSiguenteNodo(Nodo n){
		siguenteNodo = n;
	}

}




public class Nodo {

	private Nodo nodoSig = null;
	private int elem = 0;

	public Nodo (int elem, Nodo n){

		setElem(elem);
		setNodoSig(n);
	}

	public Nodo getNodoSig() {
		return nodoSig;
	}

	public void setNodoSig(Nodo nodoSig) {
		this.nodoSig = nodoSig;
	}

	public int getElem() {
		return elem;
	}

	public void setElem(int elem) {
		this.elem = elem;
	}
}

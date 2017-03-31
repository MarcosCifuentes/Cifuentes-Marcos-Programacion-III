
public class Lista {

	private Nodo first = null;

	public int getFirst() {

		return first.getElem();
	}

	public void setFirst(Nodo first) {
		this.first = first;
	}

	public boolean isEmpty(){
		return first == null;
	}

	public void add(int elem){

		Nodo tmp = new Nodo(elem, null);

		tmp.setNodoSig(first);

		first = tmp;

	}
	
	public void delete(){
		
		first=first.getNodoSig();
	}


}

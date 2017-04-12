
public class Lista {

	Nodo first;
	int contador = 0;

	public Lista() {
		first = null;
	}

	public Lista(int val){
		first = new Nodo(val);
		contador++;
	}

	public void addNodo(int s) {

		Nodo tmp = new Nodo(s);
		tmp.setNext(first);
		first = tmp;
		contador++;
	}

	public void eliminarNodo(int i) {
		int auxContador = 0;
		if (i == 0) {
			first = first.getNext();

		}			
		Nodo aux = first;
		while (auxContador < this.size()){
			if (auxContador == i-1){					
				aux = aux.getNext();
				if (aux.getNext() != null) {
					aux.setNext(aux.getNext().getNext());
					this.contador--;
				}
			}
			auxContador++;
		}

	}

	public Integer at(int i){
		int cont = 0;
		Nodo aux = first;
		while(i<this.size()){
			if(cont == i){
				return aux.getInfo();
			}else{
				aux = aux.getNext();
				cont++;
			}
		}
		return null;
	}


	public boolean esVacia() {
		return (first == null);
	}

	public int size() {
		return contador;
	}

	public int numeroMax(){
		int max = first.getInfo();
		Nodo aux = first;
		for (int i = 0; i < this.size(); i++) {
			if(aux.getNext() != null){
				if(max < aux.getNext().getInfo()){
					max = aux.getNext().getInfo();
				}
			}
		}
		return max;
	}

	public boolean buscarIguales(int elem){

		Nodo cursor = first;

		while(cursor != null){
			if(cursor.getInfo() == elem){
				return true;
			}
			cursor = cursor.getNext();
		}
		return false;
	}

	public void addNodoOrde(int info){
		if (this.esVacia() || first.getInfo() > info){
			this.addNodo(info);
		}else{
			Nodo puntero = first;

			if(puntero.getNext() == null){

				if(puntero.getInfo()< info){				
					puntero.setNext(new Nodo(info));
				}else{
					this.addNodo(info);
				}
			}else{

				while(puntero.getNext()!=null && info > puntero.getNext().getInfo()){

					puntero = puntero.getNext();
				}
				Nodo nuevo = new Nodo(info);
				nuevo.setNext(puntero.getNext());
				puntero.setNext(nuevo);
			}

			contador++;
		}	

	}

	public boolean buscarElemRecu(int valor){
		if (!this.esVacia()){
			if(first.getInfo() == valor){
				return true;
			}else{
				Nodo puntero = first;
				if(puntero.getNext() != null){
					return compararNext(valor,puntero.getNext());
				}else{
					return false;
				}
			}
		}
		return false;
	}

	public boolean compararNext(int valor, Nodo p){
		if(valor == p.getInfo()){
			return true;
		}else if(p.getNext() !=null){
			return compararNext(valor,p.getNext());
		}else{
			return false;
		}
	}

	public void addNodoFinal(int val){
		if(this.esVacia()){
			this.addNodo(val);
		}else{
			addNodoFinal(val,first);
			contador++;
		}

	}

	public void addNodoFinal(int val, Nodo n){

		if(n.getNext() == null){
			n.setNext(new Nodo(val));
		}else{
			addNodoFinal(val,n.getNext());
		}

	}
}

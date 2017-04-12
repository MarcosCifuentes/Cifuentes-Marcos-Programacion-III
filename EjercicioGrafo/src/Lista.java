
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
		tmp.setSiguenteNodo(first);
		first = tmp;
		contador++;
	}

	public void eliminarNodo(int i) {
		int auxContador = 0;
		if (i == 0) {
			first = first.getSiguenteNodo();

		}			
		Nodo aux = first;
		while (auxContador < this.size()){
			if (auxContador == i-1){					
				aux = aux.getSiguenteNodo();
				if (aux.getSiguenteNodo() != null) {
					aux.setSiguenteNodo(aux.getSiguenteNodo().getSiguenteNodo());
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
				return aux.getElem();
			}else{
				aux = aux.getSiguenteNodo();
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
		int max = first.getElem();
		Nodo aux = first;
		for (int i = 0; i < this.size(); i++) {
			if(aux.getSiguenteNodo() != null){
				if(max < aux.getSiguenteNodo().getElem()){
					max = aux.getSiguenteNodo().getElem();
				}
			}
		}
		return max;
	}

	public boolean buscarIguales(int elem){

		Nodo cursor = first;

		while(cursor != null){
			if(cursor.getElem() == elem){
				return true;
			}
			cursor = cursor.getSiguenteNodo();
		}
		return false;
	}

	public void addNodoOrdenado(int info){
		if (this.esVacia() || first.getElem() > info){
			this.addNodo(info);
		}else{
			Nodo puntero = first;

			if(puntero.getSiguenteNodo() == null){

				if(puntero.getElem()< info){				
					puntero.setSiguenteNodo(new Nodo(info));
				}else{
					this.addNodo(info);
				}
			}else{

				while(puntero.getSiguenteNodo()!=null && info > puntero.getSiguenteNodo().getElem()){

					puntero = puntero.getSiguenteNodo();
				}
				Nodo nuevo = new Nodo(info);
				nuevo.setSiguenteNodo(puntero.getSiguenteNodo());
				puntero.setSiguenteNodo(nuevo);
			}

			contador++;
		}	

	}

	public boolean buscarElemRecu(int valor){
		if (!this.esVacia()){
			if(first.getElem() == valor){
				return true;
			}else{
				Nodo puntero = first;
				if(puntero.getSiguenteNodo() != null){
					return compararNext(valor,puntero.getSiguenteNodo());
				}else{
					return false;
				}
			}
		}
		return false;
	}

	public boolean compararNext(int valor, Nodo p){
		if(valor == p.getElem()){
			return true;
		}else if(p.getSiguenteNodo() !=null){
			return compararNext(valor,p.getSiguenteNodo());
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

		if(n.getSiguenteNodo() == null){
			n.setSiguenteNodo(new Nodo(val));
		}else{
			addNodoFinal(val,n.getSiguenteNodo());
		}

	}
}

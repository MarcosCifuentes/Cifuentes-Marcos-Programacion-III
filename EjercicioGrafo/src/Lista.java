
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

		public void addNodo(int s) {// inserta un Nodo al principio-- el ult Nodo
			// tiene el next null
			Nodo tmp = new Nodo(s);
			tmp.setNext(first);
			first = tmp;
			contador++;
		}

		public void eliminarNodo(int i) {// elimina por posicion
			int auxContador = 0;
			if (i == 0) {// si quiero eliminar el primero
				first = first.getNext();

			}			
			Nodo aux = first;
			while (auxContador < this.size()){//recorro hasta llegar al nodo que quiero borrar
				if (auxContador == i-1){					
					aux = aux.getNext();
					if (aux.getNext() != null) {//preg si tengo un nodo sig para borrar
						aux.setNext(aux.getNext().getNext());
						this.contador--;//al borrar la referencia descuento el contador de la lista
					}
				}
				auxContador++;
			}

		}

		public Integer at(int i){//al darme una posicion devuelvo el dato
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
			if (this.esVacia() || first.getInfo() > info){//chequeo si la lista no esta vacia o si la info va al principio
				this.addNodo(info);
			}else{
				Nodo puntero = first;
				
				if(puntero.getNext() == null){//chequea que el sig de primero no sea null
					
					if(puntero.getInfo()< info){				
						puntero.setNext(new Nodo(info));
					}else{
						this.addNodo(info);
					}
				}else{
					
					while(puntero.getNext()!=null && info > puntero.getNext().getInfo()){//busca donde va el nuevo nodo
						
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
					return true;//retorna esto si el valor esta en el primero
				}else{
					Nodo puntero = first;
					if(puntero.getNext() != null){
						 return compararNext(valor,puntero.getNext());
					}else{
						return false;//retorna esto xq llego al fin de la lista
					}
				}
			}
			return false;//retorna esto xq la lista esta vacia
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

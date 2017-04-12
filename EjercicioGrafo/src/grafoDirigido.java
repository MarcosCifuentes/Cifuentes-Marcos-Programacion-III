
public class grafoDirigido {

		Lista[] vertices;
		

		public grafoDirigido(int ver){
			vertices = new Lista[ver];
		}
		
		public int getCantVertices(){
			return vertices.length;
		}
		
		public int getCantAristasByVert(int i){
			return vertices[i].size();
		}
		
		public void addVertice(int indice){
			
			if(indice >= vertices.length){
				Lista[] aux = new Lista[indice * 2];
				
				for (int i = 0; i < aux.length; i++) {
					aux[i] = vertices[i];
					aux[i] = new Lista();
					vertices = aux;
				}
			}
			vertices[indice] = new Lista();
			
		}
		
		public void addArista(int i, int j){
			if(i < vertices.length && j < vertices.length){
				vertices[i].addNodo(j);;
			}
		}
		
		public int getValorArista(int v,int i){
			return vertices[v].at(i);
		}
		
		public boolean tieneCicloRecursivo(){
			Vertice[] aux = new Vertice [vertices.length];
			for (int i = 0; i < aux.length; i++) {
				aux[i] = new Vertice(i,Estado.NoVisitado);
			}
			//cargado
			int tiempo = 0;
			
			for (int j = 0; j < aux.length; j++) {
				if(aux[j].getEstado() == Estado.NoVisitado){
					return DFS_Visit(aux[j],tiempo,aux);
				}
			}
			return false;
		}
		
		private boolean DFS_Visit(Vertice v,int t, Vertice[] aux){
			
			v.setEstado(Estado.Visitandose);
			v.setInicio(t);
			t=t+1;
			
			for (int i = 0; i < vertices[v.getIndice()].size(); i++) {//recorro la lista de adyacentes
				int pos = vertices[v.getIndice()].at(i);//tomo la posicion para ir a buscar al arreglo aux
				if(aux[pos].getEstado() == Estado.NoVisitado){// si es blanco paso al vertice para que tmb recorra sus adyacentes
					return DFS_Visit(aux[pos], t, aux);
				}else if(aux[pos].getEstado() == Estado.Visitandose){
					return true;
				}
					
			}
			
			v.setEstado(Estado.Visitado);
			return false;
		}
		
		
		public boolean tieneCicloIterativo(){
			
			Pila pila = new Pila();
			
			Vertice[] aux = new Vertice [vertices.length];
			for (int i = 0; i < aux.length; i++) {
				aux[i] = new Vertice(i,Estado.NoVisitado);
			}
			//cargado
			
			pila.apilar(0);//cero es el primero vertice
			
			while (!pila.estaVacia()) {
				if(aux[pila.verTope()].getEstado() == Estado.NoVisitado){//blanco
					aux[pila.verTope()].setEstado(Estado.Visitandose);//amarillo
					
					//agregar adyacentes
					if(vertices[pila.verTope()].size()>0){//tiene adyacentes
						for (int i = 0; i < vertices[pila.verTope()].size(); i++) {
							if(aux[vertices[pila.verTope()].at(i)].getEstado() == Estado.NoVisitado){//si es blanco agrega
								pila.apilar(vertices[pila.verTope()].at(i));
							}else if(aux[vertices[pila.verTope()].at(i)].getEstado() == Estado.Visitandose){//es amarillo
								return true;
							}
							
						}
					}else{//no tiene adyacentes
						aux[pila.verTope()].setEstado(Estado.Visitado);//negro
						pila.desapilar();
					}
					
					
					
				}else if(aux[pila.verTope()].getEstado() == Estado.Visitado){//negro
					pila.desapilar();
				}else{
					aux[pila.verTope()].setEstado(Estado.Visitado);//amarillo
					pila.desapilar();
				}
				
			}
			
			return false;
		}
		
		public void addAristas(){
			int i = 0;
			while( i < vertices.length-1){
				this.addArista(i, i+1);
				this.addArista(i, i+2);
				i++;
			}
		}
	

}

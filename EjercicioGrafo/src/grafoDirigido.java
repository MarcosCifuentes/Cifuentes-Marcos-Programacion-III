
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

		for (int i = 0; i < vertices[v.getIndice()].size(); i++) {
			int pos = vertices[v.getIndice()].at(i);
			if(aux[pos].getEstado() == Estado.NoVisitado){
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


		pila.apilar(0);

		while (!pila.estaVacia()) {
			if(aux[pila.verTope()].getEstado() == Estado.NoVisitado){
				aux[pila.verTope()].setEstado(Estado.Visitandose);


				if(vertices[pila.verTope()].size()>0){
					for (int i = 0; i < vertices[pila.verTope()].size(); i++) {
						if(aux[vertices[pila.verTope()].at(i)].getEstado() == Estado.NoVisitado){
							pila.apilar(vertices[pila.verTope()].at(i));
						}else if(aux[vertices[pila.verTope()].at(i)].getEstado() == Estado.Visitandose){
							return true;
						}

					}
				}else{
					aux[pila.verTope()].setEstado(Estado.Visitado);
					pila.desapilar();
				}



			}else if(aux[pila.verTope()].getEstado() == Estado.Visitado){
				pila.desapilar();
			}else{
				aux[pila.verTope()].setEstado(Estado.Visitado);
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


public class grafoDirigido {

	public static Lista[] vertices;


	public grafoDirigido(int vertice){
		vertices = new Lista[vertice];
	}

	public int getCantVertices(){
		return vertices.length;
	}

	public int getCantAristasPorVertice(int i){
		return vertices[i].size();
	}

	public void addVertice(int indice){//agrega vertices

		if(indice >= vertices.length){
			Lista[] auxiliar = new Lista[indice * 2];

			for (int i = 0; i < auxiliar.length; i++) {
				auxiliar[i] = vertices[i];
				auxiliar[i] = new Lista();
				vertices = auxiliar;
			}
		}
		vertices[indice] = new Lista();
	}

	public void addArista(int i, int j){//agrega arista a un vertice definido
		if(i < vertices.length && j < vertices.length){
			vertices[i].addNodo(j);;
		}
	}

	public int getValorArista(int v,int i){
		return vertices[v].at(i);
	}

	public static boolean tieneCicloIterativo(){//funcion que recorre el grafo iterativamente y retorna si el grafo es ciclico

		Pila pila = new Pila();

		Vertice[] auxiliar = new Vertice [vertices.length];
		for (int i = 0; i < auxiliar.length; i++) {
			auxiliar[i] = new Vertice(i,Estado.NoVisitado);
		}

		pila.apilar(0);

		while (!pila.estaVacia()) {
			if(auxiliar[pila.verTope()].getEstado() == Estado.NoVisitado){
				auxiliar[pila.verTope()].setEstado(Estado.Visitandose);
				if(vertices[pila.verTope()].size()>0){
					for (int i = 0; i < vertices[pila.verTope()].size(); i++) {
						if(auxiliar[vertices[pila.verTope()].at(i)].getEstado() == Estado.NoVisitado){
							pila.apilar(vertices[pila.verTope()].at(i));
						}else if(auxiliar[vertices[pila.verTope()].at(i)].getEstado() == Estado.Visitandose){
							return true;
						}
					}
				}else{
					auxiliar[pila.verTope()].setEstado(Estado.Visitado);
					pila.desapilar();
				}
			}else if(auxiliar[pila.verTope()].getEstado() == Estado.Visitado){
				pila.desapilar();
			}else{
				auxiliar[pila.verTope()].setEstado(Estado.Visitado);
				pila.desapilar();
			}
		}
		return false;
	}

	public static boolean tieneCicloRecursivo(){//funcion que retorna si el grafo es ciclico, utilizando la funcion recursiva
		Vertice[] auxiliar = new Vertice [vertices.length];
		for (int i = 0; i < auxiliar.length; i++) {
			auxiliar[i] = new Vertice(i,Estado.NoVisitado);
		}

		int tiempo = 0;

		for (int j = 0; j < auxiliar.length; j++) {
			if(auxiliar[j].getEstado() == Estado.NoVisitado){
				return DFS_Visit(auxiliar[j],tiempo,auxiliar);
			}
		}
		return false;
	}

	private static boolean DFS_Visit(Vertice v,int t, Vertice[] auxiliar){//funcion recursiva que recorre el grafo
			
		v.setEstado(Estado.Visitandose);
		v.setInicio(t);
		t=t+1;

		for (int i = 0; i < vertices[v.getIndice()].size(); i++) {
			int pos = vertices[v.getIndice()].at(i);
			if(auxiliar[pos].getEstado() == Estado.NoVisitado){
				return DFS_Visit(auxiliar[pos], t, auxiliar);
			}else if(auxiliar[pos].getEstado() == Estado.Visitandose){
				return true;
			}
		}

		v.setEstado(Estado.Visitado);
		return false;
	}

	public void addAristas(){//agrega aristas a todo el grafo dinamicamente
		int i = 0;
		while( i < vertices.length-1){
			this.addArista(i, i+2);
			this.addArista(i, i+1);

			i++;
		}
	}
}

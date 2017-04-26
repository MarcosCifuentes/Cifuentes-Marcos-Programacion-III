
public class Vertice {

	int indice;
	Estado estado;
	int inicio;
	int fin;
	
	public int getInicio() {//funcion que da el tiempo en el que se inicio
		return inicio;		//la visita al vertice al recorrer el grafo recursivamente
	}

	public void setInicio(int inicio) {
		this.inicio = inicio;
	}

	public int getFin() {//funcion que de el tiempo en el que se finalizo
		return fin;		 //la visita al vertice al recorrer el grafo recursivamente
	}

	public void setFin(int fin) {
		this.fin = fin;
	}

	public Vertice(int i, Estado s) {
		indice = i;
		estado = s;
	}

	public int getIndice() {
		return indice;
	}

	public void setIndice(int indice) {
		this.indice = indice;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
}

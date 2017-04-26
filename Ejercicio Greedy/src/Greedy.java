
public class Greedy {

	public Elemento[] greedy(Elemento[] e,int pesoMaximo){

		this.burbujeo(e);

		Elemento[] mochila = new Elemento[e.length];
		//cargo la mochila con el arreglo de elementos recibido
		for (int i = 0; i < mochila.length; i++) {
			mochila[i] = new Elemento(e[i].getNombre(), e[i].getValor(),e[i].getPeso(), 0);
		}

		int peso = 0;
		int i = 0;

		while(peso < pesoMaximo && i < e.length){

			if(e[i].getPeso() <= pesoMaximo - peso && (e[i].getCant()>0)){
				mochila[i].setCant(mochila[i].getCant()+1);
				peso+= e[i].getPeso();
				e[i].setCant(e[i].getCant()-1);
			}else{
				i++;
			}
		}
		//devuelvo los elementos cargados a la mochila
		return mochila;
	}

	//funcion que ordena los elementos de acuerdo a su relacion valor/peso
	public void burbujeo(Elemento [] e){
		for (int i = 0; i < e.length; i++) {
			for (int j = i+1; j < e.length; j++) {
				if(e[i].getRelacion() <= e[j].getRelacion()){
					Elemento tmp = e[j];
					e[j]=e[i];
					e[i]=tmp;
				}
			}
		}
	}
}

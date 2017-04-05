
public class ListaConArreglo {

	private int [] Arreglo;

	private int [] auxiliar;

	public ListaConArreglo (int cant){

		this.Arreglo= new int [cant];

		this.auxiliar= new int [cant];

	}

	public void cargarArreglo (){

		for (int i = 0; i < Arreglo.length; i++) {

			Arreglo[i]=(int) Math.ceil(Math.random() * 100);
		}
	}

	public void ordenamientoMergesort(int low, int high) {

		if (low < high) {

			int middle = (low + high) / 2;

			ordenamientoMergesort(low, middle);

			ordenamientoMergesort(middle + 1, high);

			merge(low, middle, high);

		}
	}

	private void merge(int low, int middle, int high) {

		for (int i = low; i <= high; i++) {

			auxiliar[i] = Arreglo[i];

		}

		int i = low;

		int j = middle + 1;

		int k = low;

		while (i <= middle && j <= high) {

			if (auxiliar[i] <= auxiliar[j]) {

				Arreglo[k] = auxiliar[i];

				i++;

			} else {

				Arreglo[k] = auxiliar[j];

				j++;

			}

			k++;

		}

		while (i <= middle) {

			Arreglo[k] = auxiliar[i];

			k++;

			i++;

		}

	}

	public void ordanamientoBurbujeo(){

		int i, j, aux;

		for(i=0;i<Arreglo.length-1;i++)

			for(j=0;j<Arreglo.length-i-1;j++)

				if(Arreglo[j+1]<Arreglo[j]){

					aux=Arreglo[j+1];

					Arreglo[j+1]=Arreglo[j];

					Arreglo[j]=aux;

				}
	}

	public String toString(){

		String retornable = "" ;

		for (int i = 0; i < Arreglo.length; i++) {
			retornable += " |"+Arreglo[i]+" |";
		}


		return retornable;
	}
}

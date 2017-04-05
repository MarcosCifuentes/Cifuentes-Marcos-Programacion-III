
public class Simulador {

	public static void main(String[] args) {
		
		final int MAX = 5000;
		
		final int MIN = 0;
		
		ListaConArreglo Lista1 = new ListaConArreglo(MAX);
		
		ListaConArreglo Lista2 = new ListaConArreglo(MAX);
		
		Lista1.cargarArreglo();
		
		Lista2.cargarArreglo();
		
		System.out.println("Lista 1 desordenada");
		
		System.out.println(Lista1.toString());
		
		System.out.println("Lista 2 desordenada");

		System.out.println(Lista2.toString());
		
		long startTime1 = System.nanoTime();
		Lista1.ordenamientoMergesort(MIN, MAX-1);
		long endTime1 = System.nanoTime();

		long duration1 = (endTime1 - startTime1);
		
		System.out.println(duration1+" milisegundos");
		
		System.out.println("Lista 1 ordenada");
		
		System.out.println(Lista1.toString());
		
		long startTime2 = System.nanoTime();
		Lista2.ordanamientoBurbujeo();
		long endTime2 = System.nanoTime();

		long duration2 = (endTime2 - startTime2);
		Lista2.ordanamientoBurbujeo();
		
		System.out.println(duration2+" milisegundos");
		
		System.out.println("Lista 2 ordenada");
		
		System.out.println(Lista2.toString());
	}

}

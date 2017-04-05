import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Simulador {

	public static void main(String[] args) {

		//Constante que brinda el maximo del arreglo		
		final int MAX =100000;
		//Constante del minimo del arreglo
		final int MIN = 0;
		//Elementos tipo DateFormat usados para calcular el tiempo de ejecucion
		final DateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss:S");

		final DateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss:S");
		//Arreglos del ejercicio
		ListaConArreglo Lista1 = new ListaConArreglo(MAX);

		ListaConArreglo Lista2 = new ListaConArreglo(MAX);
		//Llamado a funcion para cargar los arreglos
		Lista1.cargarArreglo();

		Lista2.cargarArreglo();
		//Inicio de ordenamientos y calculos de tiempos de ejecucion
		Date v_start1 = new Date();

		System.out.println(sdf1.format(v_start1));
		//Funcion que ordena por Mergesort a un arreglo
		Lista1.ordenamientoMergesort(MIN, MAX-1);

		Date v_end1 = new Date();

		System.out.println(sdf1.format(v_end1));

		//Muestra del tiempo de ejecucuion
		System.out.println("Lista 1 ordenada en ");

		System.out.println((v_end1.getTime() - v_start1.getTime())+ " milisegundos");

		Date v_start2 = new Date();

		System.out.println(sdf2.format(v_start2));
		//Funcion que ordena por Burbujeo a un arreglo
		Lista2.ordanamientoBurbujeo();

		Date v_end2 = new Date();

		System.out.println(sdf2.format(v_end2));

		//Muestra del tiempo de ejecucuion
		System.out.println("Lista 2 ordenada en ");

		System.out.println((v_end2.getTime() - v_start2.getTime())+ " milisegundos");

		//Luego de hacer unas pruebas con distintas cantidades de valores, pude ver que cuando los arreglos poseen un tamaño 
		//de 100000 valores, el ordenamiento por Mergesort comienza a dar tiempos constantes de 16 milisegundos 
		//(desde los 10000 daba resultados de entre 0 hasta los 16 milisegundos, en el peor de los casos), con pruebas mayores,  
		//los tiempos aumentan pero a un ritmo reducido con una complejidad de O(n log n), en comparacion del ordenamento por 
		//burbujeo, que a los 100000 valores, le toma unos 30000 milisegundos en completarse, y con los distintos valores 
		//muestra una compejidad de O(nXn)

	}

}

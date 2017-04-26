
public class Elemento {

	double valor;
	double peso;
	double cantidad;
	String nombre;

	public Elemento(String s,double v, double p, double c){
		valor = v;
		peso = p;
		cantidad = c;
		nombre = s;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String n) {
		nombre = n;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double v) {
		valor = v;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double p) {
		peso = p;
	}

	public double getCant() {
		return cantidad;
	}

	public void setCant(double cant) {
		cantidad = cant;
	}

	public double getRelacion(){
		return valor/peso;
	}

	@Override
	public String toString() {
		return "---------------\n"+"Elemento: "+this.getNombre()+"\n"+"Valor: "+this.getValor()+"\n"+"Peso: "+this.getPeso()+"\n"+"Cantidad: "+this.getCant();
	}
}

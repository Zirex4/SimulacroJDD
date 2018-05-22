package GeneralidadesEstetica;

import java.util.ArrayList;

public class Articulo {
//Variables
	private String codigoArticulo;
	private int stock;
	//venta = [cantidad][precio]
	private float ultimoPrecioMedio;
	private ArrayList<float[]> ventas;

//Constructores
	public Articulo(String codigoArticulo, int stock) {
		this.codigoArticulo = codigoArticulo;
		this.stock = stock;
		this.ultimoPrecioMedio = 0;
		ventas = new ArrayList<float[]>();
}

//Metodos de Acceso
//Funcionalidades
	public float precioVentaMedio() {
		int numeroVentas = 0;
		float totalVentaAcumulativo = 0;
		//venta = [cantidad][precio]
		for (float[] venta : ventas) {
			numeroVentas += (int) venta[0];
			totalVentaAcumulativo += venta[0] * venta[1];
		}
		return totalVentaAcumulativo/numeroVentas;
	}

	public void vender(int cantidad, float precio) {
		float venta[] = {(int)cantidad, precio};
		stock -= cantidad;
		ventas.add(venta);
		ultimoPrecioMedio = this.precioVentaMedio();
	}

}

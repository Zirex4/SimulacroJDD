package GeneralidadesEstetica;

public class LineasAlbaran {
//Variables
		//Variables albaran
		private String serie;
		private int numero;
		private CabezaAlbaran cabeza;
		//Variables Articulo
		private Articulo articulo;
		private int cantidad;
		private float precio;
		private int descuentoAplicado;
		private EstadoLinea estado;
		
//Constructores
	public LineasAlbaran(CabezaAlbaran cabezaAlbaran) {
		serie = cabezaAlbaran.getSerie();
		numero = cabezaAlbaran.getNumero();
		cabeza = cabezaAlbaran;
		cabeza.addLinea(this);
	}

	
		
//Metodos de Acceso
	public String getSerie() {
		return serie;
	}

	public int getNumero() {
		return numero;
	}

	public Articulo getArticulo() {
		return articulo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public float getPrecio() {
		return precio;
	}

	public int getDescuentoAplicado() {
		return descuentoAplicado;
	}

	public EstadoLinea getEstado() {
		return estado;
	}
//Funcionalidades
	public void actualizarLinea(Articulo articulo, int cantidad, float precio) {
		articulo.vender(cantidad, precio);
	}
}

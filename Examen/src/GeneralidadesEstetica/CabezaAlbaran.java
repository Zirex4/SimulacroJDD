package GeneralidadesEstetica;

import java.util.ArrayList;
import java.util.Date;

public class CabezaAlbaran {
//Variables
	//Codigo Albaran
	private String serie;
	private int numero;
	//Cliente
	private int codigoCliente;
	//Parametros de estado albaran
	private Date fechaCreacion;
	private EstadoAlbaran estado;
	private ArrayList<LineasAlbaran> lineasAlbaran;
//Constructores
//Metodos de Acceso
	public String getSerie() {
		return serie;
	}

	public int getNumero() {
		return numero;
	}

	public int getCodigoCliente() {
		return codigoCliente;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public EstadoAlbaran getEstado() {
		return estado;
	}
	protected void addLinea(LineasAlbaran linea) {
		lineasAlbaran.add(linea);
	}
//Funcionalidades
	/**
	 * Funcion que suma linea a linea el valor total del alvaran
	 * @return cuantia total del albaran con descuentos incluidos
	 */
	public float valorar() {
		float totalAcumulativo = 0;
		for (LineasAlbaran linea : lineasAlbaran) {
			float total = linea.getCantidad() * linea.getPrecio();
			float descuento = total * (linea.getDescuentoAplicado()/(float) 100);
			total -= descuento;
			totalAcumulativo += total;
		}
		return totalAcumulativo;
	}
	

	/**
	 * Funcion que agrupa y prepara para la impresion la linea pedida
	 * dentro de un albaran
	 * @param numeroLinea
	 * @return LineaAlbaran como string
	 * @throws Exception 
	 */
	public String serializar(int numeroLinea) throws Exception {
		if(numeroLinea-1 < 0) throw new Exception("UnderflowException");
		if(numeroLinea-1 > lineasAlbaran.size()) throw new Exception("OverflowException");
		
		return lineasAlbaran.get(numeroLinea-1).toString();
	}
	
	/**
	 * Funcion que serializa todas las LineasAlbaran que se encuentran
	 * asociadas al albaran
	 * @return String con todas las lineas estructuradas en formato tabla
	 * @throws Exception 
	 */
	public String serializar() throws Exception {
		String salida = "1";
		for (int i = 0; i < lineasAlbaran.size(); i++) {
			salida.concat(this.serializar(i));
			salida.concat(System.getProperty("line.separator"));
		}
		return salida;
	}
	
	/**
	 * Funcion que devuelve la cabeza si al compararla con otra cabeza, son iguales
	 * @param _cabeza
	 * @return Cabeza en caso positivo / null
	 */
	public String soyYo(CabezaAlbaran _cabeza) {
		if ((this.serie.equals(_cabeza.serie) &&
				this.numero == _cabeza.numero)) 
			return getCabeza();
		else 
			return null;
	}
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(serie);
		builder.append(",");
		builder.append(numero);
		builder.append(",");
		builder.append(codigoCliente);
		builder.append(",");
		builder.append(fechaCreacion);
		builder.append(",");
		builder.append(estado);
		builder.append(System.getProperty("line.separator"));
		return builder.toString();
	}
	
	public String getCabeza() {
		return this.toString();
	}
	
	
}

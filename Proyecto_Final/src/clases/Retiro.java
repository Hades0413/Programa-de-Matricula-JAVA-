package clases;

public class Retiro {
	
	//Atributos
	private int numRetiro, numMatricula;
	private String fecha, hora;
	
	/*******************************************************************/
	
	//Constructor
	public Retiro(int numRetiro, int numMatricula, String fecha, String hora) {
		this.numRetiro = numRetiro;
		this.numMatricula = numMatricula;
		this.fecha = fecha;
		this.hora = hora;
	}
	
	/*******************************************************************/

	//M�todos de acceso p�blico: set / get
	//SET
	public void setNumRetiro(int numRetiro) {
		this.numRetiro = numRetiro;
	}

	public void setNumMatricula(int numMatricula) {
		this.numMatricula = numMatricula;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}
	
	//GET
	public int getNumRetiro() {
		return numRetiro;
	}

	public int getNumMatricula() {
		return numMatricula;
	}

	public String getFecha() {
		return fecha;
	}

	public String getHora() {
		return hora;
	}
}

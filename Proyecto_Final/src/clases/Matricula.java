package clases;

public class Matricula {

	//Atributos
	private int numMatricula, codAlumno, codCurso, estado;
	private String fecha, hora;
	
	/*******************************************************************/
	
	//Constructor
	public Matricula(int numMatricula, int codAlumno, int codCurso, String fecha, String hora, int estado) {
		this.numMatricula = numMatricula;
		this.codAlumno = codAlumno;
		this.codCurso = codCurso;
		this.fecha = fecha;
		this.hora = hora;
		this.estado = estado;
	}
	
	/*******************************************************************/

	//Métodos de acceso público: set / get
	//SET
	public void setNumMatricula(int numMatricula) {
		this.numMatricula = numMatricula;
	}

	public void setCodAlumno(int codAlumno) {
		this.codAlumno = codAlumno;
	}

	public void setCodCurso(int codCurso) {
		this.codCurso = codCurso;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}
	
	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	//GET
	public int getNumMatricula() {
		return numMatricula;
	}

	public int getCodAlumno() {
		return codAlumno;
	}

	public int getCodCurso() {
		return codCurso;
	}

	public String getFecha() {
		return fecha;
	}

	public String getHora() {
		return hora;
	}
	
	public int getEstado() {
		return estado;
	}
}

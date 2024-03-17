package clases;

public class Curso {

	//Atributos
	private int codCurso, ciclo, creditos, horas;
	private String asignatura;
	
	/*******************************************************************/
	
	//Constructor
	public Curso(int codCurso, String asignatura, int ciclo, int creditos, int horas) {
		this.codCurso = codCurso;
		this.asignatura = asignatura;
		this.ciclo = ciclo;
		this.creditos = creditos;
		this.horas = horas;
	}
	
	/*******************************************************************/

	//M�todos de acceso p�blico: set / get
	//SET
	public void setCodCurso(int codCurso) {
		this.codCurso = codCurso;
	}

	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}
	
	public void setCiclo(int ciclo) {
		this.ciclo = ciclo;
	}

	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}
	
	//GET
	public int getCodCurso() {
		return codCurso;
	}

	public String getAsignatura() {
		return asignatura;
	}

	public int getCiclo() {
		return ciclo;
	}

	public int getCreditos() {
		return creditos;
	}

	public int getHoras() {
		return horas;
	}
}

package arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import clases.Curso;

public class ArregloCursos {

	//Atributo
	private ArrayList <Curso> curso;
	
	//Constructor
    public ArregloCursos(){
    	curso = new ArrayList <Curso> ();
    	cargarCursos();
    }
    
    /*******************************************************************/
    
    //Operaciones públicas básicas
	public void adicionar(Curso x) {
		curso.add(x);
		grabarCursos();
	}
	
	public int tamaño() {
		return curso.size();
	}
	
	public Curso obtener(int i) {
		return curso.get(i);
	}
	
	public Curso buscar(int codigoCurso) {
		for (int i=0; i<tamaño(); i++)
			if (obtener(i).getCodCurso() == codigoCurso)
				return obtener(i);
		return null;
	}
	
	public void eliminar(Curso x) {
		curso.remove(x);
		grabarCursos();
	}
	
	public void actualizarArchivo() {
		grabarCursos();
	}
	
	//Metodo para guardar o escribir el txt
	private void grabarCursos() {
		try {
			PrintWriter pw;
			String linea;
			Curso x;
			pw = new PrintWriter(new FileWriter("cursos.txt"));
			for(int i=0; i<tamaño(); i++) {
				x = obtener(i);
				linea = x.getCodCurso() + ";" +
						x.getAsignatura() + ";" +
						x.getCiclo() + ";" +
						x.getCreditos() + ";" +
						x.getHoras();
				pw.println(linea);
			}
			pw.close();
		}
		catch (Exception e) {
		}
	}
	
	//Método para abrir o leer el txt
	private void cargarCursos() {
		try {
			BufferedReader br;
			String linea;
			String[] s;
			int codigoCurso, ciclo, creditos, horas;
			String asignatura;
			br = new BufferedReader(new FileReader("cursos.txt"));
			while ((linea=br.readLine()) != null) {
				s = linea.split(";");
				codigoCurso = Integer.parseInt(s[0].trim());
				asignatura = s[1].trim();
				ciclo = Integer.parseInt(s[2].trim());
				creditos = Integer.parseInt(s[3].trim());
				horas = Integer.parseInt(s[4].trim());
				adicionar(new Curso(codigoCurso, asignatura, ciclo, creditos, horas));
			}
			br.close();	
		}
		catch (Exception e) {
		}
	}
	
}

package arreglos;

import java.io.*;
import java.util.ArrayList;

import clases.Matricula;

public class ArregloMatriculas {
	
	//Atributo
	private ArrayList <Matricula> matricula;
	
	//Constructor
	public ArregloMatriculas() {
		matricula = new ArrayList <Matricula> ();
		cargarMatriculas();
	}
	
	/*******************************************************************/
	
	//Operaciones p�blicas b�sicas
	public void adicionar(Matricula x) {
		matricula.add(x);
		grabarMatriculas();
	}
	
	public int tama�o() {
		return matricula.size();
	}
	
	public Matricula obtener(int i) {
		return matricula.get(i);
	}
	
	public Matricula buscar(int numeroMatricula) {
		for (int i=0; i<tama�o(); i++)
			if (obtener(i).getNumMatricula() == numeroMatricula)
				return obtener(i);
		return null;
	}
	
	public Matricula buscarCurso(int codigoCurso){
		for(int i=0; i<tama�o(); i++)
			if(obtener(i).getCodCurso() == codigoCurso)
				return obtener(i);
		return null;
	}
	
	public Matricula buscarAlumno(int codigoAlumno){
		for(int i=0; i<tama�o(); i++)
			if(obtener(i).getCodAlumno() == codigoAlumno)
				return obtener(i);
		return null;
	}
	
	public void eliminar(Matricula x) {
		matricula.remove(x);
		grabarMatriculas();
	}
	
	public void actualizarArchivo() {
		grabarMatriculas();
	}
	
	//Metodo para guardar o escribir el txt
	private void grabarMatriculas() {
		try {
			PrintWriter pw;
			String linea;
			Matricula x;
			pw = new PrintWriter(new FileWriter("matriculas.txt"));
			for (int i=0; i<tama�o(); i++) {
				x = obtener(i);
				linea =	x.getNumMatricula() + ";" +
						x.getCodAlumno() + ";" +
						x.getCodCurso() + ";" +
						x.getFecha() + ";" +
						x.getHora() + ";" +
						x.getEstado();
				pw.println(linea);
			}
			pw.close();
		}
		catch (Exception e) {
		}
	}
	
	//M�todo para abrir o leer el txt
	public void cargarMatriculas() {
		try {
			BufferedReader br;
			String linea;
			String[] s;
			int numeroMatricula, codigoAlumno, codigoCurso, estado;
			String fecha, hora;
			br = new BufferedReader(new FileReader("matriculas.txt"));
			while ((linea=br.readLine()) != null) {
				s = linea.split(";");
				numeroMatricula = Integer.parseInt(s[0].trim());
				codigoAlumno = Integer.parseInt(s[1].trim());
				codigoCurso = Integer.parseInt(s[2].trim());
				fecha = s[3].trim();
				hora = s[4].trim();
				estado = Integer.parseInt(s[5].trim());
				adicionar(new Matricula(numeroMatricula, codigoAlumno, codigoCurso, fecha, hora, estado));
			}
			br.close();
		}
		catch (Exception e) {
		}
	}
	
	/*******************************************************************/
	
	//Operaciones p�blicas complementarias
	public int codigoCorrelativo() {
		if (tama�o() == 0)
			return 100001;
		else
			return obtener(tama�o()-1).getNumMatricula() + 1;
	}
	
}

package guis;

import clases.Alumno;
import arreglos.ArregloAlumnos;

import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Toolkit;

public class DlgAlumnosMatriculaVigente extends JDialog {


	private static final long serialVersionUID = 1L;
	
	private JScrollPane scrollPane;
	private JTextArea txtS;
	private JLabel lblAlumnosConMatricula;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgAlumnosMatriculaVigente dialog = new DlgAlumnosMatriculaVigente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgAlumnosMatriculaVigente() {
		getContentPane().setBackground(new Color(0, 51, 102));
		setModal(true);
		setResizable(false);
		setTitle("Reporte | Alumnos con matr\u00EDcula vigente");
		setIconImage(Toolkit.getDefaultToolkit().getImage(DlgAlumnosMatriculaVigente.class.getResource("/img/icono.png")));
		setBounds(100, 100, 755, 477);
		getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 47, 729, 385);
		getContentPane().add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setEditable(false);
		txtS.setFont(new Font("Monospaced", Font.PLAIN, 14));
		scrollPane.setViewportView(txtS);
		
		lblAlumnosConMatricula = new JLabel("ALUMNOS CON MATRICULA VIGENTE");
		lblAlumnosConMatricula.setForeground(Color.WHITE);
		lblAlumnosConMatricula.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAlumnosConMatricula.setBounds(10, 11, 384, 25);
		getContentPane().add(lblAlumnosConMatricula);
		
		listar();
	}

	/*******************************************************************/
	
	//M�todos tipo void (sin par�metros)
	void imprimir() {
		imprimir("");
	}
	void listar() {
		ArregloAlumnos aa = new ArregloAlumnos();
		Alumno a;
		txtS.setText("");
		for(int i=0; i<aa.tama�o(); i++){
			a = aa.obtener(i);
			if(a.getEstado()==1){
				imprimir("C�digo del alumno :  " + a.getCodAlumno());
				imprimir("Nombres           :  " + a.getNombres());
				imprimir("Apellidos         :  " + a.getApellidos());
				imprimir("DNI               :  " + a.getDni());
				imprimir("Edad              :  " + a.getEdad());
				imprimir("Celular           :  " + a.getCelular());
				imprimir();
			}
			else
				imprimir();
		}
	}
	
	/*******************************************************************/
		
	//M�todos tipo void (con par�metros)
	void imprimir(String s) {
		txtS.append(s + "\n");
	}
}

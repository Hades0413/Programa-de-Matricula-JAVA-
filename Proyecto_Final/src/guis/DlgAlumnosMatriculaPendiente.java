package guis;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JScrollPane;

import clases.Alumno;
import arreglos.ArregloAlumnos;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Toolkit;

public class DlgAlumnosMatriculaPendiente extends JDialog {
	
	
	private static final long serialVersionUID = 1L;
	
	private JTextArea txtS;
	private JScrollPane scrollPane;
	private JLabel lblAlumnosConMatricula;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgAlumnosMatriculaPendiente dialog = new DlgAlumnosMatriculaPendiente();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public DlgAlumnosMatriculaPendiente() {
		getContentPane().setBackground(new Color(0, 51, 102));
		setModal(true);
		setTitle("Reporte | Alumnos con matr\u00EDculas pendientes ");
		setIconImage(Toolkit.getDefaultToolkit().getImage(DlgAlumnosMatriculaPendiente.class.getResource("/img/icono.png")));
		setResizable(false);
		setBounds(100, 100, 755, 475);
		getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Tahoma", Font.PLAIN, 11));
		scrollPane.setBounds(10, 47, 729, 385);
		getContentPane().add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setEditable(false);
		scrollPane.setViewportView(txtS);
		txtS.setFont(new Font("Monospaced", Font.PLAIN, 14));
		
		lblAlumnosConMatricula = new JLabel("ALUMNOS CON MATRICULA PENDIENTE");
		lblAlumnosConMatricula.setForeground(Color.WHITE);
		lblAlumnosConMatricula.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAlumnosConMatricula.setBounds(10, 11, 413, 25);
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
			if(a.getEstado()==0){
				imprimir("C�digo del alumno :  " + a.getCodAlumno());
				imprimir("Nombres           :  " + a.getNombres());
				imprimir("Apellidos         :  " + a.getApellidos());
				imprimir("DNI               :  " + a.getDni());
				imprimir("Edad              :  " + a.getEdad());
				imprimir("Celular           :  " + a.getCelular());
				imprimir();
			}
		}
	}
	
	/*******************************************************************/
	
	//M�todos tipo void (con par�metros)
	void imprimir(String s) {
		txtS.append(s + "\n");
	}
}

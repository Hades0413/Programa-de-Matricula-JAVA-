package guis;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Font;
import clases.*;
import arreglos.*;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Toolkit;

public class DlgAlumnosMatriculadosCurso extends JDialog {


	private static final long serialVersionUID = 1L;
	
	private JScrollPane scrollPane;
	private JTextArea txtS;
	private JLabel lblAlumnosMatriculadosPor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgAlumnosMatriculadosCurso dialog = new DlgAlumnosMatriculadosCurso();
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
	public DlgAlumnosMatriculadosCurso() {
		getContentPane().setBackground(new Color(0, 51, 102));
		setModal(true);
		setResizable(false);
		setTitle("Reporte | Alumnos matriculados por curso");
		setIconImage(Toolkit.getDefaultToolkit().getImage(DlgAlumnosMatriculadosCurso.class.getResource("/img/icono.png")));
		setBounds(100, 100, 755, 476);
		getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 47, 729, 385);
		getContentPane().add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setFont(new Font("Monospaced", Font.PLAIN, 14));
		txtS.setEditable(false);
		scrollPane.setViewportView(txtS);
		
		lblAlumnosMatriculadosPor = new JLabel("ALUMNOS MATRICULADOS POR CURSO");
		lblAlumnosMatriculadosPor.setForeground(Color.WHITE);
		lblAlumnosMatriculadosPor.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAlumnosMatriculadosPor.setBounds(10, 11, 407, 25);
		getContentPane().add(lblAlumnosMatriculadosPor);
		
		listar();
	}
	
	/*******************************************************************/
	
	//M�todos tipo void (sin par�metros)
	void imprimir() {
		imprimir("");
	}
	
	void listar(){
		ArregloMatriculas am = new ArregloMatriculas();
		ArregloAlumnos aa = new ArregloAlumnos();
		ArregloCursos ac = new ArregloCursos();
		Matricula m;
		Alumno a;
		Curso c;
		txtS.setText("");
		for(int i=0; i<am.tama�o(); i++){
			if(am.tama�o()==0){
				imprimir();
			}
			else {
				m = am.obtener(i);
				a = aa.buscar(m.getCodAlumno());
				c = ac.buscar(m.getCodCurso());
				imprimir("N�mero de matr�cula : " + m.getNumMatricula());
				imprimir("Nombres             : " + a.getNombres());
				imprimir("Apellidos           : " + a.getApellidos());
				imprimir("Curso               : " + c.getAsignatura());
				imprimir();
			}
		}
			
	}
	
	/*******************************************************************/
	
	//M�todos tipo void (con par�metros)
	void imprimir(String s){
		txtS.append(s + "\n");
	}
}

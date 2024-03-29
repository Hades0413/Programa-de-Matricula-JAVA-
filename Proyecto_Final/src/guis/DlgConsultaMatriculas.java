package guis;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import clases.*;
import arreglos.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.ActionEvent;
import java.awt.Font;
import libreria.Lib;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import java.awt.Toolkit;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class DlgConsultaMatriculas extends JDialog implements ActionListener, KeyListener {

	
	private static final long serialVersionUID = 1L;
	
	private JLabel lblNmeroDeMatrcula;
	private JTextArea txtS;
	private JScrollPane scrollPane;
	private JTextField txtNumero;
	private JButton btnConsultar;
	private JPanel panel;
	private JLabel lblConsultaDeMatriculas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgConsultaMatriculas dialog = new DlgConsultaMatriculas();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgConsultaMatriculas() {
		getContentPane().setBackground(new Color(0, 51, 102));
		setModal(true);
		setResizable(false);
		setTitle("Consulta | Matr\u00EDculas");
		setIconImage(Toolkit.getDefaultToolkit().getImage(DlgConsultaMatriculas.class.getResource("/img/icono.png")));
		setBounds(100, 100, 755, 485);
		getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 103, 729, 338);
		getContentPane().add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setEditable(false);
		txtS.setFont(new Font("Monospaced", Font.PLAIN, 14));
		scrollPane.setViewportView(txtS);
		
		panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 47, 729, 45);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		txtNumero = new JTextField();
		txtNumero.addKeyListener(this);
		txtNumero.setBounds(146, 11, 116, 20);
		panel.add(txtNumero);
		txtNumero.setColumns(10);
		
		soloNumeros(txtNumero);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setForeground(new Color(0, 51, 102));
		btnConsultar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnConsultar.setBounds(615, 10, 104, 23);
		panel.add(btnConsultar);
		
		lblNmeroDeMatrcula = new JLabel("N\u00FAmero de Matr\u00EDcula:");
		lblNmeroDeMatrcula.setBounds(10, 14, 126, 14);
		panel.add(lblNmeroDeMatrcula);
		
		lblConsultaDeMatriculas = new JLabel("CONSULTA DE MATRICULAS");
		lblConsultaDeMatriculas.setForeground(Color.WHITE);
		lblConsultaDeMatriculas.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblConsultaDeMatriculas.setBounds(10, 11, 407, 25);
		getContentPane().add(lblConsultaDeMatriculas);
		btnConsultar.addActionListener(this);
	}
	
	//Declaraci�n global
	ArregloMatriculas am = new ArregloMatriculas();
	ArregloAlumnos aa = new ArregloAlumnos();
	ArregloCursos ac = new ArregloCursos();

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(arg0);
		}
	}
	
	/*******************************************************************/

	//Boton Consultar
	protected void actionPerformedBtnConsultar(ActionEvent arg0) {
		int numeroMatricula = leerNumeroMatricula();
		Matricula m = am.buscar(numeroMatricula);
		if(m != null){
			txtS.setText("");
			listar();
		}
		else
			error("Ingrese un c�digo v�lido", txtNumero);
	}
	
	/*******************************************************************/
	
	//M�todos tipo void (sin par�metros)
	void imprimir(){
		imprimir("");
	}
	
	void listar(){
		Matricula m = am.buscar(leerNumeroMatricula());
		Alumno a = aa.buscar(m.getCodAlumno());
		Curso c = ac.buscar(m.getCodCurso());
		imprimir("Matr�cula            : " + m.getNumMatricula());
		imprimir("Estado de matr�cula  : " + Lib.estadosmatricula[m.getEstado()]);
		imprimir();
		imprimir("Alumno               : " + a.getCodAlumno());
		imprimir("Nombres              : " + a.getNombres());
		imprimir("Apellidos            : " + a.getApellidos());
		imprimir("DNI                  : " + a.getDni());
		imprimir("Edad                 : " + a.getEdad());
		imprimir("Celular              : " + a.getCelular());
		imprimir();
		imprimir("Curso                : " + c.getCodCurso());
		imprimir("Asignatura           : " + c.getAsignatura());
		imprimir("Ciclo                : " + Lib.ciclocursos[c.getCiclo()]);
		imprimir("Cantidad de cr�ditos : " + c.getCreditos());
		imprimir("Cantidad de horas    : " + c.getHoras());
	}
	
	/*******************************************************************/
	
	//M�todos tipo void (con par�metros)
	void imprimir(String s) {
		txtS.append(s + "\n");
	}
	
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s, "Informaci�n", 0);
	}
	
	void error(String s, JTextField txt) {
		mensaje(s);
		txt.setText("");
		txt.requestFocus();
	}
	
	/*******************************************************************/
	
	//M�todos que retornan valor (sin par�metros)
	int leerNumeroMatricula(){
		return Integer.parseInt(txtNumero.getText().trim());
	}

	/*******************************************************************/
	
	//M�todos que validan los caracteres ingresados
	public void soloNumeros(JTextField a){
		a.addKeyListener(new KeyAdapter(){
			public void keyTyped(KeyEvent e){
				char c=e.getKeyChar();
				if(!Character.isDigit(c)){
					e.consume();
				}
			}
		});
	}
	
	public void keyPressed(KeyEvent e) {
	}
	
	public void keyReleased(KeyEvent e) {
	}
	
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtNumero) {
			keyTypedTxtNumero(e);
		}
	}
	protected void keyTypedTxtNumero(KeyEvent e) {
		if(txtNumero.getText().length() >= 6){
			e.consume();
		}
	}
}

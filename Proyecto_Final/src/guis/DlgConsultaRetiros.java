package guis;

import javax.swing.JDialog;
import clases.*;
import libreria.Lib;
import arreglos.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.ActionEvent;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import java.awt.Toolkit;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class DlgConsultaRetiros extends JDialog implements ActionListener, KeyListener {


	private static final long serialVersionUID = 1L;
	
	private JLabel lblNmeroDeRetiro;
	private JTextArea txtS;
	private JScrollPane scrollPane;
	private JButton btnConsultar;
	private JTextField txtNumero;
	private JPanel panel;
	private JLabel lblConsultaDeRetiros;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgConsultaRetiros dialog = new DlgConsultaRetiros();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgConsultaRetiros() {
		getContentPane().setBackground(new Color(0, 51, 102));
		setModal(true);
		setResizable(false);
		setTitle("Consulta | Retiros");
		setIconImage(Toolkit.getDefaultToolkit().getImage(DlgConsultaRetiros.class.getResource("/img/icono.png")));
		setBounds(100, 100, 755, 475);
		getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 102, 729, 330);
		getContentPane().add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setEditable(false);
		txtS.setFont(new Font("Monospaced", Font.PLAIN, 14));
		scrollPane.setViewportView(txtS);
		
		panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 47, 729, 44);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		txtNumero = new JTextField();
		txtNumero.addKeyListener(this);
		txtNumero.setBounds(122, 11, 117, 20);
		panel.add(txtNumero);
		txtNumero.setColumns(10);
		
		soloNumeros(txtNumero);
		
		lblNmeroDeRetiro = new JLabel("N\u00FAmero de Retiro:");
		lblNmeroDeRetiro.setBounds(10, 14, 117, 14);
		panel.add(lblNmeroDeRetiro);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setForeground(new Color(0, 51, 102));
		btnConsultar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnConsultar.setBounds(602, 10, 117, 23);
		panel.add(btnConsultar);
		
		lblConsultaDeRetiros = new JLabel("CONSULTA DE RETIROS");
		lblConsultaDeRetiros.setForeground(Color.WHITE);
		lblConsultaDeRetiros.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblConsultaDeRetiros.setBounds(10, 11, 407, 25);
		getContentPane().add(lblConsultaDeRetiros);
		btnConsultar.addActionListener(this);
		
	}
	
	//Declaración global
	ArregloRetiros ar = new ArregloRetiros();
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
		int numeroRetiro = leerNumeroRetiro();
		Retiro r = ar.buscar(numeroRetiro);
		if(r != null){
			txtS.setText("");
			listar();
		}
		else
			error("Ingrese un código válido", txtNumero);
	}
	
	/*******************************************************************/
	
	//Métodos tipo void (sin parámetros)
	void imprimir(){
		imprimir("");
	}
	
	void listar(){
		Retiro r = ar.buscar(leerNumeroRetiro());
		Matricula m = am.buscar(r.getNumMatricula());
		Alumno a = aa.buscar(m.getCodAlumno());
		Curso c = ac.buscar(m.getCodCurso());
		imprimir("Número de retiro     : " + r.getNumRetiro());
		imprimir("Número de matrícula  : " + r.getNumMatricula());
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
		imprimir("Cantidad de créditos : " + c.getCreditos());
		imprimir("Cantidad de horas    : " + c.getHoras());
	}
	
	/*******************************************************************/
	
	//Métodos tipo void (con parámetros)
	void imprimir(String s){
		txtS.append(s + "\n");
	}
	
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s, "Información", 0);
	}
	
	void error(String s, JTextField txt) {
		mensaje(s);
		txt.setText("");
		txt.requestFocus();
	}
	
	/*******************************************************************/
	
	//Métodos que retornan valor (sin parámetros)
	int leerNumeroRetiro(){
		return Integer.parseInt(txtNumero.getText().trim());
	}
	
	/*******************************************************************/
	
	//Métodos que validan los caracteres ingresados
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

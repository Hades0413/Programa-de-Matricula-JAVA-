package guis;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

import clases.Curso;
import libreria.Lib;
import arreglos.ArregloCursos;
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

public class DlgConsultaCursos extends JDialog implements ActionListener, KeyListener {

	
	private static final long serialVersionUID = 1L;
	
	private JLabel lblCdigoDelCurso;
	private JButton btnConsultar;
	private JTextField txtCodigo;
	private JPanel panel;
	private JLabel lblConsultaDeCursos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgConsultaCursos dialog = new DlgConsultaCursos();
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
	public DlgConsultaCursos() {
		getContentPane().setBackground(new Color(0, 51, 102));
		setModal(true);
		setResizable(false);
		setTitle("Consulta | Cursos");
		setIconImage(Toolkit.getDefaultToolkit().getImage(DlgConsultaCursos.class.getResource("/img/icono.png")));
		setBounds(100, 100, 755, 480);
		getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 47, 729, 44);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		txtCodigo = new JTextField();
		txtCodigo.addKeyListener(this);
		txtCodigo.setBounds(135, 11, 115, 20);
		panel.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		soloNumeros(txtCodigo);
		
		lblCdigoDelCurso = new JLabel("C\u00F3digo del Curso:");
		lblCdigoDelCurso.setBounds(10, 14, 115, 14);
		panel.add(lblCdigoDelCurso);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setForeground(new Color(0, 51, 102));
		btnConsultar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnConsultar.setBounds(604, 10, 115, 23);
		panel.add(btnConsultar);
		btnConsultar.addActionListener(this);
		
		lblConsultaDeCursos = new JLabel("CONSULTA DE CURSOS");
		lblConsultaDeCursos.setForeground(Color.WHITE);
		lblConsultaDeCursos.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblConsultaDeCursos.setBounds(10, 11, 407, 25);
		getContentPane().add(lblConsultaDeCursos);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 102, 729, 331);
		getContentPane().add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setFont(new Font("Monospaced", Font.PLAIN, 14));
		scrollPane.setViewportView(txtS);
	}
	
	//Declaración global
	ArregloCursos ac = new ArregloCursos();
	private JScrollPane scrollPane;
	private JTextArea txtS;
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(arg0);
		}
	}
	
	/*******************************************************************/

	//Boton Consultar
	protected void actionPerformedBtnConsultar(ActionEvent arg0) {
		int codigoCurso = leerCodigoCurso();
		Curso c = ac.buscar(codigoCurso);
		if(c != null){
			txtS.setText("");
			listar();
		}
		else
			error("Ingrese un código válido", txtCodigo);
	}
	
	/*******************************************************************/

	//Métodos tipo void (sin parámetros)
	void imprimir(){
		imprimir("");
	}
	
	void listar(){
		Curso c = ac.buscar(leerCodigoCurso());
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
	int leerCodigoCurso() {
		return Integer.parseInt(txtCodigo.getText().trim());
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
		if (e.getSource() == txtCodigo) {
			keyTypedTxtCodigo(e);
		}
	}
	
	protected void keyTypedTxtCodigo(KeyEvent e) {
		if(txtCodigo.getText().length() >= 4){
			e.consume();
		}
	}
}

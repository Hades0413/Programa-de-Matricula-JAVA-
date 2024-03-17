package guis;

import java.awt.Cursor;
import java.awt.EventQueue;

import clases.Alumno;
import arreglos.ArregloAlumnos;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;

import libreria.Lib;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

public class DlgAlumno extends JDialog implements ActionListener, KeyListener, MouseListener  {

	
	private static final long serialVersionUID = 1L;
	
	private JLabel lblCdigo;
	private JLabel lblNombres;
	private JLabel lblApellidos;
	private JLabel lblDni;
	private JLabel lblEdad;
	private JLabel lblCelular;
	private JLabel lblEstado;
	private JTextField txtCodigo;
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JTextField txtDNI;
	private JTextField txtEdad;
	private JTextField txtCelular;
	private JComboBox<String> cboEstado;
	private JButton btnAdicionar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnAceptar;
	private JButton btnConsultar;
	private JButton btnBuscar;
	private JScrollPane scrollPane;
	private JTable tblAlumno;
	private DefaultTableModel modelo;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblMantenimientoDeAlumnos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgAlumno dialog = new DlgAlumno();
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
	public DlgAlumno() {
		getContentPane().setBackground(new Color(0, 51, 102));
		setModal(true);
		setResizable(false);
		setTitle("Mantenimiento | Alumnos");
		setIconImage(Toolkit.getDefaultToolkit().getImage(DlgAlumno.class.getResource("/img/icono.png")));
		setBounds(100, 100, 684, 543);
		getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 292, 657, 207);
		getContentPane().add(scrollPane);
		
		tblAlumno = new JTable();
		tblAlumno.addKeyListener(this);
		tblAlumno.addMouseListener(this);
		tblAlumno.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblAlumno);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("CÓDIGO");
		modelo.addColumn("NOMBRES");
		modelo.addColumn("APELLIDOS");
		modelo.addColumn("DNI");
		modelo.addColumn("EDAD");
		modelo.addColumn("CELULAR");
		modelo.addColumn("ESTADO");
		tblAlumno.setModel(modelo);
		
		panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(361, 47, 164, 149);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setForeground(new Color(0, 51, 102));
		btnConsultar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnConsultar.setBounds(10, 11, 143, 23);
		panel.add(btnConsultar);
		btnConsultar.addMouseListener(this);
		btnConsultar.addActionListener(this);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setForeground(new Color(0, 51, 102));
		btnAdicionar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAdicionar.setBounds(10, 45, 143, 23);
		panel.add(btnAdicionar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setForeground(new Color(0, 51, 102));
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnModificar.setBounds(10, 79, 143, 23);
		panel.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setForeground(new Color(0, 51, 102));
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEliminar.setBounds(10, 113, 143, 23);
		panel.add(btnEliminar);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(10, 47, 341, 234);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(77, 11, 113, 20);
		panel_1.add(txtCodigo);
		txtCodigo.addKeyListener(this);
		txtCodigo.setColumns(10);
		
		txtCodigo.setEditable(false);
		
		txtNombres = new JTextField();
		txtNombres.setBounds(77, 44, 250, 20);
		panel_1.add(txtNombres);
		txtNombres.addKeyListener(this);
		txtNombres.setColumns(10);
		
		txtApellidos = new JTextField();
		txtApellidos.setBounds(77, 75, 250, 20);
		panel_1.add(txtApellidos);
		txtApellidos.addKeyListener(this);
		txtApellidos.setColumns(10);
		
		txtDNI = new JTextField();
		txtDNI.setBounds(77, 106, 113, 20);
		panel_1.add(txtDNI);
		txtDNI.addKeyListener(this);
		txtDNI.setColumns(10);
		
		txtEdad = new JTextField();
		txtEdad.setBounds(77, 137, 113, 20);
		panel_1.add(txtEdad);
		txtEdad.addKeyListener(this);
		txtEdad.setColumns(10);
		
		txtCelular = new JTextField();
		txtCelular.setBounds(77, 168, 113, 20);
		panel_1.add(txtCelular);
		txtCelular.addKeyListener(this);
		txtCelular.setColumns(10);
		
		cboEstado = new JComboBox<String>();
		cboEstado.setBounds(77, 197, 113, 20);
		panel_1.add(cboEstado);
		cboEstado.setModel(new DefaultComboBoxModel<String>(Lib.estadosalumnos));
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setForeground(new Color(0, 51, 102));
		btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAceptar.setBounds(200, 196, 127, 23);
		panel_1.add(btnAceptar);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setForeground(new Color(0, 51, 102));
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBuscar.setBounds(200, 10, 89, 23);
		panel_1.add(btnBuscar);
		btnBuscar.addMouseListener(this);
		btnBuscar.addActionListener(this);
		btnBuscar.setEnabled(false);
		
		lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setBounds(10, 13, 70, 14);
		panel_1.add(lblCdigo);
		
		lblNombres = new JLabel("Nombres:");
		lblNombres.setBounds(10, 47, 70, 14);
		panel_1.add(lblNombres);
		
		lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(10, 78, 70, 14);
		panel_1.add(lblApellidos);
		
		lblDni = new JLabel("DNI:");
		lblDni.setBounds(10, 109, 46, 14);
		panel_1.add(lblDni);
		
		lblEdad = new JLabel("Edad:");
		lblEdad.setBounds(10, 140, 46, 14);
		panel_1.add(lblEdad);
		
		lblCelular = new JLabel("Celular:");
		lblCelular.setBounds(10, 171, 46, 14);
		panel_1.add(lblCelular);
		
		lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(10, 200, 46, 14);
		panel_1.add(lblEstado);
		
		lblMantenimientoDeAlumnos = new JLabel("MANTENIMIENTO DE ALUMNOS");
		lblMantenimientoDeAlumnos.setForeground(Color.WHITE);
		lblMantenimientoDeAlumnos.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMantenimientoDeAlumnos.setBounds(10, 11, 330, 25);
		getContentPane().add(lblMantenimientoDeAlumnos);
		
		lblNewLabel = new JLabel("\r\n");
		lblNewLabel.setIcon(new ImageIcon(DlgAlumno.class.getResource("/img/itachi.jpg")));
		lblNewLabel.setBounds(-566, 0, 1250, 827);
		getContentPane().add(lblNewLabel);
		btnAceptar.addActionListener(this);
		btnAceptar.addMouseListener(this);
		btnEliminar.addActionListener(this);
		btnEliminar.addMouseListener(this);
		btnModificar.addActionListener(this);
		btnModificar.addMouseListener(this);
		btnAdicionar.addActionListener(this);
		btnAdicionar.addMouseListener(this);
				
		habilitarEntradas(false);
		ajustarAnchoColumnas();
		listar();
		editarFila();
	}
	
	//Declaración global
	ArregloAlumnos aa = new ArregloAlumnos();
	private JLabel lblNewLabel;
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(arg0);
		}
		if (arg0.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(arg0);
		}
		if (arg0.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(arg0);
		}
		if (arg0.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(arg0);
		}
		if (arg0.getSource() == btnModificar) {
			actionPerformedBtnModificar(arg0);
		}
		if (arg0.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(arg0);
		}
	}
	
	/*******************************************************************/
		//BOTONES
	/*******************************************************************/
	
	//Boton Adicionar
	protected void actionPerformedBtnAdicionar(ActionEvent arg0) {
		habilitarBotones(true);
		habilitarEntradas(true);
		habilitarBusqueda(false);
		btnAdicionar.setEnabled(false);
		cboEstado.setEnabled(false);
		txtCodigo.setText("" + aa.numeroCorrelativo());
		limpiar();
		txtNombres.requestFocus();
	}
	
	//Boton Modificar
	protected void actionPerformedBtnModificar(ActionEvent arg0) {
		habilitarBotones(true);
		btnModificar.setEnabled(false);
		try{
			if (aa.tamaño() == 0) {
				btnAceptar.setEnabled(false);
				habilitarEntradas(false);
				mensaje("No existen alumnos");	
			}
			else{
				habilitarBotones(true);
				habilitarEntradas(false);
				habilitarBusqueda(true);
				btnModificar.setEnabled(false);
				limpiar();
				txtCodigo.setText("");
				txtCodigo.requestFocus();
			}
		}
		catch(Exception e){
			txtCodigo.requestFocus();
		}
	}
	
	//Boton Eliminar
	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		habilitarBotones(true);
		if (aa.tamaño() == 0)
			mensaje("No existen alumnos");
		else {
			habilitarEntradas(false);
			try{
				int codAlumno = leerCodigoAlumno();
				Alumno x = aa.buscar(codAlumno);
				if (x.getEstado() == 0){
				int ok = confirmar("¿ Desea eliminar el registro ?");
				if (ok == 0) {
					aa.eliminar(aa.buscar(leerCodigoAlumno()));
					listar();
					editarFila();
					}
				}
				else
					mensaje("Solo se puede eliminar alumnos registrados");
			}
			catch(Exception e){
				txtCodigo.requestFocus();
			}
		}
	}
	
	//Boton Aceptar
	protected void actionPerformedBtnAceptar(ActionEvent arg0) {
		int codAlumno = leerCodigoAlumno();
		String nombres = leerNombresAlumno();
		if(nombres.length() > 0){
			String apellidos = leerApellidosAlumno();
			if(apellidos.length() > 0){
				try{
				String dni = leerDNIAlumno();
					try{
						int edad = leerEdadAlumno();
						try{
							int celular = leerCelularAlumno();
							int estado = leerEstadoAlumno();
							if (btnAdicionar.isEnabled() == false) {
								Alumno a = aa.buscarDNI(dni);
								if(a == null){
									Alumno nuevo = new Alumno(codAlumno, nombres, apellidos, dni, edad, celular, estado);
									aa.adicionar(nuevo);
									btnAdicionar.setEnabled(true);
								}
								else
									error("El DNI " + dni + " ya existe", txtDNI);
							}
							if (btnModificar.isEnabled() == false) {
								Alumno a = aa.buscar(codAlumno);
								a.setNombres(nombres);
								a.setApellidos(apellidos);
								a.setDni(dni);
								a.setEdad(edad);
								a.setCelular(celular);
								a.setEstado(estado);
								aa.actualizarArchivo();
								btnModificar.setEnabled(true);
							}
							listar();
							habilitarEntradas(false);
						}
						catch(Exception e){
							error("Ingrese CELULAR del Alumno", txtCelular);
						}
					}
					catch(Exception e){
						error("Ingrese EDAD del Alumno", txtEdad);
					}
				}
				catch(Exception e){
					error("Ingrese DNI del Alumno", txtDNI);
				}
			}
			else
				error("Ingrese APELLIDOS del Alumno", txtApellidos);
		}
		else
			error("Ingrese NOMBRES del Alumno", txtNombres);
	}
	
	//Boton Consultar
	protected void actionPerformedBtnConsultar(ActionEvent arg0) {
		habilitarBotones(true);
		habilitarEntradas(false);
		habilitarBusqueda(true);
		btnConsultar.setEnabled(false);
		limpiar();
		txtCodigo.setText("");
		txtCodigo.requestFocus();
	}
	
	//Boton Buscar
	protected void actionPerformedBtnBuscar(ActionEvent arg0) {
		try {
			int codigo = leerCodigoAlumno();
			Alumno a = aa.buscar(codigo);

			if(btnModificar.isEnabled() == false){
				if (a != null) {
					txtNombres.setText(a.getNombres());
					txtApellidos.setText(a.getApellidos());
					txtDNI.setText(""+a.getDni());
					txtEdad.setText(String.valueOf(a.getEdad()));
					txtCelular.setText(String.valueOf(a.getCelular()));
					cboEstado.setSelectedIndex(a.getEstado());
					habilitarEntradas(true);
					txtDNI.setEditable(false);
					habilitarBotones(true);
					btnModificar.setEnabled(false);
					habilitarBusqueda(false);
				}
				else
					error("El código " + codigo + " no existe", txtCodigo);
			}
			else{
				if (a != null) {
					txtNombres.setText(a.getNombres());
					txtApellidos.setText(a.getApellidos());
					txtDNI.setText(""+a.getDni());
					txtEdad.setText(String.valueOf(a.getEdad()));
					txtCelular.setText(String.valueOf(a.getCelular()));
					cboEstado.setSelectedIndex(a.getEstado());
					habilitarEntradas(false);
					habilitarBotones(true);
					habilitarBusqueda(false);
				}
				else
					error("El código " + codigo + " no existe", txtCodigo);
				
			}
		}
		catch (Exception e) {
			error("Ingrese un CÓDIGO", txtCodigo);
		}
	}
	
	/***********************************************************************************/
	
	public void keyPressed(KeyEvent arg0) {
	}
	
	public void keyReleased(KeyEvent arg0) {	
	}
	
	public void keyTyped(KeyEvent arg0) {
		if (arg0.getSource() == txtApellidos) {
			keyTypedTxtApellidos(arg0);
		}
		if (arg0.getSource() == txtNombres) {
			keyTypedTxtNombres(arg0);
		}
		if (arg0.getSource() == txtCelular) {
			keyTypedTxtCelular(arg0);
		}
		if (arg0.getSource() == txtEdad) {
			keyTypedTxtEdad(arg0);
		}
		if (arg0.getSource() == txtDNI) {
			keyTypedTxtDNI(arg0);
		}
		if (arg0.getSource() == txtCodigo) {
			keyTypedTxtCodigoAlumno(arg0);
		}
	}
	
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == tblAlumno) {
			mouseClickedTabAlumno(arg0);
		}
	}
	
	public void mouseEntered(MouseEvent arg0) {
		if (arg0.getSource() == btnBuscar) {
			mouseEnteredBtnBuscar(arg0);
		}
		if (arg0.getSource() == btnAceptar) {
			mouseEnteredBtnAceptar(arg0);
		}
		if (arg0.getSource() == btnEliminar) {
			mouseEnteredBtnEliminar(arg0);
		}
		if (arg0.getSource() == btnModificar) {
			mouseEnteredBtnModificar(arg0);
		}
		if (arg0.getSource() == btnConsultar) {
			mouseEnteredBtnConsultar(arg0);
		}
		if (arg0.getSource() == btnAdicionar) {
			mouseEnteredBtnAdicionar(arg0);
		}
		if (arg0.getSource() == tblAlumno) {
			mouseEnteredTblAlumno(arg0);
		}
	}
	
	public void mouseExited(MouseEvent arg0) {
	}
	
	public void mousePressed(MouseEvent arg0) {
	}
	
	public void mouseReleased(MouseEvent arg0) {
	}
	
	protected void mouseClickedTabAlumno(MouseEvent arg0) {
		habilitarEntradas(false);
		habilitarBotones(true);
		btnConsultar.setEnabled(true);
		btnBuscar.setEnabled(false);
		txtCodigo.setEditable(false);
		editarFila();
	}
	
	protected void mouseEnteredTblAlumno(MouseEvent arg0) {
		tblAlumno.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	
	protected void mouseEnteredBtnAdicionar(MouseEvent arg0) {
		btnAdicionar.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	
	protected void mouseEnteredBtnConsultar(MouseEvent arg0) {
		btnConsultar.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	
	protected void mouseEnteredBtnModificar(MouseEvent arg0) {
		btnModificar.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	
	protected void mouseEnteredBtnEliminar(MouseEvent arg0) {
		btnEliminar.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	
	protected void mouseEnteredBtnAceptar(MouseEvent arg0) {
		btnAceptar.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	
	protected void mouseEnteredBtnBuscar(MouseEvent arg0) {
		btnBuscar.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	
	/***********************************************************************************/
	
	//Métodos tipo void (sin parámetros)
	void ajustarAnchoColumnas() {
		TableColumnModel tcm = tblAlumno.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna(20));  //codigo
		tcm.getColumn(1).setPreferredWidth(anchoColumna(30));  //nombres
		tcm.getColumn(2).setPreferredWidth(anchoColumna(40));  //apellidos
		tcm.getColumn(3).setPreferredWidth(anchoColumna(20));  //dni
		tcm.getColumn(4).setPreferredWidth(anchoColumna(10));  //edad
		tcm.getColumn(5).setPreferredWidth(anchoColumna(20));  //celular
		tcm.getColumn(6).setPreferredWidth(anchoColumna(20));  //estado
	}
	
	void listar(){
		int posFila = 0;
		if (modelo.getRowCount() > 0)
			posFila = tblAlumno.getSelectedRow();
		if (modelo.getRowCount() == aa.tamaño() - 1)
			posFila = aa.tamaño() - 1;
		if (posFila == aa.tamaño())
			posFila --;
		modelo.setRowCount(0);
		Alumno a;
		for (int i=0; i<aa.tamaño(); i++) {
			a = aa.obtener(i);
			Object[] fila = { a.getCodAlumno(),
					          a.getNombres(),
					          a.getApellidos(),
					          a.getDni(),
					          a.getEdad(),
					          a.getCelular(),
					          enTextoEstado(a.getEstado())};
			modelo.addRow(fila);
		}
		if (aa.tamaño() > 0)
			tblAlumno.getSelectionModel().setSelectionInterval(posFila, posFila);
	}
	
	void editarFila(){
		if (aa.tamaño() == 0)
			limpiar();
		else {
			Alumno a = aa.obtener(tblAlumno.getSelectedRow());
			txtCodigo.setText("" + a.getCodAlumno());
			txtNombres.setText(a.getNombres());
			txtApellidos.setText(a.getApellidos());
			txtDNI.setText(""+a.getDni());
			txtEdad.setText(String.valueOf(a.getEdad()));
			txtCelular.setText(String.valueOf(a.getCelular()));
			cboEstado.setSelectedIndex(a.getEstado());
		}
	}
	
	void limpiar(){
		txtNombres.setText("");
		txtApellidos.setText("");
		txtDNI.setText("");
		txtEdad.setText("");
		txtCelular.setText("");
		cboEstado.setSelectedIndex(0);
	}
	
	/***********************************************************************************/
	
	//Métodos tipo void (con parámetros)
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s, "Información", 0);
	}
	
	void error(String s, JTextField txt) {
		mensaje(s);
		txt.setText("");
		txt.requestFocus();
	}
	
	void habilitarEntradas(boolean sino) {
		btnAceptar.setEnabled(sino);
		txtNombres.setEditable(sino);
		txtApellidos.setEditable(sino);
		txtDNI.setEditable(sino);
		txtEdad.setEditable(sino);
		txtCelular.setEditable(sino);
		cboEstado.setEnabled(sino);
	}
	
	void habilitarBotones(boolean sino) {
		btnAdicionar.setEnabled(sino);
		btnModificar.setEnabled(sino);
		btnConsultar.setEnabled(sino);
	}
	
	void habilitarBusqueda(boolean sino){
		btnBuscar.setEnabled(sino);
		txtCodigo.setEditable(sino);
	}
	
	/***********************************************************************************/
	
	//Métodos que retornan valor (sin parámetros)
	int leerCodigoAlumno() {
		return Integer.parseInt(txtCodigo.getText().trim());
	}
	
	String leerNombresAlumno() {
		return txtNombres.getText().trim();
	}
	
	String leerApellidosAlumno() {
		return txtApellidos.getText().trim();
	}
	
	String leerDNIAlumno() {
		return txtDNI.getText().trim();
	}
	
	int leerEdadAlumno() {
		return Integer.parseInt(txtEdad.getText().trim());
	}
	
	int leerCelularAlumno() {
		return Integer.parseInt(txtCelular.getText().trim());
	}
	
	int leerEstadoAlumno() {
		return cboEstado.getSelectedIndex();
	}
	
	/***********************************************************************************/
	
	//Métodos que retornan valor (con parámetros)
	String enTextoEstado(int i){
		return cboEstado.getItemAt(i);
	}
	
	int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}
	
	int confirmar(String s) {
		return JOptionPane.showConfirmDialog(this, s, "Alerta", 0, 1, null);
	}
	
	/***********************************************************************************/
	
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
	
	protected void keyTypedTxtCodigoAlumno(KeyEvent arg0) {
		if(txtCodigo.getText().length() >= 9){
			arg0.consume();
		}
	}
	
	protected void keyTypedTxtNombres(KeyEvent arg0) {
		if(txtNombres.getText().length() >= 50){
			arg0.consume();
		}
		if(arg0.getKeyChar()>=33 && arg0.getKeyChar()<=64 
			|| arg0.getKeyChar()>=91 && arg0.getKeyChar()<=96
			|| arg0.getKeyChar()>=123 && arg0.getKeyChar()<=179
			|| arg0.getKeyChar()>=181 && arg0.getKeyChar()<=192
			|| arg0.getKeyChar()>=194 && arg0.getKeyChar()<=200
			|| arg0.getKeyChar()>=202 && arg0.getKeyChar()<=204
			|| arg0.getKeyChar()>=206 && arg0.getKeyChar()<=208
			|| arg0.getKeyChar()==210 
			|| arg0.getKeyChar()>=212 && arg0.getKeyChar()<=217
			|| arg0.getKeyChar()>=219 && arg0.getKeyChar()<=224
			|| arg0.getKeyChar()>=226 && arg0.getKeyChar()<=232
			|| arg0.getKeyChar()>=234 && arg0.getKeyChar()<=236
			|| arg0.getKeyChar()>=238 && arg0.getKeyChar()<=240
			|| arg0.getKeyChar()==242
			|| arg0.getKeyChar()>=244 && arg0.getKeyChar()<=249
			|| arg0.getKeyChar()>=251 && arg0.getKeyChar()<=255){
			arg0.consume();
		}
	}
	
	protected void keyTypedTxtApellidos(KeyEvent arg0) {
		if(txtApellidos.getText().length() >= 50){
			arg0.consume();
		}
		if(arg0.getKeyChar()>=33 && arg0.getKeyChar()<=64 
			|| arg0.getKeyChar()>=91 && arg0.getKeyChar()<=96
			|| arg0.getKeyChar()>=123 && arg0.getKeyChar()<=179
			|| arg0.getKeyChar()>=181 && arg0.getKeyChar()<=192
			|| arg0.getKeyChar()>=194 && arg0.getKeyChar()<=200
			|| arg0.getKeyChar()>=202 && arg0.getKeyChar()<=204
			|| arg0.getKeyChar()>=206 && arg0.getKeyChar()<=208
			|| arg0.getKeyChar()==210 
			|| arg0.getKeyChar()>=212 && arg0.getKeyChar()<=217
			|| arg0.getKeyChar()>=219 && arg0.getKeyChar()<=224
			|| arg0.getKeyChar()>=226 && arg0.getKeyChar()<=232
			|| arg0.getKeyChar()>=234 && arg0.getKeyChar()<=236
			|| arg0.getKeyChar()>=238 && arg0.getKeyChar()<=240
			|| arg0.getKeyChar()==242
			|| arg0.getKeyChar()>=244 && arg0.getKeyChar()<=249
			|| arg0.getKeyChar()>=251 && arg0.getKeyChar()<=255){
			arg0.consume();
		}
	}
	
	protected void keyTypedTxtDNI(KeyEvent arg0) {
		if(txtDNI.getText().length() >= 8){
			arg0.consume();
		}
	}
	
	protected void keyTypedTxtEdad(KeyEvent arg0) {
		if(txtEdad.getText().length() >= 2){
			arg0.consume();
		}
	}
	
	protected void keyTypedTxtCelular(KeyEvent arg0) {
		if(txtCelular.getText().length() >= 9){
			arg0.consume();
		}
	}
}

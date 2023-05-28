package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import arreglos.Socio;

import clases.ClaseSocio;


//import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
//importamos clase DefaultTableModel
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
//import java.awt.event.MouseAdapter;



public class Dsocios extends JDialog implements ActionListener, MouseListener, KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblDni;
	private JLabel lblTelefono;
	private JButton btnAdicionar;
	private JButton btnConsutar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnListar;
	private JLabel lblCodigo;
	private JTextField txtCodigo;
	private JScrollPane scrollPane;
	public JTable table;
	public DefaultTableModel modelo;
   
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Dsocios dialog = new Dsocios();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	
	public Dsocios() {
		setModal(true);
		setTitle("USUARIO");
		setBounds(100, 100, 450, 411);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(36, 97, 46, 14);
		contentPanel.add(lblNombre);
		
		lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(36, 122, 46, 14);
		contentPanel.add(lblApellido);
		
		lblDni = new JLabel("Dni");
		lblDni.setBounds(36, 63, 46, 14);
		contentPanel.add(lblDni);
		
		lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(36, 147, 63, 14);
		contentPanel.add(lblTelefono);
		
		lblCodigo = new JLabel("C\u00F3digo");
		lblCodigo.setBounds(36, 38, 46, 14);
		contentPanel.add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(130, 29, 86, 20);
		contentPanel.add(txtCodigo);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 188, 404, 163);
		contentPanel.add(scrollPane);
		
		modelo = new DefaultTableModel();
		
		modelo.addColumn("C�DIGO");
	     modelo.addColumn("DNI");
		modelo.addColumn("NOMBRE");
		modelo.addColumn("APELLIDO");
	//	modelo.addColumn("DNI");
		modelo.addColumn("TELEFONO");
		
		table = new JTable();
		table.addMouseListener(this);
		table.setModel(modelo);
		scrollPane.setViewportView(table);
		
		btnAdicionar = new JButton("ADICIONAR");
		btnAdicionar.setBounds(299, 34, 114, 23);
		contentPanel.add(btnAdicionar);
		
		btnConsutar = new JButton("CONSULTAR");
		btnConsutar.setBounds(299, 63, 114, 23);
		contentPanel.add(btnConsutar);
		
		btnModificar = new JButton("MODIFICAR");
		btnModificar.setBounds(299, 93, 114, 23);
		contentPanel.add(btnModificar);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setBounds(298, 122, 114, 23);
		contentPanel.add(btnEliminar);
		
		btnListar = new JButton("LISTAR");
		btnListar.setBounds(299, 154, 114, 23);
		contentPanel.add(btnListar);
		
		txtDni = new JTextField();
		txtDni.addKeyListener(this);
		txtDni.setBounds(130, 60, 86, 20);
		contentPanel.add(txtDni);
		txtDni.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(130, 94, 86, 20);
		contentPanel.add(txtNombre);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(130, 119, 86, 20);
		contentPanel.add(txtApellido);
		
		txtFono = new JTextField();
		txtFono.setColumns(10);
		txtFono.setBounds(130, 144, 86, 20);
		contentPanel.add(txtFono);
		
		lblGuardar = new JLabel("Guardar");
		lblGuardar.addMouseListener(this);
		lblGuardar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblGuardar.setBackground(Color.BLACK);
		lblGuardar.setOpaque(true);
		
		lblGuardar.setForeground(Color.WHITE);
		//lblGuardar.setIcon(new ImageIcon(Dsocios.class.getResource("/javax/swing/plaf/metal/icons/ocean/floppy.gif")));
		lblGuardar.setBounds(20, 11, 79, 20);
		contentPanel.add(lblGuardar);
		btnListar.addActionListener(this);
		btnEliminar.addActionListener(this);
		btnModificar.addActionListener(this);
		btnConsutar.addActionListener(this);
		btnAdicionar.addMouseListener(this);
		btnAdicionar.addActionListener(this);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
		listar();
		
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnListar) {
			actionPerformedBtnListar(e);
		}
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificar(e);
		}
		if (e.getSource() == btnConsutar) {
			actionPerformedBtnConsutar(e);
		}
		if (e.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(e);
		}
	}
	
	//*****************************Variable Global****************
	                          Socio as =new Socio("Socio.txt");
	
	//**********************************************************
	private JTextField txtDni;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtFono;
	private JLabel lblGuardar;
	
	
	protected void actionPerformedBtnAdicionar(ActionEvent e) {
	
		txtCodigo.setText("" + as.codigoCorrelativo());
		adicionar();
		
	}
	protected void actionPerformedBtnConsutar(ActionEvent e) {
	consultar();
	}
	protected void actionPerformedBtnModificar(ActionEvent e) {
		modificar();
		
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		
		eliminar();
		}
	protected void actionPerformedBtnListar(ActionEvent e) {
		
		listar();
		
	}
	
	void eliminar() {
		
		
		ClaseSocio j = as.buscar(leerCodigo());
		
		try {
			
				if (leerCodigo() == -1 &&  j !=null  ) {  //Se usara la indiferencia de resultado
					JOptionPane.showMessageDialog(null,"el C�DIGO no existe");
				}else {
				
					as.eliminar(j);
				limpieza();
				listar();
				txtCodigo.requestFocus();
					//visibleNombre();
				}
				
		} catch (Exception e) {
			// TODO: handle exception
			//txtCodigo.setText("");
			  //(x);
			
			JOptionPane.showMessageDialog(null,"Intente nuevamente el c�digo ingresar", "Aviso de Sistema", JOptionPane.WARNING_MESSAGE);
			
	}
	}
	
	
	void adicionar() {
		//validar el dni
		try {
			if(leerNombres().equals("")) {
				//JOptionPane.showMessageDialog(parentComponent, message, title, messageType);("No ingreso ningun dato");
				JOptionPane.showInputDialog(null, "Escriba nuevamente su nombre", "Error!", JOptionPane.ERROR_MESSAGE);
				txtNombre.requestFocus();
			}else if(leerApellidos().equals("")) {
				JOptionPane.showInputDialog(null, "Escriba nuevamente su Apellido", "Error!", JOptionPane.ERROR_MESSAGE);
				txtApellido.requestFocus();
			}else if (leerDni().equals("")) {
				JOptionPane.showInputDialog(null, "Escriba nuevamente su Dni", "Error!", JOptionPane.ERROR_MESSAGE);
				txtDni.requestFocus();
			}else if(validarDni()) {
				JOptionPane.showInputDialog(null, "El dni existe, corrija", "Error!", JOptionPane.ERROR_MESSAGE);
				txtDni.setText("");
				txtDni.requestFocus();
			}
			
			else if(leerTelefono().equals("")){
				JOptionPane.showInputDialog(null, "Escriba nuevamente su Telefono", "Error!", JOptionPane.ERROR_MESSAGE);
				txtFono.requestFocus();
			}
			
			else {
				ClaseSocio nuevo= new ClaseSocio( leerCodigo(), leerDni(), leerNombres() ,  leerApellidos()  ,  leerTelefono());
				as.adicionar(nuevo);
				limpieza();
				listar();
				
			}
				
			
		} catch (Exception e) {
			// TODO: handle exception
			
			JOptionPane.showMessageDialog(null,"Existe un ERROR en todo el Formulario complete todo los datos", "Aviso de Sistema", JOptionPane.WARNING_MESSAGE);
		}
		
		
	}
	void consultar() {
		
	
		try {
			
			
			ClaseSocio cs = as.buscar(leerCodigo());
			
			
			if (cs == null) {
				
				JOptionPane.showMessageDialog(null,"el C�DIGO no existe");
				limpieza();
				listar();
			}
			else {
				
				txtCodigo.setText(""+cs.getCodigoSocio());
				txtCodigo.requestFocus();
				txtNombre.setText("" + cs.getNombres());
				txtApellido.setText("" + cs.getApellidos());
				txtDni.setText("" + cs.getDni());
				txtFono.setText(""+cs.getTelefono());
				
				//txtFono.requestFocus();
			}
			
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			
			
			JOptionPane.showMessageDialog(null,"Intente nuevamente el c�digo ingresar", "Aviso de Sistema", JOptionPane.WARNING_MESSAGE);
		}
		
		
		
		
		
		
	}
	void modificar() {
		
		
		
		try {
			ClaseSocio cs = as.buscar(leerCodigo());
			if (cs == null) {
				JOptionPane.showMessageDialog(null,"el C�DIGO no existe");
			} else {
                  cs.setCodigoSocio(leerCodigo());
                  cs.setNombres(leerNombres());
                  cs.setApellidos(leerApellidos());
                  cs.setDni(leerDni());
                  cs.setTelefono(leerTelefono());
               
                  listar();
                  limpieza();
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null,"Intente nuevamente el c�digo ingresar", "Aviso de Sistema", JOptionPane.WARNING_MESSAGE);

		}
		
	}
	
	
	
	
	void limpieza() {
		txtCodigo.setText("");
		txtDni.setText("");
		txtNombre.setText("");
		txtApellido.setText("");
		
		txtFono.setText("");
	}
	
void listar(){
		
		
		modelo.setRowCount(0);
		for (int i=0; i<as.tamano(); i++) {
			Object fila[] = { as.obtener(i).getCodigoSocio(),
					          as.obtener(i).getDni(),
					          as.obtener(i).getNombres(),
					          as.obtener(i).getApellidos(),
					       
					          as.obtener(i).getTelefono() };
			modelo.addRow(fila);
		}
		
		txtCodigo.setText("" + as.codigoCorrelativo());
	}



//*************



int leerCodigo() {
	return Integer.parseInt(txtCodigo.getText());
}

String leerNombres() {
	return txtNombre.getText();
}

String leerApellidos() {
	return txtApellido.getText();
}
String leerDni() {
	return txtDni.getText();
}
String leerTelefono() {
	return txtFono.getText();
}

//evento de mouse
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == lblGuardar) {
			mouseClickedLblGuardar(arg0);
		}
		if (arg0.getSource() == btnAdicionar) {
			mouseClickedBtnAdicionar(arg0);
		}
		if (arg0.getSource() == table) {
			mouseClickedTable(arg0);
		}
	}
	public void mouseEntered(MouseEvent arg0) {
		btnAdicionar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(10, 20, 26)));
		 btnAdicionar.setOpaque(true);
		 btnAdicionar.setBackground(new Color(10, 20, 26));
	     btnAdicionar.setForeground(new Color(255, 255, 255));
		
	}
	public void mouseExited(MouseEvent arg0) {
		btnAdicionar.setOpaque(false);
		btnAdicionar.setForeground(new Color(243, 124, 47));
		btnAdicionar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(10, 20, 26)));
		btnAdicionar.setForeground(new Color(10, 20, 26));
		
	}
	public void mousePressed(MouseEvent arg0) {
	}
	public void mouseReleased(MouseEvent arg0) {
	}
	protected void mouseClickedTable(MouseEvent arg0) {
		cargarFila();
	}
	
	void cargarFila() {
		
		int f=table.getSelectedRow();
		
		txtCodigo.setText(table.getValueAt(f, 0).toString());
		txtDni.setText(table.getValueAt(f, 1).toString());
		txtNombre.setText(table.getValueAt(f, 2).toString());
		txtApellido.setText(table.getValueAt(f, 3).toString());
		
		txtFono.setText(table.getValueAt(f, 4).toString());
		
	}
	
	/*
	private void visibleNombre(){
		txtNombre.setVisible(false);
		lblNombre.setVisible(false);
		
	}
	*/
	//validador de dni
	boolean validarDni() {
		ClaseSocio cs;
		for (int i = 0; i < as.tamano(); i++) {
			cs = as.obtener(i);
			if (cs.getCodigoSocio() != leerCodigo()) {
				if (cs.getDni().equals(leerDni())) {
					return true;
				}
			}
			else {
				if (cs.getDni().equals(leerDni())) {
					return false;
				}
			}
		}
		return false;
	}
	protected void mouseClickedBtnAdicionar(MouseEvent arg0) {
		
		
		
	}
	public void keyPressed(KeyEvent arg0) {
	}
	public void keyReleased(KeyEvent arg0) {
	}
	public void keyTyped(KeyEvent arg0) {
		if (arg0.getSource() == txtDni) {
			keyTypedTxtDni(arg0);
		}
	}
	//limitar digitos dni
	public  void maxdni(KeyEvent e, JTextField txtDni, int longitud) {
		if (txtDni.getText().length() >= longitud) {
			e.consume();
		}
		//no escritura de letras
       char car = e.getKeyChar();
		
		if (!Character.isDigit(car)) {
			e.consume();
		}	
		
		
	}
	protected void keyTypedTxtDni(KeyEvent arg0) {
		maxdni(arg0, txtDni, 8);  
		/*int limite = 8;
		if (txtDni.getText().length()>= limite);
		arg0.consume();*/
	}
	protected void mouseClickedLblGuardar(MouseEvent arg0) {
		darleGrabar();
	}
	
	//***************Carga y guardado de texto
	
	void darleGrabar() {
		if (as.existeArchivo()) {
			int ok = confirmacion(this, "� Desea actualizar \"" + as.getArchivo() + "\" ?");
			if (ok == 0) {
				as.GrabarSocio();
				
				mensajeInformacion(this, "\"" + as.getArchivo() + "\" ha sido actualizado");
			}
			else
				mensajeInformacion(this, "No se actualiz�  \"" + as.getArchivo() + "\"");
		}
		else {
			as.GrabarSocio();
			
			mensajeInformacion(this, "\"" + as.getArchivo() + "\" ha sido creado");
		}
		
	}
	
//*******************Mensajes de confirmacion de carga de texto	
	public static int confirmacion(JDialog jd, String s) {
		return JOptionPane.showConfirmDialog(jd, s, "Advertencia", JOptionPane.YES_NO_OPTION,
				JOptionPane.WARNING_MESSAGE);
	}
	public static void mensajeInformacion(JDialog jd, String s) {
		JOptionPane.showMessageDialog(jd, s, "Informaci�n", JOptionPane.INFORMATION_MESSAGE);
	}
	
	
}

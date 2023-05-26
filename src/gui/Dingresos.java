package gui;

import java.awt.BorderLayout;
import java.awt.Font;

import arreglos.Socio;


import clases.ClaseIngreso;
import arreglos.Ingreso;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import libreria.Fecha;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;


public class Dingresos extends JDialog implements ActionListener, MouseListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
							//***************************variable global***********
	                        Socio as= new Socio("Socio.txt");
	                        Ingreso ai = new Ingreso("Ingreso.txt");  
	                     
	                        Fecha f = new Fecha();
  //******************************************************** 
	                        
	                        
	private final JPanel contentPanel = new JPanel();
	private JLabel lblCodigoIngreso;
	private JLabel lblCodigoSocio;
	private JLabel lblFechaIngreso;
	private JLabel lblNumeroDeInvitados;
	private JLabel lblCostoIngreso;
	private JLabel lblEstado;
	private JTextField txtIngreso;
	private JComboBox <Object> cboSocio;
	private JComboBox  cboDia;
	private JComboBox cboMes;
	private JComboBox  cboAnio;
	private JComboBox <Object>cboEstados;
	private JTextField txtCosto;
	private JComboBox <Object>cboInvitado;
	private JScrollPane scrollPane;
	private JTable table;
	private DefaultTableModel modelo;
	private JLabel lblGrabar;
	private JLabel lblAgregar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Dingresos dialog = new Dingresos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Dingresos() {
		setTitle("INGRESO");
		setBounds(100, 100, 892, 539);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblCodigoIngreso = new JLabel("C\u00F3digo Ingreso");
		lblCodigoIngreso.setBounds(31, 37, 95, 14);
		contentPanel.add(lblCodigoIngreso);
		
		lblCodigoSocio = new JLabel("C\u00F3digo Socio");
		lblCodigoSocio.setBounds(31, 62, 79, 14);
		contentPanel.add(lblCodigoSocio);
		
		lblFechaIngreso = new JLabel("Fecha Ingreso");
		lblFechaIngreso.setBounds(31, 87, 95, 14);
		contentPanel.add(lblFechaIngreso);
		
		lblNumeroDeInvitados = new JLabel("N\u00FAmero de Invitados");
		lblNumeroDeInvitados.setBounds(31, 128, 136, 14);
		contentPanel.add(lblNumeroDeInvitados);
		
		lblCostoIngreso = new JLabel("Costo Ingreso");
		lblCostoIngreso.setBounds(31, 153, 95, 14);
		contentPanel.add(lblCostoIngreso);
		
		lblEstado = new JLabel("Estado");
		lblEstado.setBounds(31, 178, 79, 14);
		contentPanel.add(lblEstado);
		
		txtIngreso = new JTextField();
		txtIngreso.setBounds(177, 34, 122, 20);
		contentPanel.add(txtIngreso);
		txtIngreso.setColumns(10);
		
		cboSocio = new JComboBox();
		cboSocio.setBounds(177, 59, 122, 20);
		cboSocio.addActionListener(this);
		contentPanel.add(cboSocio);
		
		cboDia = new JComboBox();
		cboDia.setBounds(177, 84, 53, 20);
		cboDia.setEnabled(false);
		//Su usa las libreria extra para traer las fecha actual y darle valor en numeros
		
		Fecha.colocarItems(cboDia, 1, 31);;
	    Fecha.diaActual(cboDia);
		//***************************
		contentPanel.add(cboDia);
		
		cboMes = new JComboBox();
		cboMes.setBounds(240, 84, 91, 20);
		cboMes.setEnabled(false);
		Fecha.colocarMeses(cboMes);
	    Fecha.mesActual(cboMes);
		contentPanel.add(cboMes);
		
		cboAnio = new JComboBox();
		cboAnio.setBounds(341, 84, 72, 20);
		cboAnio.setEnabled(false);
		//verificar la fecha del anio
		
		Fecha.anioActual(cboAnio);
	    cboAnio.addItem(""+ Fecha.anioActual(cboAnio));
		contentPanel.add(cboAnio);
		
		cboEstados = new JComboBox();
		cboEstados.setEnabled(false);
		cboEstados.setBounds(177, 175, 95, 20);
		cboEstados.setModel(new DefaultComboBoxModel(new String[] {"Pendiente", "Pagado"}));
		contentPanel.add(cboEstados);
		
		txtCosto = new JTextField();
		txtCosto.setBounds(177, 150, 122, 20);
		txtCosto.setEditable(false);
		contentPanel.add(txtCosto);
		txtCosto.setColumns(10);
		
		cboInvitado = new JComboBox ();
		cboInvitado.addActionListener(this);
		cboInvitado.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "15", "20"}));
		cboInvitado.setBounds(177, 125, 79, 20);
		contentPanel.add(cboInvitado);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 221, 856, 268);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		table.setModel(modelo = new DefaultTableModel());
		modelo.addColumn("CODIGO INGRESO");
		modelo.addColumn("CODIGO SOCIO");
		modelo.addColumn("FECHA INGRESO");
		modelo.addColumn("HORA INGRESO");
		modelo.addColumn("INVITADOS");
		modelo.addColumn("COSTO");
		modelo.addColumn("ESTADO");
		//modelo.addColumn("");
		
		
		scrollPane.setViewportView(table);
		
		lblGrabar = new JLabel("Grabar");
		lblGrabar.addMouseListener(this);
		//lblGrabar.setEnabled(false);
		lblGrabar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblGrabar.setForeground(Color.WHITE);
		lblGrabar.setBackground(new Color(255, 0, 0));
		lblGrabar.setIcon(new ImageIcon("F:\\oscar\\Bungalow\\iconos\\save.png"));
		lblGrabar.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblGrabar.setBounds(635, 128, 106, 64);
		contentPanel.add(lblGrabar);
		lblGrabar.setOpaque(true);
		lblGrabar.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblAgregar = new JLabel("Agregar");
		lblAgregar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblAgregar.addMouseListener(this);
		lblAgregar.setOpaque(true);
		lblAgregar.setBackground(Color.BLACK);
		lblAgregar.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblAgregar.setForeground(Color.WHITE);
		lblAgregar.setIcon(new ImageIcon("F:\\oscar\\Bungalow\\iconos\\AgregarBlanco.png"));
		lblAgregar.setBounds(635, 62, 106, 51);
		contentPanel.add(lblAgregar);
		//ai.cargarIngreso();
		llenarCombo();
		listar();
		
		
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == cboInvitado) {
			actionPerformedCboInvitado(arg0);
		}
		if (arg0.getSource() == cboSocio) {
			actionPerformedCboSocio(arg0);
		}
	}
	protected void actionPerformedCboInvitado(ActionEvent arg0) {
		txtCosto.setText(""+operacionPrecio());
	}
	

	protected void actionPerformedCboSocio(ActionEvent arg0) {
		/* 
		Dsocios ds = new  Dsocios();
		ds.setTitle("LISTADO DE PACIENTES");
		ds.setVisible(true);
		*/
		//ClaseSocio cs = as.buscar(leerSocio()) ;
	// cs.getCodigoSocio();
		//int index=0;
/*		
		for (int i=0; i<as.tamano(); i++) {
		cboSocio.setSelectedIndex(as.buscar(i).getCodigoSocio());
		}
		*/
		
		
	}
  
	void llenarCombo(){
		cboSocio.addItem("[Seleccionar]");
		for (int i = 0; i <as.tamano(); i++) {
			cboSocio.addItem(as.obtener(i).getCodigoSocio());
		}
	}
	void listar(){
		
 // int j=0;
		modelo.setRowCount(0);
		
		
		for (int i=0; i<ai.tamano(); i++) {
			
			ClaseIngreso x= ai.obtener(i);
	//		while (j<as.tamano()) {
				
			
	//		ClaseSocio x=  as.obtener(i);
			
			Object fila[] = { 
					ai.obtener(i).getCodigoIngreso(),
					
					//cboSocio.getItemAt(as.obtener(j).getCodigoSocio()),
					//cboSocio.getSelectedItem(),
					
					//cboSocio.getSelectedItem(),
					enTextoEstado(x.getCodigoSocio()),
				//	enTextoCategoria(as.obtener(i).getCodigoSocio()),
					//as.obtener(i).getCodigoSocio(),
			    	Fecha.dd_mm_aaaa(ai.obtener(i).getFechaIngreso()),
					Fecha.hh_mm_ss(ai.obtener(i).getHoraIngreso()),
					//ai.obtener(i).getNumeroInvitados(),
					cboInvitado.getItemAt(ai.obtener(i).getNumeroInvitados()),
					ai.obtener(i).getCostoIngreso(),
					verEstado(ai.obtener(i).getEstado())
					          //as.obtener(i).getNombres(),
					         // as.obtener(i).getApellidos(),
					         // as.obtener(i).getDni(),
					        //  as.obtener(i).getTelefono()
					          };
			modelo.addRow(fila);
		//	j++;
		//	break ;
	//	}
	}
		//txtCodigo.setText("" + as.codigoCorrelativo());
		
		
		
		txtIngreso.setText(""+ai.codigoCorrelativo());
		
		
	}
	
	//String para socio de muestra en la tabla
	
	String enTextoEstado(int i) {
		return cboSocio.getItemAt(i).toString();
	}
	
	double operacionPrecio() {
	
		switch (leerInvitados()) {
		case 0:
			
			return 25.0;
     case 1:
			
			return 50.0;
     case 2:
			
			return 75.0;
     case 3:
			
			return 100.0;
     case 4:
			
			return 125.0;
     case 5:
			
			return 150.0;
     case 6:
			
			return 175.0;
     case 7:
			
			return 200.0;
     case 8:
			
			return 225.0;
     case 9:
			
			return 250.0;
     case 10:
			
			return 375.0;
		default:
			
			return 500.0;
		}
		
		
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == lblAgregar) {
			mouseClickedLblAgregar(e);
		}
		if (e.getSource() == lblGrabar) {
			mouseClickedLblGrabar(e);
		}
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void mouseClickedLblGrabar(MouseEvent e) {
		darleGrabar();
	}
	
	
	protected void mouseClickedLblAgregar(MouseEvent e) {
		adicionarIngreso();
		
	}
	
	//Volever el numero en letras al ComboBox
	
		String verEstado(int i){
			
			return cboEstados.getItemAt(i).toString();
		}
		// etiqueta de accion agregar
		void adicionarIngreso() {
			if (leerIngreso() < 0) {
				JOptionPane.showMessageDialog(null, "No selecciono ningun codigo");
			}
			else if (cboSocio.getSelectedIndex() < 0) {
				
				JOptionPane.showMessageDialog(this, "No hay ningun Socio AHORA!");
			}
			else {
				/*
				 * public ClaseIngreso(int codigoIngreso, int codigoSocio, String fechaIngreso, String horaIngreso,
			int numeroInvitados, double costoIngreso, int estado) {
				 * 
				 */
				ClaseIngreso nueva = new ClaseIngreso(leerIngreso(), leerSocio(), fechaLLegada(),
						 Fecha.obtenerHoraActual(), leerInvitados(), leerCosto(), leerEstado());
				ai.adicionar(nueva);
			//	fijarCamaOcupado(leerNumerocama());
				listar();
				limpieza();
			
			}
		}
		
		//leer datos
		
		
		@Override
		public String toString() {
			return "Dingresos [fechaLLegada()=" + fechaLLegada() + "]";
		}
		
		
		
		

		int leerIngreso() {
			return Integer.parseInt(txtIngreso.getText());
		}
		

		int leerSocio() {
			return cboSocio.getSelectedIndex();
		}
		
		int  fechaLLegada(){
			return Fecha.getFecha(cboDia, cboMes, cboAnio);
		}
		
		//string leer hora 
		
		int leerInvitados() {
			
			return cboInvitado.getSelectedIndex();
		}
		double leerCosto() {
			return Double.parseDouble(txtCosto.getText());
		}
		
		int leerEstado() {
			return cboEstados.getSelectedIndex();
		}
		
		void limpieza(){
			txtIngreso.requestFocus();
			cboSocio.setSelectedIndex(0);
			cboInvitado.setSelectedIndex(0);
			txtCosto.setText("");
		//	cboEstado.setSelectedIndex(0);
			
		}
		
		void listadoPendiente(){
			
			
		}
		void darleGrabar() {
			if (ai.existeArchivo()) {
				int ok = confirmacion(this, "¿ Desea actualizar \"" + ai.getArchivo() + "\" ?");
				if (ok == 0) {
					ai.GrabarIngreso();
					as.GrabarSocio();
					mensajeInformacion(this, "\"" + ai.getArchivo() + "\" ha sido actualizado");
				}
				else
					mensajeInformacion(this, "No se actualizó  \"" + ai.getArchivo() + "\"");
			}
			else {
				ai.GrabarIngreso();
				as.GrabarSocio();
				mensajeInformacion(this, "\"" + ai.getArchivo() + "\" ha sido creado");
			}
			
		}
		
	//*******************Mensajes de confirmacion de carga de texto	
		public static int confirmacion(JDialog jd, String s) {
			return JOptionPane.showConfirmDialog(jd, s, "Advertencia", JOptionPane.YES_NO_OPTION,
					JOptionPane.WARNING_MESSAGE);
		}
		public static void mensajeInformacion(JDialog jd, String s) {
			JOptionPane.showMessageDialog(jd, s, "Información", JOptionPane.INFORMATION_MESSAGE);
		}
		
}

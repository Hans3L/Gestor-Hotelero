package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import javax.swing.table.DefaultTableModel;
import arreglos.Producto;
import clases.ClaseProducto;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;


public class Dproducto extends JDialog implements ActionListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Variable global
	//ClaseProducto cp = new ClaseProducto();
	Producto ap =new Producto("Producto.txt");
	
	
	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigo;
	private JTextField txtStock;
	private JTextField txtPrecio;
	private JTable table;
	private JButton btnConsultar;
    private DefaultTableModel modelo;
    private JButton btnAdicionar;
    private JButton btnModificar;
    private JButton btnEliminar;
    private JButton btnListar;
   
    private JScrollPane scrollPane;
    private JTextField txtDetalle;
    private JLabel lblGuardar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Dproducto dialog = new Dproducto();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Dproducto() {
		setTitle("PRODUCTOS");
		setBounds(100, 100, 563, 435);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblCodigo = new JLabel("C\u00F3digo");
		lblCodigo.setBounds(29, 38, 68, 14);
		contentPanel.add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(115, 35, 154, 20);
		contentPanel.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		JLabel lblDetalles = new JLabel("Detalles");
		lblDetalles.setBounds(29, 81, 68, 14);
		contentPanel.add(lblDetalles);
		
		JLabel lblStock = new JLabel("Stock");
		lblStock.setBounds(29, 156, 68, 14);
		contentPanel.add(lblStock);
		
		txtStock = new JTextField();
		txtStock.setColumns(10);
		txtStock.setBounds(115, 153, 154, 20);
		contentPanel.add(txtStock);
		
		JLabel lblPrecioUnidad = new JLabel("Precio Unidad");
		lblPrecioUnidad.setBounds(29, 187, 80, 14);
		contentPanel.add(lblPrecioUnidad);
		
		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(115, 184, 154, 20);
		contentPanel.add(txtPrecio);
		
		 scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 220, 527, 155);
		contentPanel.add(scrollPane);
		//Dsocios dso =new Dsocios();
		//dso.modelo = new DefaultTableModel();
		
		table = new JTable();
		table.addMouseListener(this);
		table.setModel(modelo =new DefaultTableModel());
		modelo.addColumn("CÓDIGO");
		modelo.addColumn("DETALLE");
		modelo.addColumn("STOCK");
		modelo.addColumn("PRECIO x UNIDAD");
		
		
		
		
		
		scrollPane.setViewportView(table);
		
		btnAdicionar = new JButton("ADICIONAR");
		btnAdicionar.addMouseListener(this);
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(369, 34, 132, 23);
		contentPanel.add(btnAdicionar);
		
		btnConsultar = new JButton("CONSULTAR");
		btnConsultar.addActionListener(this);
		btnConsultar.setBounds(369, 67, 132, 23);
		contentPanel.add(btnConsultar);
		
		btnModificar = new JButton("MODIFICAR");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(369, 101, 132, 23);
		contentPanel.add(btnModificar);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(369, 133, 132, 23);
		contentPanel.add(btnEliminar);
		
		btnListar = new JButton("LISTAR");
		btnListar.addActionListener(this);
		btnListar.setBounds(369, 167, 132, 23);
		contentPanel.add(btnListar);
		
		txtDetalle = new JTextField();
		txtDetalle.setBounds(115, 78, 154, 64);
		contentPanel.add(txtDetalle);
		txtDetalle.setColumns(10);
		
		lblGuardar = new JLabel("Guardar");
		lblGuardar.addMouseListener(this);
		lblGuardar.setBackground(Color.BLACK);
		lblGuardar.setForeground(Color.WHITE);
		lblGuardar.setOpaque(true);
		lblGuardar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		//lblGuardar.setIcon(new ImageIcon(Dproducto.class.getResource("/com/sun/java/swing/plaf/windows/icons/FloppyDrive.gif")));
		lblGuardar.setBounds(10, 11, 68, 20);
		contentPanel.add(lblGuardar);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
		
		listar();
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnListar) {
			actionPerformedBtnListar(arg0);
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
		if (arg0.getSource() == btnConsultar) {
			actionPerformedButton(arg0);
		}
	}
	protected void actionPerformedButton(ActionEvent arg0) {
		consultar();
	}
	protected void actionPerformedBtnAdicionar(ActionEvent arg0) {
		adicionar();
		
	}
	protected void actionPerformedBtnModificar(ActionEvent arg0) {
		modificar();
	}
	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		eliminar();
	}
	protected void actionPerformedBtnListar(ActionEvent arg0) {
		listar();
	}
	
	void adicionar() {
		try {
			
			if(leerCodigo() == -1) {
				JOptionPane.showInputDialog(null, "Escriba nuevamente", "Error!", JOptionPane.ERROR_MESSAGE);
			}
			
			
		else if(leerDetalle(). equals("")) {
				//JOptionPane.showMessageDialog(parentComponent, message, title, messageType);("No ingreso ningun dato");
				JOptionPane.showInputDialog(null, "Escriba nuevamente", "Error!", JOptionPane.ERROR_MESSAGE);
				//txtS.requestFocus();
			
			}	
		else if(leerStock()== -1) {
			//JOptionPane.showMessageDialog(parentComponent, message, title, messageType);("No ingreso ningun dato");
			JOptionPane.showInputDialog(null, "Escriba nuevamente", "Error!", JOptionPane.ERROR_MESSAGE);
			//txtS.requestFocus();
		}else if (leerPrecio()== -1) {
				//JOptionPane.showMessageDialog(parentComponent, message, title, messageType);("No ingreso ningun dato");
				JOptionPane.showInputDialog(null, "Escriba nuevamente", "Error!", JOptionPane.ERROR_MESSAGE);
				//txtS.requestFocus();
		}else {
				ClaseProducto nuevo= new ClaseProducto( leerCodigo(),  leerDetalle() ,  leerStock() , leerPrecio() );
				ap.adicionar(nuevo);
				listar();
				
			}
							
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null,"Existe un ERROR en todo el Formulario complete todo los datos", "Aviso de Sistema", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	void modificar() {
		
		try {
			ClaseProducto cp = ap.buscar(leerCodigo());
			if (cp == null) {
				JOptionPane.showMessageDialog(null,"el CÓDIGO no existe");
			} else {
                  cp.setCodigoProducto(leerCodigo());
                  cp.setDetalle(leerDetalle());
                  cp.setStock(leerStock());
                  cp.setPrecioUnitario(leerPrecio());
                  limpieza();
                  listar();
                  txtCodigo.requestFocus();
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null,"Intente nuevamente el código ingresar", "Aviso de Sistema", JOptionPane.WARNING_MESSAGE);

		}
		
		
		
	}
	void consultar() {
		
try {
			
			
			ClaseProducto cp = ap.buscar(leerCodigo());
			
			
			if (cp == null) {
				
				JOptionPane.showMessageDialog(null,"el CÓDIGO no existe");
				limpieza();
				listar();
			}
			else {
				
				txtCodigo.setText(""+cp.getCodigoProducto());
				txtCodigo.requestFocus();
				txtDetalle.setText("" + cp.getDetalle());
				txtStock.setText("" + cp.getStock());
				txtPrecio.setText("" + cp.getPrecioUnitario());
			
				//cboEstado.setSelectedIndex(a.getEstado());
				//txtFono.requestFocus();
			}
			
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			
			
			JOptionPane.showMessageDialog(null,"Intente nuevamente el código ingresar", "Aviso de Sistema", JOptionPane.WARNING_MESSAGE);
		}
		
		
	}
	void eliminar() {
ClaseProducto j = ap.buscar(leerCodigo());
		
		try {
			
				if (leerCodigo() == -1 &&  j ==null  ) {  //Se usara la indiferencia de resultado
					JOptionPane.showMessageDialog(null,"el CÓDIGO no existe");
				}else {
				
					ap.eliminar(j);
				limpieza();
				listar();
				txtCodigo.requestFocus();
					//visibleNombre();
				}
				
		} catch (Exception e) {
			// TODO: handle exception
			//txtCodigo.setText("");
			  //(x);
			
			JOptionPane.showMessageDialog(null,"Intente nuevamente el código ingresar", "Aviso de Sistema", JOptionPane.WARNING_MESSAGE);
			
	}
		
		
	}
	//Dsocios dso =new Dsocios();
	void listar() {
		modelo.setRowCount(0);
		for (int i=0; i<ap.tamano(); i++) {
			Object fila[] = { ap.obtener(i).getCodigoProducto(),
					ap.obtener(i).getDetalle(),
					ap.obtener(i).getStock(),
					ap.obtener(i).getPrecioUnitario()};
			modelo.addRow(fila);
		}
		
		
		txtCodigo.setText("" + ap.codigoCorrelativo());
	}
	void limpieza() {
		txtCodigo.setText("");
		txtDetalle.setText("");
		txtStock.setText("");
		txtPrecio.setText("");
		
	}
	

	
	int leerCodigo() {
		return Integer.parseInt(txtCodigo.getText());
	}
	String leerDetalle() {
		return txtDetalle.getText();
	}
	int leerStock() {
		return Integer.parseInt(txtStock.getText());
	}
	double leerPrecio() {
		return Double.parseDouble(txtPrecio.getText());
	}
	
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
		//String cboEstado.setText("");
		//seleccionado = cboEstado.getSelectedIndex();
		txtCodigo.setText(table.getValueAt(f, 0).toString());
		txtDetalle.setText(table.getValueAt(f, 1).toString());
		//txtS.setText(table.getValueAt(f, 1).toString());
		
		txtStock.setText(table.getValueAt(f, 2).toString());
		txtPrecio.setText(table.getValueAt(f, 3).toString());
		//txtS.append(table.getValueAt(f,3).toString());
		
		
	}



//evento de la sombra
	protected void mouseClickedBtnAdicionar(MouseEvent arg0) {
		
		/*
		if (arg0.getSource() == btnAdicionar) {
			mouseClickedBtnAdicionar(arg0);
		}
		if (arg0.getSource() == table) {
			mouseClickedTable(arg0);
		}
		*/
	}
	protected void mouseClickedLblGuardar(MouseEvent arg0) {
		grabar();
	}
	
	
	void grabar() {
		
		//***************Carga y guardado de texto
		
	
			if (ap.existeArchivo()) {
				int ok = confirmacion(this, "¿ Desea actualizar \"" + ap.getArchivo() + "\" ?");
				if (ok == 0) {
					ap.GrabarProducto();
					
					mensajeInformacion(this, "\"" + ap.getArchivo() + "\" ha sido actualizado");
				}
				else
					mensajeInformacion(this, "No se actualizó  \"" + ap.getArchivo() + "\"");
			}
			else {
				ap.GrabarProducto();
				
				mensajeInformacion(this, "\"" + ap.getArchivo() + "\" ha sido creado");
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

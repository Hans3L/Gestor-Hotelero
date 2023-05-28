package gui;

//import java.awt.FlowLayout;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import clases.ClaseBungalow;

import arreglos.Bungalow;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.ListSelectionModel;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Cursor;

public class Dbungalow extends JDialog implements ActionListener, MouseListener, KeyListener {
	
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//*************variable global
Bungalow ab = new Bungalow("Bungalow.txt");
//****************************
	private JTextField txtNb;
	private JTextField txtPrecio;
	private JTable table;
	private JButton btnAdicionar;
	private JButton btnConsultar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnListar;
    private DefaultTableModel modelo;
  //  private static JComboBox <Integer>  cboCategoria_1 ;
    private JComboBox <Object> cboEstado;
   private JComboBox<Object> cboCategoria_1;
   private JLabel lblGuardar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Dbungalow dialog = new Dbungalow();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//System.out.println(leerCategoria());
	}

	/**
	 * Create the dialog.
	 */
	public Dbungalow() {
		setModal(true);
		setTitle("BUNGALOW");
		setBounds(100, 100, 450, 445);
		getContentPane().setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBorder(new EmptyBorder(5, 5, 5, 5));
			panel.setBounds(0, 0, 434, 412);
			getContentPane().add(panel);
			{
				JLabel lblNB = new JLabel("N\u00FAmero Bungalow");
				lblNB.setBounds(23, 59, 115, 14);
				panel.add(lblNB);
			}
			{
				JLabel lblCategoria = new JLabel("Categoria");
				lblCategoria.setBounds(23, 90, 59, 14);
				panel.add(lblCategoria);
			}
			{
				JLabel lblPrecioXDia = new JLabel("Precio x Dia");
				lblPrecioXDia.setBounds(23, 124, 86, 14);
				panel.add(lblPrecioXDia);
			}
			{
				JLabel lblEstado = new JLabel("Estado");
				lblEstado.setBounds(23, 161, 46, 14);
				panel.add(lblEstado);
			}
			{
				txtNb = new JTextField();
				txtNb.addKeyListener(this);
				txtNb.setColumns(10);
				txtNb.setBounds(167, 56, 86, 20);
				panel.add(txtNb);
			}
			{
				txtPrecio = new JTextField();
				txtPrecio.setEditable(false);
				txtPrecio.setColumns(10);
				txtPrecio.setBounds(167, 121, 86, 20);
				panel.add(txtPrecio);
			}
			{
				btnAdicionar = new JButton("ADICIONAR");
				btnAdicionar.addActionListener(this);
				btnAdicionar.setBounds(276, 22, 127, 23);
				panel.add(btnAdicionar);
			}
			{
				JButton button = new JButton("ELIMINAR");
				button.setBounds(297, 93, 89, -17);
				panel.add(button);
			}
			{
				btnConsultar = new JButton("CONSULTAR");
				btnConsultar.addActionListener(this);
				btnConsultar.setBounds(276, 53, 127, 23);
				panel.add(btnConsultar);
			}
			{
				btnModificar = new JButton("MODIFICAR");
				btnModificar.addActionListener(this);
				btnModificar.setBounds(276, 89, 127, 23);
				panel.add(btnModificar);
			}
			{
				btnEliminar = new JButton("ELIMINAR");
				btnEliminar.addActionListener(this);
				btnEliminar.setBounds(276, 123, 127, 23);
				panel.add(btnEliminar);
			}
			{
				btnListar = new JButton("LISTAR");
				btnListar.addActionListener(this);
				btnListar.setBounds(276, 157, 127, 23);
				panel.add(btnListar);
			}
			
			cboCategoria_1 = new JComboBox<>();
			cboCategoria_1.addActionListener(this);
			cboCategoria_1.setModel(new DefaultComboBoxModel<>(new String[] {"Simple", "Doble", "Familiar"}));
			cboCategoria_1.setBounds(167, 87, 86, 20);
			panel.add(cboCategoria_1);
			
		    cboEstado = new JComboBox <Object> () ;
		    cboEstado.setEnabled(false);
			cboEstado.setModel(new DefaultComboBoxModel<Object>(new String[] {"Libre", "Ocupado"}));
			cboEstado.setBounds(167, 158, 86, 20);
			panel.add(cboEstado);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 202, 414, 199);
			panel.add(scrollPane);
			table = new JTable();
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table.setEditingColumn(ERROR);
			table.setEditingRow(ABORT);
			table.addMouseListener(this);
			table.setModel(modelo= new DefaultTableModel());
			modelo.addColumn("CODIGO");
			modelo.addColumn("CATEGORIA");
			modelo.addColumn("PRECIO UNIDAD");
			modelo.addColumn("ESTADO");
			
			scrollPane.setViewportView(table);
			{
				lblGuardar = new JLabel("Guardar");
				lblGuardar.addMouseListener(this);
				lblGuardar.setForeground(Color.WHITE);
				lblGuardar.setBackground(Color.BLACK);
				lblGuardar.setOpaque(true);
				lblGuardar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				//lblGuardar.setIcon(new ImageIcon(Dbungalow.class.getResource("/javax/swing/plaf/metal/icons/ocean/floppy.gif")));
				lblGuardar.setBounds(10, 11, 72, 20);
				panel.add(lblGuardar);
			}
		}
		listar();
		
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cboCategoria_1) {
			actionPerformedCboCategoria(e);
		}
		if (e.getSource() == btnListar) {
			actionPerformedBtnListar(e);
		}
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificar(e);
		}
		if (e.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(e);
		}
		if (e.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(e);
		}
	}
	protected void actionPerformedCboCategoria(ActionEvent e) {
		txtPrecio.setText("" + establecerPrecio());
	}
	protected void actionPerformedBtnAdicionar(ActionEvent e) {
		adicionar();
	}
	protected void actionPerformedBtnConsultar(ActionEvent e) {
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
		limpieza();
	}
	void consultar() {
		
		try {
            ClaseBungalow cb = ab.buscar(leerCodigo());
			
			
			if (cb == null) {
				
				JOptionPane.showMessageDialog(null,"el CÓDIGO no existe");
				limpieza();
				listar();
			}
			else {
				
				txtNb.setText(""+cb.getNumeroBungalow());
				txtNb.requestFocus();
				//cboCategoria_1.setText(
				cboCategoria_1.setSelectedIndex(cb.getCategoria());
				txtPrecio.setText("" + cb.getPrecioDia());
				//cboEstado.setText("" + 
				cb.getEstado();
				//txtFono.setText(""+cb.getTelefono());
				//txtFono.requestFocus();
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			JOptionPane.showMessageDialog(null, "Operación realizada correctamente");
		}
		
		
	}
	void listar() {
		
		modelo.setRowCount(0);
		for (int i=0; i<ab.tamano(); i++) {
			Object fila[] = {
					ab.obtener(i).getNumeroBungalow(),
					enTextoCategoria(ab.obtener(i).getCategoria()),
					ab.obtener(i).getPrecioDia(),
					enTextoEstado(ab.obtener(i).getEstado())
					};
			modelo.addRow(fila);
		}
		
		
		txtNb.setText("" + ab.codigoCorrelativo());
	}
	void modificar() {
		
		try {
			ClaseBungalow cb = ab.buscar(leerCodigo());
			if (cb == null) {
				JOptionPane.showMessageDialog(null,"el CÓDIGO no existe");
			} else {
				cb.setNumeroBungalow(leerCodigo());
				cb.setCategoria(leerCategoria());
				cb.setPrecioDia(leerPrecio());
				cb.setEstado(leerEstado());
                //  cs.setTelefono(leerTelefono());
                  limpieza();
                  listar();
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	void eliminar() {
		ClaseBungalow j= ab.buscar(leerCodigo());
	
		try {
		
			if (leerCodigo() !=-1  &&  j ==null ) {  //Se usara la indiferencia de resultado
				JOptionPane.showMessageDialog(null,"el CÓDIGO no existe");
			//}if(j ==null) {
			//	validadorCodigo();
			}
			
			else {
			
				ab.eliminar(j);
			limpieza();
			listar();
			txtNb.requestFocus();
			
		} 
		}		catch (Exception e) {
			
			// TODO: handle exception
			
		}finally {
			JOptionPane.showMessageDialog(null, "Operación realizada correctamente");
		}
		
		
	}
	
	void adicionar() {
		
		try {
			
			if(leerCodigo() == -1) {
				JOptionPane.showInputDialog(null, "Escriba nuevamente", "Error!", JOptionPane.ERROR_MESSAGE);
			}else {
			ClaseBungalow nuevo = new ClaseBungalow(leerCodigo(),leerCategoria(), leerPrecio(),leerEstado() );
			ab.adicionar(nuevo);
			limpieza();
			listar();
			}
		} 
			catch (Exception e) {
			
			JOptionPane.showMessageDialog(null,"Existe un ERROR en todo el Formulario complete todo los datos", "Aviso de Sistema", JOptionPane.WARNING_MESSAGE);
		}
		
		
		
		
		
	}
	
	
	void limpieza() {
		//txtNb.setText("");
		txtNb.requestFocus();
		cboCategoria_1.setSelectedIndex(0);
		txtPrecio.setText("");
		cboEstado.setSelectedIndex(0);
		
	}
	
	
	
	
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == lblGuardar) {
			mouseClickedLblGuardar(arg0);
		}
		if (arg0.getSource() == table) {
			mouseClickedTable(arg0);
		}
	}
	public void mouseEntered(MouseEvent arg0) {
	}
	public void mouseExited(MouseEvent arg0) {
	}
	public void mousePressed(MouseEvent arg0) {
	}
	public void mouseReleased(MouseEvent arg0) {
	}
	protected void mouseClickedTable(MouseEvent arg0) {
		cargarFila();
	}
void cargarFila() {
		
		if (ab.tamano() == 0)
			limpieza();
		else {
			ClaseBungalow x = ab.obtener(table.getSelectedRow());
			txtNb.setText("" + x.getNumeroBungalow());
			cboCategoria_1.setSelectedIndex(x.getCategoria());
			txtPrecio.setText("" + x.getPrecioDia());
			cboEstado.setSelectedIndex(x.getEstado());
		}
		
	//Casteamos el combobox
	/*
		int f=table.getSelectedRow();
		txtNb.setText(table.getValueAt(f, 0).toString());
		cboCategoria_1.setSelectedIndex((int) table.getValueAt(f, 1));
		//txtS.setText(table.getValueAt(f, 1).toString());
		txtPrecio.setText(table.getValueAt(f, 2).toString());
		//cboEstado.setSelectedIndex((int) table.getValueAt(f, 3));
		//*/
	}
	
	//leer datos
	 int leerCodigo() {
		
		return Integer.parseInt(txtNb.getText());
	}
	
	 int leerCategoria() {
		return cboCategoria_1.getSelectedIndex();
	}
	double leerPrecio() {
		return Double.parseDouble(txtPrecio.getText());
	}
	int leerEstado() {
		return cboEstado.getSelectedIndex();
	}
	double establecerPrecio() {
		switch (leerCategoria()) {
		case 0:
			
			return 100.0;
		case 1:
			
			return 200.0;

		default:
			return 500.0;
		}
	}
	
	public static void soloNumero(KeyEvent e, JTextField txt, int longitud) {
		if (txt.getText().length() >= longitud) {
			e.consume();
		}
		
		char car = e.getKeyChar();
		
		if (!Character.isDigit(car)) {
			e.consume();
		}
	}
	
/*	boolean validadorCodigo() {
		
		ClaseBungalow cb;
		for (int i = 0; i < ab.tamano(); i++) {
			cb = ab.obtener(i);
			if (cb.getNumeroBungalow() != leerCodigo()) {
				//if (cb.getDni().equals(leerDni())) {
					return true;
				//}
			}
			else {
				//if (cs.getDni().equals(leerDni())) {
					return false;
				
			}
		}
		
		return false;
	}*/
	//Devuelve valores numeros en letras en la tabla
	String enTextoCategoria(int i) {
		return cboCategoria_1.getItemAt(i).toString();
	}
	String enTextoEstado(int i) {
		return cboEstado.getItemAt(i).toString();
	}
	
	
	public void keyPressed(KeyEvent arg0) {
	}
	public void keyReleased(KeyEvent arg0) {
	}
	public void keyTyped(KeyEvent arg0) {
		if (arg0.getSource() == txtNb) {
			keyTypedTxtNb(arg0);
		}
	}
	//validador de caaracteres, limites y vacios
	public  void valicodigo(KeyEvent e, JTextField txtNB, int longitud) {
	//	if(txtNb.getText().equals("")){
	 //       e.consume();	
	  //  }
		if (txtNb.getText().length() >= longitud) {
			e.consume();
		}
         char car = e.getKeyChar();
		
		if (!Character.isDigit(car)) {
			e.consume();
		}	
		
	}
	protected void keyTypedTxtNb(KeyEvent arg0) {
		valicodigo(arg0, txtNb, 5); 
	}
	protected void mouseClickedLblGuardar(MouseEvent arg0) {
		darleGrabar();
	}
	
	
	//************************************Accion de guardar**********
	
	void darleGrabar() {
		if (ab.existeArchivo()) {
			int ok = confirmacion(this, "¿ Desea actualizar \"" + ab.getArchivo() + "\" ?");
			if (ok == 0) {
				ab.GrabarBungalow();
			
				mensajeInformacion(this, "\"" + ab.getArchivo() + "\" ha sido actualizado");
			}
			else
				mensajeInformacion(this, "No se actualizó  \"" + ab.getArchivo() + "\"");
		}
		else {
			ab.GrabarBungalow();
			
			mensajeInformacion(this, "\"" + ab.getArchivo() + "\" ha sido creado");
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

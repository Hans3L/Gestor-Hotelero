package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import arreglos.Producto;
import arreglos.Socio;
import clases.ClaseProducto;

import javax.swing.JToolBar;
import javax.swing.JTabbedPane;
import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JButton;

public class Principal01 extends JFrame implements ActionListener {
	private JMenuBar menuBar;
	private JMenuBar menuBar_1;
	private JMenu mnMantenimiento;
	private JMenuItem mntmSocio;
	private JMenuItem mntmProducto;
	private JMenuItem mntmBungalow;
	private JSeparator separator;
	private JSeparator separator_1;
	private JButton btnSalir;
	private JMenuItem mntmIngreso;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal01 frame = new Principal01();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal01() {
		//setResizable(false);
		//this.setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 779, 550);
		setTitle("Principal");
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		menuBar.add(mnMantenimiento);
		
		mntmSocio = new JMenuItem("Usuario");
		mntmSocio.addActionListener(this);
		mnMantenimiento.add(mntmSocio);
		
		separator = new JSeparator();
		mnMantenimiento.add(separator);
		
		mntmProducto = new JMenuItem("Producto");
		mntmProducto.addActionListener(this);
		mnMantenimiento.add(mntmProducto);
		
		separator_1 = new JSeparator();
		mnMantenimiento.add(separator_1);
		
		mntmBungalow = new JMenuItem("Bungalow");
		mntmBungalow.addActionListener(this);
		mnMantenimiento.add(mntmBungalow);
		
		JMenu mnRegistro = new JMenu("Registro");
		menuBar.add(mnRegistro);
		
		mntmIngreso = new JMenuItem("Ingreso");
		mntmIngreso.addActionListener(this);
		mnRegistro.add(mntmIngreso);
		
		JSeparator separator_2 = new JSeparator();
		mnRegistro.add(separator_2);
		
		JMenuItem mntmConsumo = new JMenuItem("Consumo");
		mnRegistro.add(mntmConsumo);
		
		JSeparator separator_3 = new JSeparator();
		mnRegistro.add(separator_3);
		
		JMenuItem mntmHospedaje = new JMenuItem("Hospedaje");
		mnRegistro.add(mntmHospedaje);
		
		JMenu mnPago = new JMenu("Pago");
		menuBar.add(mnPago);
		
		JMenuItem mntmIngresoYConsumo = new JMenuItem("Ingreso y Consumo");
		mnPago.add(mntmIngresoYConsumo);
		
		JSeparator separator_4 = new JSeparator();
		mnPago.add(separator_4);
		
		JMenuItem mntmHospedajes = new JMenuItem("Hospedajes");
		mnPago.add(mntmHospedajes);
		
		JMenu mnReporte = new JMenu("Reporte");
		menuBar.add(mnReporte);
		
		JMenuItem mntmIngresoYConsumo_1 = new JMenuItem("Ingreso y Consumo Pendientes");
		mnReporte.add(mntmIngresoYConsumo_1);
		
		JSeparator separator_5 = new JSeparator();
		mnReporte.add(separator_5);
		
		JMenuItem mntmIngresoYConsumos = new JMenuItem("Ingreso y Consumos Pagados");
		mnReporte.add(mntmIngresoYConsumos);
		
		JSeparator separator_6 = new JSeparator();
		mnReporte.add(separator_6);
		
		JMenuItem mntmHospedajesPendientes = new JMenuItem("Hospedajes Pendientes");
		mnReporte.add(mntmHospedajesPendientes);
		
		JSeparator separator_7 = new JSeparator();
		mnReporte.add(separator_7);
		
		JMenuItem mntmHospedajesPagados = new JMenuItem("Hospedajes Pagados");
		mnReporte.add(mntmHospedajesPagados);
		
		menuBar_1 = new JMenuBar();
		menuBar.add(menuBar_1);
		getContentPane().setLayout(null);
		
		btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(this);
		btnSalir.setBounds(664, 445, 89, 23);
		getContentPane().add(btnSalir);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == mntmIngreso) {
			actionPerformedMntmIngreso(arg0);
		}
		if (arg0.getSource() == mntmBungalow) {
			actionPerformedMntmBungalow(arg0);
		}
		if (arg0.getSource() == mntmProducto) {
			actionPerformedMntmProducto(arg0);
		}
		if (arg0.getSource() == btnSalir) {
			actionPerformedBtnSalir(arg0);
		}
		if (arg0.getSource() == mntmSocio) {
			actionPerformedMntmSocio(arg0);
		}
	}
	protected void actionPerformedMntmSocio(ActionEvent arg0) {
		
		Dsocios ds = new Dsocios();
		ds.setLocationRelativeTo(this);
		ds.setVisible(true);
		
		
		
		
	}
	protected void actionPerformedBtnSalir(ActionEvent arg0) {
		System.exit(0);
	}
	protected void actionPerformedMntmProducto(ActionEvent arg0) {
		
		Dproducto dp = new Dproducto();
		dp.setLocationRelativeTo(this);
		dp.setVisible(true);
	}
	protected void actionPerformedMntmBungalow(ActionEvent arg0) {
		
		Dbungalow db = new Dbungalow();
		db.setLocationRelativeTo(this);
		db.setVisible(true);
		
		
	}
	
	
	
	protected void actionPerformedMntmIngreso(ActionEvent arg0) {
		Dingresos di = new Dingresos();
		di.setLocationRelativeTo(this);
		di.setVisible(true);
	}
}

package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class Dhospedaje extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigo;
	private JComboBox cboIngreso;
	private JComboBox cboBungalow;
	private JComboBox cboDia;
	private JComboBox cboMes;
	private JComboBox cboAnio;
	private JTextField txtCostoH;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Dhospedaje dialog = new Dhospedaje();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Dhospedaje() {
		setTitle("HOSPEDAJE");
		setBounds(100, 100, 859, 542);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(185, 57, 86, 20);
		contentPanel.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		cboIngreso = new JComboBox();
		cboIngreso.setBounds(185, 101, 86, 20);
		contentPanel.add(cboIngreso);
		
		cboBungalow = new JComboBox();
		cboBungalow.setBounds(185, 142, 86, 20);
		contentPanel.add(cboBungalow);
		
		cboDia = new JComboBox();
		cboDia.setBounds(185, 187, 48, 20);
		contentPanel.add(cboDia);
		
		cboMes = new JComboBox();
		cboMes.setBounds(243, 187, 77, 20);
		contentPanel.add(cboMes);
		
		cboAnio = new JComboBox();
		cboAnio.setBounds(330, 187, 77, 20);
		contentPanel.add(cboAnio);
		
		txtCostoH = new JTextField();
		txtCostoH.setBounds(185, 231, 122, 20);
		contentPanel.add(txtCostoH);
		txtCostoH.setColumns(10);
	}
}

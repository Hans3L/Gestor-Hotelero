package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.ScrollPane;

public class DingresosyConsumos extends JDialog {
	private JComboBox comboBox;
	private JLabel lblCodigo;
	private ScrollPane scrollPane;
	private JButton btnProceder;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DingresosyConsumos dialog = new DingresosyConsumos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DingresosyConsumos() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		comboBox = new JComboBox();
		comboBox.setBounds(101, 46, 103, 20);
		getContentPane().add(comboBox);
		
		lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(35, 49, 46, 14);
		getContentPane().add(lblCodigo);
		
		scrollPane = new ScrollPane();
		scrollPane.setBounds(24, 81, 372, 149);
		getContentPane().add(scrollPane);
		
		btnProceder = new JButton("Proceder");
		btnProceder.setBounds(290, 45, 89, 23);
		getContentPane().add(btnProceder);
	}
}

package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.ScrollPane;

public class DhospedajeP extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DhospedajeP dialog = new DhospedajeP();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DhospedajeP() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel label = new JLabel("");
			label.setBounds(217, 10, 0, 0);
			contentPanel.add(label);
		}
		{
			JLabel lblCodigo = new JLabel("Codigo");
			lblCodigo.setBounds(43, 35, 46, 14);
			contentPanel.add(lblCodigo);
		}
		{
			JComboBox comboBox = new JComboBox();
			comboBox.setBounds(116, 32, 114, 20);
			contentPanel.add(comboBox);
		}
		{
			JButton btnProcesar = new JButton("Procesar");
			btnProcesar.setBounds(307, 31, 89, 23);
			contentPanel.add(btnProcesar);
		}
		{
			ScrollPane scrollPane = new ScrollPane();
			scrollPane.setBounds(32, 71, 349, 150);
			contentPanel.add(scrollPane);
		}
	}

}

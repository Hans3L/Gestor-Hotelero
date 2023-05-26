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

public class DIngresoYConsumoPendiente extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DIngresoYConsumoPendiente dialog = new DIngresoYConsumoPendiente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DIngresoYConsumoPendiente() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblCodigo = new JLabel("Codigo");
			lblCodigo.setBounds(27, 11, 46, 14);
			contentPanel.add(lblCodigo);
		}
		{
			JComboBox comboBox = new JComboBox();
			comboBox.setBounds(93, 8, 68, 20);
			contentPanel.add(comboBox);
		}
		{
			ScrollPane scrollPane = new ScrollPane();
			scrollPane.setBounds(10, 95, 414, 156);
			contentPanel.add(scrollPane);
		}
		{
			JButton btnProceder = new JButton("Proceder");
			btnProceder.setBounds(276, 7, 89, 23);
			contentPanel.add(btnProceder);
		}
	}

}

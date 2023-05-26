package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.ScrollPane;
import javax.swing.JComboBox;

public class DHospedajePagados extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DHospedajePagados dialog = new DHospedajePagados();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DHospedajePagados() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel label = new JLabel("Codigo");
			label.setBounds(27, 15, 46, 14);
			contentPanel.add(label);
		}
		{
			ScrollPane scrollPane = new ScrollPane();
			scrollPane.setBounds(10, 99, 414, 156);
			contentPanel.add(scrollPane);
		}
		{
			JComboBox comboBox = new JComboBox();
			comboBox.setBounds(93, 12, 68, 20);
			contentPanel.add(comboBox);
		}
		{
			JButton button = new JButton("Proceder");
			button.setBounds(276, 11, 89, 23);
			contentPanel.add(button);
		}
	}

}

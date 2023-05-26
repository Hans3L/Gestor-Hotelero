package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.TextArea;

public class Dboleta extends JDialog {
	private TextArea textArea;
	private JButton btnProceder;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Dboleta dialog = new Dboleta();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Dboleta() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		textArea = new TextArea();
		textArea.setBounds(10, 91, 414, 160);
		getContentPane().add(textArea);
		
		btnProceder = new JButton("Proceder");
		btnProceder.setBounds(158, 33, 89, 23);
		getContentPane().add(btnProceder);
	}
}

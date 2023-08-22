package View;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

public class RegistroProducto extends JPanel implements ActionListener {

	private JComboBox comboBox;
	private JPanel panel;
	private RegistrarPerecedero perecedero = new RegistrarPerecedero ();
	/**
	 * Create the panel.
	 */
	public RegistroProducto() {

		setBorder(new LineBorder(new Color(0, 0, 0), 2));

		setBackground(Color.WHITE);
		setBounds(208, 34, 750, 600);
		setLayout(null);
		
		panelSuperior ();
	}
	
	private void panelSuperior () {
		
		JLabel lblRegistroDeProductos = new JLabel("Registro de Productos");
		lblRegistroDeProductos.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblRegistroDeProductos.setBounds(10, 11, 236, 27);
		add(lblRegistroDeProductos);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(10, 49, 730, 20);
		add(separator);
		
		JLabel lblNewLabel = new JLabel("Tipo Producto:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(20, 80, 156, 27);
		add(lblNewLabel);
		
		comboBox = new JComboBox();
		comboBox.setBounds(20, 108, 156, 27);
		add(comboBox);
		
		comboBox.addItem("...");
		comboBox.addItem("Perecedero");
		comboBox.addItem("Refrigerado");
		comboBox.addItem("Envasado");
		
		comboBox.addActionListener(this);
		
		panel = new JPanel();
		panel.setBounds(20, 146, 707, 431);
		add(panel);
		panel.setLayout(null);
	}
	
	
	public void ReemplazarPanel (JPanel NuevoPanel) {
		panel.removeAll();
		panel.add(NuevoPanel);
		NuevoPanel.setLocation(0, 0);
		panel.repaint();
		panel.revalidate();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String item = (String) comboBox.getSelectedItem();
		
		if (item.equalsIgnoreCase("...")) {
			JPanel panel = new JPanel ();
			ReemplazarPanel(panel);
		}
		
		if (item.equalsIgnoreCase("perecedero")){
			RegistrarPerecedero perecedero = new RegistrarPerecedero ();
			ReemplazarPanel(perecedero);
		}
		
		if (item.equalsIgnoreCase("refrigerado")) {
			RegistrarRefrigerado refrigerado = new RegistrarRefrigerado ();
			ReemplazarPanel(refrigerado);
		}
		
		if (item.equalsIgnoreCase("envasado")) {
			RegistrarEnvasado envasado = new RegistrarEnvasado ();
			ReemplazarPanel (envasado);
		}
	}
}

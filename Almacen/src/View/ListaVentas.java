package View;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ListaVentas extends JPanel {
	private JTable tabla;
	private JButton btnActualizar;
	private Component btnDetalles;
	private DefaultTableModel model;

	/**
	 * Create the panel.
	 */
	public ListaVentas() {

		setBorder(new LineBorder(new Color(0, 0, 0), 2));

		setBackground(Color.WHITE);
		setBounds(208, 34, 750, 600);
		setLayout(null);
		
		panelSuperior ();
		tabla ();
		panelInferior ();
		
	}
	
	private void tabla () {
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane.setBounds(0, 49, 750, 511);
		add(scrollPane);
		
		tabla = new JTable();
		
		model = new DefaultTableModel ();
		
		model.addColumn("Codigo");
		model.addColumn("Fecha de Venta");
		model.addColumn("Total Pagado");
		model.addColumn("IVA");
		
		rellenarTabla ();
		
		tabla.setModel(model);
		
		scrollPane.setViewportView(tabla);
	}
	
	private void rellenarTabla() {
		
		
	}

	private void panelSuperior () {
		
		JLabel lblTitulo = new JLabel("Registro de Ventas");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblTitulo.setBounds(10, 11, 223, 27);
		add(lblTitulo);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(621, 17, 102, 23);
		add(btnActualizar);
	}
	
	private void panelInferior () {
		
		btnDetalles = new JButton("Ver Detalles");
		btnDetalles.setBounds(609, 566, 114, 23);
		add(btnDetalles);
	}
}

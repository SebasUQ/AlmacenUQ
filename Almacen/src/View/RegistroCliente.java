package View;

import java.awt.Color;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import Model.Cliente;
import Model.biblioteca;

import javax.swing.event.ChangeEvent;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class RegistroCliente extends JPanel implements ActionListener {

	private JButton btnRNatural;
	private JButton btnRJuridico;
	
	private Cliente cliente;
	private VentanaPrincipal principal;
	private biblioteca metodo;
	
	private JTextField txtBusqueda;
	private JButton btnBuscar;
	private JTable tabla;
	private DefaultTableModel model;
	private JScrollPane scrollPane;

	/**
	 * Create the panel.
	 */
	public RegistroCliente(VentanaPrincipal ventana) {

		cliente = new Cliente ();
		this.principal = ventana;
		metodo = new biblioteca ();
		
		setBorder(new LineBorder(new Color(0, 0, 0), 2));

		setBackground(Color.WHITE);
		setBounds(208, 34, 750, 600);
		setLayout(null);
	
		botones ();
		tabla();
		entradasYTitulos ();

	}
	
	private void tabla () {
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(360, 168, 343, 300);
		add(scrollPane);
		
		tabla = new JTable();
		tabla.setShowHorizontalLines(false);
		tabla.setRowSelectionAllowed(false);
		tabla.setEnabled(false);
		
		model = new DefaultTableModel ();
		model.addColumn("Nombre");
		model.addColumn("Apellido");
		model.addColumn("Identificacion");
		
		rellenarTabla();
		
		tabla.setModel(model);
		scrollPane.setViewportView(tabla);
	}
	
	private void rellenarTabla () {
		
		ArrayList <Cliente> clientes = cliente.getListaClientes();
		String fila [] = new String [3];
		
		for (int i = 0; i < clientes.size(); i++) {
			
			Cliente a = clientes.get(i);
			
			fila [0] = a.getNombre();
			fila [1] = a.getApellido();
			fila [2] = "" + a.getId();
			
			model.addRow(fila);
		}
	}
	
	private void devolverBusqueda (int id) {
		
		ArrayList <Cliente> clientes = cliente.getListaClientes();
		String fila [] = new String [3];
		for (int i = 0; i < clientes.size(); i++) {
			Cliente c = clientes.get(i);
			if (c.getId() == id) {
				fila [0] = c.getNombre();
				fila [1] = c.getApellido();
				fila [2] = "" + c.getId();
				
				model.addRow(fila);
			}
		}
	}
	
	private void entradasYTitulos () {
		JLabel Titulo = new JLabel("Por favor escoja el tipo de cliente que desea registrar");
		Titulo.setFont(new Font("Tahoma", Font.BOLD, 22));
		Titulo.setHorizontalAlignment(SwingConstants.CENTER);
		Titulo.setBounds(43, 11, 660, 118);
		add(Titulo);
		
		JLabel lblClientes = new JLabel("Clientes Registrados:");
		lblClientes.setBounds(476, 140, 124, 27);
		add(lblClientes);
		
		txtBusqueda = new JTextField();
		txtBusqueda.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				
				if (c < '0' || c>'9')e.consume();
			}
		});
		txtBusqueda.setColumns(10);
		txtBusqueda.setBounds(398, 490, 185, 20);
		add(txtBusqueda);
		
		JLabel lblNewLabel = new JLabel("*Busqueda solo por id*");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(408, 521, 168, 23);
		add(lblNewLabel);
	}
	
	private void botones () {
		
		btnRNatural = new JButton("Cliente Natural");
		btnRNatural.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRNatural.setBounds(102, 196, 191, 80);
		add(btnRNatural);
		
		btnRJuridico = new JButton("Cliente Juridico");
		btnRJuridico.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRJuridico.setBounds(102, 355, 191, 80);
		add(btnRJuridico);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(593, 489, 84, 23);
		add(btnBuscar);
		
		btnRNatural.addActionListener(this);
		btnRJuridico.addActionListener(this);
		btnBuscar.addActionListener(this);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		
		RegistroCJuridico juridico = new RegistroCJuridico (principal);
		RegistroCNatural natural = new RegistroCNatural(principal);
		
		if (e.getSource() == btnRNatural) {
            principal.ReemplazarPanel(natural );
		}
		
		if (e.getSource() == btnRJuridico) {
			principal.ReemplazarPanel(juridico);
		}
		
		if (e.getSource() == btnBuscar) {
			String busqueda = "";
			busqueda = txtBusqueda.getText();
			
			if (busqueda.equals("")) {
				
			}
			else {		
				int busqueda1 = metodo.leerEntero(busqueda);
				
				if (cliente.verificarCliente(busqueda1)) {
					
					tabla = new JTable();
					tabla.setShowHorizontalLines(false);
					tabla.setRowSelectionAllowed(false);
					tabla.setEnabled(false);
					
					model = new DefaultTableModel ();
					model.addColumn("Nombre");
					model.addColumn("Apellido");
					model.addColumn("Identificacion");
					
					devolverBusqueda(busqueda1);
					
					tabla.setModel(model);
					scrollPane.setViewportView(tabla);
				}
				else {
					metodo.imprimir("Cliente no encontrado");
				}
			}
		}
	}
}

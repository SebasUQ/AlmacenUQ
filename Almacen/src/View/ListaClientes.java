package View;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import Model.Cliente;
import Model.biblioteca;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JTable;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ListaClientes extends JPanel implements ActionListener{
	
	private JTable tabla;
	private JTextField txtBusqueda;
	private JButton btnActualizar;
	private JButton btnBuscar;
	private JButton btnEliminar;
	private DefaultTableModel model;

	private biblioteca metodo;
	private Cliente cliente;
	private JScrollPane scrollPane;
	private JButton btnDetalles;
	/**
	 * Create the panel.
	 */
	public ListaClientes() {

		metodo = new biblioteca ();
		cliente = new Cliente ();
		
		setBorder(new LineBorder(new Color(0, 0, 0), 2));

		setBackground(Color.WHITE);
		setBounds(208, 34, 750, 600);
		setLayout(null);
		
		panelSuperior ();
		tabla ();
		panelInferior ();

	
	}

	private void tabla() {
		scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane.setBounds(0, 49, 750, 511);
		add(scrollPane);
		
		tabla = new JTable();
		tabla.setShowHorizontalLines(false);
		
		model = new DefaultTableModel ();
		
		model.addColumn("Nombre");
		model.addColumn("Apellido");
		model.addColumn("Identificacion");
		model.addColumn("Direccion");
		model.addColumn("Telefono");
		
		rellenarTabla ();
		
		tabla.setModel(model);
		scrollPane.setViewportView(tabla);
	}
	
	private void rellenarTabla () {
		
		ArrayList <Cliente> clientes = cliente.getListaClientes();
		Object fila [] = new Object [5];
		
		for (int i = 0; i < clientes.size(); i++) {
			
			Cliente a = clientes.get(i);
			
			fila [0] = a.getNombre();
			fila [1] = a.getApellido();
			fila [2] = a.getId();
			fila [3] = a.getDireccion();
			fila [4] = a.getTel();
			
			model.addRow(fila);
		}
	}
	
	private void devolverBusqueda (String nombre) {
		
		ArrayList <Cliente> clientes = cliente.getListaClientes();
		Object fila [] = new Object [5];
		
		for (int i = 0; i< clientes.size(); i++) {
			
			Cliente a = clientes.get(i);
			String nombreCompleto = a.getNombre() +" "+ a.getApellido();	
			
			if (nombreCompleto.toLowerCase().contains(nombre.toLowerCase())) {
				
				fila [0] = a.getNombre();
				fila [1] = a.getApellido();
				fila [2] = a.getId();
				fila [3] = a.getDireccion();
				fila [4] = a.getTel();
				
				model.addRow(fila);
			}
		}
	}
	
	private void devolverBusqueda1 (int id) {
		
		ArrayList <Cliente> clientes = cliente.getListaClientes();
		Object fila [] = new Object [5];
		
		for (int i = 0; i< clientes.size(); i++) {
			Cliente a = clientes.get(i);
			if (a.getId() == id) {
				
				fila [0] = a.getNombre();
				fila [1] = a.getApellido();
				fila [2] = a.getId();
				fila [3] = a.getDireccion();
				fila [4] = a.getTel();
				
				model.addRow(fila);
			}
			else {
				metodo.imprimir("Cliente no encontrado");
			}
		}
		
	}

	private void panelSuperior() {
		JLabel lblTitulo = new JLabel("Lista Clientes");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblTitulo.setBounds(10, 11, 147, 27);
		add(lblTitulo);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(420, 17, 89, 23);
		add(btnBuscar);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(621, 17, 102, 23);
		add(btnActualizar);
		
		txtBusqueda = new JTextField();
		txtBusqueda.setBounds(243, 18, 167, 20);
		add(txtBusqueda);
		txtBusqueda.setColumns(10);
		
		btnBuscar.addActionListener(this);
		btnActualizar.addActionListener(this);
	}

	private void panelInferior() {
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(621, 566, 102, 23);
		add(btnEliminar);
		
		btnEliminar.addActionListener(this);
		
		btnDetalles = new JButton("ver Detalles");
		btnDetalles.setBounds(30, 566, 102, 23);
		add(btnDetalles);
		
		btnDetalles.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == btnActualizar) {
			
			tabla.setShowHorizontalLines(false);
			tabla.setEnabled(true);
			scrollPane.setViewportView(tabla);
			
			model = new DefaultTableModel ();
			
			model.addColumn("Nombre");
			model.addColumn("Apellido");
			model.addColumn("Identificacion");
			model.addColumn("Direccion");
			model.addColumn("Telefono");
			
			rellenarTabla ();
			
			tabla.setModel(model);
			
			scrollPane.setViewportView(tabla);
		}
		
		if (e.getSource() == btnEliminar) {
			
			int posicion = tabla.getSelectedRow();

			if (posicion != -1) {
				
				boolean pregunta = metodo.leerBoolean("¿Esta seguro que desea eliminar este cliente?");
				
				if (pregunta == true) {
					DefaultTableModel m = (DefaultTableModel) tabla.getModel();
					int id =  (int) m.getValueAt(posicion, 2);
					cliente.eliminarCliente(id);
					
					tabla.setShowHorizontalLines(false);
					tabla.setEnabled(true);
					scrollPane.setViewportView(tabla);
					
					model = new DefaultTableModel ();
					
					model.addColumn("Nombre");
					model.addColumn("Apellido");
					model.addColumn("Identificacion");
					model.addColumn("Direccion");
					model.addColumn("Telefono");
					
					rellenarTabla ();
					
					tabla.setModel(model);
					
					scrollPane.setViewportView(tabla);
				}
			}
			else {
				metodo.imprimir("Por favor, primero seleccione al usuario que desea eliminar");
			}
		}
		
		if (e.getSource() == btnBuscar) {
			String busqueda = txtBusqueda.getText();
			
			if (busqueda.equals("")) {
				
			}
			else {
				if (metodo.isNumericD(busqueda)) {
					
					int id = metodo.leerEntero(busqueda);
					
					tabla.setShowHorizontalLines(false);
					tabla.setEnabled(true);
					scrollPane.setViewportView(tabla);
					
					model = new DefaultTableModel ();
					
					model.addColumn("Nombre");
					model.addColumn("Apellido");
					model.addColumn("Identificacion");
					model.addColumn("Direccion");
					model.addColumn("Telefono");
					
					devolverBusqueda1 (id);
					
					tabla.setModel(model);
					
					scrollPane.setViewportView(tabla);
				}
				else {
					tabla.setShowHorizontalLines(false);
					tabla.setEnabled(true);
					scrollPane.setViewportView(tabla);
					
					model = new DefaultTableModel ();
					
					model.addColumn("Nombre");
					model.addColumn("Apellido");
					model.addColumn("Identificacion");
					model.addColumn("Direccion");
					model.addColumn("Telefono");
					
					devolverBusqueda (busqueda);
					
					tabla.setModel(model);
					
					scrollPane.setViewportView(tabla);
				}
			}			
		}
		
		if (e.getSource() == btnDetalles) {
			
			int posicion = tabla.getSelectedRow();

			if (posicion != -1) {
				
				DefaultTableModel m = (DefaultTableModel) tabla.getModel();
				int id =  (int) m.getValueAt(posicion, 2);
				cliente.verDetalles(id);
			}
		}
	}
}

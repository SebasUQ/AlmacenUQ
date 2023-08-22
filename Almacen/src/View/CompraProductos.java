package View;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import Model.Producto;
import Model.biblioteca;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CompraProductos extends JPanel implements ActionListener{
	
	private JTextField txtId;
	private JTextField txtFecha;
	private JTextField txtNombreP;
	private JTextField txtCantidad;
	private JTable Compras;
	private DefaultTableModel model;
	
	private Producto producto;
	private biblioteca metodo;
	
	private JTable Productos;
	private DefaultTableModel model1;
	private JButton btnComprar;
	private JButton btnAnadir;
	private JScrollPane ListaCompras;
	private JScrollPane ListaProductos;
	
	private static ArrayList <String []> lista = new ArrayList <>();
	
	/**
	 * Create the panel.
	 */
	public CompraProductos() {
		
		producto = new Producto ();
		metodo = new biblioteca ();

		setBorder(new LineBorder(new Color(0, 0, 0), 2));

		setBackground(Color.WHITE);
		setBounds(208, 34, 750, 600);
		setLayout(null);
		
		panelSuperior ();
		datosCliente ();
		Listas ();
		datosProducto ();
	}
	
	private void panelSuperior () {
		
		JLabel lblTitulo = new JLabel("Compra de Productos");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblTitulo.setBounds(10, 11, 236, 27);
		add(lblTitulo);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(10, 49, 730, 20);
		add(separator);
	}
	
	private void Listas () {
		
		ListaCompras = new JScrollPane();
		ListaCompras.setBounds(353, 148, 180, 301);
		add(ListaCompras);
		
		Compras = new JTable();
		
		model = new DefaultTableModel ();
		model.addColumn("Producto");
		model.addColumn("Cantidad");
		
		rellenarListaC ();
		
		Compras.setModel(model);
		
		Compras.setShowHorizontalLines(false);
		Compras.setRowSelectionAllowed(false);
		Compras.setEnabled(false);
		ListaCompras.setViewportView(Compras);
	
		
		
		ListaProductos = new JScrollPane();
		ListaProductos.setBounds(543, 148, 180, 301);
		add(ListaProductos);
		
		Productos = new JTable();
		
		model1 = new DefaultTableModel ();
		model1.addColumn("Producto");
		model1.addColumn("Valor Unitario");
		
		rellenarListaP ();
		
		Productos.setModel(model1);;
		
		Productos.setShowHorizontalLines(false);
		Productos.setRowSelectionAllowed(false);
		Productos.setEnabled(false);
		ListaProductos.setViewportView(Productos);
	}
	
	private void rellenarListaC () {
		
		for (int i = 0; i< lista.size(); i++) {
			String [] fila = lista.get(i);
			
			model.addRow(fila);
		}
	}
	
	private void rellenarListaP() {
		
		ArrayList <Producto> productos = producto.getListaProducto();
		
		for (int i = 0; i< productos.size();i++) {
			
			String fila [] = new String [2];
			Producto p = productos.get(i);
			fila [0] = p.getNomProducto();
			fila [1] = "$ "+p.getValorU();
			
			model1.addRow(fila);
		}
	}
		
	
	private void datosProducto () {
		
		JLabel lblDatosDelProducto = new JLabel("Datos del Producto");
		lblDatosDelProducto.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDatosDelProducto.setBounds(10, 80, 194, 27);
		add(lblDatosDelProducto);
		
		JLabel lblNombreP = new JLabel("Nombre del Producto: ");
		lblNombreP.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNombreP.setBounds(10, 148, 180, 27);
		add(lblNombreP);
		
		txtNombreP = new JTextField();
		txtNombreP.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				
				if((c < 'a'|| c >'z')&& (c <'A' || c >'Z'))e.consume();
			}
		});
		txtNombreP.setColumns(10);
		txtNombreP.setBounds(187, 153, 149, 20);
		add(txtNombreP);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCantidad.setBounds(54, 199, 123, 27);
		add(lblCantidad);
		
		txtCantidad = new JTextField();
		txtCantidad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				
				if (c < '0' || c>'9')e.consume();
			}
		});
		txtCantidad.setColumns(10);
		txtCantidad.setBounds(187, 204, 149, 20);
		add(txtCantidad);
		
		JLabel lblListaCompras = new JLabel("Carrito de Compras");
		lblListaCompras.setBounds(390, 117, 123, 20);
		add(lblListaCompras);
		
		JLabel lblProductosDisponibles = new JLabel("Productos Disponibles");
		lblProductosDisponibles.setBounds(566, 117, 141, 20);
		add(lblProductosDisponibles);
		
		btnAnadir = new JButton("Añadir");
		btnAnadir.setBounds(258, 253, 78, 23);
		add(btnAnadir);
		
		btnAnadir.addActionListener(this);
		
		JLabel lblTotal = new JLabel("");
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTotal.setBounds(54, 384, 212, 27);
		add(lblTotal);
		
	}
	
	private void datosCliente () {
		JLabel lblSubTitulo = new JLabel("Datos Cliente");
		lblSubTitulo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSubTitulo.setBounds(10, 473, 133, 27);
		add(lblSubTitulo);
		
		JLabel lblId = new JLabel("Identificacion: ");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblId.setBounds(10, 511, 133, 27);
		add(lblId);
		
		txtId = new JTextField();
		txtId.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				
				if (c < '0' || c>'9')e.consume();
			}
		});
		txtId.setColumns(10);
		txtId.setBounds(10, 537, 149, 20);
		add(txtId);
		
		JLabel lblFecha = new JLabel("Fecha de Compra:");
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFecha.setBounds(187, 511, 149, 27);
		add(lblFecha);
		
		txtFecha = new JTextField();
		txtFecha.setHorizontalAlignment(SwingConstants.CENTER);
		txtFecha.setText("DD / MM / AA ");
		txtFecha.setColumns(10);
		txtFecha.setBounds(187, 537, 149, 20);
		add(txtFecha);
		
		btnComprar = new JButton("Realizar Compra");
		btnComprar.setBounds(473, 500, 133, 53);
		add(btnComprar);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == btnAnadir) {
			
			String nombreP = txtNombreP.getText();
			String cantidad = txtCantidad.getText();
			String [] fila = new String [2];
			fila[0] = nombreP;
			fila[1] = cantidad;
			lista.add(fila);
		
			Compras = new JTable();
			
			model = new DefaultTableModel ();
			model.addColumn("Producto");
			model.addColumn("Cantidad");
			
			rellenarListaC ();
			
			Compras.setModel(model);
			
			Compras.setShowHorizontalLines(false);
			Compras.setRowSelectionAllowed(false);
			Compras.setEnabled(false);
			ListaCompras.setViewportView(Compras);
			
			txtNombreP.setText("");
			txtCantidad.setText("");
		}
	}
}

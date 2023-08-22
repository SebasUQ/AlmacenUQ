package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.LineBorder;

import Model.biblioteca;

public class VentanaPrincipal extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JPanel panel;
	
	private JButton btnRegistrarC;
	private JButton btnRegistrarP;
	private JButton btnComprar;
	private JButton btnClientes;
	private JButton btnVentas;
	
	private biblioteca metodo;
	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		
		metodo = new biblioteca ();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panelCambiante ();
		Botones ();
		
		setTitle("Ventana Principal");
		setResizable (false);
		setLocationRelativeTo (null);
	}
	
	private void panelCambiante () {
		
		
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setForeground(Color.BLACK);
		panel.setBackground(Color.WHITE);
		panel.setBounds(208, 34, 750, 600);
		contentPane.add(panel);
		panel.setLayout(null);
	
	}
	
	private void Botones () {
		
		btnRegistrarC = new JButton("Registro Clientes");
		btnRegistrarC.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRegistrarC.setBounds(10, 34, 188, 69);
		contentPane.add(btnRegistrarC);
		{
			btnComprar = new JButton("Comprar");
			btnComprar.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnComprar.setBounds(10, 114, 188, 69);
			contentPane.add(btnComprar);
		}
		
		btnRegistrarP = new JButton("Registrar Productos");
		btnRegistrarP.setBounds(10, 565, 188, 69);
		contentPane.add(btnRegistrarP);
		btnRegistrarP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		{
			btnClientes = new JButton("Lista Clientes");
			btnClientes.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnClientes.setBounds(10, 485, 188, 69);
			contentPane.add(btnClientes);
		}
		{
			btnVentas = new JButton("Lista Ventas");
			btnVentas.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnVentas.setBounds(10, 405, 188, 69);
			contentPane.add(btnVentas);
		}
		
		btnRegistrarC.addActionListener (this);
		btnComprar.addActionListener(this);
		btnRegistrarP.addActionListener(this);
		btnClientes.addActionListener(this);
		btnVentas.addActionListener(this);
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
		
		
		if (e.getSource()  == btnRegistrarC) {
			RegistroCliente nuevoPanel = new RegistroCliente (this);
			ReemplazarPanel (nuevoPanel);
		}
		
		if (e.getSource() == btnClientes) {
			String respuesta = "1004960376";
			String entrada = metodo.leerString("Ingrese la Clave de seguridad:");
			
			if (entrada != null && entrada.equals(respuesta)) {
				ListaClientes clientes = new ListaClientes();
				ReemplazarPanel (clientes);
			}
			else {
				if (entrada == null || entrada.equals("")) {
					
				}
				else {
					metodo.imprimir("Clave denegada");
				}
			}
		}
		if (e.getSource() == btnVentas) {
			String respuesta = "1004960376";
			String entrada = metodo.leerString("Ingrese la Clave de seguridad:");
			
			if (entrada != null && entrada.equals(respuesta)) {
				ListaVentas ventas = new ListaVentas();
				ReemplazarPanel (ventas);
			}
			else {
				if (entrada == null || entrada.equals("")) {
					
				}
				else {
					metodo.imprimir("Clave denegada");
				}
			}
		}
		
		if (e.getSource() == btnComprar) {
			CompraProductos compra = new CompraProductos ();
			ReemplazarPanel (compra);
			metodo.imprimir("Antes de realizar cualquier compra por favor asegurese de estar registrado como cliente");
		}
		
		if (e.getSource() == btnRegistrarP) {
			
			String respuesta = "1004960376";
			String entrada = metodo.leerString("Ingrese la Clave de seguridad:");
			
			if (entrada != null && entrada.equals(respuesta)) {
				RegistroProducto producto = new RegistroProducto();
				ReemplazarPanel (producto);
			}
			else {
				if (entrada == null || entrada.equals("")) {
					
				}
				else {
					metodo.imprimir("Clave denegada");
				}
			}
		}
	}
}

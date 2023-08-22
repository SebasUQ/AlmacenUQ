package View;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import Model.ProductoPerecedero;
import Model.biblioteca;

import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class RegistrarPerecedero extends JPanel implements ActionListener{
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtCantidad;
	private JTextField txtValor;
	private JTextField txtFecha;
	private JTextPane txtDescripcion;
	private JButton btnRegistrar;

	private biblioteca metodo;
	private ProductoPerecedero p;
	
	/**
	 * Create the panel.
	 */
	public RegistrarPerecedero() {

		p = new ProductoPerecedero ();
		metodo = new biblioteca ();
		
		setBounds(20, 146, 707, 431);
		setLayout(null);
		
		labels();
		entradas ();
	}
	
	private void entradas () {
		txtCodigo = new JTextField();
		txtCodigo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				
				if (c < '0' || c>'9')e.consume();
			}
		});
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(32, 74, 106, 20);
		add(txtCodigo);
		
		txtNombre = new JTextField();
		txtNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				
				if((c < 'a'|| c >'z')&& (c <'A' || c >'Z'))e.consume();
			}
		});
		txtNombre.setColumns(10);
		txtNombre.setBounds(202, 74, 106, 20);
		add(txtNombre);
		
		txtCantidad = new JTextField();
		txtCantidad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				
				if (c < '0' || c>'9')e.consume();
			}
		});
		txtCantidad.setColumns(10);
		txtCantidad.setBounds(32, 282, 106, 20);
		add(txtCantidad);
		
		txtValor = new JTextField();
		txtValor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				
				if (c < '0' || c>'9')e.consume();
			}
		});
		txtValor.setColumns(10);
		txtValor.setBounds(202, 282, 106, 20);
		add(txtValor);
		
		txtFecha = new JTextField();
		txtFecha.setColumns(10);
		txtFecha.setBounds(544, 51, 106, 20);
		add(txtFecha);
		
		txtDescripcion = new JTextPane();
		txtDescripcion.setBounds(32, 147, 274, 87);
		add(txtDescripcion);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(440, 307, 139, 53);
		add(btnRegistrar);
		
		btnRegistrar.addActionListener(this);
	}
	
	private void labels () {
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCodigo.setBounds(32, 46, 106, 26);
		add(lblCodigo);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNombre.setBounds(202, 46, 106, 26);
		add(lblNombre);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDescripcion.setBounds(32, 119, 106, 26);
		add(lblDescripcion);
		
		JLabel lblValor = new JLabel("Valor Unitario:");
		lblValor.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblValor.setBounds(202, 257, 139, 26);
		add(lblValor);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCantidad.setBounds(32, 257, 106, 26);
		add(lblCantidad);
		
		JLabel lblVencimiento = new JLabel("Fecha de Vencimiento:");
		lblVencimiento.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblVencimiento.setBounds(374, 46, 208, 26);
		add(lblVencimiento);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String nombrep ="", codigo ="", descripcion = "", valor = "", cantidad="", fechaV = "";
		
		if (e.getSource() == btnRegistrar) {
			codigo = txtCodigo.getText();
			nombrep = txtNombre.getText();
			descripcion = txtDescripcion.getText();
			valor = txtValor.getText();
			cantidad = txtCantidad.getText();
			fechaV = txtFecha.getText();
			
			if (nombrep.equalsIgnoreCase("") || codigo.equalsIgnoreCase("") || descripcion.equalsIgnoreCase("") || valor.equalsIgnoreCase("") || 
				cantidad.equalsIgnoreCase("") || fechaV.equalsIgnoreCase("")) {
				
				metodo.imprimir("Por favor ingrese los datos del producto primero primero");
				
			}
			else {
				int codigo1 = metodo.leerEntero(codigo) ;
				double valorU = metodo.leerDouble(valor);
				int cantidadE = metodo.leerEntero(cantidad);
				
				p.registrarPerecedero(codigo1, nombrep, descripcion, valorU, cantidadE, fechaV);;
				
				metodo.imprimir("Producto registrado correctamente");
				
				txtCodigo.setText("");
				txtNombre.setText("");
				txtDescripcion.setText("");
				txtValor.setText("");
				txtCantidad.setText("");
				txtFecha.setText("");
			}
		}
		
	}

}

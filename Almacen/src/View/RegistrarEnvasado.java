package View;

import java.awt.Component;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import Model.ProductoEnvasado;
import Model.biblioteca;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class RegistrarEnvasado extends JPanel implements ActionListener {

	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtCantidad;
	private JTextField txtValor;
	private JTextField txtFechaE;
	private JTextPane txtDescripcion;
	private JTextField txtPesoE;
	private JButton btnRegistrar;
	private JTextField txtPais;
	
	biblioteca metodo;
	ProductoEnvasado p;

	/**
	 * Create the panel.
	 */
	public RegistrarEnvasado() {

		p = new ProductoEnvasado ();
		metodo = new biblioteca ();
		
		setBounds(20, 146, 707, 431);
		setLayout(null);
		
		labels();
		entradas ();
	}

	private void entradas() {
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
		
		txtFechaE = new JTextField();
		txtFechaE.setColumns(10);
		txtFechaE.setBounds(544, 51, 106, 20);
		add(txtFechaE);
		
		txtDescripcion = new JTextPane();
		txtDescripcion.setBounds(32, 147, 274, 87);
		add(txtDescripcion);
		
		txtPesoE = new JTextField();
		txtPesoE.setColumns(10);
		txtPesoE.setBounds(544, 124, 106, 20);
		add(txtPesoE);
				
		txtPais = new JTextField();
		txtPais.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				
				if((c < 'a'|| c >'z')&& (c <'A' || c >'Z'))e.consume();
			}
		});
		txtPais.setColumns(10);
		txtPais.setBounds(544, 195, 106, 20);
		add(txtPais);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(440, 307, 139, 53);
		add(btnRegistrar);
		
		btnRegistrar.addActionListener(this);
	}

	private void labels() {
		JLabel lblPesoE = new JLabel("Peso del Envase:");
		lblPesoE.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPesoE.setBounds(374, 119, 208, 26);
		add(lblPesoE);
		
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
		
		JLabel lblFechaE = new JLabel("Fecha de Envasado:");
		lblFechaE.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFechaE.setBounds(374, 46, 208, 26);
		add(lblFechaE);
		
		JLabel lblPais = new JLabel("Pais de Origen:");
		lblPais.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPais.setBounds(374, 190, 208, 26);
		add(lblPais);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String nombrep ="", codigo ="", descripcion = "", valor = "", cantidad="", fechaE = "", pais = "", pesoE = "";
		
		if (e.getSource() == btnRegistrar) {
			codigo = txtCodigo.getText();
			nombrep = txtNombre.getText();
			descripcion = txtDescripcion.getText();
			valor = txtValor.getText();
			cantidad = txtCantidad.getText();
			fechaE = txtFechaE.getText();
			pais = txtPais.getText();
			pesoE = txtPesoE.getText();
			
			if (nombrep.equalsIgnoreCase("") || codigo.equalsIgnoreCase("") || descripcion.equalsIgnoreCase("") || valor.equalsIgnoreCase("") || 
				cantidad.equalsIgnoreCase("") || fechaE.equalsIgnoreCase("") || pais.equalsIgnoreCase("") || pesoE.equalsIgnoreCase("")) {
				
				metodo.imprimir("Por favor ingrese los datos del producto primero primero");
				
			}
			else {
				int codigo1 = metodo.leerEntero(codigo) ;
				double valorU = metodo.leerDouble(valor);
				int cantidadE = metodo.leerEntero(cantidad);
				double peso = metodo.leerDouble(pesoE);
				
				p.registrarEnvasado(codigo1, nombrep, descripcion, valorU, cantidadE, fechaE, peso, pais);;
				
				metodo.imprimir("Producto registrado correctamente");
				
				txtCodigo.setText("");
				txtNombre.setText("");
				txtDescripcion.setText("");
				txtValor.setText("");
				txtCantidad.setText("");
				txtFechaE.setText("");
				txtPais.setText("");
				txtPesoE.setText("");
			}
		}
		
	}

}

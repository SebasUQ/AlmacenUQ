package View;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import Model.Cliente;
import Model.ClienteNatural;
import Model.biblioteca;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class RegistroCNatural extends JPanel implements ActionListener{
	
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtId;
	private JTextField txtDireccion;
	private JTextField txtTel;
	private JTextField txtEmail;
	private JTextField txtNacimiento;
	private JButton btnRegistrar;
	private JLabel lblClienteNatural;

	private VentanaPrincipal principal;
	private ClienteNatural c;
	private biblioteca metodo;
	
	private JButton btnRegresar;
	/**
	 * Create the panel.
	 * @param ventana 
	 */
	public RegistroCNatural(VentanaPrincipal ventana) {
		
		this.principal = ventana;
		c = new ClienteNatural();
		metodo = new biblioteca ();
		
		setBorder(new LineBorder(new Color(0, 0, 0), 2));

		setBackground(Color.WHITE);
		setBounds(208, 34, 750, 600);
		setLayout(null);
		
		labels();
		entradas();
		botones ();
	}
	

	private void labels () {
		
		JLabel lblNombre = new JLabel("Nombre(s):");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNombre.setBounds(199, 128, 131, 27);
		add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido(s):");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblApellido.setBounds(393, 128, 158, 27);
		add(lblApellido);
		
		JLabel lblNumeroDeIdentificacion = new JLabel("# Identificacion: ");
		lblNumeroDeIdentificacion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNumeroDeIdentificacion.setBounds(199, 206, 168, 27);
		add(lblNumeroDeIdentificacion);
		
		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDireccion.setBounds(392, 206, 158, 27);
		add(lblDireccion);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTelefono.setBounds(199, 283, 158, 27);
		add(lblTelefono);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEmail.setBounds(393, 286, 158, 27);
		add(lblEmail);
		
		JLabel lblFechaDeNacimineto = new JLabel("Fecha de Nacimineto:");
		lblFechaDeNacimineto.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFechaDeNacimineto.setBounds(199, 383, 194, 27);
		add(lblFechaDeNacimineto);
		
		lblClienteNatural = new JLabel("Registro de Cliente Natural");
		lblClienteNatural.setHorizontalAlignment(SwingConstants.CENTER);
		lblClienteNatural.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblClienteNatural.setBounds(153, 25, 444, 57);
		add(lblClienteNatural);
		
	}
	
	private void entradas () {
		
		txtNombre = new JTextField();
		txtNombre.setBounds(199, 160, 168, 27);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(393, 160, 168, 27);
		add(txtApellido);
		
		txtId = new JTextField();
		txtId.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				
				if (c < '0' || c>'9')e.consume();
			}
		});
		txtId.setColumns(10);
		txtId.setBounds(199, 238, 168, 27);
		add(txtId);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(392, 240, 168, 27);
		add(txtDireccion);
		
		txtTel = new JTextField();
		txtTel.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				
				if (c < '0' || c>'9')e.consume();
			}
		});
		txtTel.setColumns(10);
		txtTel.setBounds(199, 317, 168, 27);
		add(txtTel);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(393, 317, 168, 27);
		add(txtEmail);
		
		txtNacimiento = new JTextField();
		txtNacimiento.setHorizontalAlignment(SwingConstants.CENTER);
		txtNacimiento.setText("DD/MM/AA");
		txtNacimiento.setColumns(10);
		txtNacimiento.setBounds(393, 383, 168, 27);
		add(txtNacimiento);
	}
	
	private void botones () {
	
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRegistrar.setBounds(298, 464, 168, 57);
		add(btnRegistrar);
		
		btnRegresar = new JButton("Regresar");
		btnRegresar.setBounds(29, 48, 89, 23);
		add(btnRegresar);
		
		btnRegresar.addActionListener(this);
		btnRegistrar.addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
	
		if (e.getSource() == btnRegresar) {
            principal.ReemplazarPanel(new RegistroCliente(principal));
		}
		
		if (e.getSource() == btnRegistrar) {
			
			String nombre = "", id ="", apellido ="", direccion ="", telefono ="", nacimiento ="", email ="";
			nombre = txtNombre.getText();
			apellido = txtApellido.getText();
			id = txtId.getText();
			direccion = txtDireccion.getText();
			telefono = txtTel.getText();
			nacimiento = txtNacimiento.getText();
			email = txtEmail.getText();
			
			int id1;
			Long tel1;
			
			if(nombre.equals("") || apellido.equals("") || id.equals("") || direccion.equals("") || telefono.equals("") || nacimiento.equals("")
			   || email.equals("")) {
				
				metodo.imprimir("Por favor ingrese todos los datos primero");
			}
			else {

				id1 = metodo.leerEntero(id);
				tel1 = metodo.leerLong(telefono);
				
				if (c.verificarCliente(id1) == false) {
					
					if (metodo.isNumericD(nombre) == false && metodo.isNumericD(apellido) == false) {
						
						c.RegistrarClienteN(nombre, apellido, id1, direccion, tel1, email, nacimiento);
						txtNombre.setText("");
						txtApellido.setText("");
						txtId.setText("");
						txtDireccion.setText("");
						txtTel.setText("");
						txtEmail.setText("");
						txtNacimiento.setText("");
						
						metodo.imprimir("Cliente registrado correctamente");
						
						principal.ReemplazarPanel(new RegistroCliente (principal));
					}
					else {
						metodo.imprimir("Error: ingreso de datos invalido");
					}
				}
				else {
					metodo.imprimir("El cliente ya se encuentra registrado.");
				}
			}			
		}
	}
}

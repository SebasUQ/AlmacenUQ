package View;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import Model.Cliente;
import Model.ClienteJuridico;
import Model.biblioteca;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class RegistroCJuridico extends JPanel implements ActionListener{

	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtId;
	private JTextField txtDireccion;
	private JTextField txtTel;
	private JTextField txtNit;
	private JButton btnRegistrar;
	
	private VentanaPrincipal principal;
	private biblioteca metodo;
	private ClienteJuridico c;
	
	private JButton btnRegresar;
	
	/**
	 * Create the panel.
	 */
	public RegistroCJuridico(VentanaPrincipal ventana) {
	
		this.principal = ventana;
		metodo = new biblioteca ();
		c = new ClienteJuridico ();
		
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
		lblNombre.setBounds(195, 129, 131, 27);
		add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido(s):");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblApellido.setBounds(393, 129, 158, 27);
		add(lblApellido);
		
		JLabel lblNumeroDeIdentificacion = new JLabel("# Identificacion: ");
		lblNumeroDeIdentificacion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNumeroDeIdentificacion.setBounds(195, 198, 168, 27);
		add(lblNumeroDeIdentificacion);
		
		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDireccion.setBounds(393, 198, 158, 27);
		add(lblDireccion);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTelefono.setBounds(195, 274, 158, 27);
		add(lblTelefono);
		
		JLabel lblNit = new JLabel("Nit:");
		lblNit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNit.setBounds(393, 274, 158, 27);
		add(lblNit);
		
		JLabel lblNewLabel = new JLabel("Registro de Cliente Juridico");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(153, 25, 444, 57);
		add(lblNewLabel);
	}
	
	private void entradas () {
		
		txtNombre = new JTextField();
		txtNombre.setBounds(195, 158, 168, 27);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(393, 158, 168, 27);
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
		txtId.setBounds(195, 227, 168, 27);
		add(txtId);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(393, 227, 168, 27);
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
		txtTel.setBounds(195, 303, 168, 27);
		add(txtTel);
		
		txtNit = new JTextField();
		txtNit.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				
				if (c < '0' || c>'9')e.consume();
			}
		});
		txtNit.setColumns(10);
		txtNit.setBounds(393, 303, 168, 27);
		add(txtNit);
	}
	
	private void botones () {
	
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRegistrar.setBounds(303, 466, 168, 57);
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
			principal.ReemplazarPanel(new RegistroCliente (principal));
		}
	
		if (e.getSource() == btnRegistrar) {
			
			String nombre = "", id = "", apellido = "", direccion = "", telefono = "", nit = "";
			nombre = txtNombre.getText();
			apellido = txtApellido.getText();
			id = txtId.getText();
			direccion = txtDireccion.getText();
			telefono = txtTel.getText();
			nit = txtNit.getText();
			
			int id1 , nit1;
			Long tel1;
			
			if(nombre.equals("") || apellido.equals("") || id.equals("") || direccion.equals("") || telefono.equals("") || nit.equals("")) {
				
				metodo.imprimir("Por favor ingrese todos los datos primero");
			}
			else {
				id1 = metodo.leerEntero(id);
				nit1 = metodo.leerEntero(nit);
				tel1 = metodo.leerLong(telefono);
				
				if (c.verificarCliente(id1) == false) {
					
					if (metodo.isNumericD(nombre) == false && metodo.isNumericD(apellido) == false) {
						
						c.RegistrarClienteJ(nombre, apellido, id1, direccion, tel1, nit1);
						txtNombre.setText("");
						txtApellido.setText("");
						txtId.setText("");
						txtDireccion.setText("");
						txtTel.setText("");
						txtNit.setText("");

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

package PVideos;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VGenerales extends JFrame implements ActionListener {
	private JLabel lbl_id, lbl_titulo, lbl_autor, lbl_mensaje;
	private JTextField tf_id, tf_titulo, tf_autor;
	private JButton btn_aceptar, btn_borrar, btn_imprimir, btn_eliminar, btn_buscar, btn_modificar;
	private alumno[] alumno;
	private int indice, i_buscar;
	public VGenerales () {
		super ();
		setTitle ("Datos generales");
		setSize (500,200);
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 lbl_id = new JLabel("Id:"); 
		 lbl_titulo = new JLabel("Titulo:");
		 lbl_autor = new JLabel("Autor:");
		 lbl_mensaje = new JLabel("");
		 tf_id = new JTextField(10);
		 tf_titulo = new JTextField(20);
		 tf_autor = new JTextField(20);
		 btn_aceptar = new JButton("Aceptar");
		 btn_aceptar.addActionListener(this);
		 btn_borrar = new JButton("Borrar");
		 btn_borrar.addActionListener(this);
		 btn_imprimir = new JButton("Imprimir");
		 btn_imprimir.addActionListener(this);
		 btn_eliminar = new JButton("Eliminar");
		 btn_eliminar.addActionListener(this);
		 btn_buscar = new JButton("Buscar");
		 btn_buscar.addActionListener(this);
		 btn_modificar = new JButton("Modificar");
		 btn_modificar.addActionListener(this);
		 btn_modificar.setEnabled(false);
		 add (lbl_id);
		 add (tf_id);
		 add (lbl_titulo);
		 add (tf_titulo);
		 add (lbl_autor);
		 add (tf_autor);
		 add (btn_aceptar);
		 add (btn_buscar);
		 add (btn_eliminar);
		 add (btn_modificar);
		 add (btn_borrar);
		 add (btn_imprimir);
		 add (lbl_mensaje);
		 indice = 0;
		 i_buscar = -1;
		alumno = new alumno[3];
		setVisible(true);
	}

	public static void main(String[] args) {
		VGenerales ventana = new VGenerales();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn_aceptar) {
			alumno [indice] = new alumno();
			alumno[indice].setId(tf_id.getText());
			alumno[indice].setTitulo(tf_titulo.getText());
			alumno[indice].setAutor(tf_autor.getText());
			indice++;
			lbl_mensaje.setText("Alumno agregado");
		}
		if (e.getSource()== btn_imprimir) {
			for (int i=0; i<3; i++)
				System.out.println(alumno[i].toString());
			//lbl_mensaje.setText("Matricula: "+ matricula + "Nombre: " + nombre + "Direccion: " + direccion);
		}
		if (e.getSource()== btn_borrar) {
			tf_id.setText("");
			tf_titulo.setText("");
		    tf_autor.setText("");
		    lbl_mensaje.setText("");
		}
		if (e.getSource()== btn_eliminar) {
			int i_borrar = -1;
			String a_borrar = "";
			a_borrar = tf_id.getText().toString();
			for (int i=0; i<3;i++) {
				if (alumno [i].getId().equals(a_borrar)) {
					i_borrar = i;
				}
			}
			if (i_borrar == -1) {
				lbl_mensaje.setText("No se encontro la matricula");
			} else {
				for (int i=i_borrar; i<2; i++) {
					alumno[i] = alumno [i+1];
				}
				indice --;
				lbl_mensaje.setText("Alumno eliminado");
			}
		}
	if (e.getSource ()==btn_buscar) {
		int i_buscar = -1;
		String a_buscar = "";
		a_buscar = tf_id.getText().toString();
		for (int i=0; i<3;i++) {
			if (alumno [i].getId().equals(a_buscar)) {
				i_buscar = i;
				}
			}
		if (i_buscar== -1) {
			lbl_mensaje.setText("No se encontro la matricula");
		} else {
			tf_id.setText(alumno [i_buscar].getId());
			tf_titulo.setText(alumno [i_buscar].getTitulo());
			tf_autor.setText(alumno[i_buscar].getAutor());
			btn_modificar.setEnabled(true);

			}
	}if (e.getSource ()==btn_modificar) {
		int i_buscar = -1;
		String a_buscar = "";
		a_buscar = tf_id.getText().toString();
		for (int i=0; i<3;i++) {
			if (alumno [i].getId().equals(a_buscar)) {
				i_buscar = i;
				}

	   alumno [i_buscar].setId(tf_id.getText().toString());
	   alumno[i_buscar].setTitulo(tf_titulo.getText().toString());
	   alumno[i_buscar].setAutor(tf_autor.getText().toString());
	   lbl_mensaje.setText("Alumno modificado");
		}
	}
}
	}

	

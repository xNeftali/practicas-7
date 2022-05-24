package PVideos;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VArchivoModificar extends JFrame implements ActionListener {

	private JLabel lbl_id, lbl_titulo, lbl_autor, lbl_mensaje,lbl_categoria,lbl_reseña;
	private JTextField tf_id, tf_titulo, tf_autor,tf_categoria,tf_reseña;
	private JButton btn_borrar, btn_imprimir,btn_modificar, btn_buscar;
	private alumno[] alumno;
	private indice indice;
	public VArchivoModificar(alumno [] alumno, indice indice) {
		super();
		setTitle("Modificar");
		setSize(700,200);
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		lbl_id = new JLabel("ID:");
		lbl_titulo = new JLabel("Titulo:");
		lbl_autor = new JLabel("Autor:");
		lbl_categoria = new JLabel("Categoria:");
		lbl_reseña = new JLabel("Reseña:");
		lbl_mensaje = new JLabel("");
		tf_id = new JTextField(15);
		tf_titulo = new JTextField(20);
		tf_autor = new JTextField(15);
		tf_categoria = new JTextField(15);
		tf_reseña = new JTextField(30);
		
		btn_modificar = new JButton("Modificar");
		btn_modificar.addActionListener(this);
		btn_borrar = new JButton("Borrar");
		btn_borrar.addActionListener(this);
		btn_imprimir = new JButton("Imprimir");
		btn_imprimir.addActionListener(this);
		btn_buscar = new JButton("Buscar");
		btn_buscar.addActionListener(this);
		
		
		add(lbl_id);
		add(tf_id);
		
		add(lbl_titulo);
		add(tf_titulo);
		
		add(lbl_autor);
		add(tf_autor);

		add(lbl_categoria);
		add(tf_categoria);
		
		add(lbl_reseña);
		add(tf_reseña);
		
		add(btn_buscar);
		add (btn_modificar);
		add(btn_borrar);
		add(btn_imprimir);
		
		add(lbl_mensaje);
		
		this.alumno = alumno;
		this.indice = indice;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource()== btn_imprimir) {
			for (int i=0; i<3; i++)
				System.out.println(alumno[i].toString());
			}
		if (e.getSource()== btn_borrar) {
			tf_id.setText("");
			tf_titulo.setText("");
		    tf_autor.setText("");
		    tf_categoria.setText("");
		    tf_reseña.setText("");
		    lbl_mensaje.setText("");
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
				lbl_mensaje.setText("No se encontro la identificación");
			} else {
				tf_id.setText(alumno [i_buscar].getId());
				tf_titulo.setText(alumno [i_buscar].getTitulo());
				tf_autor.setText(alumno[i_buscar].getAutor());
				tf_categoria.setText(alumno[i_buscar].getAutor());
				tf_reseña.setText(alumno[i_buscar].getAutor());
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
		   alumno[i_buscar].setCategoria(tf_categoria.getText().toString());
		   alumno[i_buscar].setReseña(tf_reseña.getText().toString());
		   lbl_mensaje.setText("Libro editado");
			}
		
		}
	}
	
}

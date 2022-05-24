package PVideos;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VArchivoAgregar extends JFrame implements ActionListener {

	private JLabel lbl_id, lbl_titulo, lbl_autor, lbl_mensaje, lbl_categoria, lbl_reseña;
	private JTextField tf_id, tf_titulo, tf_autor, tf_categoria, tf_reseña;
	private JButton btn_aceptar, btn_borrar, btn_imprimir;
	private alumno[] alumno;
	private indice indice;
	public VArchivoAgregar(alumno [] alumno, indice indice) {
		super();
		setTitle("Agregar");
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
		btn_aceptar = new JButton("Aceptar");
		btn_aceptar.addActionListener(this);
		btn_borrar = new JButton("Borrar");
		btn_borrar.addActionListener(this);
		btn_imprimir = new JButton("Imprimir");
		btn_imprimir.addActionListener(this);
		
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
		
		add(btn_aceptar);
		add(btn_borrar);
		add(btn_imprimir);
		
		add(lbl_mensaje);
		
		this.alumno = alumno;
		this.indice = indice;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == btn_aceptar) {
			alumno [indice.getIndice()] = new alumno();
			alumno[indice.getIndice()].setId(tf_id.getText());
			alumno[indice.getIndice()].setTitulo(tf_titulo.getText());
			alumno[indice.getIndice()].setAutor(tf_autor.getText());
			alumno[indice.getIndice()].setCategoria(tf_categoria.getText());
			alumno[indice.getIndice()].setReseña(tf_reseña.getText());
			indice.setIndice(indice.getIndice()+1);
			lbl_mensaje.setText("Libro añadido a la biblioteca");
		}
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
	}

	 
	}

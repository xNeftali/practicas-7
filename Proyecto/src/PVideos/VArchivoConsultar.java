package PVideos;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.TextAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class VArchivoConsultar extends JFrame implements ActionListener{
	private JLabel lbl_id, lbl_titulo, lbl_autor, lbl_mensaje, lbl_categoria, lbl_reseña;
	private JTextField tf_id, tf_titulo, tf_autor, tf_categoria, tf_reseña;
	private JButton btn_buscar, btn_borrar, btn_imprimir;
	private alumno[] alumno;
	private indice indice;
	public VArchivoConsultar (alumno [] alumno, indice indice) {
		super();
		setTitle("Consultar");
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
		btn_buscar = new JButton("Buscar");
		btn_buscar.addActionListener(this);
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
		
		add(btn_buscar);
		add(btn_borrar);
		add(btn_imprimir);
		
		add(lbl_mensaje);
		
		this.alumno = alumno;
		this.indice = indice;
	}

	
	public boolean generar() {
		boolean respuesta = false;
		
		XWPFDocument documento;
		XWPFParagraph titulo_doc;
		XWPFParagraph parrafo;
		
		XWPFRun r_titulo, r_parrafo;
		FileOutputStream word;
		
		
		String t_documento = "Consulta de libro";	
		String p_id = "id" + tf_id.getText();
		String p_titulo = "Titulo" + tf_titulo.getText();
		String p_autor = "Autor" + tf_autor.getText();
		String p_categoria = "categoria" + tf_categoria.getText();
		String p_reseña = "Reseña" + tf_reseña.getText();
	
		
		
		
		documento = new XWPFDocument();
		titulo_doc = documento.createParagraph();
		titulo_doc.setAlignment(ParagraphAlignment.CENTER); 
		titulo_doc.setVerticalAlignment(TextAlignment.TOP);
		
		parrafo = documento.createParagraph();
		parrafo.setAlignment(ParagraphAlignment.BOTH);
		
		r_titulo = titulo_doc.createRun();
		r_titulo.setBold(true);
		r_titulo.setText(t_documento);
		r_titulo.setFontFamily("Arial");
		r_titulo.setFontSize(14);
		r_titulo.setTextPosition(10);
		
		r_parrafo = parrafo.createRun();
		r_parrafo.setText(p_id);
		r_parrafo = parrafo.createRun();
		r_parrafo.setFontSize(12);
		r_parrafo.setText(p_titulo);
		r_parrafo = parrafo.createRun();
		r_parrafo.setFontSize(12);
		r_parrafo.setText(p_autor);
		r_parrafo = parrafo.createRun();
		r_parrafo.setFontSize(12);
		r_parrafo.setText(p_categoria);
		r_parrafo.addCarriageReturn();
		r_parrafo.setFontSize(12);
		r_parrafo.setText(p_reseña);
		r_parrafo.addCarriageReturn();
		r_parrafo.setFontSize(12);
		r_parrafo.addCarriageReturn();
		
		try {
			word = new FileOutputStream("documento.docx");
			documento.write(word);
			word.close();
			documento.close();
			respuesta = true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		 
		
		
		
		return respuesta;
	}
	
	public static void main(String[] args) {
		EjemploWord ew = new EjemploWord();
	}

	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn_imprimir) {
			if (generar()) {
				lbl_mensaje.setText("archivo generado");
			}
			else {
					lbl_mensaje.setText("el archivo no se genero");
				}
			
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
				tf_categoria.setText(alumno[i_buscar].getCategoria());
				tf_reseña.setText(alumno[i_buscar].getReseña());
	}
			
		}
}
}
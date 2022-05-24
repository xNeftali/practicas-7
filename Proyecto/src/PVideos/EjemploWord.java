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

public class EjemploWord extends JFrame implements ActionListener {

	private JLabel lbl_nombre, lbl_mensaje;
	private JTextField tf_nombre;
	private JButton btn_generar;
	
	public EjemploWord () {
		super();
		setTitle("Word ejemplo");
		setSize(400,200);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new FlowLayout());
		
		lbl_nombre = new JLabel("ingrese nombre de archivo");
		lbl_mensaje = new JLabel("");
		tf_nombre = new JTextField(30);
		btn_generar = new JButton("Generar");
		btn_generar.addActionListener(this);
		
		add(lbl_nombre);
		add(tf_nombre);
		add(btn_generar);
		add(lbl_mensaje);
		
		setVisible(true);
		
	}
	public boolean generar() {
		
		XWPFDocument documento;
		XWPFParagraph titulo_doc;
		XWPFParagraph parrafo;
		
		XWPFRun r_titulo, r_parrafo;
		FileOutputStream word;
		
		String t_documento = "Consulta simple";
		String p_documento = "No pude, pero lo intente:(";
		
		boolean respuesta = false;
		
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
		r_parrafo.setText(p_documento);
		r_parrafo.addCarriageReturn();
		r_parrafo.setText(p_documento);
		r_parrafo.addCarriageReturn();
		r_parrafo.setFontSize(12);
		r_parrafo.addCarriageReturn();
		
		try {
			word = new FileOutputStream(tf_nombre.getText()+".docx");
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
		if(e.getSource()==btn_generar) {
			if (generar()) {
				lbl_mensaje.setText("archivo generado");
			}else {
					lbl_mensaje.setText("el archivo no se genero");
				}
			
		}
		
	}

}

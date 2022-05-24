
package PVideos;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class VPrincipal extends JFrame implements ActionListener {
	private JMenuBar jMenuBar;
	private JMenu jMenuArchivo, jMenuEditar, jMenuSalir;
	private JMenuItem jMenuItemAgregar, jMenuItemEliminar, jMenuItemModificar, jMenuItemConsultar, jMenuItemImprimir;
	private JMenuItem jMenuItemSalir;
	private alumno[] alumno;
	private indice indice;
public VPrincipal () {
	super();
	setTitle("Biblioteca");
	setSize(800, 600);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLayout(new FlowLayout());
	jMenuBar = new JMenuBar();
	jMenuArchivo = new JMenu("Archivo");
    jMenuEditar = new JMenu ("Editar");
	jMenuSalir = new JMenu ("Salir");
	jMenuItemAgregar = new JMenuItem("Agregar");
	jMenuItemAgregar.addActionListener(this);
	jMenuItemEliminar = new JMenuItem("Eliminar");
	jMenuItemEliminar.addActionListener(this);
	jMenuItemModificar = new JMenuItem("Modificar");
	jMenuItemModificar.addActionListener(this);
	jMenuItemConsultar = new JMenuItem("Consultar");
	jMenuItemConsultar.addActionListener(this);
	jMenuItemImprimir = new JMenuItem("Imprimir");
	jMenuItemImprimir.addActionListener(this);
	jMenuItemSalir = new JMenuItem("Salir");
	jMenuItemSalir.addActionListener(this);
	jMenuArchivo.add(jMenuItemAgregar);
	jMenuArchivo.add(jMenuItemEliminar);
	jMenuArchivo.add(jMenuItemModificar);
	jMenuArchivo.add(jMenuItemConsultar);
	jMenuArchivo.add(jMenuItemImprimir);
	jMenuSalir.add(jMenuItemSalir);
	jMenuBar.add(jMenuArchivo);
	jMenuBar.add(jMenuEditar);
	jMenuBar.add(jMenuSalir);
	setJMenuBar(jMenuBar);
	setVisible(true);
	
	alumno = new alumno[3];
	indice = new indice ();
	indice.setIndice(0);
}
	public static void main(String[] args) {
		VPrincipal p = new VPrincipal();

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()== jMenuItemAgregar) {
			VArchivoAgregar vaa = new VArchivoAgregar(alumno, indice);
			vaa.setVisible(true);
		}
		if (e.getSource()==jMenuItemEliminar) {
			VArchivoEliminar vae = new VArchivoEliminar(alumno, indice);
			vae.setVisible(true);
		}
		if(e.getSource() == jMenuItemSalir) {
			System.exit(0);
		}
		
		if (e.getSource()==jMenuItemModificar) {
			VArchivoModificar vam = new VArchivoModificar(alumno, indice);
			vam.setVisible(true);
		}
		if (e.getSource()==jMenuItemConsultar) {
			VArchivoConsultar vac = new VArchivoConsultar(alumno, indice);
			vac.setVisible(true);
		
		}if (e.getSource()==jMenuItemImprimir) {
			EjemploWord ew = new EjemploWord() ;
			ew.setVisible(true);
		}
	}	
}

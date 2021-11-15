package Interfaz;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

public class PanelDatos extends JPanel{

	private JTextArea textArea;

	public PanelDatos ()
	{
		setBorder (new TitledBorder ("Panel de informaci�n"));
		setLayout( new BorderLayout( ) );

		textArea = new JTextArea("Aqu� sale el resultado de las operaciones solicitadas");
		textArea.setEditable(false);
		add (new JScrollPane(textArea), BorderLayout.CENTER);
	}
	
	
	  public void actualizarInterfaz (String texto)
	    {
	    	textArea.setText(texto);
	    }
	  
	  public void actualizarInterfaz2 (String texto)
	    {
		  //JTextArea textArea2 =  new JTextArea("Aqu� sale el resultado de las operaciones solicitadas");
		  //textArea2.setEditable(false);
			//add (new JScrollPane(textArea2), BorderLayout.CENTER);
			textArea.append("\n " + texto + "\n");
	    	//textArea2.setText(texto);
	    }


}

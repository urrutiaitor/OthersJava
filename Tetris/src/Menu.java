

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

	public class Menu extends JFrame implements ActionListener{
			
			
			private static final long serialVersionUID = -3392103358305595153L;

			JButton jugar, salir, clasificacion, opciones;
			JPanel panelVentana;
			

			public static void main(String[] args) {
				Menu programa = new Menu();
				programa.ejecutar();
				

			}
			
			private void ejecutar() {
				crearventana();
			}
			
			
			void crearventana(){
				setSize(400, 500);
				setTitle("Tetris");
				Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
				setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
				setContentPane(panelventana());
				setDefaultCloseOperation(3);
				setResizable(false);
				setVisible(true);
				
			}


			private Container panelventana() {
				panelVentana = new JPanel(new BorderLayout());
				panelVentana.add(panelCentro(), BorderLayout.CENTER);
				
				return panelVentana;
			}


			private Component panelCentro() {
				PanelFondo panel = new PanelFondo("./fotos/tetrisOriginal.jpg");
				
				jugar = new JButton();
				salir = new JButton();
				clasificacion = new JButton();
				opciones = new JButton();
				
				jugar.setText("JUGAR");
				salir.setText("SALIR");
				clasificacion.setText("CLASIFICACION");
				opciones.setText("OPCIONES");
				
				jugar.addActionListener(this);
				salir.addActionListener(this);
				clasificacion.addActionListener(this);
				opciones.addActionListener(this);

				panel.add(jugar);
				panel.add(opciones);
				panel.add(clasificacion);
				panel.add(salir);

				
				return panel;
			}
			
			public class PanelFondo extends JPanel{
				
				private static final long serialVersionUID = 1L;
				
				public Image imagen;
				
				PanelFondo(String direccion){
					setLayout(new FlowLayout());
					imagen = new ImageIcon(direccion).getImage();
				}
				
				public void paintComponent(Graphics g){
					g.drawImage(imagen, 0, 0, getWidth(), getHeight(), null);
				}	

			}

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == jugar){
					iniciarJuego();
				}
				
				if(e.getSource() == salir){
					cerrarJuego();
				}
				
				if(e.getSource() == clasificacion){
					mostrarClasificacion();
				}
				
				if(e.getSource() == opciones){
					mostrarOpciones();
				}
			}

			private void mostrarOpciones() {
				JDialog opciones = new JDialog();
				opciones.setVisible(true);
				opciones.setTitle("CONFIGURACION");
				opciones.setSize(280, 280);
				opciones.setLocation(this.getLocation());
				
				//opciones.setContentPane(panel); //el panel que se vaya a poner de opciones
				
			}

			private void mostrarClasificacion() {
				JDialog opciones = new JDialog();
				opciones.setVisible(true);
				opciones.setTitle("CLASIFICACION");
				opciones.setSize(280, 280);
				opciones.setLocation(this.getLocation());
				
				//opciones.setContentPane(panel); //el panel que se vaya a poner de opciones				
			}

			private void cerrarJuego() {
				System.exit(0);
			}

			private void iniciarJuego() {
				this.setVisible(false);
				new Thread(
			            new Runnable() {
			                public void run() {
			                   new Main();
			                }
			            }
			        ).start();				
			}

		}

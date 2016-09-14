import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.Semaphore;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import pieces.Block;
import pieces.Piece;

public class Window extends JFrame implements Observer, KeyListener {

	Semaphore s;
	ArrayList<Block> list;
	Piece piece;
	int screenWidth;
	int screenHeight;
	Screen screen;
	
	
	public Window(Semaphore s, ArrayList<Block> blockList, int screenWidth, int screenHeight){
		this.s = s;
		this.list = blockList;
		this.screenHeight = screenHeight;
		this.screenWidth = screenWidth;
		
		this.setLocation(500, 200);
		this.getContentPane().add(createWindowPane());
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.addKeyListener(this);
		this.setResizable(false);
	}

	private Component createWindowPane() {
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.ORANGE),
				BorderFactory.createTitledBorder("Tetris")));
		panel.setBackground(Color.WHITE);
		
		panel.add(createMenuZone(), BorderLayout.NORTH);
		panel.add(createGameZone(), BorderLayout.CENTER);
		panel.add(createInfoZone(), BorderLayout.EAST);
		
		return panel;
	}

	private Component createMenuZone() {
		JPanel panel = new JPanel();
		
		return panel;
	}

	private Component createGameZone() {
		screen = new Screen(screenWidth, screenHeight, list);
		return screen;
	}
	
	private Component createInfoZone() {
		JPanel panel = new JPanel(new GridLayout(2, 1));
		panel.add(createNextPieceZone());
		panel.add(createScoreZone());
		return panel;
	}

	private Component createNextPieceZone() {
		/* PieceScreen ps = new PieceScreen();
		
		return ps; */
		
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.ORANGE),
				BorderFactory.createTitledBorder("Siguiente pieza")));
		panel.add(new JLabel("CONTENIDO"), BorderLayout.CENTER);
		panel.setBackground(Color.WHITE);
		return panel;
	}

	private Component createScoreZone() {
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.ORANGE),
				BorderFactory.createTitledBorder("Puntuación")));
		panel.add(new JLabel("CONTENIDO"), BorderLayout.CENTER);
		panel.setBackground(Color.WHITE);
		return panel;
	}

	@Override
	public void update(Observable o, Object arg) {
		if (arg instanceof Piece) piece = (Piece) arg;
		screen.setPiece(piece);
		screen.repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) piece.setNextMove("RIGHT");
		if (e.getKeyCode() == KeyEvent.VK_LEFT) piece.setNextMove("LEFT");
		if (e.getKeyCode() == KeyEvent.VK_UP) piece.setNextMove("ROTATE");
		if (e.getKeyCode() == KeyEvent.VK_DOWN) piece.setNextMove("DOWN");
		if (e.getKeyCode() == KeyEvent.VK_Q) System.exit(-1);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		//piece.setNextMove("NOTHING");
	}
	
}
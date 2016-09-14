import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import pieces.Block;
import pieces.Piece;

public class Screen extends JPanel {

	int screenWidth;
	int screenHeight;
	int screenWidthP;
	int screenHeightP;
	ArrayList<Block> blockList;
	Piece piece;
	int pixel = 28;
	int frame = 3;
	
	public Screen (int screenWidth, int screenHeight, ArrayList<Block> blockList) {
		this.screenWidth = screenWidth;
		this.screenHeight = screenHeight;
		this.blockList = blockList;
		
		screenWidthP = (frame * (screenWidth + 1)) + (pixel * screenWidth);
		screenHeightP = (frame * (screenHeight + 1)) + (pixel * screenHeight);
		
		this.setPreferredSize(new Dimension(screenWidthP, screenHeightP));
	}
	
	public void paint (Graphics g) {
		paintBackground(g);
		
		for (int i = 0; i < blockList.size(); i++) {
			Block b = blockList.get(i);
			
			g.setColor(b.getColor());
			g.fillRect(b.getPosX() * (pixel + frame), b.getPosY() * (pixel + frame), pixel, pixel);
		}
		
		if (piece != null) {
			
			for (int i = 0; i < piece.getBlockList().size(); i++) {
				
				Block b = piece.getBlockList().get(i);
	
				g.setColor(piece.getColor());
				g.fillRect(b.getPosX() * (pixel + frame), b.getPosY() * (pixel + frame), pixel, pixel);
				
			}
		}
	}
	
	private void paintBackground (Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, screenWidthP, screenHeightP);
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

}

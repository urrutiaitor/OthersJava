import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

import pieces.Block;
import pieces.Piece;

public class PieceScreen extends JPanel {

	int screenWidth;
	int screenHeight;
	int screenWidthP;
	int screenHeightP;
	Piece piece;
	int pixel = 40;
	int frame = 5;
	
	public PieceScreen (Piece nextPiece) {
		screenWidth = 4;
		screenHeight = 4;
		
		screenWidthP = (frame * (screenWidth + 1)) + (pixel * screenWidth);
		screenHeightP = (frame * (screenHeight + 1)) + (pixel * screenHeight);
		
		this.setPreferredSize(new Dimension(screenWidthP, screenHeightP));
	}
	
	public void paint (Graphics g) {
		paintBackground(g);
		
		if (piece != null) {
			
			for (int i = 0; i < piece.getBlockList().size(); i++) {
				
				Block b = piece.getBlockList().get(i);
	
				g.setColor(piece.getColor());
				g.fillRect((b.getPosX() - 3) * (pixel + frame), (b.getPosY() + 2) * (pixel + frame), pixel, pixel);
				
			}
		}
	}
	
	private void paintBackground (Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, screenWidthP, screenHeightP);
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}
	
}

package pieces;

import java.awt.Color;
import java.util.ArrayList;

public class Block {

	int posX;
	int posY;
	Color color;
	
	public Block(int posX, int posY, Color color) {
		super();
		this.posX = posX;
		this.posY = posY;
		this.color = color;
	}
	
	public boolean checkBlock (ArrayList<Block> blockList) {
		
		//if (posY < 1) return false;
		
		for (int i = 0; i < blockList.size(); i++) {
			if (posX == blockList.get(i).getPosX()) {
				if (posY + 1 == blockList.get(i).getPosY()) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	public boolean checkFinish (ArrayList<Block> blockList) {
		
		for (int i = 0; i < blockList.size(); i++) {
			
			if (posX == blockList.get(i).getPosX()) {
				if (posY  == blockList.get(i).getPosY()) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	public boolean checkBlock (ArrayList<Block> blockList, int X, int width) {
		
		if (posX + X < 0) return false;
		if (posX + X >= width - 1) return false;
		
		for (int i = 0; i < blockList.size(); i++) {
			if (posX + X + 1 == blockList.get(i).getPosX()) {
				if (posY == blockList.get(i).getPosY()) {
					return false;
				}
			}
			if (posX + X == blockList.get(i).getPosX()) {
				if (posY == blockList.get(i).getPosY()) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	public boolean checkGround(int height) {
		if (posY >= height - 1) {
			System.out.println("----------- TOUCH IN THE GROUND -----------");
			return false;
		}
		return true;
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

	public Color getColor() {
		return color;
	}

	public void modifyY(int i) {
		posY = posY + i;
	}

	public void modifyX(int X) {
		posX = posX + X;
	}
	
	
}
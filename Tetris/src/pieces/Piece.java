package pieces;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class Piece {

	int posX = 0;
	int posY = 0;
	ArrayList<Block> blockList = null;
	Color color = null;
	final static int pieceNum = 1;
	Random random = new Random();
	int gameWidth;
	int gameHeight;
	String nextMove = "NOTHING";
	
	
	public Piece (int posX, int posY, int gameWidth, int gameHeight) {
		super();
		this.posX = posX;
		this.posY = posY;
		this.gameHeight = gameHeight;
		this.gameWidth = gameWidth;
		
		switch (random.nextInt(pieceNum)) {
		
		case 0: /* SQUARE */
			createSquare();
			break;
		case 1: /* STICK */
			createStick();
			break;
		case 2: /* TRIANGLE */
			createTriangle();
			break;
		case 3: /* ANGLE */
			createAngle();
			break;

		default:
			break;
		}
		
	}

	private void createSquare () {
		//color = Color.BLUE;
		color = Color.BLACK;
		blockList = new ArrayList<>();
		blockList.add(new Block(posX, posY, color));
		blockList.add(new Block(posX, posY + 1, color));
		blockList.add(new Block(posX + 1, posY, color));
		blockList.add(new Block(posX + 1, posY + 1, color));
	}
	
	private void createStick() {
		color = Color.YELLOW;
		blockList = new ArrayList<>();
		blockList.add(new Block(posX, posY, color));
		blockList.add(new Block(posX, posY + 1, color));
		blockList.add(new Block(posX, posY + 2, color));
		blockList.add(new Block(posX, posY + 3, color));
	}

	private void createTriangle() {
		color = Color.GREEN;
		blockList = new ArrayList<>();
		blockList.add(new Block(posX, posY, color));
		blockList.add(new Block(posX, posY + 1, color));
		blockList.add(new Block(posX - 1, posY + 1, color));
		blockList.add(new Block(posX + 1, posY + 1, color));
	}
	
	private void createAngle() {
		color = Color.RED;
		blockList = new ArrayList<>();
		blockList.add(new Block(posX, posY, color));
		blockList.add(new Block(posX, posY + 1, color));
		blockList.add(new Block(posX + 1, posY + 1, color));
	}
	
	public boolean move () {
		for (int i = 0; i < blockList.size(); i++) {
			blockList.get(i).modifyY(1);
		}
		return true;
	}
	
	public boolean checkMove (ArrayList<Block> boardBlockList) {
		
		for (int i = 0; i < blockList.size(); i++) {
			if (!blockList.get(i).checkBlock(boardBlockList)) { /* WILL TOUCH IN THE MOVE */
				return false;
			}
			if (!blockList.get(i).checkGround(gameHeight)) { /* WILL TOUCH THE GROUND */
				return false;
			}
		}
		
		return true;
	}
	
	
	
	public boolean moveX () {
		if (nextMove.matches("RIGHT")) {
			for (int i = 0; i < blockList.size(); i++) {
				blockList.get(i).modifyX(1);
			}
		}
		if (nextMove.matches("LEFT")) {
			for (int i = 0; i < blockList.size(); i++) {
				blockList.get(i).modifyX(-1);
			}
		}
		nextMove = "NOTHING";
		
		return true;
	}
	
	public boolean checkMoveX (ArrayList<Block> boardBlockList) {
		int X = 0;
		
		if (nextMove.matches("RIGTH")) {
			X = 1;
		}
		if (nextMove.matches("LEFT")) {
			X = -1;
		}
		
		for (int i = 0; i < blockList.size(); i++) {
			if (!blockList.get(i).checkBlock(boardBlockList, X, gameWidth)) { /* WILL TOUCH IN THE MOVE */
				return false;
			}
		}
		
		return true;
	}

	public ArrayList<Block> getBlockList() {
		return blockList;
	}
	
	public boolean checkFinish (ArrayList<Block> boardBlockList) {
		
		for (int i = 0; i < blockList.size(); i++) {
			if (!blockList.get(i).checkFinish(boardBlockList)) {
				return false;
			}
		}
		
		return true;
	}

	public Color getColor() {
		return color;
	}

	public String getNextMove() {
		return nextMove;
	}

	public void setNextMove(String nextMove) {
		this.nextMove = nextMove;
	}
	
	
	
}
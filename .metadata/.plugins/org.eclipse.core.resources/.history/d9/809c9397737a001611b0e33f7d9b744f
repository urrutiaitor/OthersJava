import java.util.ArrayList;
import java.util.Observable;
import java.util.concurrent.Semaphore;

import pieces.Block;
import pieces.Piece;

public class Physics extends Observable implements Runnable {

	ArrayList<Block> blockList = null;
	Piece piece = null;
	long movePeriod;
	Semaphore semaphore = null;
	int screenWidth = 10;
	int screenHeight = 10;
	
	public Physics (long movePeriod, Semaphore semaphore, ArrayList<Block> blockList, int screenWidth, int screenHeight) {
		this.blockList = blockList;
		this.movePeriod = movePeriod;
		this.semaphore = semaphore;
		this.screenHeight = screenHeight;
		this.screenWidth = screenWidth;

		
	}
	
	@Override
	public void run() { /* PERIOD OF ALL GAME */
		System.out.println("Starting physics");
		while (loop()) {
		}
		
		System.exit(-1);
	}

	private boolean loop() { /* PERIOD OF EACH PIECE */
		piece = new Piece(screenWidth/2, 0, screenWidth, screenHeight);

		while (piece.checkFinish(blockList)) {
			moveHorizontal();
			if (!moveVertical()) {
				blockList.addAll(piece.getBlockList());
				piece = null;
				return true; /* THE PIECE HAS TOUCH THE GROUND */
			}
			moveHorizontal();
		}
		
		return false;
	}

	private boolean moveHorizontal() {
		boolean r = false;
		
		try {
			semaphore.acquire();
			Thread.sleep(movePeriod);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (piece.checkMoveX(blockList)) {
			r = piece.moveX();
			this.setChanged();
			this.notifyObservers(piece);
		}
		
		semaphore.release();
		
		return r;
	}

	private boolean moveVertical() {
		boolean r = false;
		
		try {
			semaphore.acquire();
			Thread.sleep(movePeriod);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (piece.checkMove(blockList)) {
			r = piece.move();
			this.setChanged();
			this.notifyObservers(piece);
		} else {
			r = false;
		}
		
		semaphore.release();
		
		return r;
	}

	private boolean move() {
		try {
			semaphore.acquire();
			Thread.sleep(movePeriod);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		boolean r = piece.move();
		this.setChanged();
		this.notifyObservers(piece);
		
		semaphore.release();
		
		return r;
	}

}

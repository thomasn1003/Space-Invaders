package snake;

import java.awt.Rectangle;

public class Pellet extends Rectangle {

	public Pellet(int w, int h) {
		super((int) (Math.random() * 400) - 20, (int) (Math.random() * 600) - 20, 20, 20);
	}
	
	public void resetPosition() {
		this.x = (int) (Math.random() * 400);
		this.y = (int) (Math.random() * 600);
	}
	
	
}



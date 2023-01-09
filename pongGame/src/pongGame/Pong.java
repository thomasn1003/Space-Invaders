package pongGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

public class Pong extends GDV5 {
	Ball b1 = new Ball();
	Paddle pL = new Paddle(10, GDV5.getMaxWindowY()/2, KeyEvent.VK_W, KeyEvent.VK_S);
	Paddle pR = new Paddle(GDV5.getMaxWindowX() - 30, GDV5.getMaxWindowY()/2, KeyEvent.VK_UP, KeyEvent.VK_DOWN);
	ScoreBoard s1 = new ScoreBoard();
	int gameState = 0;
	boolean comp1 = false;
	
	
	public static void main(String[] args) {
		Pong p = new Pong();
		p.start();
	}
	
	public void update() {
		if(GDV5.KeysPressed[KeyEvent.VK_SPACE]) {gameState =1; ScoreBoard.rightscore = 0; ScoreBoard.leftscore = 0; }
		if(GDV5.KeysPressed[KeyEvent.VK_1]) {gameState = 2; comp1 = true;}
		if(GDV5.KeysPressed[KeyEvent.VK_2]) {gameState = 3; comp1 = false;} 
		if(GDV5.KeysPressed[KeyEvent.VK_BACK_SPACE])gameState = 5;
		if(GDV5.KeysPressed[KeyEvent.VK_P])gameState = 4;
		if(GDV5.KeysPressed[KeyEvent.VK_O])gameState = 5; 
		if(gameState ==5) {b1.move(pL, pR); pR.move(); 
			if(comp1 == false)
				pL.move();
			if(comp1 == true)
				pL.comp();
		}
	}

	public void draw(Graphics2D win) {	
		if(ScoreBoard.leftscore == 5) gameState = 7;
		if(ScoreBoard.rightscore == 5) gameState = 6;
		if(gameState == 0)
			s1.splashpage(win);
		if(gameState == 1)
			s1.chooseMode(win);
		if(gameState == 2)
			s1.how2playSingle(win);
		if(gameState ==3)
			s1.how2playMulti(win);
		if(gameState ==4)
			s1.pause(win);
		if(gameState ==5) {
			b1.draw(win);
			pL.draw(win);
			pR.draw(win);
			s1.displayScore(win);
		}
		if(gameState == 6 ) 
			s1.right(win);
		if(gameState == 7)
			s1.left(win);
	}
	
	
}

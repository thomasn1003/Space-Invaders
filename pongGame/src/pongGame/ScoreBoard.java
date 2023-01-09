package pongGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class ScoreBoard {
	
	static int leftscore = 0;
	static int rightscore = 0;
	
	public void splashpage(Graphics2D paintbrush) {
		paintbrush.setColor(Color.MAGENTA);
		paintbrush.setFont(new Font("Arial", Font.BOLD, 120));
		paintbrush.drawString("Welcome to Pong", GDV5.getMaxWindowX()/2-500, 200);
		paintbrush.setFont(new Font("Arial", Font.PLAIN, 50));
		paintbrush.setColor(Color.YELLOW);
		paintbrush.drawString("Press SPACE to start", GDV5.getMaxWindowX()/2-250, 600);
		paintbrush.setColor(Color.MAGENTA);
		paintbrush.drawString("by Thomas Nguyen", GDV5.getMaxWindowX()/2-250, 250);
		
	}
	public void chooseMode(Graphics2D paintbrush) {
		paintbrush.setColor(Color.WHITE);
		paintbrush.setFont(new Font("Arial", Font.BOLD, 80));
		paintbrush.drawString("Choose A Mode", GDV5.getMaxWindowX()/2-300, 100);
		paintbrush.setFont(new Font("Arial", Font.PLAIN, 50));
		paintbrush.setColor(Color.RED);
		paintbrush.drawString("Single Player", GDV5.getMaxWindowX()/2-450, 300);
		paintbrush.drawString("Click '1'", GDV5.getMaxWindowX()/2-400, 400);
		paintbrush.setColor(Color.BLUE);
		paintbrush.drawString("Two Player", GDV5.getMaxWindowX()/2+150, 300);
		paintbrush.drawString("Click '2'", GDV5.getMaxWindowX()/2+200, 400);	
	}
	
	public void how2playSingle(Graphics2D paintbrush) {
		paintbrush.setColor(Color.WHITE);
		paintbrush.setFont(new Font("Arial", Font.BOLD, 80));
		paintbrush.drawString("The Pong Game", GDV5.getMaxWindowX()/2-300, 100);
		paintbrush.setColor(Color.GREEN);
		paintbrush.drawString("Paddle", GDV5.getMaxWindowX()/2-100, 250);
		paintbrush.setFont(new Font("Arial", Font.PLAIN, 50));
		paintbrush.setColor(Color.WHITE);
		paintbrush.drawString("^", GDV5.getMaxWindowX()/2, 350);
		paintbrush.drawString("v", GDV5.getMaxWindowX()/2, 400);
		paintbrush.setColor(Color.BLUE);
		paintbrush.drawString("Arrow Keys", GDV5.getMaxWindowX()/2-100, 500);
		paintbrush.setColor(Color.RED);
		paintbrush.drawString("'P' to pause", GDV5.getMaxWindowX()/2-600, 550);
		paintbrush.drawString("'O' to unpause", GDV5.getMaxWindowX()/2-600, 600);
		paintbrush.setColor(Color.YELLOW);
		paintbrush.drawString("Press 'Back Space' to Continue", GDV5.getMaxWindowX()/2-200, 750);
	}
	
	public void how2playMulti(Graphics2D paintbrush){
		paintbrush.setColor(Color.WHITE);
		paintbrush.setFont(new Font("Arial", Font.BOLD, 80));
		paintbrush.drawString("The Pong Game", GDV5.getMaxWindowX()/2-300, 100);
		paintbrush.setColor(Color.RED);
		paintbrush.drawString("Right Paddle", GDV5.getMaxWindowX()/2+100, 250);
		paintbrush.setColor(Color.BLUE);
		paintbrush.drawString("Left Paddle", GDV5.getMaxWindowX()/2-600, 250);
		paintbrush.setFont(new Font("Arial", Font.PLAIN, 50));
		paintbrush.setColor(Color.WHITE);
		paintbrush.drawString("^", GDV5.getMaxWindowX()/2+400, 350);
		paintbrush.drawString("v", GDV5.getMaxWindowX()/2+400, 400);
		paintbrush.drawString("W", GDV5.getMaxWindowX()/2-400, 350);
		paintbrush.drawString("S", GDV5.getMaxWindowX()/2-400, 400);
		paintbrush.setColor(Color.BLUE);
		paintbrush.drawString("Arrow ", GDV5.getMaxWindowX()/2-100, 500);
		paintbrush.setColor(Color.RED);
		paintbrush.drawString("Keys ", GDV5.getMaxWindowX()/2+50, 500);
		paintbrush.drawString("'P' to pause", GDV5.getMaxWindowX()/2-600, 550);
		paintbrush.drawString("'O' to unpause", GDV5.getMaxWindowX()/2-600, 600);
		paintbrush.setColor(Color.YELLOW);
		paintbrush.drawString("Press 'Back Space' to Continue", GDV5.getMaxWindowX()/2-200, 750);
		
	}
	public void pause(Graphics2D paintbrush) {
		paintbrush.setColor(Color.WHITE);
		paintbrush.setFont(new Font("Arial", Font.BOLD, 80));
		paintbrush.drawString("Paused", GDV5.getMaxWindowX()/2-200, 100);
		paintbrush.setColor(Color.RED);
		paintbrush.setFont(new Font("Arial", Font.PLAIN, 50));
		paintbrush.drawString("Press SPACE to Restart", GDV5.getMaxWindowX()/2-250, 450);
		paintbrush.setColor(Color.GREEN);
		paintbrush.drawString("Press 'O' to Continue", GDV5.getMaxWindowX()/2-250, 400);
		
	}
	public void right(Graphics2D paintbrush) {
		paintbrush.setColor(Color.MAGENTA);
		paintbrush.setFont(new Font("Arial", Font.BOLD, 120));
		paintbrush.drawString("Right Player Wins", GDV5.getMaxWindowX()/2-500, 200);
		paintbrush.setFont(new Font("Arial", Font.PLAIN, 50));
		paintbrush.drawString("Press SPACE to start Again", GDV5.getMaxWindowX()/2-250, 600);
		
	
	}
	public void left(Graphics2D paintbrush) {
		paintbrush.setColor(Color.MAGENTA);
		paintbrush.setFont(new Font("Arial", Font.BOLD, 120));
		paintbrush.drawString("Left Player Wins", GDV5.getMaxWindowX()/2-500, 200);
		paintbrush.setFont(new Font("Arial", Font.PLAIN, 50));
		paintbrush.drawString("Press SPACE to start Again", GDV5.getMaxWindowX()/2-250, 600);
	}
	public void displayScore(Graphics2D paintbrush) {
		paintbrush.setColor(Color.WHITE);
		paintbrush.setFont(new Font("Arial", Font.BOLD, 50));
		paintbrush.drawString(leftscore + "              "+ rightscore, GDV5.getMaxWindowX()/2-120, 100);
		paintbrush.setFont(new Font("Arial", Font.PLAIN, 25));
		paintbrush.drawString("Press Enter to move Ball", GDV5.getMaxWindowX()/2-100, 800);
		
	}

}

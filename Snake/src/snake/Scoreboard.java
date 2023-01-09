package snake;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class Scoreboard {
	
	static int leftscore = 0;
	static int rightscore = 0;
	
	public void splashpage(Graphics2D paintbrush) {
		paintbrush.setColor(Color.MAGENTA);
		paintbrush.setFont(new Font("Arial", Font.BOLD, 120));
		paintbrush.drawString("Welcome to Snake", GDV5.getMaxWindowX()/2-500, 200);
		paintbrush.setFont(new Font("Arial", Font.PLAIN, 50));
		paintbrush.setColor(Color.YELLOW);
		paintbrush.drawString("Press SPACE to start", GDV5.getMaxWindowX()/2-250, 600);
		paintbrush.setColor(Color.MAGENTA);
		paintbrush.drawString("by Thomas Nguyen", GDV5.getMaxWindowX()/2-250, 250);
		
	}
	
	public void how2play(Graphics2D paintbrush) {
		paintbrush.setColor(Color.WHITE);
		paintbrush.setFont(new Font("Arial", Font.BOLD, 80));
		paintbrush.drawString("The Snake Game", GDV5.getMaxWindowX()/2-300, 100);
		paintbrush.setColor(Color.GREEN);
		paintbrush.drawString("Movement", GDV5.getMaxWindowX()/2-100, 250);
		paintbrush.setFont(new Font("Arial", Font.PLAIN, 50));
		paintbrush.setColor(Color.WHITE);
		paintbrush.drawString("^", GDV5.getMaxWindowX()/2, 350);
		paintbrush.drawString("v", GDV5.getMaxWindowX()/2, 400);
		paintbrush.drawString(">", GDV5.getMaxWindowX()/2 +40, 375);
		paintbrush.drawString("<", GDV5.getMaxWindowX()/2 -40, 375);
		paintbrush.setColor(Color.BLUE);
		paintbrush.drawString("Arrow Keys", GDV5.getMaxWindowX()/2-100, 500);
		paintbrush.setColor(Color.RED);
		paintbrush.drawString("'ESCAPE' to pause", GDV5.getMaxWindowX()/2-600, 550);
		paintbrush.setColor(Color.YELLOW);
		paintbrush.drawString("Press 'ENTER' to Continue", GDV5.getMaxWindowX()/2-200, 750);
	}
	
	public void pause(Graphics2D paintbrush) {
		paintbrush.setColor(Color.WHITE);
		paintbrush.setFont(new Font("Arial", Font.BOLD, 80));
		paintbrush.drawString("Paused", GDV5.getMaxWindowX()/2-200, 100);
		paintbrush.setColor(Color.RED);
		paintbrush.setFont(new Font("Arial", Font.PLAIN, 50));
		paintbrush.drawString("Press 'L' to Restart", GDV5.getMaxWindowX()/2-250, 450);
		paintbrush.setColor(Color.GREEN);
		paintbrush.drawString("Press 'C' to Continue", GDV5.getMaxWindowX()/2-250, 400);
		
	}
	public void lose(Graphics2D paintbrush) {
		paintbrush.setColor(Color.WHITE);
		paintbrush.setFont(new Font("Arial", Font.BOLD, 80));
		paintbrush.drawString("You Lose!", GDV5.getMaxWindowX()/2-200, 100);
		paintbrush.setColor(Color.RED);
		paintbrush.setFont(new Font("Arial", Font.PLAIN, 50));
		paintbrush.drawString("Press 'BACKSPACE' to Restart", GDV5.getMaxWindowX()/2-250, 500);

	}

}

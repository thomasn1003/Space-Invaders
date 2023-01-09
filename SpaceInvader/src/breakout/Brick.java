package breakout;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import utilities.GDV5;

public class Brick extends Rectangle {
	
	boolean broken = false;
	Particle[] particles;
	int row;
	String powerup = "";
	
	public Brick(int x, int y, int w, int h, int r) { //Constructor
		super(x, y, w, h);
		row = r;
		int p = (int)(Math.random() * 4);
		if (p == 1) {
			powerup = "speed";
		} else if (p == 2) {
			powerup = "ball";
		} else if (p == 3) {
			powerup = "charge";
		} else {
			powerup = "none";
		}
	}
	
	public void brickCheck(Ball b, Paddle p, Breakout br) { //Checks for collision with ball (and moves particles)
		if ((b.intersects(this)) && (broken == false)) {
			broken = true;
			
			br.score += row * 100;
			
			particles = new Particle[20];
			
			for (int i = 0; i < 6; i++) {
				particles[i] = new Particle((int)(Math.random() * 3) + this.x + (i * 12), (int)(Math.random() * 3) + this.y, 3, 3);
			}
			for (int i = 6; i < 12; i++) {
				particles[i] = new Particle((int)(Math.random() * 3) + this.x + ((i - 6) * 12), (int)(Math.random() * 3) + this.y + 40, 3, 3);
			}
			for (int i = 12; i < 16; i++) {
				particles[i] = new Particle((int)(Math.random() * 3) + this.x, (int)(Math.random() * 3) + this.y + ((i - 12) * 10), 3, 3);
			}
			for (int i = 16; i < 20; i++) {
				particles[i] = new Particle((int)(Math.random() * 3) + this.x + 75, (int)(Math.random() * 3) + this.y + ((i - 16) * 10), 3, 3);
			}
			
			b.y = -100;
		}
		
		if (particles != null) {
			for (int i = 0; i < particles.length; i++) {
				if (particles[i].randomMove() == 1) {
					particles = null;
					break;
				}
			}
		}
		
		if (x < -20 || x > GDV5.getMaxWindowX() - 55) broken = true;
	
	}
	
	public void paddleCheck(Paddle p, Breakout br) {
		if (p.intersects(this) && broken == false) br.restart();
	}
	
	public void draw(Graphics2D win, Images images, Breakout br) {

		if (broken == false) {
			if (powerup == "none") win.drawImage(images.brickblue, x, y, br);
			else if (powerup == "speed") win.drawImage(images.brickyellow, x, y, br);
			else if (powerup == "ball") win.drawImage(images.brickred, x, y, br);
			else if (powerup == "charge") win.drawImage(images.brickpink, x, y, br);
		}
		if (particles != null) {
			for (Particle p : particles) {
				p.draw(win);
			}
		}
	}
}

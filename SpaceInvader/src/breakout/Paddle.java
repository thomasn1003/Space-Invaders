package breakout;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import utilities.GDV5;

public class Paddle extends Rectangle {
	
	//Object variables
	boolean left_pressed = false;
	boolean right_pressed = false;
	boolean up_pressed = false;
	boolean down_pressed = false;
	int left_move, right_move, up_move, down_move;
	double mini_right_move, mini_left_move, mini_up_move, mini_down_move;
	double acc = 0.2;
	int maxSpeed = 4;
	boolean shoot = true;
	int shootcounter  = 0;
	
	public Paddle(int x, int y, int w, int h) { //Constructor
		super(x, y, w, h);
	}
	
	public void move() { //Moves the paddle
		
		x += right_move - left_move; //Updates x position
		
		//Checks for wall collision
		if (this.getX() >= GDV5.getMaxWindowX() - this.width) { //Right side
			this.x = GDV5.getMaxWindowX() - this.width;
		} else if (this.getX() <= 0) { //Left side
			this.x = 0;
		}

		//Acceleration and deceleration of paddle
		if ((right_pressed) && (right_move <= maxSpeed)) {
			mini_right_move += acc;
			right_move = (int)mini_right_move;
		}
		if ((left_pressed) && (left_move <= maxSpeed)) {
			mini_left_move += acc;
			left_move = (int)mini_left_move;
		}
		if (!(right_pressed) && (right_move >= 0)) {
			mini_right_move -= acc;
			right_move = (int)mini_right_move;
		}
		if (!(left_pressed) && (left_move >= 0)) {
			mini_left_move -= acc;
			left_move = (int)mini_left_move;
		}
		
		y += down_move - up_move; //Updates x position
		
		//Checks for wall collision
		if (this.getY() >= GDV5.getMaxWindowY() - this.height) { //Right side
			this.y = GDV5.getMaxWindowY() - this.height;
		} else if (this.getY() <= 0) { //Left side
			this.y = 0;
		}

		//Acceleration and deceleration of paddle
		if ((down_pressed) && (down_move <= maxSpeed)) {
			mini_down_move += acc;
			down_move = (int)mini_down_move;
		}
		if ((up_pressed) && (up_move <= maxSpeed)) {
			mini_up_move += acc;
			up_move = (int)mini_up_move;
		}
		if (!(down_pressed) && (down_move >= 0)) {
			mini_down_move -= acc;
			down_move = (int)mini_down_move;
		}
		if (!(up_pressed) && (up_move >= 0)) {
			mini_up_move -= acc;
			up_move = (int)mini_up_move;
		}
		
		shootcounter++;
		if (shootcounter > 50) {
			shoot = true;
		}
	}
	
	public void paddleCheck(Ball b) { //Checks for collision with ball
		if (b.intersects(this)) {
			b.dY *= -1; //Reverses ball's y-direction
			
			b.y = this.y - 20; //Makes sure that the ball isn't clipping into the paddle
			
			//b.dX += (right_move - left_move) / 6; //Changes ball's x-direction based on paddle movement
		}
	}
	
	public void shoot(Breakout br) {
		for (int k = 0; k < br.balls.length; k++) {
			if (br.balls[k] == null) {
				if (shoot) {
					br.balls[k] = new Ball(this.x + 10, this.y + 10, 20, 20, false);
					br.balls[k].charge = 0;
					br.balls[k].dX = (int)(Math.random() * 3) - 1;
					br.balls[k].dY = -10;
					shoot = false;
					shootcounter = 0;
				}
				break;
			}
		}
	}
	
	public void keyPressed(Breakout br) { //Checks for keys being pressed
		if (GDV5.KeysPressed[KeyEvent.VK_LEFT]) {
			left_pressed = true;
		}
		if (GDV5.KeysPressed[KeyEvent.VK_RIGHT]) {
			right_pressed = true;
		}
		if (GDV5.KeysPressed[KeyEvent.VK_UP]) {
			up_pressed = true;
		}
		if (GDV5.KeysPressed[KeyEvent.VK_DOWN]) {
			down_pressed = true;
		}
		if (GDV5.KeysPressed[KeyEvent.VK_SPACE]) {
			shoot(br);
		}
	}
	
	public void keyReleased() { //Checks for keys not being pressed
		if (!GDV5.KeysPressed[KeyEvent.VK_LEFT]) {
			left_pressed = false;
		}
		if (!GDV5.KeysPressed[KeyEvent.VK_RIGHT]) {
			right_pressed = false;
		}
		if (!GDV5.KeysPressed[KeyEvent.VK_UP]) {
			up_pressed = false;
		}
		if (!GDV5.KeysPressed[KeyEvent.VK_DOWN]) {
			down_pressed = false;
		}
	}
}

package pongGame;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Ball extends Rectangle {
	int dX, dY;
	
	
	
	public Ball() {
		super(GDV5.getMaxWindowX()/2, GDV5.getMaxWindowY()/2, 20, 20);
		dX = 0;
		dY= 0;
	}
	
	public void move(Paddle p1, Paddle p2) {
		this.x = this.x + dX; 
		this.y =this.y +dY;
		if(this.y + this.height>= Pong.getMaxWindowY()) this.dY =-this.dY;
		if(this.y <=0) this.dY = -this.dY;
		//if(this.x + this.width >= Pong.getMaxWindowX()) this.dX = -this.dX;
		//if(this.x <= 0) this.dX = -this.dX;
		if(this.x <-50) {
			ScoreBoard.rightscore +=1;
			this.x = GDV5.getMaxWindowX()/2;
			this.y = GDV5.getMaxWindowY()/2;
			this.dX = 0;
			this.dY = 0;
		}
		
		if(this.x > GDV5.getMaxWindowX()+50) {
			ScoreBoard.leftscore +=1;
			this.x = GDV5.getMaxWindowX()/2;
			this.y = GDV5.getMaxWindowY()/2;
			this.dX = 0;
			this.dY =0;
		}
		
		if(GDV5.KeysPressed[KeyEvent.VK_ENTER]) {
			this.dX = 3;
			this.dY = 3;
		}
		
		this.bounce(p1);
		this.bounce(p2);
		if(this.intersects(p1)) this.dX +=1;
		if(this.intersects(p2)) this.dX -=1;
	}

	public void bounce(Paddle p) {
		if(this.intersects(p)) {
			this.dX = -this.dX;
		}
	}
	
	public void draw(Graphics2D pb) {
		pb.setColor(Color.WHITE);
		pb.fillOval(this.x, this.y, this.width, this.height);
	}

}


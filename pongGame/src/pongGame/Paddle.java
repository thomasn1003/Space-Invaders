package pongGame;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Paddle extends Rectangle {
	int dX,dY;
	private Color col; 
	private int upKey, downKey;
	
	public Paddle(int x, int y, int u, int d) {
		super(x, y, 20, 110);
		dY = 10;
		col = Color.GREEN;
		upKey = u;
		downKey = d;
	}
	
	public void move() { 
		
		if(GDV5.KeysPressed[upKey]) {
			this.y -= 7;
		}
		if(GDV5.KeysPressed[downKey])
			this.y +=7;
		if(this.y + this.height>= Pong.getMaxWindowY()) this.y =-this.y;
		if(this.y <=1) this.y = -this.y;
	}
	
	public void comp() { 
		this.y =this.y +dY;
		if(this.y + this.height>= Pong.getMaxWindowY()) this.dY =-this.dY;
		if(this.y <=0) this.dY = -this.dY;
	}
	
	public void draw(Graphics2D pb) { 
		pb.setColor(col);
		pb.fill(this);
	}
	
}

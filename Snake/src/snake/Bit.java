package snake;

import java.awt.Rectangle;


public class Bit extends Rectangle {
	
	int distance = 20;
	int dX = 1;
	int dY = 0;
	int tempx = 999;
	int tempy = 999;
	
	public Bit(int w, int h) {
		super(GDV5.getMaxWindowX()/2, GDV5.getMaxWindowY()/2, w, h);
	}
	
	public int getTempx() {
		return tempx;
	}
	
	public int getTempy() {
		return tempy;
	}
	
	public void setTemp(int x, int y) {
		tempx = x;
		tempy = y;
	}
	
	public void setDx(int x) {
		dX = x;
		dY = 0;
	}
	
	public void setDy(int y) {
		dY = y;
		dX = 0;
	}
	
	public int getDx() {
		return dX;
	}
	
	public int getDY() {
		return dY;
	}
	
	public void setLocation(int x, int y) {
		this.x = x;
		this.y = y;
	} 
	
	public void move() {
		x += dX * distance;
		y += dY * distance;
	}
	

}

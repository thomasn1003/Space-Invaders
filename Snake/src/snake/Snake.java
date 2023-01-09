package snake;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Snake extends GDV5 {
	
	int frame = 0;
	boolean bulk = false;
	int score =0;
	int level = 0;
	static ArrayList<Bit> snake = new ArrayList<Bit>();
	static Pellet p = new Pellet(10, 10);
	Scoreboard s1 = new Scoreboard();
	int gameState = 0;
	//gamestate 0 = home screen
	//gamestate 1 = how to play screen
	//gamestate 2 = game screen
	//gamestate 3 = lose screen 
	//gamestate 4 = win screen 
	//gamestate 5 = pause screen
	
	public static void main(String[] args) {
		Snake g = new Snake();
		g.start();
		fillSnake();
		p.resetPosition();
		
	}
	
	public static void fillSnake() {
		snake.clear();
		for (int i = 0; i < 5; i++) {
			Bit b = new Bit(20, 20);
			snake.add(b);
			
		}
	}
	
	public void gameEnd() {
		gameState = 3;
		bulk = false;
	}
	
	public void lvlChange() {
		if(score ==5) {
			level++;
			score =0;
		}
	}
	
	public void update() {
		
		keyObserver();
		movementLogic();
		pelletCollider();
		lvlChange();
		
	}
	
	public void movementLogic() {
		if (gameState == 2) {
			frame++;	
			boundaryObserver();
			if (frame % 5 == 0) {
				snake.get(0).move();
				for (int i = 1; i < snake.size(); i++) {
					snake.get(i).setLocation(snake.get(i).tempx, snake.get(i).tempy);
					snake.get(i).setTemp(snake.get(i-1).x, snake.get(i-1).y);
					
					for (Bit _b: snake.subList(1, snake.size())) {
						if (snake.get(0).intersects(_b)) {
							gameEnd();
						}
					}
			    }
			}	
		}
	}
	
	public void pelletCollider() {
		if (snake.get(0).intersects(p)) {
			snake.add(new Bit (20,20));
			p.resetPosition();
			score++;
		}
	}
	
	public void boundaryObserver() {
		
		if (snake.get(0).y + snake.get(0).height == Snake.getMaxWindowY() + 20) {
			gameEnd();
		}
		
		//coll off the top
		if (snake.get(0).y == 0 - 20) {
			gameEnd();
		}
		
		//coll off the right
		if (snake.get(0).x + snake.get(0).width == Snake.getMaxWindowX() + 20) {
			gameEnd();
		}
		
		//coll off the left	
		if (snake.get(0).x == 0 - 20) {
			gameEnd();
		}
		
	}
	
	public void keyObserver() {
		int xdir = snake.get(0).getDx();
		int ydir = snake.get(0).getDY();
		
		if (ydir == 0 && GDV5.KeysPressed[KeyEvent.VK_UP]) {
			snake.get(0).setDy(-1);
		}
		if (ydir == 0 && GDV5.KeysPressed[KeyEvent.VK_DOWN]) {
			snake.get(0).setDy(1);
		}
		if (xdir == 0 && GDV5.KeysPressed[KeyEvent.VK_LEFT]) {
			snake.get(0).setDx(-1);
		}
		if (xdir == 0 && GDV5.KeysPressed[KeyEvent.VK_RIGHT]) {
			snake.get(0).setDx(1);
		}
		
		if ( gameState == 0 && GDV5.KeysPressed[KeyEvent.VK_SPACE]) {
			score = 0;
			level =0;
			gameState = 1;
			
		}
		if ( gameState == 1 && GDV5.KeysPressed[KeyEvent.VK_ENTER]) {
			gameState = 2;
			fillSnake();
			
		}
		
		if (gameState == 3 && GDV5.KeysPressed[KeyEvent.VK_BACK_SPACE]) {
			gameState = 0;
			fillSnake();
		}
		
		if(gameState == 2 && GDV5.KeysPressed[KeyEvent.VK_ESCAPE]) {
			gameState = 5;
		}
		if(gameState == 5 && GDV5.KeysPressed[KeyEvent.VK_C]) {
			gameState = 2;
		}
		if(gameState == 5 && GDV5.KeysPressed[KeyEvent.VK_L]) {
			gameState = 3;
		}
		
		if (gameState == 2 && GDV5.KeysPressed[KeyEvent.VK_SPACE] && !bulk) {
			p.width *= 4;
			p.height *= 4;
			bulk = true;
		}
		
	}
	public void draw(Graphics2D win) {
		win.setColor(Color.WHITE);
    
        if (gameState == 0) {
        	s1.splashpage(win);
        }
        if(gameState == 1) {
        	s1.how2play(win);
        }
        
        if (gameState  == 2) {
        	
        	win.setFont(new Font("Times Roman", Font.PLAIN, 60));
        	win.setColor(Color.YELLOW);
        	win.drawString("Score " + String.valueOf(score), GDV5.getMaxWindowX() / 2 - 600, GDV5.getMaxWindowY() / 2-300);
        	win.drawString("Level " + String.valueOf(level), GDV5.getMaxWindowX() / 2 - 600, GDV5.getMaxWindowY() / 2-350);
        	win.setColor(Color.WHITE);
            for (Bit _b: snake) {
            	win.fill(_b);
            }
            
            win.fill(p);
        }
        
        if (gameState == 3) {
        	/*win.setFont(new Font("Times Roman", Font.PLAIN, 40)); 
			win.drawString("You lose.", GDV5.getMaxWindowX() / 2 - 90, 100);
			
			win.setFont(new Font("Times Roman", Font.PLAIN, 20));
			win.drawString("Press BACKSPACE to restart.", GDV5.getMaxWindowX() / 2 - 140, 500); */
        	win.setFont(new Font("Times Roman", Font.PLAIN, 60));
        	win.setColor(Color.GREEN);
        	win.drawString("Level " + String.valueOf(level), GDV5.getMaxWindowX() / 2 -100, GDV5.getMaxWindowY() / 2-100);
			s1.lose(win);
			
        }
        
        if (gameState == 4) {
        	/*
        	win.setFont(new Font("Times Roman", Font.PLAIN, 40)); 
        	win.drawString("You lose.", GDV5.getMaxWindowX() / 2 - 90, 100);
        	*/
        	
        	
        }
        if (gameState == 5) {
        	s1.pause(win);
        }
        
   
	}
}

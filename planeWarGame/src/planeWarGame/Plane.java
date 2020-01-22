package planeWarGame;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;

import planeWarGame.Constant;

public class Plane extends GameObject{
	
	int speed = 8;
	boolean left,right,up,down;
	boolean live=true;
		
	
	public void drawSelf(Graphics g) {
		if(live) {
		g.drawImage(img,(int)x,(int)y,null);
		
		//每一次重画时进行判断
		if(left&&x>10)
			x-=speed;	
		if(right&&x<Constant.GAME_WIDTH-10-(this.img.getWidth(null)))
			x+=speed;
		if(up&&y>30)
			y-=speed;
		if(down&&y<Constant.GAME_HEIGHT-15-(this.img.getHeight(null)))
			y+=speed;
		}
		
	}
	
	public Plane(Image img, double x ,double y) {
		this.img = img;
		this.x = x;
		this.y = y;
		this.width=img.getWidth(null);
		this.height=img.getHeight(null);
				
	}
	
	/*
	 * 键盘交互
	 */
	public void addDirection(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			left = true;
			break;
		case KeyEvent.VK_UP:
			up = true;
			break;
		case KeyEvent.VK_RIGHT:
			right = true;
			break;
		case KeyEvent.VK_DOWN:
			down = true;
		
			break;
		}
	}
	
	public void minusDeirection(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			left = false;
			break;
		case KeyEvent.VK_UP:
			up = false;
			break;
		case KeyEvent.VK_RIGHT:
			right = false;
			break;
		case KeyEvent.VK_DOWN:
			down = false;
			break;
		}
	}

}

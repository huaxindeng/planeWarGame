package planeWarGame;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

/**
 * 游戏物体的父类
 * @author lenovo
 *
 */
public class GameObject {
	Image img;
	double x,y;
	int speed;
	int width,height;
	
	
	public void drawSelf(Graphics g) {
		g.drawImage(img,(int)x,(int)y,null);
	}

	public GameObject(Image img, double x, double y) {
		super();
		this.img = img;
		this.x = x;
		this.y = y;

	}
	
	public GameObject() {
		
	}
	
	/**
	 * 返回物体的检测，便于后续的碰撞检测
	 * @return
	 */
	public Rectangle getRect() {
		return new Rectangle((int)x,(int)y,width,height);
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	

	
}

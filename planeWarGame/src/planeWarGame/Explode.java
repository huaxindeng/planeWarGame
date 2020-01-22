/**
 * 
 */
package planeWarGame;

import java.awt.Graphics;
import java.awt.Image;

/**
 * 爆炸类
 * @author 邓华鑫
 * Created on 2019年8月8日
 * Description:
 */
public class Explode {
	
	double x , y;
	int count;
	/*
	 * 静态定义，防止多次加载，节约资源
	 */
	static Image[] imgs = new Image[10];
	static {
		for(int i=0;i<imgs.length;i++) {
			imgs[i]=GameUtil.getImage("imagesPlaneWar/e"+(i+1)+".png");
			imgs[i].getWidth(null);			
		}		
	}
	
	/*
	 * 画出 爆炸图集
	 */
	public void draw(Graphics g) {
		if(count < 10) {
			g.drawImage(imgs[count], (int)x, (int)y, null);
			count++;
		}
	}
	/*
	 * 构造器
	 */
	public Explode(double x, double y) {
		this.x = x;
		this.y = y;
	}
}
/**
 * 
 */
package planeWarGame;

import java.awt.Graphics;
import java.awt.Image;

/**
 * ��ը��
 * @author �˻���
 * Created on 2019��8��8��
 * Description:
 */
public class Explode {
	
	double x , y;
	int count;
	/*
	 * ��̬���壬��ֹ��μ��أ���Լ��Դ
	 */
	static Image[] imgs = new Image[10];
	static {
		for(int i=0;i<imgs.length;i++) {
			imgs[i]=GameUtil.getImage("imagesPlaneWar/e"+(i+1)+".png");
			imgs[i].getWidth(null);			
		}		
	}
	
	/*
	 * ���� ��ըͼ��
	 */
	public void draw(Graphics g) {
		if(count < 10) {
			g.drawImage(imgs[count], (int)x, (int)y, null);
			count++;
		}
	}
	/*
	 * ������
	 */
	public Explode(double x, double y) {
		this.x = x;
		this.y = y;
	}
}
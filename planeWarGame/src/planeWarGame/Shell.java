package planeWarGame;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/**
 * �ڵ���
 * @author �˻���
 *
 */
public class Shell extends GameObject{
	
	Random random = new Random();
	
	double degree;

	public Shell() {
		x = random.nextInt(300)+100;		//��������ڵ�λ��
		y = random.nextInt(200)+50;
		width = 6;
		speed = 0;
		height = 6;
		
		
		degree = Math.random()*Math.PI*2;
	}
	
	/*
	 * �ڵ��ƶ��㷨
	 */
	public void draw(Graphics g) {
		Color c = g.getColor();
		
		g.setColor(Color.yellow);
		
		g.fillOval((int)x, (int)y, width, height);
		
		x+=speed*Math.cos(degree);		
		y+=speed*Math.sin(degree);
		if(x<10||x>Constant.GAME_WIDTH-20)
			degree = Math.PI-degree;		//�����귴ת
		if(y<30||y>Constant.GAME_HEIGHT-15)
			degree = -degree;				//�����귴ת
		g.setColor(c);
		
		
		
	}
	

}

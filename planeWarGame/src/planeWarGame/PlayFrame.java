package planeWarGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.JFrame;

public class PlayFrame  extends JFrame {
	
	Explode bao;
	int period=0;				//��Ϸ����ʱ��
	String periodStr = null;
	Date startTime = new Date();
	Date endTime = null;	
	int speed= 0;				//������Ϸ�ȼ���һ�������ڵ����ٶȺ�����
	int num = 0;
	Shell[] shell ;
	int rank = 0;
	int level;
	Image bg = GameUtil.getImage("imagesPlaneWar/bg.jpg");
	Image planeImg = GameUtil.getImage("imagesPlaneWar/plane.jpg");
	
	Plane plane = new Plane(planeImg,400,450);
	ConnectJdbc connect ;
	
	/*
	 * �����ڵ������������ٶ�
	 */
	public PlayFrame( int num,int speedShell) throws Exception{
		
		this.shell =  new Shell[num];
		this.speed = speedShell;
		this.num = num;
	}

	/*
	 * ˫���弼�������Ƶ������
	 */
	private Image offScreenImage = null;
	public void update(Graphics g) {
		if(offScreenImage ==null)
			offScreenImage = this.createImage(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
		
		Graphics gOff = offScreenImage.getGraphics();
		paint(gOff);
		g.drawImage(offScreenImage, 0, 0, null);
	}
	
	
	/*
	 * ������������������ڵĻ���
	 */
	public  void paint(Graphics g) {	
		
		Color c = g.getColor();													//����Color��ĳ�ʼ��ɫ
		g.drawImage(bg, 0, 0, null);
		plane.drawSelf(g);
		
		for(int i = 0; i<shell.length;i++) {
			shell[i].draw(g);			
			boolean die = shell[i].getRect().intersects(plane.getRect());		//�ж��ڵ��Ƿ���ɻ��ཻ
			
			if (die) {
				plane.live=false;
				/*
				 * ��ȡ��һ����ײ��ʱ��
				 */
				if(period==0) {
				endTime = new Date();
				period = (int)((endTime.getTime()-startTime.getTime())/1000);	//��������ʱ��
				
				periodStr = countTime(period);
				try {
					connect = new ConnectJdbc(this.speed-2);
					connect.insertCountTime(periodStr);
				} catch (SQLException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
				}
					
				if(bao == null) {
					bao = new Explode(plane.x,plane.y);							//�����ֲ����������÷ɻ���ը����
				}
				bao.draw(g);
				
			//������ͣ	
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			GameAgain again = new GameAgain(periodStr);
			again.createGUI();
			setVisible(false);
			}		
		}	
		g.setColor(c);															//����Color�ĳ�ʼ��ɫ

	}
	
	
	/**
	 * ��ʼ������
	 */
	public void launchFrame() {
		
		/*
		 * ���ڻ������ԣ����⡢��С������λ�á���ʾ
		 */	
		setTitle("�ɻ���ս_�˻��γ�Ʒ");
		setSize(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);
		setLocation(500,200);													//��y�ᣬ��x��
		setVisible(true);
		
		/*
		 * ��ʼ���ڵ�
		 */
		for(int i = 0;i<shell.length;i++) {
			shell[i] = new Shell();
			shell[i].speed = speed;
		}		
		
		/*
		 * �����߳�
		 */
		new PaintThread().start();
		
		/*
		 * ͨ�������࣬���Ӽ��̼�����
		 */
		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {}

			@Override
			public void keyPressed(KeyEvent e) {
				plane.addDirection(e);		
			}

			@Override
			public void keyReleased(KeyEvent e) {
				plane.minusDeirection(e);	
			}		
		});
		
		/*
		 *�����˳����Զ��������� 
		 */
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
	}
	
	public static String countTime(int period) {	
		int second = period;
		int minute = 0;
		int hour = 0;
		String secondStr = null;
		String minuteStr = null;
		String hourStr = null;
		if(second>60) {
			minute = second/60; second%=60;	}
		if(minute>60) {
			hour=minute/60;  minute%=60;	
		}
		if(hour<10&&hour!=0)
			hourStr = "0"+hour;
		else
			hourStr = ""+hour;
		if(minute<10&&minute!=0)
			minuteStr = "0"+second;
		else
			minuteStr = ""+minute;
		if(second<10&&second!=0)
			secondStr = "0"+second;
		else
			secondStr = ""+second;
		return  hourStr+"ʱ"+minuteStr+"��"+secondStr+"��";	
	}
	
	/*
	 * �߳��࣬���߳�
	 */
	class PaintThread extends Thread{
		public void run() {
			while(true) {
				repaint();															//�ػ�
				
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					e.printStackTrace();
		}}}	
	}

}
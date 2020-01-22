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
	int period=0;				//游戏持续时间
	String periodStr = null;
	Date startTime = new Date();
	Date endTime = null;	
	int speed= 0;				//根据游戏等级进一步设置炮弹的速度和数量
	int num = 0;
	Shell[] shell ;
	int rank = 0;
	int level;
	Image bg = GameUtil.getImage("imagesPlaneWar/bg.jpg");
	Image planeImg = GameUtil.getImage("imagesPlaneWar/plane.jpg");
	
	Plane plane = new Plane(planeImg,400,450);
	ConnectJdbc connect ;
	
	/*
	 * 设置炮弹数量并保存速度
	 */
	public PlayFrame( int num,int speedShell) throws Exception{
		
		this.shell =  new Shell[num];
		this.speed = speedShell;
		this.num = num;
	}

	/*
	 * 双缓冲技术，解决频闪问题
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
	 * 窗口类的主方法，窗口的绘制
	 */
	public  void paint(Graphics g) {	
		
		Color c = g.getColor();													//保存Color类的初始颜色
		g.drawImage(bg, 0, 0, null);
		plane.drawSelf(g);
		
		for(int i = 0; i<shell.length;i++) {
			shell[i].draw(g);			
			boolean die = shell[i].getRect().intersects(plane.getRect());		//判断炮弹是否与飞机相交
			
			if (die) {
				plane.live=false;
				/*
				 * 获取第一次碰撞的时间
				 */
				if(period==0) {
				endTime = new Date();
				period = (int)((endTime.getTime()-startTime.getTime())/1000);	//计算出存活时间
				
				periodStr = countTime(period);
				try {
					connect = new ConnectJdbc(this.speed-2);
					connect.insertCountTime(periodStr);
				} catch (SQLException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				}
					
				if(bao == null) {
					bao = new Explode(plane.x,plane.y);							//采用轮播技术，设置飞机爆炸场景
				}
				bao.draw(g);
				
			//界面暂停	
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
		g.setColor(c);															//返回Color的初始颜色

	}
	
	
	/**
	 * 初始化窗口
	 */
	public void launchFrame() {
		
		/*
		 * 窗口基本属性，标题、大小、桌面位置、显示
		 */	
		setTitle("飞机大战_邓华鑫出品");
		setSize(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);
		setLocation(500,200);													//先y轴，后x轴
		setVisible(true);
		
		/*
		 * 初始化炮弹
		 */
		for(int i = 0;i<shell.length;i++) {
			shell[i] = new Shell();
			shell[i].speed = speed;
		}		
		
		/*
		 * 增加线程
		 */
		new PaintThread().start();
		
		/*
		 * 通过匿名类，增加键盘监听器
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
		 *窗口退出后，自动结束程序 
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
		return  hourStr+"时"+minuteStr+"分"+secondStr+"秒";	
	}
	
	/*
	 * 线程类，多线程
	 */
	class PaintThread extends Thread{
		public void run() {
			while(true) {
				repaint();															//重画
				
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					e.printStackTrace();
		}}}	
	}

}
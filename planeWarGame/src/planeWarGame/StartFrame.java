/**
 * 
 */
package planeWarGame;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * 
 * @author 邓华鑫
 * Created on 2019年8月13日
 * Description:
 */
public class StartFrame extends JFrame {

	public void createGUI() throws Exception{
		
		
		//初始化窗口
		
		JFrame frame = new JFrame("飞机大战_邓华鑫出品");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,400);
		frame.setLocation(600,200);			//先y轴，后x轴	
		
		Container container = frame.getContentPane();
		container.setLayout(new FlowLayout(FlowLayout.CENTER,300,50));
		
		//添加按钮
		JButton start = new JButton("开始游戏");
		JButton gameRecode = new JButton("游戏记录");
		JButton dropOut = new JButton("退出游戏");
		
		/*
		 * 添加鼠标点击事件，产生游戏等级界面，并关闭现有窗口
		 */
		start.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				GameLevelFrame game = new GameLevelFrame();
				try {
					game.createGUI();
				} catch (Exception e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
				
				frame.setVisible(false);
			}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}		
		});
		
		gameRecode.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				GameRecord record;
				try {
					record = new GameRecord();
					record.createGUI();
				} catch (Exception e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}	
				
				frame.setVisible(false);
				
			}

			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}		
		});
		
		dropOut.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);			
			}
			@Override
			public void mousePressed(MouseEvent e) {}
	 	@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}		
		});
		container.add(start);
		container.add(gameRecode);
		container.add(dropOut);
		
		frame.setVisible(true);
	}
	
	public static void main(String[]args) throws Exception{
		StartFrame game = new StartFrame();
		
		game.createGUI();
	}
}

/**
 * 
 */
package planeWarGame;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 
 * @author 邓华鑫
 * Created on 2019年8月15日
 * Description:
 */
public class GameAgain extends JFrame{
	
	String gameTime = null;
	
	public GameAgain(String gameTime) {
		this.gameTime = gameTime;
		
	}
	
	public void createGUI() {
		
		//初始化窗口
		JFrame frame = new JFrame("飞机大战_邓华鑫出品");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,400);
		frame.setLocation(600,200);			//先y轴，后x轴
		Color c = Color.red;
		Container container = frame.getContentPane();
		container.setLayout(new FlowLayout(FlowLayout.CENTER,300,30));
		
		JButton gameAgain = new JButton("再来一次");
		JButton dropOut = new JButton("退出游戏");
		JLabel slogan = new JLabel("存活时间");
		slogan.setFont(new Font("宋体",Font.BOLD,30));
		JLabel time = new JLabel();
		time.setText(gameTime);
		time.setFont(new Font("正楷",Font.BOLD,20));
		
		gameAgain.addMouseListener(new MouseListener() {

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
		container.add(slogan);
		container.add(time);
		container.add(gameAgain);
		container.add(dropOut);
		frame.setVisible(true);
	}
	

}

/**
 * 
 */
package planeWarGame;

import java.awt.Container;
import java.awt.FlowLayout;
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
public class GameLevelFrame extends JFrame{
	

	public void createGUI() throws Exception{
		
		/*
		 * 初始化窗口
		 */
		JFrame frame = new JFrame("飞机大战_游戏难度"); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,400);
		frame.setLocation(600,200);			//先y轴，后x轴	
		
		Container container = frame.getContentPane();
		container.setLayout(new FlowLayout(FlowLayout.CENTER,300,30));
		
		/*
		 * 添加游戏级别选择按钮
		 */
		JButton class1 = new JButton("简单");
		JButton class2 = new JButton("一般");
		JButton class3 = new JButton("困难");
		JButton reback = new JButton("返回");	
		JButton dropOut = new JButton("退出");
		
		
		class1.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				PlayFrame game = null;
				try {
					game = new PlayFrame(20,3);
				} catch (Exception e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
				game.launchFrame();
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
		
		class2.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
				PlayFrame game = null;
				try {
					game = new PlayFrame(30,4);
				} catch (Exception e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}	
				game.launchFrame();
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
		class3.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
				PlayFrame game = null;
				try {
					game = new PlayFrame(40,5);
				} catch (Exception e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
				game.launchFrame();
				
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
		
		reback.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				StartFrame game = new StartFrame();
				
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
		container.add(class1);
		container.add(class2);
		container.add(class3);
		container.add(reback);
		container.add(dropOut);
		frame.setVisible(true);
	}

}

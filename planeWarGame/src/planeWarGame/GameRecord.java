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
 * Created on 2019年8月14日
 * Description:
 */
public class GameRecord extends JFrame{
	

	public void createGUI() {
	JFrame frame = new JFrame("飞机大战_游戏记录");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(300,400);
	frame.setLocation(600,200);			//先y轴，后x轴
	
	//添加面板
	Container container = frame.getContentPane();
	container.setLayout(new FlowLayout(FlowLayout.CENTER,800,30));
	
	JButton level1 = new JButton("简单");
	JButton level2 = new JButton("一般");
	JButton level3 = new JButton("困难");
	JButton reback = new JButton("返回");	
	JButton dropOut = new JButton("退出");
	
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
	
	
	level1.addMouseListener(new MouseListener() {

		@Override
		public void mouseClicked(MouseEvent e) {
			GradeFrame grade = new GradeFrame(1);
			try {
				grade.createGUI();
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
	
	level2.addMouseListener(new MouseListener() {

		@Override
		public void mouseClicked(MouseEvent e) {
			GradeFrame grade = new GradeFrame(2);
			try {
				grade.createGUI();
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
	
	level3.addMouseListener(new MouseListener() {

		@Override
		public void mouseClicked(MouseEvent e) {
			GradeFrame grade = new GradeFrame(3);
			try {
				grade.createGUI();
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
	
	container.add(level1);
	container.add(level2);
	container.add(level3);
	container.add(reback);
	container.add(dropOut);
	
	
	frame.setVisible(true);
	}


}

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
 * @author �˻���
 * Created on 2019��8��13��
 * Description:
 */
public class StartFrame extends JFrame {

	public void createGUI() throws Exception{
		
		
		//��ʼ������
		
		JFrame frame = new JFrame("�ɻ���ս_�˻��γ�Ʒ");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,400);
		frame.setLocation(600,200);			//��y�ᣬ��x��	
		
		Container container = frame.getContentPane();
		container.setLayout(new FlowLayout(FlowLayout.CENTER,300,50));
		
		//��Ӱ�ť
		JButton start = new JButton("��ʼ��Ϸ");
		JButton gameRecode = new JButton("��Ϸ��¼");
		JButton dropOut = new JButton("�˳���Ϸ");
		
		/*
		 * ���������¼���������Ϸ�ȼ����棬���ر����д���
		 */
		start.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				GameLevelFrame game = new GameLevelFrame();
				try {
					game.createGUI();
				} catch (Exception e1) {
					// TODO �Զ����ɵ� catch ��
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
					// TODO �Զ����ɵ� catch ��
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

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
 * @author �˻���
 * Created on 2019��8��15��
 * Description:
 */
public class GameAgain extends JFrame{
	
	String gameTime = null;
	
	public GameAgain(String gameTime) {
		this.gameTime = gameTime;
		
	}
	
	public void createGUI() {
		
		//��ʼ������
		JFrame frame = new JFrame("�ɻ���ս_�˻��γ�Ʒ");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,400);
		frame.setLocation(600,200);			//��y�ᣬ��x��
		Color c = Color.red;
		Container container = frame.getContentPane();
		container.setLayout(new FlowLayout(FlowLayout.CENTER,300,30));
		
		JButton gameAgain = new JButton("����һ��");
		JButton dropOut = new JButton("�˳���Ϸ");
		JLabel slogan = new JLabel("���ʱ��");
		slogan.setFont(new Font("����",Font.BOLD,30));
		JLabel time = new JLabel();
		time.setText(gameTime);
		time.setFont(new Font("����",Font.BOLD,20));
		
		gameAgain.addMouseListener(new MouseListener() {

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

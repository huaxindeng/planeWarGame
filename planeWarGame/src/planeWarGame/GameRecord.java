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
 * @author �˻���
 * Created on 2019��8��14��
 * Description:
 */
public class GameRecord extends JFrame{
	

	public void createGUI() {
	JFrame frame = new JFrame("�ɻ���ս_��Ϸ��¼");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(300,400);
	frame.setLocation(600,200);			//��y�ᣬ��x��
	
	//������
	Container container = frame.getContentPane();
	container.setLayout(new FlowLayout(FlowLayout.CENTER,800,30));
	
	JButton level1 = new JButton("��");
	JButton level2 = new JButton("һ��");
	JButton level3 = new JButton("����");
	JButton reback = new JButton("����");	
	JButton dropOut = new JButton("�˳�");
	
	reback.addMouseListener(new MouseListener() {

		@Override
		public void mouseClicked(MouseEvent e) {
			StartFrame game = new StartFrame();
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
	
	
	level1.addMouseListener(new MouseListener() {

		@Override
		public void mouseClicked(MouseEvent e) {
			GradeFrame grade = new GradeFrame(1);
			try {
				grade.createGUI();
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
	
	level2.addMouseListener(new MouseListener() {

		@Override
		public void mouseClicked(MouseEvent e) {
			GradeFrame grade = new GradeFrame(2);
			try {
				grade.createGUI();
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
	
	level3.addMouseListener(new MouseListener() {

		@Override
		public void mouseClicked(MouseEvent e) {
			GradeFrame grade = new GradeFrame(3);
			try {
				grade.createGUI();
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
	
	container.add(level1);
	container.add(level2);
	container.add(level3);
	container.add(reback);
	container.add(dropOut);
	
	
	frame.setVisible(true);
	}


}

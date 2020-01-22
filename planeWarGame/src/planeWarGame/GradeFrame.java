/**
 * 
 */
package planeWarGame;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * 
 * @author �˻���
 * Created on 2019��8��15��
 * Description:
 */
public class GradeFrame extends JFrame{
	
	DefaultTableModel tableModel = new DefaultTableModel();
	
	JTable table = new JTable(tableModel);
	String[][] record = new String[3][2];
	int level = 0;
	
	public GradeFrame(int level) {
		this.level = level;
	}
	public void createGUI() throws Exception{
		
		//��ʼ������	
		JFrame frame = new JFrame("�ɻ���ս_��ѳɼ�");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,400);
		frame.setLocation(600,200);			//��y�ᣬ��x��
		
		//������
		Container container = frame.getContentPane();
		container.setLayout(new BorderLayout());
		JScrollPane sp = new JScrollPane(table);
		
		JButton reback = new JButton("����");
		reback.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				GameRecord game;
				try {
					game = new GameRecord();
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
		

		table.setFillsViewportHeight(true);
		table.setRowSelectionAllowed(true);
		container.add(sp,BorderLayout.CENTER);
		
		tableModel.addColumn("����");
		tableModel.addColumn("�ɼ�");
		ConnectJdbc connect = new ConnectJdbc(1);
		
		for(int i = 0;i<3;i++) {
			for(int j=0;j<2;j++) {
				record[i][j] = null;
			}
		}
		record = connect.getGameRecord(level);
		
		for(int i=0;i<3;i++) {
			addTableRow(record[i][0],record[i][1]);
		}
		
		container.add(reback,BorderLayout.SOUTH);
		
		frame.setVisible(true);
	}
	
	private void addTableRow(String rank,String grade) {
		
		//Vector�Ǹ����ͣ���ʾ����
		Vector<Object> rowData = new Vector<>();
		rowData.add(rank);
		rowData.add(grade);
		tableModel.addRow(rowData);		//���һ��
		
	}

}

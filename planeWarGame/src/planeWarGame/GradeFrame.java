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
 * @author 邓华鑫
 * Created on 2019年8月15日
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
		
		//初始化窗口	
		JFrame frame = new JFrame("飞机大战_最佳成绩");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,400);
		frame.setLocation(600,200);			//先y轴，后x轴
		
		//添加面板
		Container container = frame.getContentPane();
		container.setLayout(new BorderLayout());
		JScrollPane sp = new JScrollPane(table);
		
		JButton reback = new JButton("返回");
		reback.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				GameRecord game;
				try {
					game = new GameRecord();
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
		

		table.setFillsViewportHeight(true);
		table.setRowSelectionAllowed(true);
		container.add(sp,BorderLayout.CENTER);
		
		tableModel.addColumn("名次");
		tableModel.addColumn("成绩");
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
		
		//Vector是个泛型，表示数组
		Vector<Object> rowData = new Vector<>();
		rowData.add(rank);
		rowData.add(grade);
		tableModel.addRow(rowData);		//添加一行
		
	}

}

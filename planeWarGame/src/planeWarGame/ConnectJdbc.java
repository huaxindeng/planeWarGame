/**
 * 
 */
package planeWarGame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * @author �˻���
 * Created on 2019��8��14��
 * Description:
 */
public class ConnectJdbc {
	
	
	int level = 0;
	public ConnectJdbc(int level) {
		this.level = level;
	}
	/*
	 * ��Ϸ��¼
	 */
	public static String[][] getGameRecord(int level) throws SQLException {
		
		String username = "root";
		String password ="123";
		String connectionUrl = "jdbc:mysql://127.0.0.1:3306/gamerecord?useUnicode=true&characterEncoding=UTF-8";
		
		Connection conn = DriverManager.getConnection(connectionUrl, username, password);
		String countTime = null;
		int rank = 0;
		String sql = null;
		String[][] record = new String[3][2];
		for(int i = 0;i<3;i++) {
			for(int j=0;j<2;j++) {
				record[i][j]=null;
			}
		}
		java.sql.Statement stmt = conn.createStatement();
		
		//���ⱨ��
		sql = "select * from level"+level+" order by time desc";

		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next()&&rank<3) {
			countTime = rs.getString("time");

			if(rank==0) {
				record[0][0]="��һ��";
				record[0][1]=countTime;
			}
			else if(rank==1) {
				record[1][0]="�ڶ���";
				record[1][1]=countTime;
			}				
			else if(rank==2) {
				record[2][0]="������";
				record[2][1]=countTime;
			}
			
			if(rank!=0&&record[rank-1][1].equals(countTime))
				rank--;
			rank++;
			
		}
		conn.close();
		return record;
	}
	
	public void insertCountTime(String time) throws SQLException {
		String user = "root";
		String password = "123";
		String connectUrl = "jdbc:mysql://127.0.0.1:3306/gamerecord?useUnicode=true&characterEncoding=UTF-8";
		
		java.sql.Connection conn = DriverManager.getConnection(connectUrl,user,password);
		java.sql.Statement stmt = conn.createStatement();
		String sql = null;
		if(level == 1)
			sql = "insert into level1(time)"+"Values('"+time+"')";
		else if(level==2)
			sql = "insert into level2(time)"+"Values('"+time+"')";
		else if(level==3)
			sql = "insert into level3(time)"+"Values('"+time+"')";
		
		stmt.execute(sql);
	}
	

}

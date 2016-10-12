package www.hwh.myjdbc;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.*;

public class Test {

	public static void main(String[] args) {

		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/mytest";
		String username = "root";
		String password = "roomroom";
		Connection con = null;
		Statement st = null;
		try {
			Class.forName(driver);
			con = (Connection) DriverManager.getConnection(url, username, password);
			
			//����statementִ�в�����������Ƽ�
			// st = (Statement) con.createStatement();
			// st.executeUpdate("insert into StudentTable(NAME,DATE)
			// values('Zhang San',now())");
			
			//ִ�в������
			/*String sql = ("insert into StudentTable(NAME,DATE) values(?,?)");
			PreparedStatement pre = (PreparedStatement) con.prepareStatement(sql);
			pre.setObject(1, "abc");
			pre.setObject(2, new Date(System.currentTimeMillis()));
			pre.execute();*/
			
			//ִ�в�ѯ����
			/*String que = "select ID,NAME from StudentTable";
			PreparedStatement pre1 = (PreparedStatement) con.prepareStatement(que);
			ResultSet rs = pre1.executeQuery();*/

			/*while (rs.next()) {
				int id = rs.getInt("ID");
				String name = rs.getString("NAME");
				System.out.println("ID=" + id + "; NAME=" + name);
			}*/
			//���������� Ԥ������Ҫ�����ڴ棬Ӧʹ��statement
			long first = System.currentTimeMillis();
			con.setAutoCommit(false);
			Statement state = (Statement) con.createStatement();
			for(int i=1;i<20000;i++){
				state.addBatch("insert into StudentTable(NAME,DATE) values('hwh"+i+"',now())");
			}
			state.executeBatch();
			con.commit();
			long last = System.currentTimeMillis();
			System.out.println("����ʱ��Ϊ"+(last-first));

		} catch (Exception ex) {
			/*try {
				con.rollback(); //���ʧ�ܣ���ɻع�
			} catch (SQLException e) {
				e.printStackTrace();
			}//
*/			ex.printStackTrace();
		} finally {
			if (st != null)
				try {
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

}

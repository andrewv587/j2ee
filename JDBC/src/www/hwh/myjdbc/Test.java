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
			
			//利用statement执行插入操作，不推荐
			// st = (Statement) con.createStatement();
			// st.executeUpdate("insert into StudentTable(NAME,DATE)
			// values('Zhang San',now())");
			
			//执行插入操作
			/*String sql = ("insert into StudentTable(NAME,DATE) values(?,?)");
			PreparedStatement pre = (PreparedStatement) con.prepareStatement(sql);
			pre.setObject(1, "abc");
			pre.setObject(2, new Date(System.currentTimeMillis()));
			pre.execute();*/
			
			//执行查询操作
			/*String que = "select ID,NAME from StudentTable";
			PreparedStatement pre1 = (PreparedStatement) con.prepareStatement(que);
			ResultSet rs = pre1.executeQuery();*/

			/*while (rs.next()) {
				int id = rs.getInt("ID");
				String name = rs.getString("NAME");
				System.out.println("ID=" + id + "; NAME=" + name);
			}*/
			//进行批处理 预编译需要消耗内存，应使用statement
			long first = System.currentTimeMillis();
			con.setAutoCommit(false);
			Statement state = (Statement) con.createStatement();
			for(int i=1;i<20000;i++){
				state.addBatch("insert into StudentTable(NAME,DATE) values('hwh"+i+"',now())");
			}
			state.executeBatch();
			con.commit();
			long last = System.currentTimeMillis();
			System.out.println("花费时间为"+(last-first));

		} catch (Exception ex) {
			/*try {
				con.rollback(); //如果失败，则可回滚
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

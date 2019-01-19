package RoomEscape;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class RoomEscapeDAO {
	private static String driverClassName = "org.mariadb.jdbc.Driver";
	private static String driverServerURL = "jdbc:mariadb://localhost:3306/roomescape";
	private static String driverUserId = "root";
	private static String driverUserPw = "quydcjf2";
	private Connection con = null;

	private void connect() {
		try {
			Class.forName(driverClassName);
			con = DriverManager.getConnection(driverServerURL, driverUserId, driverUserPw);
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	public void insertGuest(RoomEscape RE) throws Exception {
		connect();
		String sql = "insert into guest values(?, ?, ?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, RE.getName());
			pstmt.setString(2, RE.getDate());
			pstmt.setInt(3, RE.getCount());

			pstmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			con.close();
		}
	}

	public void deleteGuest(String name) throws Exception {
		connect();
		String sql = "delete from guest where name=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);

			pstmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			con.close();
		}
	}
	/*
	public void updateGuest(RoomEscape RE) throws Exception {
		connect();
		String sql = "update guest set date=?, count=? where name=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, RE.getDate());
			pstmt.setInt(2, RE.getCount());
			pstmt.setString(3, RE.getName());

			pstmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			con.close();
		}
	}
	*/

	public Vector listGuests() throws Exception {
		Vector data = new Vector();
		connect();
		String sql = "select * from guest order by count desc";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String name = rs.getString(1);
				String date = rs.getString(2);
				int count = rs.getInt(3);

				Vector row = new Vector();

				row.add(name);
				row.add(date);
				row.add(count);
				data.add(row);
			} // while
		} catch (Exception e) {
			throw e;
		} finally {
			con.close();
		}
		return data;
	}
}
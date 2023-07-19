package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBCUtil;
import model.Sach;

public class SachDAO implements DAOInterface<Sach> {

	public static SachDAO getInstance() {
		return new SachDAO();
	}

	@Override
	public int add(Sach t) {
		// TODO Auto-generated method stub

		try {
			// B1 tao connection
			Connection cnt = JDBCUtil.getConnection();

			// B2 tao statement
			Statement stm = cnt.createStatement();

			// B3 tao SQL
			String sql = "INSERT INTO sach (id,tenSach, giaBan, namXuatBan)" + " VALUES ('" + t.getId() + "','"
					+ t.getTenSach() + "'," + t.getGiaBan() + "," + t.getNamXuatBan() + ")";
			int ketQua = stm.executeUpdate(sql);
			// B4
			System.out.println("Da thuc thi : " + sql);
			System.out.println(ketQua + " dong bi thay doi!");

			// B5 close connection
			JDBCUtil.closeConnection(cnt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public int update(Sach t) {
		// TODO Auto-generated method stub
		try {
			// B1 tao connection
			Connection cnt = JDBCUtil.getConnection();

			// B2 Tạo SQL

			String sql = " update sach set tenSach=?, giaBan=?, namXuatBan=? where  id=? ;";

			// B3 tao statement
			PreparedStatement stm = cnt.prepareStatement(sql);
			// set giá trị cho parameter

			stm.setString(1, t.getTenSach());
			stm.setFloat(2, t.getGiaBan());
			stm.setInt(3, t.getNamXuatBan());
			stm.setString(4, t.getId());

			// tao SQL with Statement
//			String sql = "UPDATE sach " + " SET (" + t.getGiaBan() + " = " + t.getGiaBan() + " + 20000 )" 
//					+ " WHERE ('"+ t.getId() + "' = 'Java 1')";
//			String sql = "UPDATE sach "+
//					 " SET " +
//					 " tenSach='"+ t.getTenSach()+"'"
//					 +
//					 ", giaBan="+ t.getGiaBan()
//					 +  
//					 ", namXuatBan="+ t.getNamXuatBan()
//					 +
//					 " WHERE id='"+t.getId()+"\'";

			// System.out.println(stm);

			int ketQua = stm.executeUpdate();
			// B4
			System.out.println("Da thuc thi : " + stm);
			System.out.println(ketQua + " dong bi thay doi!");

			// B5 close connection
			JDBCUtil.closeConnection(cnt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 1;
	}

	@Override
	public int delete(Sach t) {

		try {
			// B1 get connection
			Connection cnt = JDBCUtil.getConnection();

			// B2 Create SQL query
			String sql = " DELETE FROM sach WHERE id=?  ";
			PreparedStatement stm = cnt.prepareStatement(sql);
			stm.setString(1, t.getId());
			System.out.println(stm);

			// B3 Thực thi Update
			int kq = stm.executeUpdate();
			System.out.println("Da thuc thi: " + sql);
			System.out.println("So dong thay doi: " + kq);

			// B4 Close connection
			JDBCUtil.closeConnection(cnt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public ArrayList<Sach> selectAll() {
		ArrayList<Sach> listSach = new ArrayList<Sach>();

		try {
			// B1 get connection
			Connection cnt = JDBCUtil.getConnection();

			// B2 Create SQL query
			String sql = " SELECT * FROM sach  ";
			PreparedStatement stm = cnt.prepareStatement(sql);

			System.out.println(stm);

			// B3 Thực thi Update
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				String id = rs.getString("id");
				float giaBan = rs.getFloat("giaBan");
				String tenSach = rs.getString("tenSach");
				int nam = rs.getInt("namXuatBan");
				Sach s = new Sach(id, tenSach, giaBan, nam);
				listSach.add(s);
				System.out.println(s);
			}
			// System.out.println(rs);
			System.out.println("Da thuc thi: " + sql);
			// System.out.println("So dong thay doi: "+kq);

			// B4 Close connection
			JDBCUtil.closeConnection(cnt);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Sach selectById(Sach t) {

		try {
			// B1 get connection
			Connection cnt = JDBCUtil.getConnection();

			// B2 Create SQL query
			String sql = " SELECT * FROM sach where id=? 0 ";
			PreparedStatement stm = cnt.prepareStatement(sql);
			stm.setString(1, t.getId());
			System.out.println(stm);

			// B3 Thực thi Update
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				String id = rs.getString("id");

				String ten = rs.getString(2);

				float gia = rs.getFloat(3);
				int nam = rs.getInt(4);
				Sach s = new Sach(id, ten, gia, nam);
				System.out.println("Két qua: " + s);
			}
			System.out.println("Da thuc thi: " + sql);

			// System.out.println("So dong thay doi: "+kq);

			// B4 Close connection
			JDBCUtil.closeConnection(cnt);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<Sach> selectByCondition(String condition) {
		ArrayList<Sach> listSach = new ArrayList<Sach>();

		try {
			// B1 get connection
			Connection cnt = JDBCUtil.getConnection();

			// B2 Create SQL query
			String sql = " SELECT * FROM sach where " + condition;
			PreparedStatement stm = cnt.prepareStatement(sql);

			System.out.println(stm);

			// B3 Thực thi Query
			ResultSet rs = stm.executeQuery();
			int count = 0;
			while (rs.next()) {
				String id = rs.getString("id");
				float giaBan = rs.getFloat("giaBan");
				String tenSach = rs.getString("tenSach");
				int nam = rs.getInt("namXuatBan");
				Sach s = new Sach(id, tenSach, giaBan, nam);
				listSach.add(s);
				System.out.println(s);
				count++;
			}
			if (count == 0) {
				System.out.println("Không tìm thấy sách có condition: " + condition);
			}
			// System.out.println(rs);
			System.out.println("Da thuc thi: " + sql);
			// System.out.println("So dong thay doi: "+kq);

			// B4 Close connection
			JDBCUtil.closeConnection(cnt);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}

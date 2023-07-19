package dao;

import java.sql.Connection;
//import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.JDBCUtil;
import model.KhachHang;

public class KhachHangDAO implements DAOInterface<KhachHang> {

	public static KhachHangDAO getInstance() {
		return new KhachHangDAO();
	}
	@Override
	public int add(KhachHang t) {
		
		try {
			Connection cnt = JDBCUtil.getConnection();
			System.out.println(cnt);
			String sql = "INSERT INTO khachhang VALUES (?, ?, ?, ?); ";
			PreparedStatement stm = cnt.prepareStatement(sql);
			stm.setLong(1, t.getId());
			stm.setString(2, t.getHoVaTen());
			//Date date = new Date(0, 0, 0);
			stm.setString(3, t.getNgaySinh());
			stm.setString(4, t.getDiaChi());
			int kq = stm.executeUpdate();
			
			System.out.println("Đã thực thi: " + stm);
			System.out.println("Số dòng thay đổi: "+kq);
			JDBCUtil.closeConnection(cnt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int update(KhachHang t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(KhachHang t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<KhachHang> selectAll() {

		ArrayList<KhachHang> dskh = new ArrayList<KhachHang>();
		try {
			Connection cnt = JDBCUtil.getConnection();
			String sql = " SELECT * FROM khachhang";
			PreparedStatement stm = cnt.prepareStatement(sql);
			
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				String ten = rs.getString(2);
				String ngay = rs.getString(3);
				String diaChi = rs.getString(4);
				KhachHang kh = new KhachHang(id, ten, ngay, diaChi);
				dskh.add(kh);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dskh;
	}

	@Override
	public KhachHang selectById(KhachHang t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<KhachHang> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}


}

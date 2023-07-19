package test;

import java.util.ArrayList;

import dao.KhachHangDAO;
import model.KhachHang;

public class testKhachHangDAO {
	public static void main(String[] args) {
		//KhachHang khach = new KhachHang(0, null, 2000-2-2, null);
		//add khách hàng
//		for (int i = 0;i<100;i++) { 
//			KhachHang khach = new KhachHang(i,"Phan Van " + i,"2000-03-2"+i%2, i+100 +" Lý Thường Kiệt");
//			KhachHangDAO.getInstance().add(khach);	
//		}
		// Print danh sách khách hàng
		ArrayList<KhachHang> kh = KhachHangDAO.getInstance().selectAll();
		for (KhachHang khachHang : kh) {
			System.out.println(khachHang);
		}
		jjw

	}
}

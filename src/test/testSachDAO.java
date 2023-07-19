package test;

import dao.SachDAO;
import model.Sach;

public class testSachDAO {
	public static void main(String[] args) {
		
		Sach sach1 = new Sach("Java 6", "Lap Trinh Java", 50000, 2021);
		Sach sach2 = new Sach("C", "Lap Trinh C", 40000, 20238);
		
		//1.  add sách 
		//SachDAO.getInstance().add(sach2)
		// add nhiều sách
//		for(int i = 0; i < 10; i++) {
//			Sach sach = new Sach("Java "+i, "Lap Trinh Java "+i, 50000 +2*i, 2021+i);
//			SachDAO.getInstance().add(sach); 
//		}
		//2. Update sách
		//SachDAO.getInstance().update(sach2);
		
		//3. Delete sach
		//SachDAO.getInstance().delete(sach2);
		
//		for(int i=0; i<5; i++) {
//			Sach sach = new Sach("Java "+i);
//			SachDAO.getInstance().delete(sach);
//		}
		//4. Print ra List Sach
		//SachDAO.getInstance().selectAll();
		//5 Print sach by ID
		SachDAO.getInstance().selectById(sach1);
		//SachDAO.getInstance().selectByCondition("namXuatBan>2027");
	}
}

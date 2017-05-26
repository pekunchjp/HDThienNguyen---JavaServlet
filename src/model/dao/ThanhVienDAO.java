package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.ThanhVien;

public class ThanhVienDAO {

	public static ArrayList<ThanhVien> getListThanhVien() {
		Connection conn = Connect.connect();
		String sql = "SELECT * FROM THANHVIEN";
		ResultSet rs = null;
		try {
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		ArrayList<ThanhVien> list = new ArrayList<ThanhVien>();
		ThanhVien tv;
		try {
			while (rs.next()) {
				tv = new ThanhVien();
				tv.setMaTV(rs.getString("MaTV"));
				tv.setHoTen(rs.getString("HoTen"));
				tv.setGioiTinh(rs.getInt("GioiTinh"));
				java.util.Date utilDate = rs.getDate("NgaySinh");
				Date sqlDate = new Date(utilDate.getTime());
				tv.setNgaySinh(sqlDate);
				tv.setDiaChiEmail(rs.getString("DiaChiEmail"));
				tv.setSoDienThoai(rs.getString("SoDienThoai"));
				list.add(tv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}

package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.DiemTrungBinh;

public class ThamGiaDAO {
	public static ArrayList<DiemTrungBinh> getDanhSachDiemTrungBinh() {
		Connection conn = Connect.connect();
		String sql = "SELECT tv.MaTV, tv.HoTen, AVG(DiemTruongDoan) DTB FROM THANHVIEN tv INNER JOIN HOATDONG hd ON tv.MaTV = hd.MaTV INNER JOIN THAMGIA tg ON tg.MaHD = hd.MaHD GROUP BY tv.MaTV, tv.HoTen ORDER BY DTB DESC";
		ResultSet rs = null;
		try {
			Statement st = conn.createStatement();
			rs = st.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage() + e.getErrorCode());
		}
		ArrayList<DiemTrungBinh> list = new ArrayList<>();
		DiemTrungBinh dtb;
		try {
			while (rs.next()) {
				dtb = new DiemTrungBinh();
				dtb.setMaTV(rs.getString("MaTV"));
				dtb.setTenTV(rs.getString("HoTen"));
				dtb.setDiemTB(rs.getFloat("DTB"));
				list.add(dtb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}

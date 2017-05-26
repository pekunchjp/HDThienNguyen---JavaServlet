package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.HoatDong;

public class HoatDongDAO {
	public static void themHoatDong(HoatDong hd) {
		Connection conn = Connect.connect();
		String sql = "INSERT INTO HOATDONG (MaHD, TenHD, MoTaHD, NgayGioBD, NgayGioKT, SLToiThieuYC, SLToiDaYC, ThoiHanDK, TrangThai, MaTV) VALUES(?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareCall(sql);
			ps.setString(1, hd.getMaHoatDong());
			ps.setString(2, hd.getTenHoatDong());
			ps.setString(3, hd.getMoTaHoatDong());
			ps.setTimestamp(4, hd.getNgayGioBD());
			ps.setTimestamp(5, hd.getNgayGioKT());
			ps.setInt(6, hd.getSoLuongToiThieuYC());
			ps.setInt(7, hd.getSoLuongToiDaYC());
			ps.setDate(8, hd.getThoiHanDK());
			ps.setString(9, hd.getTrangThai());
			ps.setString(10, hd.getMaTV());
			ps.executeUpdate();
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<HoatDong> getDanhSachHoatDong() {
		Connection conn = Connect.connect();
		String sql = "SELECT * FROM HOATDONG";
		ResultSet rs = null;
		try {
			Statement st = conn.createStatement();
			rs = st.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage() + e.getErrorCode());
		}

		ArrayList<HoatDong> list = new ArrayList<HoatDong>();
		HoatDong hd;
		try {
			while (rs.next()) {
				hd = new HoatDong();
				hd.setMaHoatDong(rs.getString("MaHD"));
				hd.setTenHoatDong(rs.getString("TenHD"));
				hd.setMoTaHoatDong(rs.getString("MoTaHD"));
				hd.setNgayGioBD(rs.getTimestamp("NgayGioBD"));
				hd.setNgayGioKT(rs.getTimestamp("NgayGioKT"));
				hd.setSoLuongToiThieuYC(rs.getInt("SLToiThieuYC"));
				hd.setSoLuongToiDaYC(rs.getInt("SLToiDaYC"));

				java.util.Date utilDate = rs.getDate("ThoiHanDK");
				Date sqlDate = new Date(utilDate.getTime());
				hd.setThoiHanDK(sqlDate);

				hd.setMaTV(rs.getString("MaTV"));
				hd.setTrangThai(rs.getString("TrangThai"));
				list.add(hd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static HoatDong getHoatDong(String maHD) {
		Connection conn = Connect.connect();
		String sql = String.format("SELECT * FROM HOATDONG WHERE MaHD = '%s'", maHD);
		ResultSet rs = null;
		try {
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		HoatDong hd = new HoatDong();
		try {
			while (rs.next()) {
				hd.setMaHoatDong(maHD);
				hd.setTenHoatDong(rs.getString("TenHD"));
				hd.setMoTaHoatDong(rs.getString("MoTaHD"));
				hd.setNgayGioBD(rs.getTimestamp("NgayGioBD"));
				hd.setNgayGioKT(rs.getTimestamp("NgayGioKT"));
				hd.setSoLuongToiThieuYC(rs.getInt("SLToiThieuYC"));
				hd.setSoLuongToiDaYC(rs.getInt("SLToiDaYC"));

				java.util.Date utilDate = rs.getDate("ThoiHanDK");
				Date sqlDate = new Date(utilDate.getTime());
				hd.setThoiHanDK(sqlDate);

				hd.setMaTV(rs.getString("MaTV"));
				hd.setTrangThai(rs.getString("TrangThai"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return hd;
	}

	public static void suaHoatDong(HoatDong hd) {
		Connection conn = Connect.connect();
		String sql = "UPDATE HOATDONG SET TenHD = ?, MoTaHD = ?, NgayGioBD = ?, NgayGioKT = ?, SLToiThieuYC = ?, SLToiDaYC = ?, ThoiHanDK = ?, TrangThai = ?, MaTV = ? WHERE MaHD = ?";
		try {
			PreparedStatement ps = conn.prepareCall(sql);
			ps.setString(1, hd.getTenHoatDong());
			ps.setString(2, hd.getMoTaHoatDong());
			ps.setTimestamp(3, hd.getNgayGioBD());
			ps.setTimestamp(4, hd.getNgayGioKT());
			ps.setInt(5, hd.getSoLuongToiThieuYC());
			ps.setInt(6, hd.getSoLuongToiDaYC());
			ps.setDate(7, hd.getThoiHanDK());
			ps.setString(8, hd.getTrangThai());
			ps.setString(9, hd.getMaTV());
			ps.setString(10, hd.getMaHoatDong());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void xoaHoatDong(String maHD) {
		Connection conn = Connect.connect();
		String sql = String.format("DELETE FROM HOATDONG WHERE MaHD = '%s'", maHD);
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

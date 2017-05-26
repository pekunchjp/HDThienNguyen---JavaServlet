package model.bean;

import java.sql.Date;
import java.sql.Timestamp;

public class HoatDong {
	private String maHoatDong;
	private String tenHoatDong;
	private String moTaHoatDong;
	private Timestamp ngayGioBD;
	private Timestamp ngayGioKT;
	private int soLuongToiThieuYC;
	private int soLuongToiDaYC;
	private Date thoiHanDK;
	private String trangThai;
	private String maTV;
	private String lyDoHuyHD;

	public String getMaHoatDong() {
		return maHoatDong;
	}

	public void setMaHoatDong(String maHoatDong) {
		this.maHoatDong = maHoatDong;
	}

	public String getTenHoatDong() {
		return tenHoatDong;
	}

	public void setTenHoatDong(String tenHoatDong) {
		this.tenHoatDong = tenHoatDong;
	}

	public String getMoTaHoatDong() {
		return moTaHoatDong;
	}

	public void setMoTaHoatDong(String moTaHoatDong) {
		this.moTaHoatDong = moTaHoatDong;
	}

	public Timestamp getNgayGioBD() {
		return ngayGioBD;
	}

	public void setNgayGioBD(Timestamp ngayGioBD) {
		this.ngayGioBD = ngayGioBD;
	}

	public Timestamp getNgayGioKT() {
		return ngayGioKT;
	}

	public void setNgayGioKT(Timestamp ngayGioKT) {
		this.ngayGioKT = ngayGioKT;
	}

	public int getSoLuongToiThieuYC() {
		return soLuongToiThieuYC;
	}

	public void setSoLuongToiThieuYC(int soLuongToiThieuYC) {
		this.soLuongToiThieuYC = soLuongToiThieuYC;
	}

	public int getSoLuongToiDaYC() {
		return soLuongToiDaYC;
	}

	public void setSoLuongToiDaYC(int soLuongToiDaYC) {
		this.soLuongToiDaYC = soLuongToiDaYC;
	}

	public Date getThoiHanDK() {
		return thoiHanDK;
	}

	public void setThoiHanDK(Date thoiHanDK) {
		this.thoiHanDK = thoiHanDK;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public String getMaTV() {
		return maTV;
	}

	public void setMaTV(String maTV) {
		this.maTV = maTV;
	}

	public String getLyDoHuyHD() {
		return lyDoHuyHD;
	}

	public void setLyDoHuyHD(String lyDoHuyHD) {
		this.lyDoHuyHD = lyDoHuyHD;
	}

}

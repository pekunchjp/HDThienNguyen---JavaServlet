package model.bean;

import java.sql.Timestamp;

public class ThamGia {
	private String maTV;
	private String maHD;
	private Timestamp ngayGioDK;
	private float diemTruongDoan;
	private int diemTieuChi1;
	private int diemTieuChi2;
	private int diemTieuChi3;
	private String nhanXetKhac;

	public String getMaTV() {
		return maTV;
	}

	public void setMaTV(String maTV) {
		this.maTV = maTV;
	}

	public String getMaHD() {
		return maHD;
	}

	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}

	public Timestamp getNgayGioDK() {
		return ngayGioDK;
	}

	public void setNgayGioDK(Timestamp ngayGioDK) {
		this.ngayGioDK = ngayGioDK;
	}

	public float getDiemTruongDoan() {
		return diemTruongDoan;
	}

	public void setDiemTruongDoan(float diemTruongDoan) {
		this.diemTruongDoan = diemTruongDoan;
	}

	public int getDiemTieuChi1() {
		return diemTieuChi1;
	}

	public void setDiemTieuChi1(int diemTieuChi1) {
		this.diemTieuChi1 = diemTieuChi1;
	}

	public int getDiemTieuChi2() {
		return diemTieuChi2;
	}

	public void setDiemTieuChi2(int diemTieuChi2) {
		this.diemTieuChi2 = diemTieuChi2;
	}

	public int getDiemTieuChi3() {
		return diemTieuChi3;
	}

	public void setDiemTieuChi3(int diemTieuChi3) {
		this.diemTieuChi3 = diemTieuChi3;
	}

	public String getNhanXetKhac() {
		return nhanXetKhac;
	}

	public void setNhanXetKhac(String nhanXetKhac) {
		this.nhanXetKhac = nhanXetKhac;
	}

}

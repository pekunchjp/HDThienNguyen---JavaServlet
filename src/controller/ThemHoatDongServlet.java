package controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.HoatDong;
import model.bean.ThanhVien;
import model.dao.ThanhVienDAO;
import model.dao.HoatDongDAO;

public class ThemHoatDongServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ThemHoatDongServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		// Lay danh sach thanh vien tu database
		ArrayList<ThanhVien> listTV = ThanhVienDAO.getListThanhVien();
		request.setAttribute("listThanhVien", listTV);

		// Lay ma thanh vien tu jsp
		String maTV = request.getParameter("maTV");

		// neu ton tai ma thanh vien trong danh sach thanh vien thi moi co the them hoat dong
		boolean coTheThem = false;
		for (ThanhVien tv : listTV) {
			if (maTV.equals(tv.getMaTV())) {
				coTheThem = true;
				break;
			}
		}

		// neu nguoi dung nhan nut submit dong thoi maTV ton tai
		if ("submit".equals(request.getParameter("submit")) && coTheThem == true) {
			HoatDong hd = new HoatDong();
			hd.setMaHoatDong(request.getParameter("maHD"));
			hd.setTenHoatDong(request.getParameter("tenHD"));
			hd.setMoTaHoatDong(request.getParameter("moTaHD"));
			
			//dinh dang tu Datetime-local sang Timestamp
			String ngayGioBDStr = request.getParameter("ngayGioBD") + ":00";
			hd.setNgayGioBD(Timestamp.valueOf(ngayGioBDStr.replace("T"," ")));
			
			String ngayGioKTStr = request.getParameter("ngayGioKT") + ":00";
			hd.setNgayGioKT(Timestamp.valueOf(ngayGioKTStr.replace("T"," ")));

			hd.setSoLuongToiThieuYC(Integer.parseInt(request.getParameter("soLuongToiThieuYC")));
			hd.setSoLuongToiDaYC(Integer.parseInt(request.getParameter("soLuongToiDaYC")));
			
			//String -> util.Date ->sql.Date
			String thoiGianDKStr = request.getParameter("thoiHanDK");
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			try {
				java.util.Date thoiGianDK = formatter.parse(thoiGianDKStr);
				java.sql.Date sqlDate = new java.sql.Date(thoiGianDK.getTime());
				hd.setThoiHanDK(sqlDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			hd.setTrangThai(request.getParameter("trangThai"));
			hd.setMaTV(maTV);
			HoatDongDAO.themHoatDong(hd);
			RequestDispatcher rd = request.getRequestDispatcher("danhSachHoatDong.jsp");
			rd.forward(request, response);
		} else {
			System.out.println("Thêm không thành công");
			RequestDispatcher rd = request.getRequestDispatcher("themHoatDong.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

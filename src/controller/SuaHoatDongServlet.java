package controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.HoatDong;
import model.dao.HoatDongDAO;

public class SuaHoatDongServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SuaHoatDongServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//lấy mã hoạt động để cập nhật
		String maHD = request.getParameter("maHD");
		if("submit".equals(request.getParameter("submit"))){		//khi nhấn nút xác nhận tại trang sửa HD, HD sẽ đc sửa
			HoatDong hd = new HoatDong();
			hd.setMaHoatDong(maHD);
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
			hd.setMaTV(request.getParameter("maTV"));
			HoatDongDAO.suaHoatDong(hd);
			RequestDispatcher rd = request.getRequestDispatcher("DanhSachHoatDongServlet");
			rd.forward(request, response);
		} else {												  // khi nhấn vào icon update trang danh sách hoạt động
			HoatDong hd = HoatDongDAO.getHoatDong(maHD);
			request.setAttribute("hd", hd);
			RequestDispatcher rd = request.getRequestDispatcher("suaHoatDong.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

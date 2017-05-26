package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.HoatDong;
import model.dao.HoatDongDAO;

public class XoaHoatDongServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public XoaHoatDongServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String maHD = request.getParameter("maHD");
		HoatDong hd = HoatDongDAO.getHoatDong(maHD);
		if(!"Đã kết thúc".equalsIgnoreCase(hd.getTrangThai())) {
			HoatDongDAO.xoaHoatDong(maHD);
		}
		response.sendRedirect("DanhSachHoatDongServlet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

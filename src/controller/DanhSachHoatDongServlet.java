package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.HoatDong;
import model.dao.HoatDongDAO;

public class DanhSachHoatDongServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DanhSachHoatDongServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//lấy danh sách hoạt động
		ArrayList<HoatDong> listHD = HoatDongDAO.getDanhSachHoatDong();
		request.setAttribute("danhSachHoatDong", listHD);
		
		RequestDispatcher rd = request.getRequestDispatcher("danhSachHoatDong.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

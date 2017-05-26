package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.DiemTrungBinh;
import model.dao.ThamGiaDAO;

public class DiemTrungBinhServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DiemTrungBinhServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<DiemTrungBinh> listDTB = ThamGiaDAO.getDanhSachDiemTrungBinh();
		request.setAttribute("listDTB", listDTB);
		RequestDispatcher rd = request.getRequestDispatcher("diemTrungBinh.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

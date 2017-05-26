<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="UTF-8">
<title>Danh sách các hoạt động đã đăng kí</title>
<link rel="stylesheet" href="css/bootstrap.min.css"/>
<link rel="stylesheet" href="css/style.css"/>
</head>
<body>
	<div class="container"> 
		<div class="chapters-header">
			Danh sách hoạt động
		</div>
		<br>
		<div class="bs-example">
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Mã hoạt động</th>
						<th>Tên hoạt động</th>
						<th>Mô tả hoạt động</th>
						<th>Ngày giờ bắt đầu</th>
						<th>Ngày giờ kết thúc</th>
						<th>Số lượng tối thiểu</th>
						<th>Số lượng tối đa</th>
						<th>Thời hạn đăng kí</th>
						<th>Trạng thái</th>
						<th>Mã thành viên(TT)</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="hd" items="${danhSachHoatDong}">
					<tr>
						<th scope="row">${hd.getMaHoatDong()}</th>
						<td>${hd.getTenHoatDong()}</td>
						<td>${hd.getMoTaHoatDong()}</td>
						<td>${hd.getNgayGioBD()}</td>
						<td>${hd.getNgayGioKT()}</td>
						<td>${hd.getSoLuongToiThieuYC()}</td>
						<td>${hd.getSoLuongToiDaYC()}</td>
						<td>${hd.getThoiHanDK()}</td>
						<td>${hd.getTrangThai()}</td>
						<td>${hd.getMaTV()}</td>
						<td>
							<a href="SuaHoatDongServlet?maHD=${hd.getMaHoatDong()}">
								<span class="glyphicon glyphicon-edit"></span>
							</a> 
							<a href="XoaHoatDongServlet?maHD=${hd.getMaHoatDong()}">
								<span class="glyphicon glyphicon-trash"></span>
							</a>
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div>
            <a class="btn btn-default" type="submit" href="themHoatDong.jsp">Thêm mới hoạt động</a>
            <a class="btn btn-default" type="submit" href="DiemTrungBinhServlet">Xem điểm trung bình</a>
        </div>
	</div>
</body>
</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="UTF-8">
<title>Điểm trung bình</title>
<link rel="stylesheet" href="css/bootstrap.min.css"/>
<link rel="stylesheet" href="css/style.css"/>
</head>
<body>
	<div class="container">
		<div class="chapters-header">
			Điểm trung bình các trưởng đoàn
		</div>
		<br>
		<div class="bs-example">
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Mã trưởng đoàn</th>
						<th>Tên trưởng đoàn</th>
						<th>Điểm đánh giá trung bình</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="dtb" items="${listDTB}">
					<tr>
						<th scope="row">${dtb.getMaTV()}</th>
						<td>${dtb.getTenTV()}</td>
						<td>${dtb.getDiemTB()}</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div>
            <a class="btn btn-default" href="DanhSachHoatDongServlet">Danh sách hoạt động</a>
            <a class="btn btn-default" onclick="history.go(-1);">Quay lại</a>
        </div>
	</div>
</body>
</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>Thêm hoạt động</title>
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" href="css/style.css"/> 
</head>
<body>
<div class="container">
    <div class="chapters-header">
			Tạo mới hoạt động
	</div>
	<br>
    <form action="ThemHoatDongServlet" method="post">
        <div class="row form-group">
            <label class="col-lg-2">Mã hoạt động</label>
            <div class="col-lg-3">
                <input type="text" class=" form-control" name="maHD" required/>
            </div>
        </div>
        <div class="row form-group">
            <label class="col-lg-2">Tên hoạt động</label>
            <div class="col-lg-3">
                <input type="text" class=" form-control" name="tenHD" required/>
            </div>
        </div>
        <div class="row form-group">
            <label class="col-lg-2">Mô tả hoạt động</label>
            <div class="col-lg-3">
                <input type="text" class=" form-control" name="moTaHD" required/>
            </div>
        </div>
        <div class="row form-group">
            <label class="col-lg-2">Ngày giờ bắt đầu</label>
            <div class="col-lg-3">
                <input type="datetime-local" class=" form-control" name="ngayGioBD" required/>
            </div>
        </div>
        <div class="row form-group">
            <label class="col-lg-2">Ngày giờ kết thúc</label>
            <div class="col-lg-3">
                <input type="datetime-local" class=" form-control" name="ngayGioKT" required/>
            </div>
        </div>
        <div class="row form-group">
            <label class="col-lg-2">Số lượng tối thiểu</label>
            <div class="col-lg-3">
                <input type="number" class=" form-control" name="soLuongToiThieuYC" required/>
            </div>
        </div>
        <div class="row form-group">
            <label class="col-lg-2">Số lượng tối đa</label>
            <div class="col-lg-3">
                <input type="number" class=" form-control" name="soLuongToiDaYC" required/>
            </div>
        </div>
        <div class="row form-group">
            <label class="col-lg-2">Thời hạn đăng kí</label>
            <div class="col-lg-3">
                <input type="date" class=" form-control" name="thoiHanDK" required/>
            </div>
        </div>
        <div class="row form-group">
            <label class="col-lg-2">Trạng thái</label>
            <div class="col-lg-3">
                <input type="text" class=" form-control" name="trangThai" required/>
            </div>
        </div>
        <div class="row form-group">
            <label class="col-lg-2">Mã thành viên</label>
            <div class="col-lg-3">
                <input type="text" class=" form-control" name="maTV" required/>
            </div>
        </div>
        <div class="row form-group">
            <div class="col-lg-3 col-lg-offset-2">
                <button class="btn btn-default" type="submit" value="submit" name="submit">Thêm mới</button>
                <input class="btn btn-default" type="button" value="Quay lại" onclick="history.go(-1);" />
            </div>
        </div>
    </form>
    <br>
</div>
</body>
</html>
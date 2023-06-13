
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<link rel="stylesheet" href="../css/custom.css" />
</head>
<body>
    <div class="bg-top">
        <!-- 메뉴바 ---------------------------------------------------------------------------------------------------- -->
        <div class="bg-header">
            <div class="container">
                <header class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-3 mycustom-header">
                    <a href="/" class="d-flex align-items-center col-md-2 mb-2 mb-md-0 text-dark text-decoration-none">
                    </a>

                    <ul class="nav col-12 col-md-auto justify-content-center mb-md-0">
                    <li><a href="#" class="nav-link px-3 link-secondary">관광지</a></li>
                    <li><a href="#" class="nav-link px-3 link-dark">축제/공연</a></li>
                    <li><a href="#" class="nav-link px-3 link-dark">레저</a></li>
                    </ul>

                    <div class="col-md-3 text-end">
                    <button type="button" class="btn btn-outline-success me-2 mycustom-mem-btn">로그인</button>
                    <button type="button" class="btn btn-outline-success mycustom-mem-btn">회원가입</button>
                    </div>
                </header>
            </div>
        </div>
        <!-- 메뉴바 끝 -------------------------------------------------------------------------------------------------- -->
        <div class="container" style="max-width: 1100px;">
            <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-2" id="list_zone" >
                <div class="swiper-wrapper">
                    <button class="btn btn-default mycustom" type="button">서울</button>
                    <button class="btn btn-default mycustom" type="button">부산</button>
                    <button class="btn btn-default mycustom" type="button">대구</button>
                    <button class="btn btn-default mycustom" type="button">인천</button>
                    <button class="btn btn-default mycustom" type="button">광주</button>
                    <button class="btn btn-default mycustom" type="button">대전</button>
                    <button class="btn btn-default mycustom" type="button">울산</button>
                    <button class="btn btn-default mycustom" type="button">세종</button>
                    <button class="btn btn-default mycustom" type="button">경기</button>
                    <button class="btn btn-default mycustom" type="button">강원</button>
                    <button class="btn btn-default mycustom" type="button">충북</button>
                    <button class="btn btn-default mycustom" type="button">충남</button>
                    <button class="btn btn-default mycustom" type="button">전북</button>
                    <button class="btn btn-default mycustom" type="button">전남</button>
                    <button class="btn btn-default mycustom" type="button">경북</button>
                    <button class="btn btn-default mycustom" type="button">경남</button>
                    <button class="btn btn-default mycustom" type="button">제주</button>
                </div>
            </div>
        </div>
        
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>


    
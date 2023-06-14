
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
                      <li><a href="/tour/" class="nav-link px-3 link-secondary">관광지</a></li>
                      <li><a href="/main/festival" class="nav-link px-3 link-dark">축제/공연</a></li>
                      <li><a href="/main/sports" class="nav-link px-3 link-dark">레저</a></li>
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
                  <button class="btn btn-default mycustom" type="button" value="1">서울</button>
                  <button class="btn btn-default mycustom" type="button" value="6">부산</button>
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

        <!-- 사진, 관광지 정보 나오는 곳---------------------------------------------------------------------------------- -->
        <div class="album py-5 mycustom-album">
            <div class="container">
        
              <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-lg-4 g-4">
                
                <c:forEach items="${ar}" var="vo">
                <div class="col">
                  <div class="card shadow-sm">
                    <c:if test="${vo.firstimage != null && vo.firstimage.length() != 0}">
                      <img class="bd-placeholder-img card-img-top" width="100%" height="225" src="${vo.firstimage}"></svg>
                    </c:if>
                    <c:if test="${vo.firstimage == null || vo.firstimage.length() == 0}">
                      <img class="bd-placeholder-img card-img-top" width="100%" height="225" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSJ0JeP-umHMYu3Zx2850WN9gAmi55XIb3Lh35n_0ga5m9-NTXa1KvaBZRyvZnV67eD830&usqp=CAU"></svg>
                    </c:if>
        
                    <div class="card-body">
                      <p class="card-text">${vo.title}</p>
                      <div class="d-flex justify-content-between align-items-center">
                        <div class="btn-group">
                          <button type="button" class="btn btn-sm btn-outline-secondary">View</button>
                          <button type="button" class="btn btn-sm btn-outline-secondary">Edit</button>
                        </div>
                        <small class="text-muted">9 mins</small>
                      </div>
                    </div>
                  </div>
                </div>
                </c:forEach>

              </div>
            </div>
          </div>
        </div>
        <!-- 사진, 관광지 정보 나오는 곳 끝---------------------------------------------------------------------------------- -->
    </div>
    <script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    <script>
    $(document).ready(function() {
      var clickedButton = null;

      $('.mycustom').click(function() {
        if (clickedButton !== null) {
            clickedButton.removeClass('mycustom_active');
            $(this).toggleClass('mycustom_active');
            clickedButton = $(this);
        } else {
            $(this).toggleClass('mycustom_active');
            clickedButton = $(this);
        }

        var buttonValue = $(this).val(); // 클릭된 버튼의 value 값을 가져옴
      });
    });
    </script>    
  </body>
</html>


    
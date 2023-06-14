
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
<style type="text/css">
	#bbs table {
	    width:580px;
	    margin-left:10px;
	    border:1px solid black;
	    border-collapse:collapse;
	    font-size:14px;
	    
	}
	
	#bbs table caption {
	    font-size:20px;
	    font-weight:bold;
	    margin-bottom:10px;
	}
	
	#bbs table th,#bbs table td {
	    text-align:center;
	    border:1px solid black;
	    padding:4px 10px;
	}
	
	.no {width:15%}
	.subject {width:30%}
	.writer {width:20%}
	.reg {width:20%}
	.hit {width:15%}
	.title{background:lightsteelblue}
	
	.odd {background:silver}
	
	/* paging */
	
	table tfoot ol.paging {
	    list-style:none;
	}
	
	table tfoot ol.paging li {
	    float:left;
	    margin-right:8px;
	}
	
	table tfoot ol.paging li a {
	    display:block;
	    padding:3px 7px;
	    border:1px solid #00B3DC;
	    color:#2f313e;
	    font-weight:bold;
	    text-decoration: none
	}
	
	table tfoot ol.paging li a:hover {
	    background:#00B3DC;
	    color:white;
	    font-weight:bold;
	    text-decoration: none
	}
	
	.disable {
	    padding:3px 7px;
	    border:1px solid silver;
	    color:silver;
	}
	
	.now {
	   padding:3px 7px;
	    border:1px solid #ff4aa5;
	    background:#ff4aa5;
	    color:white;
	    font-weight:bold;
	}
	
	.empty{
		height: 50px;
		color: #ababab;
	}
</style>
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
                      <li><a href="/tour" class="nav-link px-3 link-secondary">관광지</a></li>
                      <li><a href="/tour?content_TypeId=15" class="nav-link px-3 link-dark">축제/공연</a></li>
                      <li><a href="/tour?content_TypeId=28" class="nav-link px-3 link-dark">레저</a></li>
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
                  <button class="btn btn-default mycustom" type="button" value="4">대구</button>
                  <button class="btn btn-default mycustom" type="button" value="2">인천</button>
                  <button class="btn btn-default mycustom" type="button" value="5">광주</button>
                  <button class="btn btn-default mycustom" type="button" value="3">대전</button>
                  <button class="btn btn-default mycustom" type="button" value="7">울산</button>
                  <button class="btn btn-default mycustom" type="button" value="8">세종</button>
                  <button class="btn btn-default mycustom" type="button" value="31">경기</button>
                  <button class="btn btn-default mycustom" type="button" value="32">강원</button>
                  <button class="btn btn-default mycustom" type="button" value="33">충북</button>
                  <button class="btn btn-default mycustom" type="button" value="34">충남</button>
                  <button class="btn btn-default mycustom" type="button" value="37">전북</button>
                  <button class="btn btn-default mycustom" type="button" value="38">전남</button>
                  <button class="btn btn-default mycustom" type="button" value="35">경북</button>
                  <button class="btn btn-default mycustom" type="button" value="36">경남</button>
                  <button class="btn btn-default mycustom" type="button" value="39">제주</button>
                </div>
            </div>
        </div>

        <!-- 사진, 관광지 정보 나오는 곳---------------------------------------------------------------------------------- -->
      <div id="cardContainer">
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
      
                  <div class="card-body mycustom-card-title">
                    <p class="card-text mycustom-card-title">${vo.title}</p>
                    <div class="d-flex justify-content-between align-items-center">
                      <div class="btn-group">
                        <button type="button" class="btn btn-sm btn-outline-secondary">View</button>
                      </div>
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
      <div class="container">
        <table>
          <tfoot>
            <tr>
              <td>
                ${pageCode}
              </td>
            </tr>
          </tfoot>
        </table>
      </div>

    </div><!--bg-top 끝-->
    </div>
    <script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    <script>
    $(document).ready(function() {

      $("button[value=${area_Code}]").toggleClass('mycustom_active');

      $('.mycustom').click(function() {

        var buttonValue = $(this).val(); // 클릭된 버튼의 value 값을 가져옴

        location.href="/tour?area_Code="+buttonValue;
        
      });
    });
    </script>    
  </body>
</html>


    
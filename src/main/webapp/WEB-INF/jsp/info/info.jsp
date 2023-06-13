<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
 <meta charset="UTF-8">
 <link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
 <link rel="stylesheet" href="/resources/demos/style.css">
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
 <link rel="stylesheet" href="../css/custom.css" />
 <script src="https://code.jquery.com/jquery-3.6.4.min.js" integrity="sha256-oP6HI9z1XaZNBrJURtCoUT5SUnxFr8s3BzRl+cbzUq8=" crossorigin="anonymous"></script>
 <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
 <title>infomation</title>
 <style>
  .img{
   width : 40%;
   height: auto;
   margin: auto;
   display: inline-block;
   left: 0%;
   position: relative;
  }
  .titlebox{
   width:40%;
   margin: auto;
   display: inline-block;
   left:100%;
   font-size: 30px;
   position: relative;
  }
 </style>
</head>
<body>
 
 <div class="bg-top" style="background-color: #FFD2D7">
  <!-- 메뉴바 ---------------------------------------------------------------------------------------------------- -->
  <div class="bg-header">
      <div class="container">
          <header class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-3 mycustom-header">
              <a href="#" class="d-flex align-items-center col-md-2 mb-2 mb-md-0 text-dark text-decoration-none">
              </a>

              <ul class="nav col-12 col-md-auto justify-content-center mb-md-0">
              <li><a href="/" class="nav-link px-3 link-secondary" style="color: #212529!important;">관광지</a></li>
              <li><a href="festival" class="nav-link px-3 link-dark" style="color: #6c757d!important;">축제/공연</a></li>
              <li><a href="sports" class="nav-link px-3 link-dark">레저</a></li>
              </ul>

              <div class="col-md-3 text-end">
              <button type="button" class="btn btn-outline-success me-2 mycustom-mem-btn">로그인</button>
              <button type="button" class="btn btn-outline-success mycustom-mem-btn">회원가입</button>
              </div>
          </header>
      </div>
  </div>
  <!-- 메뉴바 끝 -------------------------------------------------------------------------------------------------- -->
 <!-- <div class=".container">
  <div class="img"><img src="../test1.jpg" id="img"><div>
  <div class="titlebox">제목영역</div>
 </div> -->
 <div class="container px-4 px-lg-5">
  <!-- Heading Row-->
  <div class="row gx-4 gx-lg-5 align-items-center my-5">
      <div class="col-lg-7"><img class="img-fluid rounded mb-4 mb-lg-0" src="https://dummyimage.com/900x400/dee2e6/6c757d.jpg" alt="..." /></div>
      <div class="col-lg-5">
          <h1 class="font-weight-light">Business Name or Tagline</h1>
          <p>This is a template that is great for small businesses. It doesn't have too much fancy flare to it, but it makes a great use of the standard Bootstrap core components. Feel free to use this template for any project you want!</p>
          <a class="btn btn-primary" href="#!">Call to Action!</a>
      </div>
  </div>
  <!-- Call to Action-->
  <div class="card text-white bg-secondary my-5 py-4 text-center">
      <div class="card-body"><p class="text-white m-0">This call to action card is a great place to showcase some important information or display a clever tagline!</p></div>
  </div>
  <!-- Content Row-->
  <div class="row gx-4 gx-lg-5">
      <div class="col-md-4 mb-5">
          <div class="card h-100">
              <div class="card-body">
                  <h2 class="card-title">Card One</h2>
                  <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Rem magni quas ex numquam, maxime minus quam molestias corporis quod, ea minima accusamus.</p>
              </div>
              <div class="card-footer"><a class="btn btn-primary btn-sm" href="#!">More Info</a></div>
          </div>
      </div>
      <div class="col-md-4 mb-5">
          <div class="card h-100">
              <div class="card-body">
                  <h2 class="card-title">Card Two</h2>
                  <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quod tenetur ex natus at dolorem enim! Nesciunt pariatur voluptatem sunt quam eaque, vel, non in id dolore voluptates quos eligendi labore.</p>
              </div>
              <div class="card-footer"><a class="btn btn-primary btn-sm" href="#!">More Info</a></div>
          </div>
      </div>
      <div class="col-md-4 mb-5">
          <div class="card h-100">
              <div class="card-body">
                  <h2 class="card-title">Card Three</h2>
                  <p class="card-text"></p>
              </div>
              <div class="card-footer"><a id="btn-thd" class="btn btn-primary btn-sm" href="#!">More Info</a></div>
             </div>
            </div>
            <div id="map" style="width:800px;height:500px;"></div>
  </div>
</div>
<!-- Bootstrap core JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- Core theme JS-->
 <script src="js/scripts.js"></script>
 
 
 
 
 
 
 
 
 
 
 <script>
  $( function() {
    $( "#map" ).dialog({
      width:auto,
      height:auto,
      autoOpen: false,
      show: {
        effect: "blind",
        duration: 1000
      },
      hide: {
        effect: "fadeOut",
        duration: 400
      }
    });
 
    $( "#btn-thd" ).on( "click", function() {
      $( "#map" ).dialog( "open" );
    });
  } );
  </script>
 <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=b64121064fac6d582b95caba86d1124d&libraries=services"></script>
 <script>
  var container = document.getElementById('map');
		var options = {
			center: new kakao.maps.LatLng(33.450701, 126.570667),
			level: 3
		};
		var map = new kakao.maps.Map(container, options);
  
  var geocoder = new kakao.maps.services.Geocoder();
  
  // 주소로 좌표 변환 객체 생성
   var callback = function(result, status) {
   if (status === kakao.maps.services.Status.OK) { // 정상적으로 검색이 되었다면
    var cords= new kakao.maps.LatLng(result[0].y,result[0].x);
    //지도의 중심을 결과값으로 받은 위치로 이동시킴.
    /*
    var markerPosition  = cords; 

    // 마커를 생성합니다
    var marker = new kakao.maps.Marker({
     position: markerPosition
    });
    
    // 마커가 지도 위에 표시되도록 설정합니다
    marker.setMap(map);
    */


   var marker = new kakao.maps.Marker({
     position: cords,
     map:map,
     clickable: true
   });

   map.setCenter(cords);
   // style 강제 적용
   // 클래스가 marker인 요소들 모두 찾아내기
   let marker_ar = document.querySelectorAll(".marker")

   marker_ar.forEach(function(e){
    // 검색된 요소들의 수만큼 반복되는 함수
    let w = e.offsetWith + 10;
    let ml = w/2;
    e.parentElement.style.top = "80px";
    e.parentElement.style.marginLeft = -ml+"px";
    e.parentElement.style.width = w+"px";
    e.parentElement.previousElementSibling.style.display="none";
    e.parentElement.parentElement.style.border="0px";
    e.parentElement.style.left="50%";
   });
   //인포윈도우를 생성하고 장소에 대한 설명을 지도에 표시합니다
    var infowindow = new kakao.maps.InfoWindow({
     map: map, // 인포윈도우가 표시될 지도
     position : cords, 
     content : '<div class="marker">부천시청으로간다</div>',
     removable : false
    });

   //  var infowindow = new kakao.maps.InfoWindow({
   //   content : '<div class="marker">부천시청으로간다</div>',
   //  });

   //  kakao.maps.event.addListener(marker, 'click', function() {
   //    // 마커 위에 인포윈도우를 표시합니다
   //    infowindow.open(map, marker);
   
   // });
  }
  };

  geocoder.addressSearch('경기도 부천시', callback);
  </script>
</body>
</html>
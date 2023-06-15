<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
 <meta charset="UTF-8">
 
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
 <link rel="stylesheet" href="../css/custom.css" />
 <script src="https://code.jquery.com/jquery-3.6.4.min.js" integrity="sha256-oP6HI9z1XaZNBrJURtCoUT5SUnxFr8s3BzRl+cbzUq8=" crossorigin="anonymous"></script>
 
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
 <title>infomation</title>
 <style>
  .wrap {position: absolute;left: 0;bottom: 40px;width: 288px;height: 132px;margin-left: -144px;text-align: left;overflow: hidden;font-size: 12px;font-family: 'Malgun Gothic', dotum, '돋움', sans-serif;line-height: 1.5;}
    .wrap * {padding: 0;margin: 0;}
    .wrap .info {display: none;
     width: 286px;height: 120px;border-radius: 5px;border-bottom: 2px solid #ccc;border-right: 1px solid #ccc;overflow: hidden;background: #fff;}
    .wrap .info:nth-child(1) {border: 0;box-shadow: 0px 1px 2px #888;}
    .info .title {padding: 5px 0 0 10px;height: 30px;background: #eee;border-bottom: 1px solid #ddd;font-size: 18px;font-weight: bold;}
    .info .close {position: absolute;top: 10px;right: 10px;color: #888;width: 17px;height: 17px;background: url('https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/overlay_close.png');}
    .info .close:hover {cursor: pointer;}
    .info .body {position: relative;overflow: hidden;}
    .info .desc {position: relative;margin: 13px 0 0 90px;height: 75px;}
    .desc .ellipsis {overflow: hidden;text-overflow: ellipsis;white-space: nowrap;}
    .desc .jibun {font-size: 11px;color: #888;margin-top: -2px;}
    .info .img {position: absolute;top: 6px;left: 5px;width: 73px;height: 71px;border: 1px solid #ddd;color: #888;overflow: hidden;}
    .info:after {content: '';position: absolute;margin-left: -12px;left: 50%;bottom: 0;width: 22px;height: 12px;background: url('https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/vertex_white.png')}
    .info .link {color: #5085BB;}
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
  .infobox{
    display: block;
    background: #50627F;
    color: #fff;
    text-align: center;
    width: auto !important; 
    height: 24px;
    line-height:18px;
    border-radius:4px;
    padding:0px 10px;
  }
  .infobox2{
    display: block;
    background: #50627F;
    color: #fff;
    text-align: center;
    height: 24px;
    line-height:18px;
    border-radius:4px;
    padding:0px 10px;
  }
  .infobox3{
    display: block;
    background: #50627F;
    color: #fff;
    text-align: center;
    height: 24px;
    line-height:18px;
    border-radius:4px;
    padding:0px 10px;
  }
  .butt {
  -webkit-appearance: none;
  -moz-appearance: none;
  appearance: none;
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
             <li><a href="/tour" class="nav-link px-3 link-secondary" style="color: #212529!important;">관광지</a></li>
             <li><a href="/tour?content_TypeId=15" class="nav-link px-3 link-dark" style="color: #6c757d!important;">축제/공연</a></li>
             <li><a href="/tour?content_TypeId=28"  class="nav-link px-3 link-dark">레저</a></li>
           </ul>

           <c:if test="${sessionScope.mvo == null}">
             <div class="col-md-3 text-end">
               <button type="button" class="btn btn-outline-success me-2 mycustom-mem-btn" onclick="location.href='/login'">로그인</button>
               <button type="button" class="btn btn-outline-success mycustom-mem-btn" onclick="location.href='/join'">회원가입</button>
             </div>
           </c:if>
           <c:if test="${sessionScope.mvo != null}">
             <div class="col-md-3 text-end">
               <button type="button" class="btn btn-outline-success me-2 mycustom-mem-btn" onclick="location.href='/tour?isLogout=true'">로그아웃</button>
             </div>
           </c:if>
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
      <div class="col-lg-7"><img class="img-fluid rounded mb-4 mb-lg-0" src="${itmVO.firstimage}" alt="..." /></div>
      <div class="col-lg-5">
          <h1 class="font-weight-light">${itmVO.title}</h1>
          <p><h4>${itmVO.addr1}</h4></p>
          <p><h4>${itmVO.tel}</h4></p>
          <!--<a class="btn btn-primary" href="#!">Call to Action!</a>-->
      </div>
  </div>
  <!-- Call to Action-->
  <div class="card text-white bg-secondary my-5 py-4 text-center">
      <div class="card-body"><p class="text-white m-0">This call to action card is a great place to showcase some important information or display a clever tagline!</p></div>
  </div>
  <div class="accordion" id="accordionExample">
   <div class="accordion-item">
     <h2 class="accordion-header" id="headingOne">
       <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne" onclick="map1load()">
         주변 축제 및 행사
       </button>
     </h2>
     <div id="collapseOne" class="accordion-collapse collapse show" aria-labelledby="headingOne" data-bs-parent="#accordionExample">
       <div class="accordion-body">
        <div id="map" style="width:800px;height:500px;"></div>
       </div>
     </div>
   </div>
   <div class="accordion-item">
     <h2 class="accordion-header" id="headingTwo">
       <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo" onclick="map2load()">
         주변 음식점 정보
       </button>
     </h2>
     <div id="collapseTwo" class="accordion-collapse collapse" aria-labelledby="headingTwo" data-bs-parent="#accordionExample">
       <div class="accordion-body">
        <div id="map2" style="width:800px;height:500px;"></div>
       </div>
      </div>
     </div>
     <div class="accordion-item">
      <h2 class="accordion-header" id="headingThree">
       <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree" onclick="map3load()">
        주변 숙박 정보
       </button>
      </h2>
      <div id="collapseThree" class="accordion-collapse collapse" aria-labelledby="headingThree" data-bs-parent="#accordionExample">
       <div class="accordion-body">
        <div class="col-md-4 mb-5" id="map3" style="width:800px;height:500px;"></div>
       </div>
     </div>
   </div>
 </div>
 
  <!-- Content Row-->
  <!-- <div class="row gx-4 gx-lg-5">
      <div class="col-md-4 mb-5">
          <div class="card h-100">
              <div class="card-body">
                  <h2 class="card-title">주변 문화 정보</h2>
                  <p class="card-text"><img src="../image/info/mona-lisa.png"></p>
              </div>
              <div class="card-footer"><a class="btn btn-primary btn-sm" href="#!">지도 보기</a></div>
          </div>
      </div>
      <div class="col-md-4 mb-5">
          <div class="card h-100">
              <div class="card-body">
                  <h2 class="card-title">주변 숙박 정보</h2>
                  <p class="card-text"><img src="../image/info/bed.png"></p>
              </div>
              <div class="card-footer"><a class="btn btn-primary btn-sm" href="#!">지도 보기</a></div>
          </div>
      </div>
      <div class="col-md-4 mb-5">
          <div class="card h-100">
              <div class="card-body">
                  <h2 class="card-title">주변 식당 정보</h2>
                  <p class="card-text"><img src="../image/info/dish.png"></p>
              </div>
              <div class="card-footer"><a id="btn-thd" class="btn btn-primary btn-sm" href="#!">지도 보기</a></div>
             </div>
            </div>
           </div>
            -->
</div>
<!-- Bootstrap core JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- Core theme JS-->
 
 
 <!-- <script>
  function sendmapdata(file,editor){
			// 이미지 파일을 첨부하여 서버로 보내야하기 떄문에 json으로 못넘겨서 formdata가 필요하다
			var frm = new FormData();
			// 보내고자 하는 파일
			frm.append("s_file",file); // 나중에 서버에서 현재 파일을 받을 때는 반드시 s_file이라는 파라미터로 받아야함.
			$.ajax({
				url:"/info/around",
				data: json,
				type:"get",
				contentType:false,
				processData:false,
				cache:false,
				dataType:"json"
			}).done(function(data){
				let path = data.path;
				let fname = data.fname;
				
				$("#content").summernote("editor.insertImage",path+"/"+fname)
			});
			
			
		}
	


  $( function() {
    $( "#map" ).dialog({
     autoOpen: false,
      show: {
        effect: "blind",
        duration: 1000
      },
      hide: {
        effect: "fadeOut",
        duration: 400
      },
      minWidth: 800,
      minHeight:800
    });
 
    $( "#btn-thd" ).on( "click", function() {
      $( "#map" ).dialog( "open");
    });
  } );
  </script> -->
 <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=b64121064fac6d582b95caba86d1124d&libraries=services"></script>
 <script>
  
  var container = document.getElementById('map');
		var options = {
			center: new kakao.maps.LatLng(${itmVO.mapy}, ${itmVO.mapx}),
			level: 4
		};
		var map = new kakao.maps.Map(container, options);
  map.relayout();
  var position = options.center

// 마커를 생성합니다
 var marker = new kakao.maps.Marker({
  position: position,
  clickable: true // 마커를 클릭했을 때 지도의 클릭 이벤트가 발생하지 않도록 설정합니다
 });

  marker.setMap(map);

var ind = 0;
function map1load(){
 map.relayout();
}
</script>
  <c:forEach items="${iar}" var="vo">
  <script>
   var position = new kakao.maps.LatLng(${vo.mapY},${vo.mapX});
// 마커를 생성합니다
    var marker = new kakao.maps.Marker({
     position: position,
     clickable: false // 마커를 클릭했을 때 지도의 클릭 이벤트가 발생하지 않도록 설정합니다
    });
    
    var overlayid = "idnum"+ ind++;

  var iwContent = '<div style="padding:5px;width:auto;" class="infobox">${vo.title}<button type="button"  class="butt" onclick="disp(\''+overlayid+'\')"></button></div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
       iwPosition = new kakao.maps.LatLng(${vo.mapY},${vo.mapX}); //인포윈도우 표시 위치입니다

   // 인포윈도우를 생성합니다
   var infowindow = new kakao.maps.InfoWindow({
       position : iwPosition, 
       content : iwContent 
   });
   // 마커 위에 인포윈도우를 표시합니다. 두번째 파라미터인 marker를 넣어주지 않으면 지도 위에 표시됩니다
   infowindow.open(map, marker); 
   
   var content = document.createElement('div');
   content.className = 'overlay';
   content.innerHTML = '<div class="wrap">' + 
            '    <div class="info" id='+overlayid+'>' + 
            '        <div class="title">' + 
            '            ${vo.title}' + 
            '            <div class="close" onclick="closeOverlay(this)" title="닫기"></div>' + 
            '        </div>' + 
            '        <div class="body">' + 
            '            <div class="img">' +
            '                <img src="${vo.firstimage2}" width="73" height="70">' +
            '           </div>' + 
            '            <div class="desc">' + 
            '                <div class="ellipsis">${vo.addr1}</div>' +
            '                <form action="/info/infomation" method="get"><div> <input type="hidden" name="title" value="${vo.title}"/>'+
            '                <div> <input type="hidden" name="mapX" value="${vo.mapX}"/>'+
            '                <div> <input type="hidden" name="mapY" value="${vo.mapY}"/>'+
            '                <div> <input type="hidden" name="addr1" value="${vo.addr1}"/>'+
            '                <div> <input type="hidden" name="contentid" value="${vo.contentid}"/>'+
            '                <div> <input type="hidden" name="modifiedtime" value="${vo.modifiedtime}"/>'+
            '                <div> <input type="hidden" name="firstimage" value="${vo.firstimage}"/>'+
            '                <div> <input type="hidden" name="firstimage2" value="${vo.firstimage2}"/>'+
            '                <div> <input type="hidden" name="tel" value="${vo.tel}"/>'+
            '<input type="submit" value="자세히보기"/></div></form>' + 
            '            </div>' + 
            '        </div>' + 
            '    </div>' +    
            '</div>';

// 마커 위에 커스텀오버레이를 표시합니다
// 마커를 중심으로 커스텀 오버레이를 표시하기위해 CSS를 이용해 위치를 설정했습니다
var overlay = new kakao.maps.CustomOverlay({
    content: content,
    map: map,
    position: marker.getPosition()       
});

function disp(aa) {
     document.getElementById(aa).style.display="block";
};

function closeOverlay(vo){
 vo.parentElement.parentElement.style.display="none";
}
 marker.setMap(map);
 </script>
</c:forEach>



 <script>
  var container2 = document.getElementById('map2');
		var options2 = {
			center: new kakao.maps.LatLng(${itmVO.mapy}, ${itmVO.mapx}),
			level: 4
		};
		var map2 = new kakao.maps.Map(container2, options2);
  map2.relayout();
  var position2 = options2.center

// 마커를 생성합니다
 var marker2 = new kakao.maps.Marker({
  position: position2,
  clickable: true // 마커를 클릭했을 때 지도의 클릭 이벤트가 발생하지 않도록 설정합니다
 });

  marker2.setMap(map2);

var ind2 = 0;
function map2load(){
 map2.relayout();
}
</script>
  <c:forEach items="${iar2}" var="vo">
  <script>
   var position2 = new kakao.maps.LatLng(${vo.mapY},${vo.mapX});
// 마커를 생성합니다
    var marker2 = new kakao.maps.Marker({
     position: position2,
     clickable: false // 마커를 클릭했을 때 지도의 클릭 이벤트가 발생하지 않도록 설정합니다
    });
    
    var overlayid2 = "idnumm"+ ind2++;

  var iwContent2 = '<div style="width:150px;" class="infobox2">${vo.title}<button type="button"  class="butt" onclick="dispp(\''+overlayid2+'\')"></button></div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
       iwPosition2 = new kakao.maps.LatLng(${vo.mapY},${vo.mapX}); //인포윈도우 표시 위치입니다

       infowindow.close();
   // 인포윈도우를 생성합니다
   var infowindow2 = new kakao.maps.InfoWindow({
       position : iwPosition2, 
       content : iwContent2 
   });
   // 마커 위에 인포윈도우를 표시합니다. 두번째 파라미터인 marker를 넣어주지 않으면 지도 위에 표시됩니다
   infowindow2.open(map2, marker2); 
   
   var content2 = document.createElement('div');
   content2.className = 'overlay';
   content2.innerHTML = '<div class="wrap">' + 
            '    <div class="info" id='+overlayid2+'>' + 
            '        <div class="title">' + 
            '            ${vo.title}' + 
            '            <div class="close" onclick="closeOverlay(this)" title="닫기"></div>' + 
            '        </div>' + 
            '        <div class="body">' + 
            '            <div class="img">' +
            '                <img src="${vo.firstimage2}" width="73" height="70">' +
            '           </div>' + 
            '            <div class="desc">' + 
            '                <div class="ellipsis">${vo.addr1}</div>' +
            '                <form action="/info/infomation" method="get"><div> <input type="hidden" name="title" value="${vo.title}"/>'+
            '                <div> <input type="hidden" name="mapX" value="${vo.mapX}"/>'+
            '                <div> <input type="hidden" name="mapY" value="${vo.mapY}"/>'+
            '                <div> <input type="hidden" name="addr1" value="${vo.addr1}"/>'+
            '                <div> <input type="hidden" name="contentid" value="${vo.contentid}"/>'+
            '                <div> <input type="hidden" name="modifiedtime" value="${vo.modifiedtime}"/>'+
            '                <div> <input type="hidden" name="firstimage" value="${vo.firstimage}"/>'+
            '                <div> <input type="hidden" name="firstimage2" value="${vo.firstimage2}"/>'+
            '                <div> <input type="hidden" name="tel" value="${vo.tel}"/>'+
            '<input type="submit" value="자세히보기"/></div></form>' + 
            '            </div>' + 
            '        </div>' + 
            '    </div>' +    
            '</div>';

// 마커 위에 커스텀오버레이를 표시합니다
// 마커를 중심으로 커스텀 오버레이를 표시하기위해 CSS를 이용해 위치를 설정했습니다
var overlay2 = new kakao.maps.CustomOverlay({
    content: content2,
    map: map2,
    position: marker2.getPosition()       
});

function dispp(aa) {
     document.getElementById(aa).style.display="block";
};

function closeOverlay(vo){
 vo.parentElement.parentElement.style.display="none";
}
 marker2.setMap(map2);
 </script>
</c:forEach>




 <script>
  var container3 = document.getElementById('map3');
		var options3 = {
			center: new kakao.maps.LatLng(${itmVO.mapy}, ${itmVO.mapx}),
			level: 4
		};
		var map3 = new kakao.maps.Map(container3, options3);
  map3.relayout();
  var position3 = options3.center

// 마커를 생성합니다
 var marker3 = new kakao.maps.Marker({
  position: position3,
  clickable: true // 마커를 클릭했을 때 지도의 클릭 이벤트가 발생하지 않도록 설정합니다
 });

  marker3.setMap(map3);

var ind3 = 0;
function map3load(){
 map3.relayout();
}
</script>
  <c:forEach items="${iar3}" var="vo">
  <script>
   var position3 = new kakao.maps.LatLng(${vo.mapY},${vo.mapX});
// 마커를 생성합니다
    var marker3 = new kakao.maps.Marker({
     position: position3,
     clickable: false // 마커를 클릭했을 때 지도의 클릭 이벤트가 발생하지 않도록 설정합니다
    });
    
    var overlayid3 = "idnumm"+ ind3++;

  var iwContent3 = '<div style="width:300px;" class="infobox3">${vo.title}<button type="button"  class="butt" onclick="disppp(\''+overlayid3+'\')"></button></div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
       iwPosition3 = new kakao.maps.LatLng(${vo.mapY},${vo.mapX}); //인포윈도우 표시 위치입니다

       
   // 인포윈도우를 생성합니다
   var infowindow3 = new kakao.maps.InfoWindow({
       position : iwPosition3, 
       content : iwContent3
   });
   // 마커 위에 인포윈도우를 표시합니다. 두번째 파라미터인 marker를 넣어주지 않으면 지도 위에 표시됩니다
   infowindow3.open(map3, marker3); 
   
   var content3 = document.createElement('div');
   content3.className = 'overlay';
   content3.innerHTML = '<div class="wrap">' + 
            '    <div class="info" id='+overlayid3+'>' + 
            '        <div class="title">' + 
            '            ${vo.title}' + 
            '            <div class="close" onclick="closeOverlay(this)" title="닫기"></div>' + 
            '        </div>' + 
            '        <div class="body">' + 
            '            <div class="img">' +
            '                <img src="${vo.firstimage2}" width="73" height="70">' +
            '           </div>' + 
            '            <div class="desc">' + 
            '                <div class="ellipsis">${vo.addr1}</div>' +
            '                <form action="/info/infomation" method="get"><div> <input type="hidden" name="title" value="${vo.title}"/>'+
            '                <div> <input type="hidden" name="mapX" value="${vo.mapX}"/>'+
            '                <div> <input type="hidden" name="mapY" value="${vo.mapY}"/>'+
            '                <div> <input type="hidden" name="addr1" value="${vo.addr1}"/>'+
            '                <div> <input type="hidden" name="contentid" value="${vo.contentid}"/>'+
            '                <div> <input type="hidden" name="modifiedtime" value="${vo.modifiedtime}"/>'+
            '                <div> <input type="hidden" name="firstimage" value="${vo.firstimage}"/>'+
            '                <div> <input type="hidden" name="firstimage2" value="${vo.firstimage2}"/>'+
            '                <div> <input type="hidden" name="tel" value="${vo.tel}"/>'+
            '<input type="submit" value="자세히보기"/></div></form>' + 
            '            </div>' + 
            '        </div>' + 
            '    </div>' +    
            '</div>';

// 마커 위에 커스텀오버레이를 표시합니다
// 마커를 중심으로 커스텀 오버레이를 표시하기위해 CSS를 이용해 위치를 설정했습니다
var overlay3 = new kakao.maps.CustomOverlay({
    content: content3,
    map: map3,
    position: marker3.getPosition()       
});

function disppp(aaa) {
     document.getElementById(aaa).style.display="block";
};

function closeOverlay(vo){
 vo.parentElement.parentElement.style.display="none";
}
 marker3.setMap(map3);
 </script>
</c:forEach>

  <script>
   

   
   let marker_ar = document.querySelectorAll(".infobox");
   
    marker_ar.forEach(function(e){
    var w = e.offsetWidth + 10;
    var ml = w/2;
    e.parentElement.style.top = "82px";
    e.parentElement.style.left = "50%";
    e.parentElement.style.marginLeft = -ml+"px";
    e.parentElement.style.width = w+"px !important;";
    e.parentElement.previousSibling.style.display = "none";
    e.parentElement.parentElement.style.border = "0px";
    e.parentElement.parentElement.style.background = "unset";
    });

   let marker_ar2 = document.querySelectorAll(".infobox2");
   
    marker_ar2.forEach(function(e2){
    var w2 = e2.offsetWidth + 10;
    var ml2 = w2/2;
    e2.parentElement.style.top = "82px";
    e2.parentElement.style.left = "50%";
    e2.parentElement.style.marginLeft = -ml2+"px";
    e2.parentElement.style.width = w2+"px !important;";
    e2.parentElement.previousSibling.style.display = "none";
    e2.parentElement.parentElement.style.border = "0px";
    e2.parentElement.parentElement.style.background = "unset";
    });
  </script>
</body>
</html>
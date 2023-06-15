<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%
        String l_id = request.getParameter("email");
        String l_pw = request.getParameter("password");
        
    %>
    
    <!DOCTYPE html>
        <html>

        <head> <!-- ml -->
            <meta charset="UTF-8">
            <link rel="stylesheet" href="css/m_style.css">
            <link href='https://unpkg.com/boxicons@2.1.2/css/boxicons.min.css' rel='stylesheet'>
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
                integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
                crossorigin="anonymous">
            
            <link rel="stylesheet" href="../css/custom.css" />

            <script src="https://code.jquery.com/jquery-3.6.4.min.js"
                integrity="sha256-oP6HI9z1XaZNBrJURtCoUT5SUnxFr8s3BzRl+cbzUq8=" crossorigin="anonymous"></script>
            <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>

            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Login</title>
        </head>

        <body>
            
            <!-- 메뉴바 ---------------------------------------------------------------------------------------------------- -->
            <div class="bg-header">
                <div class="container">
                    <header class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-3 mycustom-header">
                        <a href="/" class="d-flex align-items-center col-md-2 mb-2 mb-md-0 text-dark text-decoration-none">
                        </a>

                        <ul class="nav col-12 col-md-auto justify-content-center mb-md-0">
                        <li><a href="/tour" class="nav-link px-3 link-dark">관광지</a></li>
                        <li><a href="/tour?content_TypeId=15" class="nav-link px-3 link-dark">축제/공연</a></li>
                        <li><a href="/tour?content_TypeId=28" class="nav-link px-3 link-dark">레저</a></li>
                        </ul>

                        <c:if test="${sessionScope.mvo == null}">
                        <div class="col-md-3 text-end">
                            <button type="button" class="btn btn-outline-success me-2 mycustom-mem-btn" onclick="location.href='login'">로그인</button>
                            <button type="button" class="btn btn-outline-success mycustom-mem-btn" onclick="location.href='join'">회원가입</button>
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

            <section class="container forms m_container">
                <div class="form login">
                    <div class="form-content">
                        <p class="m_header">Login</p class="m_header">

                        <form id="login" action="login" class="input-group" method="post" name="frm">
                            <div class="field input-field">
                                <input type="email" placeholder="email" class="input" name="email" id="email">
                            </div> 

                            <div class="field input-field">
                                <input type="password" placeholder="Password" class="password" name="password" id="password">
                                <i class='bx bx-hide eye-icon'></i>
                            </div>

                            <div class="form-link">
                                <a href="#" class="forgot-pass"></a>
                            </div>
                            
                            <div class="field button-field">
                                <button type="button" class="submit" onclick="sendData()">로그인</button>
                            </div>
                            
                        </form>
                        
                        <div class="form-link">
                            <span>회원가입 하시겠습니까? <a href="/join" class="link">Signup</a></span>
                        </div>
                    </div>

                    <div class="line"></div>
                    
                    <div class="media-options">
                        <a href="https://kauth.kakao.com/oauth/authorize?client_id=ef5415e6ed027721e4d680b30eff28fe&redirect_uri=http://localhost:8080/kakao/login&response_type=code" class="field kakao">
                            <img src="../images/kakao_login.png" alt="" class="kakao-img">
                            <span></span>
                        </a>
                    </div>

                    <div class="media-options">
                        <a href="https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=py8uuUtaAKsCCxoOKiY3&state=STATE_STRING&redirect_uri=http://localhost:8080/naver/login" class="field naver">
                            <img src="../images/naver_login.png" alt="" class="naver-img">
                            <span></span>
                        </a>
                    </div>

                </div>



                </div>
            </section>

            <body class="d-flex flex-column">
                <footer id="sticky-footer" class="flex-shrink-0 py-4 bg-dark text-white-50">
                  <div class="container text-center">
                    <small>Copyright &copy; 2023 팀이름 </small>
                  </div>
                </footer>
            </body>

            <!-- JavaScript -->
            <script src="js/m_script.js"></script>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
                crossorigin="anonymous"></script>
            <script src="https://code.jquery.com/jquery-3.6.0.min.js"
                integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
            <script>
    function sendData() {




        if ($("#email").val().trim().length <= 0) {
            alert("아이디를 입력하세요!");
            ("#email").focus();
            return;
        }

        if ($("#password").val().trim().length <= 0) {
            alert("비밀번호를 입력하세요!");
            $("#password").focus();
            return;
        }
       
        


        
        //var param = "id=" + encodeURIComponent(email.val()) + "&pw=" + encodeURIComponent(pw.val()) + "&type=login";
       document.frm.submit();
    }   


            </script>
            </body>

        </html>
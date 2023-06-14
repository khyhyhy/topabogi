<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html>

        <head> <!-- ml -->
            <meta charset="UTF-8">
            <link rel="stylesheet" href="css/m_style.css">
            <link href='https://unpkg.com/boxicons@2.1.2/css/boxicons.min.css' rel='stylesheet'>
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
                integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
                crossorigin="anonymous">
            <link rel="stylesheet" href="../css/!!!.css" />
            <script src="https://code.jquery.com/jquery-3.6.4.min.js"
                integrity="sha256-oP6HI9z1XaZNBrJURtCoUT5SUnxFr8s3BzRl+cbzUq8=" crossorigin="anonymous"></script>
            <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>

            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Login</title>
        </head>

        <body>
            <section class="container forms">
                <div class="form login">
                    <div class="form-content">
                        <header>Login</header>
                        <form action="#">
                            <div class="field input-field">
                                <input type="email" placeholder="email" class="input" name="email">
                            </div> 

                            <div class="field input-field">
                                <input type="password" placeholder="Password" class="password" name="password">
                                <i class='bx bx-hide eye-icon'></i>
                            </div>

                            <div class="form-link">
                                <a href="#" class="forgot-pass"></a>
                            </div>

                            <div class="field button-field">
                                <button>로그인</button>
                            </div>
                        </form>

                        <div class="form-link">
                            <span>회원가입 하시겠습니까? <a href="redirect_uri=http://localhost:8080/join/join" class="link">Signup</a></span>
                        </div>
                    </div>

                    <div class="line"></div>
                    
                    <div class="media-options">
                        <a href="#" class="field facebook">
                            <i class='bx bxl-facebook facebook-icon'></i>
                            <span>Login with Facebook</span>
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

            <!-- JavaScript -->
            <script src="js/m_script.js"></script>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
                crossorigin="anonymous"></script>
            <script src="https://code.jquery.com/jquery-3.6.0.min.js"
                integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
        </body>

        </html>
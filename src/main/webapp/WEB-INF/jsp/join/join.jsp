<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <link rel="stylesheet" href="css/m_style.css">
            <link href='https://unpkg.com/boxicons@2.1.2/css/boxicons.min.css' rel='stylesheet'>
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
                integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
                crossorigin="anonymous">
            <script src="https://code.jquery.com/jquery-3.6.4.min.js"
                integrity="sha256-oP6HI9z1XaZNBrJURtCoUT5SUnxFr8s3BzRl+cbzUq8=" crossorigin="anonymous"></script>
            <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>sign</title>
        </head>

        <body>
            <section class="container forms show-signup">
                <div class="form signup">
                    <div class="form-content">
                        <header>회원가입</header>
                        <form action="#">
                            <div class="field input-field">
                                <input type="email" placeholder="Email" class="input">
                            </div>

                            <div class="field input-field">
                                <input type="password" placeholder="Create password" class="password">
                            </div>

                            <div class="field input-field">
                                <input type="password" placeholder="Confirm password" class="password">
                                <i class='bx bx-hide eye-icon'></i>
                            </div>

                            <div class="field input-field">
                                <input type="text" placeholder="Nickname" class="input">
                            </div>

                            <div class="field button-field">
                                <button>일반 회원가입</button>
                            </div>
                        </form>

                        <div class="form-link">
                            <span>이미 계정을 갖고 계신가요? <a href="login" class="link login-link">Login</a></span>
                        </div>
                    </div>

                    <div class="line"></div>

                    <div class="media-options">
                        <a href="https://kauth.kakao.com/oauth/authorize?client_id=c691b066d7c57c4085e1fa5fc3e2c47b&redirect_uri=http://localhost:8080/kakao/login&response_type=code">
                            <img src="images/kakao_login.png">
                        </a>
                    </div>

                    <div class="media-options">
                        <a href="https://nid.naver.com/oauth2.0/authorize?client_id=6BPvD8rTeGLnG7fdps1C&redirect_uri=http://localhost:8080/naver/login&response_type=code&state=test">
                            <img src="images/naver_login.png">
                        </a>
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
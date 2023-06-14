package com.kdt.miniproject.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class LoginCotroller {
 
    @RequestMapping("/login")
    public String init() {



        return "/login/login";
    }
 
 
 @RequestMapping("/naver/login")
 public ModelAndView naverLogin(String code) {

     ModelAndView mv = new ModelAndView();

     String access_Token = "";
     String refresh_Token = "";
     String reqURL = "https://nid.naver.com/oauth2.0/token";

     try {
         // 웹 상의 경로(URL)를 객체화 시킨다.
         URL url = new URL(reqURL);

         HttpURLConnection conn = (HttpURLConnection) url.openConnection();

         conn.setRequestMethod("POST");
         conn.setDoOutput(true);

         StringBuffer sb = new StringBuffer();
         sb.append("grant_type=authorization_code");
         sb.append("&client_id=py8uuUtaAKsCCxoOKiY3");
         sb.append("&redirect_uri=http://localhost:8080/naver/login");
         sb.append("&code=" + code);

         BufferedWriter bw = new BufferedWriter(
                 new OutputStreamWriter(conn.getOutputStream()));

         bw.write(sb.toString());
         bw.flush();

         int res_code = conn.getResponseCode();

         if (res_code == 200) {

             BufferedReader br = new BufferedReader(
                     new InputStreamReader(conn.getInputStream()));

             StringBuffer result = new StringBuffer();

             String line = null;

             while ((line = br.readLine()) != null) {
                 result.append(line);
             }

             JSONParser jsonParser = new JSONParser();

             Object obj = jsonParser.parse(result.toString());
             JSONObject json = (JSONObject) obj;

             access_Token = (String) json.get("access_token");
             refresh_Token = (String) json.get("refresh_token");

             String apiURL = "https://openapi.naver.com/v1/nid/me";
             String header = "Bearer " + access_Token;

             URL url2 = new URL(apiURL);

             HttpURLConnection conn2 = (HttpURLConnection) url2.openConnection();

             conn2.setRequestMethod("POST");
             conn2.setDoOutput(true);

             conn2.setRequestProperty("Authorization", header);

             res_code = conn2.getResponseCode();

             if (res_code == HttpURLConnection.HTTP_OK) {

                 BufferedReader brdm = new BufferedReader(
                         new InputStreamReader(conn2.getInputStream()));

                 String str = null;
                 StringBuffer res = new StringBuffer();

                 while ((str = brdm.readLine()) != null)
                     res.append(str);

                 obj = jsonParser.parse(res.toString());
                 json = (JSONObject) obj;

                 JSONObject props = (JSONObject) json.get("properties");
                 String nickName = (String) props.get("nickname");
                 String p_img = (String) props.get("profile_image");

                 JSONObject naver_acc = (JSONObject) json.get("naver_account");
                 String email = (String) naver_acc.get("email");

                 JSONObject profile = (JSONObject) naver_acc.get("profile");
                 nickName = (String) profile.get("nickname");
                 p_img = (String) profile.get("profile_image_url");

                 mv.addObject("nickname", nickName);
                 mv.addObject("p_img", p_img);
                 mv.addObject("email", email);
             } // if문의 끝
         }

     } catch (Exception e) {
         e.printStackTrace();
     }
     mv.setViewName("result");

     return mv;
 }

    @RequestMapping("/kakao/login")
    public ModelAndView kakaoLogin(String code) {

        ModelAndView mv = new ModelAndView();

        String access_Token = "";
        String refresh_Token = "";
        String reqURL = "https://kauth.kakao.com/oauth/token";

        try {
            // 웹 상의 경로(URL)를 객체화 시킨다.
            URL url = new URL(reqURL);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");
            conn.setDoOutput(true);

            StringBuffer sb = new StringBuffer();
            sb.append("grant_type=authorization_code");
            sb.append("&client_id=ef5415e6ed027721e4d680b30eff28fe");
            sb.append("&redirect_uri=http://localhost:8080/kakao/login");
            sb.append("&code=" + code);

            BufferedWriter bw = new BufferedWriter(
                    new OutputStreamWriter(conn.getOutputStream()));

            bw.write(sb.toString());
            bw.flush();

            int res_code = conn.getResponseCode();

            if (res_code == 200) {

                BufferedReader br = new BufferedReader(
                        new InputStreamReader(conn.getInputStream()));

                StringBuffer result = new StringBuffer();

                String line = null;

                while ((line = br.readLine()) != null) {
                    result.append(line);
                }

                JSONParser jsonParser = new JSONParser();

                Object obj = jsonParser.parse(result.toString());
                JSONObject json = (JSONObject) obj;

                access_Token = (String) json.get("access_token");
                refresh_Token = (String) json.get("refresh_token");

                String apiURL = "https://kapi.kakao.com/v2/user/me";
                String header = "Bearer " + access_Token;

                URL url2 = new URL(apiURL);

                HttpURLConnection conn2 = (HttpURLConnection) url2.openConnection();

                conn2.setRequestMethod("POST");
                conn2.setDoOutput(true);

                conn2.setRequestProperty("Authorization", header);

                res_code = conn2.getResponseCode();

                if (res_code == HttpURLConnection.HTTP_OK) {

                    BufferedReader brdm = new BufferedReader(
                            new InputStreamReader(conn2.getInputStream()));

                    String str = null;
                    StringBuffer res = new StringBuffer();

                    while ((str = brdm.readLine()) != null)
                        res.append(str);

                    obj = jsonParser.parse(res.toString());
                    json = (JSONObject) obj;

                    JSONObject props = (JSONObject) json.get("properties");
                    String nickName = (String) props.get("nickname");
                    String p_img = (String) props.get("profile_image");

                    JSONObject kakao_acc = (JSONObject) json.get("kakao_account");
                    String email = (String) kakao_acc.get("email");

                    JSONObject profile = (JSONObject) kakao_acc.get("profile");
                    nickName = (String) profile.get("nickname");
                    p_img = (String) profile.get("profile_image_url");

                    mv.addObject("nickname", nickName);
                    mv.addObject("p_img", p_img);
                    mv.addObject("email", email);
                } // if문의 끝
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        mv.setViewName("result");

        return mv;
    }
    
}

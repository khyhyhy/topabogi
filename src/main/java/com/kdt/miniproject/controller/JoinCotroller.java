package com.kdt.miniproject.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kdt.miniproject.service.JoinService;
import com.kdt.miniproject.vo.MemberVO;

@Controller
public class JoinCotroller {
 
    @Autowired
    private JoinService j_Service;

    @RequestMapping("/join")
    public String init(){
    return "/join/join";
    }

    @RequestMapping("/kakao/login")
        public ModelAndView kakaoLogin(String code){
            ModelAndView mv = new ModelAndView();

            //System.out.println("code:"+code);

            String access_token="";
            String refresh_token="";
            String reqURL="https://kauth.kakao.com/oauth/token";
            String status = "1";

            try {
                URL url = new URL(reqURL);

                HttpURLConnection conn = (HttpURLConnection)url.openConnection();

                conn.setRequestMethod("POST");
                conn.setDoOutput(true);

                StringBuffer sb = new StringBuffer();
                sb.append("grant_type=authorization_code");
                sb.append("&client_id=c691b066d7c57c4085e1fa5fc3e2c47b");
                sb.append("&redirect_uri=http://localhost:8080/kakao/login");
                sb.append("&code="+code);

                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));

                bw.write(sb.toString());
                bw.flush();

                int res_code=conn.getResponseCode();
                //System.out.println("res_code:"+res_code);

                if(res_code == HttpURLConnection.HTTP_OK){
                    BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    StringBuffer result = new StringBuffer();
                    String line = null;

                    while((line = br.readLine()) != null){
                        result.append(line);
                    }

                    //System.out.println("result:"+result.toString());

                    JSONParser jsonParser = new JSONParser();

                    Object obj = jsonParser.parse(result.toString());
                    JSONObject json = (JSONObject)obj;

                    //System.out.println("json:"+json);
                    /*
                    json:{"access_token":"JXec2PCCuqKJo3xa-YgK6ck_Ir24MsFfGCxYQdafCinJXwAAAYi3SRsR",
                    "refresh_token_expires_in":5183999,"refresh_token":"d5hHb7qTg2VQWTRuU_gfHQWciz8zmUDHLzQGrwhVCinJXwAAAYi3SRsP",
                    "scope":"account_email profile_image profile_nickname","token_type":"bearer","expires_in":21599}
                    */

                    access_token = (String)json.get("access_token");
                    refresh_token = (String)json.get("refresh_token");

                    String apiURL = "https://kapi.kakao.com/v2/user/me";
                    String header = "Bearer "+access_token;

                    URL url2 = new URL(apiURL);
                    HttpURLConnection conn2 = (HttpURLConnection)url2.openConnection();

                    conn2.setRequestMethod("POST");
                    conn2.setDoOutput(true);

                    conn2.setRequestProperty("Authorization", header);
                    
                    res_code = conn2.getResponseCode();
                    
                    //System.out.println("res_code:"+res_code);
                    if(res_code == HttpURLConnection.HTTP_OK){
                        BufferedReader br2 = new BufferedReader(new InputStreamReader(conn2.getInputStream(), "UTF-8"));

                        StringBuffer result2 = new StringBuffer();
                        String line2 = null;

                        while((line2 = br2.readLine()) != null){
                            result2.append(line2);
                        }

                        //System.out.println("result2:"+result2.toString());
                        /*
                        result2:{"id":2842588363,"connected_at":"2023-06-14T00:22:29Z",
                        "properties":{"nickname":"민건영",
                        "profile_image":"http://k.kakaocdn.net/dn/9W4Wd/btqEPvUeKah/QrByGeg01oqcMwerh3hrHk/img_640x640.jpg",
                        "thumbnail_image":"http://k.kakaocdn.net/dn/9W4Wd/btqEPvUeKah/QrByGeg01oqcMwerh3hrHk/img_110x110.jpg"},
                        kakao_account":{"profile_nickname_needs_agreement":false,"profile_image_needs_agreement":false,
                        "profile":{"nickname":"민건영",
                        "thumbnail_image_url":"http://k.kakaocdn.net/dn/9W4Wd/btqEPvUeKah/QrByGeg01oqcMwerh3hrHk/img_110x110.jpg",
                        "profile_image_url":"http://k.kakaocdn.net/dn/9W4Wd/btqEPvUeKah/QrByGeg01oqcMwerh3hrHk/img_640x640.jpg",
                        "is_default_image":false},"has_email":true,"email_needs_agreement":false,"is_email_valid":true,"is_email_verified":true,"email":"hahaha3456@naver.com"}}
                        */

                        Object obj2 = jsonParser.parse(result2.toString());
                        JSONObject json2 = (JSONObject)obj2;
                        JSONObject props = (JSONObject)json2.get("properties");
                        String nickname = (String)props.get("nickname");
                        String profile_image = (String)props.get("profile_image");

                        JSONObject kakao_acc = (JSONObject)json2.get("kakao_account");
                        String email = (String)kakao_acc.get("email");

                        //System.out.println("nickname:"+nickname);
                        //System.out.println("p_image:"+profile_image);
                        //System.out.println("email:"+email);
                        //System.out.println("access_token:"+access_token);
                        //System.out.println("refresh_token:"+refresh_token);

                        MemberVO vo = new MemberVO();
                        vo.setNickname(nickname);
                        vo.setProfile_image(profile_image);
                        vo.setEmail(email);
                        vo.setAccess_token(access_token);
                        vo.setRefresh_token(refresh_token);
                        vo.setStatus(status);

                        int cnt = j_Service.addMem(vo);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }



            mv.setViewName("result");

            return mv;

        }
}

package com.kdt.miniproject.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kdt.miniproject.vo.ItemVO;

@Controller
public class MainCotroller {

    @RequestMapping("/tour")
    public ModelAndView searchTourList( @RequestParam(value = "cPage", defaultValue = "1") int cPage,
                                    @RequestParam(value = "end", defaultValue = "16") int end ,
                                    @RequestParam(value = "content_TypeId", defaultValue = "12") int content_TypeId , 
                                    @RequestParam(value = "area_Code", defaultValue = "1") int area_Code) throws Exception{
    ModelAndView mv = new ModelAndView();

    int numOfRows = end;//한페이지 당 보여질 건수
    int pageNo = 1; //현재 페이지값

    String mobileOS = "ETC"; // 서비스 플랫폼 (IOS 또는 ANDROID 등)
    String mobileApp = "AppTest";// 프로젝트 명 또는 앱 이름
    String serviceKey = "0wkh1NwnopRa%2B5Uw7aOzlsxAOBxF3b86NTyB6ltJ01UEBx9I6ElfGWvNT4AOxdsVK1OzdJ4ZLcwmLAlSRe0SUw%3D%3D";// 개인 인증키 (Encoding)
    String type = "json";//응답 결과 유형
    String listYN = "Y"; // 목록: Y, 갯수:N
    String arrange = "O"; //정렬 구분 (A=제목순, C=수정일순, D=생성일순)
    int contentTypeId = content_TypeId;
    int areaCode = area_Code;

    String re_addr = "http://apis.data.go.kr/B551011/KorService1/areaBasedSyncList1?"; //호출경로

    if(content_TypeId != 0){
        contentTypeId = content_TypeId;
    }
    if(area_Code != 0){
        areaCode = area_Code;
    }

    String nowDate = "";

    if(contentTypeId == 15){
        re_addr = "http://apis.data.go.kr/B551011/KorService1/searchFestival1?";

        // 현재 날짜 구하기
        LocalDate currentDate = LocalDate.now();

        // 형식 지정
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

        nowDate = currentDate.format(formatter);
    }

    StringBuffer sb = new StringBuffer();
    sb.append(re_addr); // 호출할 경로
    sb.append("numOfRows=");
    sb.append(numOfRows);
    sb.append("&pageNo=");
    sb.append(pageNo);
    sb.append("&MobileOS=");
    sb.append(mobileOS);
    sb.append("&MobileApp=");
    sb.append(mobileApp);
    sb.append("&serviceKey=");
    sb.append(serviceKey);
    sb.append("&_type=");
    sb.append(type);
    sb.append("&listYN=");
    sb.append(listYN);
    sb.append("&arrange=");
    sb.append(arrange);

    if(contentTypeId != 15){
        sb.append("&contentTypeId=");
        sb.append(contentTypeId);
    }
    sb.append("&areaCode=");
    sb.append(areaCode);
    if(contentTypeId == 15){
        sb.append("&eventStartDate=");
        sb.append(nowDate);
    }

    System.out.println(sb.toString());

    URL url = new URL(sb.toString());

    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    conn.setRequestMethod("GET");
    conn.setRequestProperty("Content-type", "application/json");
    conn.setDoOutput(true);
    conn.connect();

    int res_code = conn.getResponseCode();

    if(res_code == HttpURLConnection.HTTP_OK){
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));

        StringBuffer result = new StringBuffer();

        String line = null;

        while((line = br.readLine()) != null){
            result.append(line);
        } 

        br.close();
        conn.disconnect();

        JSONParser jsonParser = new JSONParser();

        Object obj = jsonParser.parse(result.toString());
        JSONObject json = (JSONObject)obj;

        JSONObject response = (JSONObject) json.get("response");
        JSONObject body = (JSONObject) response.get("body");
        JSONObject items = (JSONObject)body.get("items");
        String totalCount = (String)body.get("totalCount");
        JSONArray itemsArray = (JSONArray)items.get("item");

        System.out.println(totalCount);
        
        ;       List<ItemVO> itemVOList = new ArrayList<>();

        for(Object item : itemsArray){
            JSONObject itemJson = (JSONObject) item;
            String addr1 = (String)itemJson.get("addr1");
            String addr2 = (String)itemJson.get("addr2");
            String firstimage = (String)itemJson.get("firstimage");
            String firstimage2 = (String)itemJson.get("firstimage2");
            String mapx = (String)itemJson.get("mapx");
            String mapy = (String)itemJson.get("mapy");
            String tel = (String)itemJson.get("tel");
            String areacode = (String)itemJson.get("areacode");
            String contentid = (String)itemJson.get("contentid");
            String contenttypeid = (String)itemJson.get("contenttypeid");
            String title = (String)itemJson.get("title");
            
            ItemVO vo = new ItemVO(addr1, addr2, areacode, contentid, contenttypeid, firstimage, firstimage2, mapx, mapy, tel, title);
            itemVOList.add(vo);
        }

        ItemVO[] ar = itemVOList.toArray(new ItemVO[itemVOList.size()]);

        mv.addObject("ar", ar);
    }
    
    mv.addObject("area_Code", area_Code);
    
    switch(contentTypeId){
        case 12: mv.setViewName("/main/tour");
            break;
        case 15: mv.setViewName("/main/festival");
            break;
        case 28: mv.setViewName("/main/sports");

    }
    

    return mv;
 }

}

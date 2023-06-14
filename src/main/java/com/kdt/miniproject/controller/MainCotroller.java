package com.kdt.miniproject.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
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

    // @RequestMapping("/tour/")
    // public ModelAndView viewTourList() throws Exception{
    //     ModelAndView mv = new ModelAndView();

    //     int numOfRows = 16;//한페이지 당 보여질 건수
    //     int pageNo = 1; //현재 페이지값

    //     String mobileOS = "ETC"; // 서비스 플랫폼 (IOS 또는 ANDROID 등)
    //     String mobileApp = "AppTest";// 프로젝트 명 또는 앱 이름
    //     String serviceKey = "05CgQgRROkXsywtrbtZ9zmZWzSk1rReX2%2BuH1nRGcujyHIuzqn%2FwwxCHzGIqyMX5J5RIhHhqdw7O2N9TCXqeBg%3D%3D";// 개인 인증키 (Encoding)
    //     String type = "xml";//응답 결과 유형
    //     String listYN = "Y"; // 목록: Y, 갯수:N
    //     String arrange = "D"; //정렬 구분 (A=제목순, C=수정일순, D=생성일순)
    //     int contentTypeId = 12;
    //     int areaCode = 1;
    //     int sigunguCode = 1;

    //     StringBuffer sb = new StringBuffer();
    //     sb.append("http://apis.data.go.kr/B551011/KorService1/areaBasedSyncList1?"); // 호출할 경로
    //     sb.append("numOfRows=");
    //     sb.append(numOfRows);
    //     sb.append("&pageNo=");
    //     sb.append(pageNo);
    //     sb.append("&MobileOS=");
    //     sb.append(mobileOS);
    //     sb.append("&MobileApp=");
    //     sb.append(mobileApp);
    //     sb.append("&serviceKey=");
    //     sb.append(serviceKey);
    //     sb.append("&_type=");
    //     sb.append(type);
    //     sb.append("&listYN=");
    //     sb.append(listYN);
    //     sb.append("&arrange=");
    //     sb.append(arrange);
    //     sb.append("&contentTypeId=");
    //     sb.append(contentTypeId);
    //     sb.append("&areaCode=");
    //     sb.append(areaCode);
    //     sb.append("&sigunguCode=");
    //     sb.append(sigunguCode);

    //     URL url = new URL(sb.toString());

    //     HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    //     conn.connect();

    //     SAXBuilder builder = new SAXBuilder();

    //     Document doc = builder.build(conn.getInputStream());

    //     Element root = doc.getRootElement();
    //     Element body = root.getChild("body");
    //     Element items = body.getChild("items");//body의 자식들 중 이름이 items인 요소 검색

    //     List<Element> list = items.getChildren("item");

    //     int i = 0;
    //     ItemVO[] ar = new ItemVO[list.size()];

    //     for(Element item : list){
    //         String addr1 = (String) item.get("addr1");
    //         String addr2 = (String) item.get("addr2");
    //         String firstimage = (String) item.get("firstimage");
    //         String firstimage2 = (String) item.get("firstimage2");
    //         String mapx = (String) itemJson.get("mapx");
    //         String mapy = (String) itemJson.get("mapy");
    //         String tel = (String) itemJson.get("tel");
    //         String areacode = (String) itemJson.get("areacode");
    //         String contentid = (String) itemJson.get("contentid");
    //         String contenttypeid = (String) itemJson.get("contenttypeid");
    //         String title = (String) itemJson.get("title");

    //         ItemVO vo = new ItemVO(addr1, addr2, areacode, contentid, contenttypeid, firstimage, firstimage2, mapx, mapy, tel, title);

    //         ar[i++] = vo; // 생성된 vo를 배열에 저장

    //     }

    //     mv.addObject("ar", ar);
    //     mv.setViewName("/main/tour");

    //     return mv;
    // }

 @RequestMapping("/tour/test")
 public ModelAndView searchTourList( @RequestParam(value = "end", defaultValue = "16") int end ,
                                    @RequestParam(value = "content_typeID", defaultValue = "12") int content_TypeId , 
                                    @RequestParam(value = "area_typeID", defaultValue = "1") int area_Code) throws Exception{
    ModelAndView mv = new ModelAndView();

    int numOfRows = end;//한페이지 당 보여질 건수
    int pageNo = 1; //현재 페이지값

    String mobileOS = "ETC"; // 서비스 플랫폼 (IOS 또는 ANDROID 등)
    String mobileApp = "AppTest";// 프로젝트 명 또는 앱 이름
    String serviceKey = "0wkh1NwnopRa%2B5Uw7aOzlsxAOBxF3b86NTyB6ltJ01UEBx9I6ElfGWvNT4AOxdsVK1OzdJ4ZLcwmLAlSRe0SUw%3D%3D";// 개인 인증키 (Encoding)
    String type = "json";//응답 결과 유형
    String listYN = "Y"; // 목록: Y, 갯수:N
    String arrange = "D"; //정렬 구분 (A=제목순, C=수정일순, D=생성일순)
    int contentTypeId = content_TypeId;
    int areaCode = area_Code;
    int sigunguCode = 1;

    if(content_TypeId != 0){
        contentTypeId = content_TypeId;
    }
    if(area_Code != 0){
        areaCode = area_Code;
    }
    

    StringBuffer sb = new StringBuffer();
    sb.append("http://apis.data.go.kr/B551011/KorService1/areaBasedSyncList1?"); // 호출할 경로
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
    sb.append("&contentTypeId=");
    sb.append(contentTypeId);
    sb.append("&areaCode=");
    sb.append(areaCode);

    URL url = new URL(sb.toString());

    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    conn.setRequestMethod("GET");
    conn.setDoOutput(true);

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));

    // bw.write(sb.toString());
    // bw.flush();

    int res_code = conn.getResponseCode();

    if(res_code == HttpURLConnection.HTTP_OK){
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

        StringBuffer result = new StringBuffer();

        String line = null;

        while((line = br.readLine()) != null){
            result.append(line);
        } 
        System.out.println(result.toString());
        JSONParser jsonParser = new JSONParser();

        Object obj = jsonParser.parse(result.toString());
        JSONObject json = (JSONObject)obj;

        JSONArray itemsArray = (JSONArray)json.get("items");

        List<ItemVO> itemVOList = new ArrayList<>();

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
    
    mv.setViewName("tour");

    return mv;
 }

 @RequestMapping("/main/festival")
 public String festival(){
    return "festival";
 }

 @RequestMapping("/sports")
 public String sports(){
    return "sports";
 }

}

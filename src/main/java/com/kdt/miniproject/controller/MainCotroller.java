package com.kdt.miniproject.controller;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kdt.miniproject.vo.ItemVO;



@Controller
public class MainCotroller {

    @RequestMapping("/tour/")
    public ModelAndView viewTourList() throws Exception{
        ModelAndView mv = new ModelAndView();

        int numOfRows = 16;//한페이지 당 보여질 건수
        int pageNo = 1; //현재 페이지값

        String mobileOS = "ETC"; // 서비스 플랫폼 (IOS 또는 ANDROID 등)
        String mobileApp = "AppTest";// 프로젝트 명 또는 앱 이름
        String serviceKey = "05CgQgRROkXsywtrbtZ9zmZWzSk1rReX2%2BuH1nRGcujyHIuzqn%2FwwxCHzGIqyMX5J5RIhHhqdw7O2N9TCXqeBg%3D%3D";// 개인 인증키 (Encoding)
        String type = "xml";//응답 결과 유형
        String listYN = "Y"; // 목록: Y, 갯수:N
        String arrange = "D"; //정렬 구분 (A=제목순, C=수정일순, D=생성일순)
        int contentTypeId = 12;
        int areaCode = 1;
        int sigunguCode = 1;

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
        sb.append("&sigunguCode=");
        sb.append(sigunguCode);

        URL url = new URL(sb.toString());

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.connect();

        SAXBuilder builder = new SAXBuilder();

        Document doc = builder.build(conn.getInputStream());

        Element root = doc.getRootElement();
        Element body = root.getChild("body");
        Element items = body.getChild("items");//body의 자식들 중 이름이 items인 요소 검색

        List<Element> list = items.getChildren("item");

        int i = 0;
        ItemVO[] ar = new ItemVO[list.size()];

        for(Element item : list){
            String addr1 = item.getChildText("addr1");
            String addr2 = item.getChildText("addr2");
            String firstimage = item.getChildText("firstimage");
            String firstimage2 = item.getChildText("firstimage2");
            String mapx = item.getChildText("mapx");
            String mapy = item.getChildText("mapy");
            String tel = item.getChildText("tel");
            String areacode = item.getChildText("areacode");
            String contentid = item.getChildText("contentid");
            String contenttypeid = item.getChildText("contenttypeid");
            String title = item.getChildText("title");

            ItemVO vo = new ItemVO(addr1, addr2, areacode, contentid, contenttypeid, firstimage, firstimage2, mapx, mapy, tel, title);

            ar[i++] = vo; // 생성된 vo를 배열에 저장

        }

        mv.addObject("ar", ar);
        mv.setViewName("/main/tour");

        return mv;
    }

 @RequestMapping("/tour/busan")
 public ModelAndView searchTourList(int content_typeID, int area_typeID, int sigungu_typeID) throws Exception {
    ModelAndView mv = new ModelAndView();

    int numOfRows = 16;//한페이지 당 보여질 건수
    int pageNo = 1; //현재 페이지값

    String mobileOS = "ETC"; // 서비스 플랫폼 (IOS 또는 ANDROID 등)
    String mobileApp = "AppTest";// 프로젝트 명 또는 앱 이름
    String serviceKey = "05CgQgRROkXsywtrbtZ9zmZWzSk1rReX2%2BuH1nRGcujyHIuzqn%2FwwxCHzGIqyMX5J5RIhHhqdw7O2N9TCXqeBg%3D%3D";// 개인 인증키 (Encoding)
    String type = "xml";//응답 결과 유형
    String listYN = "Y"; // 목록: Y, 갯수:N
    String arrange = "D"; //정렬 구분 (A=제목순, C=수정일순, D=생성일순)
    int contentTypeId = 12;
    int areaCode = 1;
    int sigunguCode = 1;

    if(content_typeID != 0){
        contentTypeId = content_typeID;
    }
    if(area_typeID != 0){
        areaCode = area_typeID;
    }
    if(sigungu_typeID != 0){
        sigunguCode = sigungu_typeID;
    }

    StringBuffer sb = new StringBuffer();
    sb.append("http://apis.data.go.kr/B551011/KorService1/searchFestival1?"); // 호출할 경로
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
    sb.append("&sigunguCode=");
    sb.append(sigunguCode);

    URL url = new URL(sb.toString());

    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    conn.connect();

    SAXBuilder builder = new SAXBuilder();

    Document doc = builder.build(conn.getInputStream());

    Element root = doc.getRootElement();
    Element body = root.getChild("body");
    Element items = body.getChild("items");//body의 자식들 중 이름이 items인 요소 검색

    List<Element> list = items.getChildren("item");

    int i = 0;
    ItemVO[] ar = new ItemVO[list.size()];

    for(Element item : list){
        String addr1 = item.getChildText("addr1");
        String addr2 = item.getChildText("addr2");
        String firstimage = item.getChildText("firstimage");
        String firstimage2 = item.getChildText("firstimage2");
        String mapx = item.getChildText("mapx");
        String mapy = item.getChildText("mapy");
        String tel = item.getChildText("tel");
        String areacode = item.getChildText("areacode");
        String contentid = item.getChildText("contentid");
        String contenttypeid = item.getChildText("contenttypeid");
        String title = item.getChildText("title");

        ItemVO vo = new ItemVO(addr1, addr2, areacode, contentid, contenttypeid, firstimage, firstimage2, mapx, mapy, tel, title);

        ar[i++] = vo; // 생성된 vo를 배열에 저장

    }

    mv.addObject("ar", ar);
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

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

 @RequestMapping("/main/")
 public String init(){
  return "Main";
 }

 @RequestMapping("/")
 
public ModelAndView searchFestival() throws Exception {
    ModelAndView mv = new ModelAndView();
    // 공공데이터를 활용하기 위한 URL을 생성하기에 앞서 준비해야 할 것은
    // 전체경로와 파라미터들을 문자열로 준비한다. 예를들어
    //http://apis.data.go.kr/B551011/KorService1/searchFestival1?numOfRows=10&pageNo=1&MobileOS=ETC&MobileApp=AppTest&_type=json&listYN=Y&arrange=A&eventStartDate=20230701&serviceKey=개인키
    int numOfRows = 10;//한페이지 당 보여질 건수
    int pageNo = 1; //현재 페이지값

    String mobileOS = "ETC"; // 서비스 플랫폼 (IOS 또는 ANDROID 등)
    String mobileApp = "AppTest";// 프로젝트 명 또는 앱 이름
    String type = "xml";//응답 결과 유형
    String listYN = "Y"; // 목록: Y, 갯수:N
    String arrange ="D"; //정렬구분 (A=제목순, C=수정일순, D=생성일순) 대표이미지가반드시있는정렬(O=제목순, Q=수정일순, R=생성일순)
    String eventStartDate = "20230701"; //행사 시작일
    String serviceKey = "05CgQgRROkXsywtrbtZ9zmZWzSk1rReX2%2BuH1nRGcujyHIuzqn%2FwwxCHzGIqyMX5J5RIhHhqdw7O2N9TCXqeBg%3D%3D";// 개인 인증키 (Encoding)

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
    sb.append("&_type=");
    sb.append(type);
    sb.append("&listYN=");
    sb.append(listYN);
    sb.append("&arrange=");
    sb.append(arrange);
    sb.append("&eventStartDate=");
    sb.append(eventStartDate);
    sb.append("&serviceKey=");
    sb.append(serviceKey);

    // 위의 StringBuffer가 가지고 있는 URL전체 경로를 가지고 URL객체를 먼저 생성하자!
    URL url = new URL(sb.toString());

    //위의 URL을 요청하기 위해 연결객체 생성하자!
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    conn.connect();// 호출~!

    // 호출했을 때 응답이 XML로 전달된다. 우린 이 XML문서를 파싱할 수 있어야 한다.
    // mvnrepository.com에서 jdom으로 검색하여 의존성을 알아내야 한다.
    SAXBuilder builder = new SAXBuilder();

    // 위의 SAXBuilder를 이용하여 응답되는 XML문서를 Document로 생성한다.
    Document doc = builder.build(conn.getInputStream());

    // 루트엘리먼트 얻기
    Element root = doc.getRootElement();
    //System.out.println(root.getName()); // response

    // 루트의 자식들 중 body를 얻어낸다.
    Element body = root.getChild("body");
    Element items = body.getChild("items");//body의 자식들 중 이름이 items인 요소 검색

    //items안에 자식들 중 이름이 item인 요소들 모두를 List로 받아낸다.
    List<Element> list = items.getChildren("item");

    // 위의 list 안에 있는 Element들을 ItemVO로 만들어서 배열로 저장해 둔다.
    int i = 0;
    ItemVO[] ar = new ItemVO[list.size()];

    for(Element item : list){
        // item이 가지는 값들 중 내가 필요한 값들(addr1, addr2, firstimage, ....)
        String addr1 = item.getChildText("addr1");
        String addr2 = item.getChildText("addr2");
        String firstimage = item.getChildText("firstimage");
        String firstimage2 = item.getChildText("firstimage2");
        String mapx = item.getChildText("mapx");
        String mapy = item.getChildText("mapy");
        String tel = item.getChildText("tel");
        String title = item.getChildText("title");
        String eventstartdate = item.getChildText("eventstartdate");
        String eventenddate = item.getChildText("eventenddate");

        // 위에서 얻어낸 값들을 하나의 VO로 저장해 둔다.
        ItemVO vo = new ItemVO(addr1, addr2, eventstartdate, 
            eventenddate, mapx, mapy, tel, title, firstimage, firstimage2);

        ar[i++] = vo;// 생성된 vo를 배열에 저장

    }//반복문의 끝

    // 배열의 내용을 JSP에서 지도로 표현하기 위해 배열을 mv에 저장하자!
    mv.addObject("ar", ar);
    mv.setViewName("festival");

    return mv;
}

 @RequestMapping("/festival")
 public String festival(){
    return "festival";
 }

 @RequestMapping("/sports")
 public String sports(){
    return "sports";
 }

}

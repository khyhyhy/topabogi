package com.kdt.miniproject.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kdt.miniproject.service.InfoService;
import com.kdt.miniproject.vo.InfoVO;
import com.kdt.miniproject.vo.ReviewLogVO;
import com.kdt.miniproject.vo.ReviewVO;
import com.kdt.miniproject.vo.infomationVO;

@Controller
public class InfoController {
 
 @Autowired
 InfoService service;

 @RequestMapping("/info/")
 public ModelAndView init(String contenttypeid , String contentid) throws Exception{
  ModelAndView mv = new ModelAndView();
  /*itmvo = new ItemVO("서울특별시 종로구 세종대로 175"
  , "", "1", "2848984", "15", "http://tong.visitkorea.or.kr/cms/resource/81/2848981_image2_1.jpg",
   "http://tong.visitkorea.or.kr/cms/resource/81/2848981_image3_1.jpg",
    "126.9763210635", "37.5720618985", "02-3437-0059", "거리에술 캬라반 '가을'","","");*/
    String servicekey = "VZwsEBpKrcOmbKb2y%2FszpWMkbfTx9GLvm2dZ96N6fn9bubmU0iPfGKNkuGSqCvCgpqL611HousPLRFN2KBEk9w%3D%3D";
    String infourl= "http://apis.data.go.kr/B551011/KorService1/";
    infomationVO infomaVO = new infomationVO();
    StringBuffer infosb = new StringBuffer();
    infosb.append(infourl);
    infosb.append("detailCommon1?");
    infosb.append("MobileOS=ETC");
    infosb.append("&MobileApp=dajuu");
    infosb.append("&_type=json");
    infosb.append("&contentId=");
    infosb.append(contentid);
    infosb.append("&contentTypeId=");
    infosb.append(contenttypeid);
    infosb.append("&numOfRows=10");
    infosb.append("&pageNo=1");
    infosb.append("&serviceKey=");
    infosb.append(servicekey);
    infosb.append("&defaultYN=Y&firstImageYN=Y&areacodeYN=Y&catcodeYN=Y&addrinfoYN=Y&mapinfoYN=Y&overviewYN=Y");
    URL inurl = new URL(infosb.toString());
    HttpURLConnection inconn = (HttpURLConnection)inurl.openConnection();
    //inconn.connect();
    if(inconn.getResponseCode()==HttpURLConnection.HTTP_OK){
     StringBuffer inst = new StringBuffer();
     BufferedReader br2 = new BufferedReader(new InputStreamReader(inconn.getInputStream(), "UTF-8") );
     String infoline;
     while((infoline =br2.readLine())!=null){
      inst.append(infoline);
     }
     System.out.println("상세정보 ======="+inst.toString());
      JSONParser parser1 = new JSONParser();
      JSONObject json1 = (JSONObject)parser1.parse(inst.toString());
      JSONObject resp1 = (JSONObject)json1.get("response");
      JSONObject body1 = (JSONObject)resp1.get("body");
      JSONObject items1 = (JSONObject)body1.get("items");
      JSONArray itemar = (JSONArray)items1.get("item");
     
     for(Object vo : itemar){
      JSONObject item1 = (JSONObject)vo;
      String contentid1 = (String)item1.get("contentid");
      String contenttypeid1 = (String)item1.get("contenttypeid");
      String title1 = (String)item1.get("title");
      String createdtime1 = (String)item1.get("createdtime");
      String modifiedtime1 = (String)item1.get("modifiedtime");
      String tel1 = (String)item1.get("tel");
      String telname1 = (String)item1.get("telname");
      String homepage1 = (String)item1.get("homepage");
      String booktour1 = (String)item1.get("booktour");
      String firstimage1 = (String)item1.get("firstimage");
      String firstimage21 = (String)item1.get("firstimage2");
      String cpyrhtDivCd1 = (String)item1.get("cpyrhtDivCd");
      String areacode1 = (String)item1.get("areacode");
      String sigungucode1 = (String)item1.get("sigungucode");
      String cat1 = (String)item1.get("cat1");
      String cat2 = (String)item1.get("cat2");
      String cat3 = (String)item1.get("cat3");
      String addr11 = (String)item1.get("addr1");
      String addr21 = (String)item1.get("addr2");
      String zipcode1 = (String)item1.get("zipcode");
      String mapx1 = (String)item1.get("mapx");
      String mapy1 = (String)item1.get("mapy");
      String mlevel1 = (String)item1.get("mlevel");
      String overview1 = (String)item1.get("overview");
      
      infomaVO = new infomationVO(contentid1, contenttypeid1, title1, createdtime1, modifiedtime1, tel1, telname1, homepage1, booktour1, firstimage1, firstimage21, cpyrhtDivCd1, areacode1, sigungucode1, cat1, cat2, cat3, addr11, addr21, zipcode1, mapx1, mapy1, mlevel1, overview1);
     }
     
    }
    
    mv.addObject("itmVO", infomaVO);
  String path = "http://apis.data.go.kr/B551011/KorService1";
  StringBuffer sb = new StringBuffer();
  String numOfRows = "50";
  String pageNo = "1";
  String MobileOS = "ETC";
  String listYN = "Y";
  String arrange = "A";
  String mapX = infomaVO.getMapx();
  String mapY = infomaVO.getMapy();
  String radius = "3000";
  String contentTypeId = "15";
  sb.append(path);
  sb.append("/");
  sb.append("locationBasedList1");
  sb.append("?numOfRows=");
  sb.append(numOfRows);
  sb.append("&pageNo=");
  sb.append(pageNo);
  sb.append("&MobileOS=");
  sb.append(MobileOS);
  sb.append("&MobileApp=");
  sb.append("kdt");
  sb.append("&_type=json");
  sb.append("&listYN=");
  sb.append(listYN);
  sb.append("&arrange=");
  sb.append(arrange);
  sb.append("&mapX=");
  sb.append(mapX);
  sb.append("&mapY=");
  sb.append(mapY);
  sb.append("&radius=");
  sb.append(radius);
  sb.append("&contentTypeId=");
  sb.append(contentTypeId);
  sb.append("&serviceKey=");
  sb.append(servicekey);
  
  URL url = new URL(sb.toString());
  HttpURLConnection conn = (HttpURLConnection)url.openConnection();
  conn.connect();
  StringBuffer inputst = new StringBuffer();
  if(conn.getResponseCode()==HttpURLConnection.HTTP_OK){
   BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
   String line;
   while((line =br.readLine())!=null){
    inputst.append(line);
   }
   //System.out.println("상세정보2=="+inputst.toString());
  
    JSONParser parser = new JSONParser();
    JSONObject json = (JSONObject)parser.parse(inputst.toString());
    JSONObject resp = (JSONObject)json.get("response");
    JSONObject body = (JSONObject)resp.get("body");
    //System.out.println("totalcount+=="+body.get("totalCount").toString());
    if(!body.get("totalCount").toString().equals("0")){
    JSONObject items = (JSONObject)body.get("items");
    JSONArray array = (JSONArray)items.get("item");
    List<InfoVO> list = new ArrayList<>();

    for(Object vo : array){
     JSONObject item = (JSONObject)vo;
     InfoVO ivo = new InfoVO((String)item.get("mapx"), (String)item.get("mapy"), 
     (String)item.get("title"),(String)item.get("addr1"),
     (String)item.get("contentid"),(String)item.get("modifiedtime"),
     (String)item.get("firstimage2"),(String)item.get("tel"),
     (String)item.get("firstimage"),null);
     if((String)item.get("contentid")!=null){
      ReviewLogVO[] ar = service.reviewall((String)item.get("contentid"));
      ivo.setRl_list(ar);
     }
     list.add(ivo);
   }
    InfoVO[] iar = new InfoVO[list.size()];

    list.toArray(iar);
  
    mv.addObject("iar", iar);
   }
   }
   path = "http://apis.data.go.kr/B551011/KorService1";
   sb = new StringBuffer();
   numOfRows = "50";
   pageNo = "1";
   MobileOS = "ETC";
   listYN = "Y";
   arrange = "A";
   mapX = infomaVO.getMapx();
   mapY = infomaVO.getMapy();
   radius = "3000";
   contentTypeId = "39";
   sb.append(path);
   sb.append("/");
   sb.append("locationBasedList1");
   sb.append("?numOfRows=");
   sb.append(numOfRows);
   sb.append("&pageNo=");
   sb.append(pageNo);
   sb.append("&MobileOS=");
   sb.append(MobileOS);
   sb.append("&MobileApp=");
   sb.append("kdt");
   sb.append("&_type=json");
   sb.append("&listYN=");
   sb.append(listYN);
   sb.append("&arrange=");
   sb.append(arrange);
   sb.append("&mapX=");
   sb.append(mapX);
   sb.append("&mapY=");
   sb.append(mapY);
   sb.append("&radius=");
   sb.append(radius);
   sb.append("&contentTypeId=");
   sb.append(contentTypeId);
   sb.append("&serviceKey=");
   sb.append(servicekey);
   
   url = new URL(sb.toString());
   conn = (HttpURLConnection)url.openConnection();
   conn.connect();
   inputst = new StringBuffer();
   if(conn.getResponseCode()==HttpURLConnection.HTTP_OK){
    BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
    String line;
    while((line =br.readLine())!=null){
     inputst.append(line);
    }
    //System.out.println("상세정보2=="+inputst.toString());
    
    JSONParser parser = new JSONParser();
    JSONObject json = (JSONObject)parser.parse(inputst.toString());
    JSONObject resp = (JSONObject)json.get("response");
    JSONObject body = (JSONObject)resp.get("body");
    //System.out.println("totalcount+=="+body.get("totalCount").toString());
    if(!body.get("totalCount").toString().equals("0")){
     JSONObject items = (JSONObject)body.get("items");
     JSONArray array = (JSONArray)items.get("item");
     List<InfoVO> list = new ArrayList<>();
     
     for(Object vo : array){
      JSONObject item = (JSONObject)vo;
      InfoVO ivo = new InfoVO((String)item.get("mapx"), (String)item.get("mapy"), 
      (String)item.get("title"),(String)item.get("addr1"),
      (String)item.get("contentid"),(String)item.get("modifiedtime"),
      (String)item.get("firstimage2"),(String)item.get("tel"),
      (String)item.get("firstimage"),null);
      if((String)item.get("contentid")!=null){
       ReviewLogVO[] ar = service.reviewall((String)item.get("contentid"));
       ivo.setRl_list(ar);
      }
      list.add(ivo);
     }
     InfoVO[] iar = new InfoVO[list.size()];
     
     list.toArray(iar);
     
     mv.addObject("iar2", iar);
    }
   }
   path = "http://apis.data.go.kr/B551011/KorService1";
   sb = new StringBuffer();
   numOfRows = "50";
   pageNo = "1";
   MobileOS = "ETC";
   listYN = "Y";
   arrange = "A";
   mapX = infomaVO.getMapx();
   mapY = infomaVO.getMapy();
   radius = "3000";
   contentTypeId = "32";
   sb.append(path);
   sb.append("/");
   sb.append("locationBasedList1");
   sb.append("?numOfRows=");
   sb.append(numOfRows);
   sb.append("&pageNo=");
   sb.append(pageNo);
   sb.append("&MobileOS=");
   sb.append(MobileOS);
   sb.append("&MobileApp=");
   sb.append("kdt");
   sb.append("&_type=json");
   sb.append("&listYN=");
   sb.append(listYN);
   sb.append("&arrange=");
   sb.append(arrange);
   sb.append("&mapX=");
   sb.append(mapX);
   sb.append("&mapY=");
   sb.append(mapY);
   sb.append("&radius=");
   sb.append(radius);
   sb.append("&contentTypeId=");
   sb.append(contentTypeId);
   sb.append("&serviceKey=");
   sb.append(servicekey);
   
   url = new URL(sb.toString());
   conn = (HttpURLConnection)url.openConnection();
   conn.connect();
   inputst = new StringBuffer();
   if(conn.getResponseCode()==HttpURLConnection.HTTP_OK){
    BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
    String line;
    while((line =br.readLine())!=null){
     inputst.append(line);
    }
    //System.out.println("상세정보2=="+inputst.toString());
    
    JSONParser parser = new JSONParser();
    JSONObject json = (JSONObject)parser.parse(inputst.toString());
    JSONObject resp = (JSONObject)json.get("response");
    JSONObject body = (JSONObject)resp.get("body");
    //System.out.println("totalcount+=="+body.get("totalCount").toString());
    if(!body.get("totalCount").toString().equals("0")){
     JSONObject items = (JSONObject)body.get("items");
     JSONArray array = (JSONArray)items.get("item");
     List<InfoVO> list = new ArrayList<>();
     
     for(Object vo : array){
      JSONObject item = (JSONObject)vo;
      InfoVO ivo = new InfoVO((String)item.get("mapx"), (String)item.get("mapy"), 
      (String)item.get("title"),(String)item.get("addr1"),
      (String)item.get("contentid"),(String)item.get("modifiedtime"),
      (String)item.get("firstimage2"),(String)item.get("tel"),
      (String)item.get("firstimage"),null);
      if((String)item.get("contentid")!=null){
      ReviewLogVO[] ar = service.reviewall((String)item.get("contentid"));
      ivo.setRl_list(ar);
     }
      list.add(ivo);
     }
     InfoVO[] iar = new InfoVO[list.size()];
     
     list.toArray(iar);
     
     mv.addObject("iar3", iar);
    }
   }
   mv.setViewName("info/info");
   return mv;
  }
  
  
  
  
 @RequestMapping("/info/infomation")
 public ModelAndView sanse(InfoVO vo){
  ModelAndView mv = new ModelAndView();
  System.out.println("인뽀메이숀"+vo.getTitle());
  ReviewLogVO[] ar= service.reviewall(vo.getContentid());
  vo.setRl_list(ar);
  mv.addObject("ifoVO", vo);
  mv.setViewName("info/mapinfo");
  return mv;
 } 

 @RequestMapping("/info/reviewwrite")
 public ModelAndView reviewwrite(String title, String score , String m_idx , String content,String contentid,String votitle, String voaddr1 ,String votel , String vofirstimage){
  ModelAndView mv = new ModelAndView();
  InfoVO vo = new InfoVO();
  vo.setAddr1(voaddr1);
  vo.setContentid(contentid);
  vo.setFirstimage(vofirstimage);
  vo.setTitle(votitle);
  vo.setTel(votel);
  ReviewVO rvo = new ReviewVO();
  rvo.setTitle(title);
  rvo.setContent(content);
  rvo.setContentid(contentid);
  rvo.setScore(score);
  service.reviewwrite(rvo, m_idx,contentid);
  ReviewLogVO[] ar = service.reviewall(contentid);
  vo.setRl_list(ar);
  mv.addObject("ifoVO", vo);
  mv.setViewName("info/mapinfo");
  return mv;
 }
 
 @RequestMapping("/info/test")
 public String test(){
    return "info/info";
 }
}

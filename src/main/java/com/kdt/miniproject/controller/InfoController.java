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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kdt.miniproject.vo.InfoVO;
import com.kdt.miniproject.vo.ItemVO;

@Controller
public class InfoController {
 
 @RequestMapping("/info/")
 public ModelAndView init() throws Exception{
  ModelAndView mv = new ModelAndView();
  ItemVO itmVO = new ItemVO("서울특별시 종로구 세종대로 175"
  , "", "1", "2848984", "15", "http://tong.visitkorea.or.kr/cms/resource/81/2848981_image2_1.jpg",
   "http://tong.visitkorea.or.kr/cms/resource/81/2848981_image3_1.jpg",
    "126.9763210635", "37.5720618985", "02-3437-0059", "거리에술 캬라반 '가을'");
  mv.addObject("itmVO", itmVO);
  String path = "http://apis.data.go.kr/B551011/KorService1";
  StringBuffer sb = new StringBuffer();
  String numOfRows = "10";
  String pageNo = "1";
  String MobileOS = "ETC";
  String listYN = "Y";
  String arrange = "A";
  String mapX = itmVO.getMapx();
  String mapY = itmVO.getMapy();
  String radius = "1000";
  String contentTypeId = "15";
  String servicekey = "VZwsEBpKrcOmbKb2y%2FszpWMkbfTx9GLvm2dZ96N6fn9bubmU0iPfGKNkuGSqCvCgpqL611HousPLRFN2KBEk9w%3D%3D";
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
   BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
   String line;
   while((line =br.readLine())!=null){
    inputst.append(line);
   }
   
   JSONParser parser = new JSONParser();
   JSONObject json = (JSONObject)parser.parse(inputst.toString());
   JSONObject resp = (JSONObject)parser.parse(json.get("response").toString());
   JSONObject body = (JSONObject)parser.parse(resp.get("body").toString());
   JSONObject items = (JSONObject)parser.parse(body.get("items").toString());
   JSONArray array = (JSONArray)items.get("item");
   List<InfoVO> list = new ArrayList<>();

   for(Object vo : array){
    JSONObject item = (JSONObject)vo;
    InfoVO ivo = new InfoVO((String)item.get("mapx"), (String)item.get("mapy"), 
    (String)item.get("title"),(String)item.get("addr1"),
    (String)item.get("contentid"),(String)item.get("modifiedtime"),
    (String)item.get("firstimage2"),(String)item.get("tel"));
    list.add(ivo);
   }
   InfoVO[] iar = new InfoVO[list.size()];

   list.toArray(iar);
   mv.addObject("iar", iar);

  }
  mv.setViewName("info/info");
  return mv;
 }

 
}

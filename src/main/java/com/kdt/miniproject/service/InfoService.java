package com.kdt.miniproject.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kdt.miniproject.mapper.InfoMapper;
import com.kdt.miniproject.vo.ReviewLogVO;
import com.kdt.miniproject.vo.ReviewVO;

@Service
public class InfoService {
 
 @Autowired
 InfoMapper mapper;

 public void all(){
  mapper.reviewlog("");
 }

 public void reviewwrite(ReviewVO vo , String m_idx,String contentid){
  int cnt = mapper.rvowrite(vo);
  //String contentid = rvo.getContentid();
  //String r_idx = rvo.getR_idx();
  Map<String,String> map = new HashMap<String,String>();
  map.put("m_idx", m_idx);
  map.put("r_idx", vo.getR_idx());
  map.put("contentid", contentid);
  mapper.rlvowrite(map);
 }

 public ReviewLogVO[] reviewall(String contentid){
  ReviewLogVO[] ar = null;
  List<ReviewLogVO> list = mapper.reviewlog(contentid);
  if(list!=null && list.size()!=0){
   ar = new ReviewLogVO[list.size()];
   list.toArray(ar);
  }
  return ar;
 }
}

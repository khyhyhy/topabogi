package com.kdt.miniproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kdt.miniproject.mapper.InfoMapper;

@Service
public class InfoService {
 
 @Autowired
 InfoMapper mapper;

 public void all(){
  mapper.all();
 }
}

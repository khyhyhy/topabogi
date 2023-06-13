package com.kdt.miniproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kdt.miniproject.mapper.JoinMapper;

@Service
public class JoinService {
 
 @Autowired
 JoinMapper mapper;

 public void all(){
  mapper.all();
 }
}

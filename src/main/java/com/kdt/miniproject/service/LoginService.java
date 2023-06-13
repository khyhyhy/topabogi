package com.kdt.miniproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kdt.miniproject.mapper.LoginMapper;

@Service
public class LoginService {
 
 @Autowired
 LoginMapper mapper;

 public void all(){
  mapper.all();
 }
}

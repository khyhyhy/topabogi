package com.kdt.miniproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JoinCotroller {
 
 @RequestMapping("/join")
 public String init(){
  return "/join/join";
 }
}

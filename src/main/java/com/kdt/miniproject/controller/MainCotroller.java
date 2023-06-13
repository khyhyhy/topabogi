package com.kdt.miniproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainCotroller {

 @RequestMapping("/main/")
 public String init(){
  return "Main";
 }
}

package com.kdt.miniproject.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

import com.kdt.miniproject.mapper.LoginMapper;
import com.kdt.miniproject.vo.MemberVO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Service
public class LoginService implements HandlerInterceptor{


 @Autowired
    private LoginMapper mapper;
 
    public MemberVO ml_login(String email, String password) {
       

        Map<String, String> map = new HashMap<String, String>();
        map.put("email",email);
        map.put("password", password);
        
        return mapper.login(map);

    }
}

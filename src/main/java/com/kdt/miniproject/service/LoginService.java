package com.kdt.miniproject.service;

import java.util.List;

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
 
 public MemberVO[] ml_login(String email, String password) {
     MemberVO[] ar = null;
    
     List<MemberVO> list = mapper.login(email, password);
        if(list != null && list.size() > 0){
            ar = new MemberVO[list.size()];
            list.toArray(ar);
        }

        return ar;
    }
}

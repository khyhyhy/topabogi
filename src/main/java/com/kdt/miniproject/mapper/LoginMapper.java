package com.kdt.miniproject.mapper;

import java.util.List;

import com.kdt.miniproject.vo.MemberVO;

public interface LoginMapper {
    List<MemberVO> all();

    List<MemberVO> login(String email, String password);
    
}

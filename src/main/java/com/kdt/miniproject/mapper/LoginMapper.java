package com.kdt.miniproject.mapper;

import java.util.List;
import java.util.Map;

import com.kdt.miniproject.vo.MemberVO;

public interface LoginMapper {
    List<MemberVO> all();

    MemberVO login (Map<String,String> map );
    
    
}

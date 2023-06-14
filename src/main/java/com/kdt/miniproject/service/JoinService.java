package com.kdt.miniproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kdt.miniproject.mapper.JoinMapper;
import com.kdt.miniproject.vo.MemberVO;

@Service
public class JoinService {
 
    @Autowired
    private JoinMapper j_mapper;

    public int addMem(MemberVO vo) {
		return j_mapper.addMem(vo);
		
	}
}

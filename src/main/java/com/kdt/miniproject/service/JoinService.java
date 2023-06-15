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

    public boolean check_email(MemberVO vo){
      boolean chk = false;
		
      MemberVO mvo = j_mapper.check_email(vo);
     
      if(mvo == null)
      chk = true;
      
		return chk;
    }
	
    public int updateToken(MemberVO vo) {
      return j_mapper.updateToken(vo);
    }

    public boolean check_id(String email){
      boolean chk = false;
		
      MemberVO mvo = j_mapper.check_id(email);
     
      if(mvo == null)
      chk = true;
      
		return chk;
    }

    public MemberVO getMem(MemberVO vo){
        MemberVO mvo = j_mapper.check_email(vo);

        return mvo;
    }
}

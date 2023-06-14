package com.kdt.miniproject.mapper;

import com.kdt.miniproject.vo.MemberVO;

public interface JoinMapper {
    int addMem(MemberVO vo);

    MemberVO check_email(String email);
}

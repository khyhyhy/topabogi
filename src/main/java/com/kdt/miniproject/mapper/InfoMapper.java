package com.kdt.miniproject.mapper;

import java.util.List;

import com.kdt.miniproject.vo.MemberVO;
import com.kdt.miniproject.vo.ReviewLogVO;
import com.kdt.miniproject.vo.ReviewVO;


public interface InfoMapper {
 List<ReviewLogVO> reviewlog(String param);
 MemberVO mvo(String param);
 ReviewVO rvo(String param);
}

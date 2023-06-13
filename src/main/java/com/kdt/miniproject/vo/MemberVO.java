package com.kdt.miniproject.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MemberVO {
 String m_idx , email,nickname,password,access_token,refresh_token,profile_image,joindate,status,
 m_val1,m_val2,m_val3,m_val4;
}

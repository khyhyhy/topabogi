package com.kdt.miniproject.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InfoVO {
 String mapX,mapY,title,addr1,contentid,modifiedtime,firstimage2,tel,firstimage,average;
  
 ReviewLogVO[] rl_list;
}

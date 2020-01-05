package com.my.res.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.my.res.domain.MembersVo;

@Mapper
public interface MembersDao {
	
	List<MembersVo> getMembersList();
	MembersVo getUserById(String username);
	int insertUser(HashMap<String, Object> map);
}

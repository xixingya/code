package com.atguigu.atnewmall.manager.dao;

import java.util.List;

import com.atguigu.atnewmall.bean.Tag;

public interface TagDao {

	List<Tag> queryRootTags();

	List<Tag> queryChildTagsByPid(Integer id);

	List<Tag> queryAll();

}

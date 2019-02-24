package com.atguigu.atnewmall.manager.service;

import java.util.List;

import com.atguigu.atnewmall.bean.Tag;

public interface TagService {

	List<Tag> queryRootTags();

	List<Tag> queryChildTagsByPid(Integer id);

	List<Tag> queryAll();

}
